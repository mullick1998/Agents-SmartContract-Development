// SPDX-License-Identifier: ISC
pragma solidity >=0.8.13;

// inherited contracts
import './Ownable.sol';
import './ManufacturerRole.sol';
import './WholesalerRole.sol';
import './RetailerRole.sol';


// Define a contract 'Supplychain'
contract SupplyChain is
    Ownable,
    ManufacturerRole,
    WholesalerRole,
    RetailerRole {

  // Define 'owner'
  address owner;

  // Define a variable called 'upc' for Universal Product Code (UPC)
  uint  upc;

  // Define a variable called 'sku' for Stock Keeping Unit (SKU)
  uint  sku;

  // Define a public mapping 'items' that maps the UPC to an Item.
  mapping (uint => Item) items;

  // Define a public mapping 'itemsHistory' that maps the UPC to an array of TxHash,
  // that track its journey through the supply chain -- to be sent from DApp.
  mapping (uint => Txblocks) itemsHistory;

  // constructor setup owner sku upc
  constructor() payable {
    owner = msg.sender;
    sku = 1;
    upc = 1;
  }



  // Define enum 'State' with the following values:
  enum State
  {
    ProduceByManufacturer,          // 0
    PackageByManufacturer,          // 1
    ForSaleByManufacturer,          // 2
    PurchasedByWholesaler,          // 3
    ShippedByManufacturer,          // 4
    ReceivedByWholesaler,           // 5
    ForSaleByWholesaler,            // 6
    PurchasedByRetailer,            // 7
    ShippedByWholesaler,            // 8
    ReceivedByRetailer              // 9
    }


  State constant defaultState = State.ProduceByManufacturer;

  // Define a struct 'Item' with the following fields:
  struct Item {
    uint    sku;                          // Stock Keeping Unit (SKU)
    uint    upc;                          // Universal Product Code (UPC),generated by the Manufacturer can be verified by the Cretailer
    address ownerID;                      // Metamask-Ethereum address of the current owner as the product moves through 8 stages
    address originManufacturerID;         // Metamask-Ethereum address of the Manufacturer // ADDED PAYABLE
    string  originManufacturerName;       // Manufacturer Name
    uint    productID;                    // Product ID potentially a combination of upc + sku
    string  productNotes;                 // Product Notes
    uint256 productDate;                  // Product Date NOTE: MIGHT NEED TO CHANGE type
    uint    productPrice;                 // Product Price
    uint    productPieces;                // Parent product
    State   itemState;                    // Product State as represented in the enum above
    address wholesalerID;                 // Metamask-Ethereum address of the Wholesaler
    string  wholesalerName;               // Wholesaler Name
    address retailerID;                   // Metamask-Ethereum address of the Retailer
    string  retailerName;                 // retailer Name
  }

// Block number stuct
  struct Txblocks {
    uint MTW; // blockmanufacturerToWholesaler
    uint WTR; // blockWholesalerToRetailer
  }


event ProduceByManufacturer(uint upc);         //1
event PackagedByManufacturer(uint upc);        //2
event ForSaleByManufacturer(uint upc);         //3
event PurchasedByWholesaler(uint upc);         //4
event ShippedByManufacturer(uint upc);         //5
event ReceivedByWholesaler(uint upc);          //6
event ForSaleByWholesaler(uint upc);           //7
event PurchasedByRetailer(uint upc);           //8
event ShippedByWholesaler(uint upc);           //9
event ReceivedByRetailer(uint upc);            //10



  // Define a modifer that checks to see if msg.sender == owner of the contract
  modifier onlyOwner()  override{
    require(msg.sender == owner, "owner doesn't match");
    _;
  }

  // Define a modifer that verifies the Caller
  modifier verifyCaller (address _address) {
    require(msg.sender == _address, "owner address doesn't match");
    _;
  }

  // Define a modifier that checks if the paid amount is sufficient to cover the price
  modifier paidEnough(uint _price) {
    require(msg.value >= _price, "Pay is not suffecient");
    _;
  }

  // Define a modifier that checks the price and refunds the remaining balance
  modifier checkValue(uint _upc, address payable addressToFund) {
    uint _price = items[_upc].productPrice;
    uint  amountToReturn = msg.value - _price;
    addressToFund.transfer(amountToReturn);
    _;
  }

//Item State Modifiers
  modifier producedByManufacturer(uint _upc) {
    require(items[_upc].itemState == State.ProduceByManufacturer, "producedByManufacturer State doesn't match");
    _;
  }

  modifier packagedByManufacturer(uint _upc) {
    require(items[_upc].itemState == State.PackageByManufacturer, "packagedByManufacturer State doesn't match");
    _;
  }
  modifier forSaleByManufacturer(uint _upc) {
    require(items[_upc].itemState == State.ForSaleByManufacturer, "forSaleByManufacturer State doesn't match");
    _;
  }

  modifier purchasedByWholesaler(uint _upc) {
    require(items[_upc].itemState == State.PurchasedByWholesaler, "purchasedByWholesaler State doesn't match");
    _;
  }

  modifier shippedByManufacturer(uint _upc) {
    require(items[_upc].itemState == State.ShippedByManufacturer, "shippedByManufacturer State doesn't match");
    _;
  }

  modifier receivedByWholesaler(uint _upc) {
    require(items[_upc].itemState == State.ReceivedByWholesaler, "receivedByWholesaler State doesn't match");
    _;
  }

  modifier forSaleByWholesaler(uint _upc) {
    require(items[_upc].itemState == State.ForSaleByWholesaler, "forSaleByWholesaler State doesn't match");
    _;
  }


  modifier shippedByWholesaler(uint _upc) {
    require(items[_upc].itemState == State.ShippedByWholesaler, "shippedByWholesaler State doesn't match");
    _;
  }

  modifier purchasedByRetailer(uint _upc) {
    require(items[_upc].itemState == State.PurchasedByRetailer, "purchasedByRetailer State doesn't match");
    _;
  }

  modifier receivedByRetailer(uint _upc) {
    require(items[_upc].itemState == State.ReceivedByRetailer, "receivedByRetailer State doesn't match");
    _;
  }

    // Define a function 'kill'
  function kill() public {
    if (msg.sender == owner) {
      address payable ownerAddressPayable = _make_payable(owner);
      selfdestruct(ownerAddressPayable);
    }
  }


    // allows you to convert an address into a payable address
  function _make_payable(address x) internal pure returns (address payable) {
      return payable(address (uint160(x)));
  }

/*
 1st step in supplychain
 Allows manufacturer to create product
*/
  function produceItemByManufacturer(uint _upc, string memory _originManufacturerName, string memory _productNotes, uint _price) public
    onlyManufacturer() // check address belongs to manufacturerRole
    {

    address wholesalerID; // Empty wholesalerID address
    address retailerID; // Empty retailerID address
    Item memory newProduce; // Create a new struct Item in memory
    newProduce.sku = sku;  // Stock Keeping Unit (SKU)
    newProduce.upc = _upc; // Universal Product Code (UPC), generated by the Manufacturer, goes on the package, can be verified by the Consumer
    newProduce.ownerID = msg.sender;  // Metamask-Ethereum address of the current owner as the product moves through 8 stages
    newProduce.originManufacturerID = msg.sender; // Metamask-Ethereum address of the Manufacturer
    newProduce.originManufacturerName = _originManufacturerName;  // Manufacturer Name
    newProduce.productID = _upc+sku;  // Product ID
    newProduce.productNotes = _productNotes; // Product Notes
    newProduce.productPrice = _price;  // Product Price
    newProduce.productDate = block.timestamp;
    newProduce.productPieces = 0;
    newProduce.itemState = defaultState; // Product State as represented in the enum above
    newProduce.wholesalerID = wholesalerID; // Metamask-Ethereum address of the Wholesaler
    newProduce.wholesalerName = "Mr.X"; // wholesaler Name
    newProduce.retailerID = retailerID; // Metamask-Ethereum address of the Retailer
    newProduce.retailerName = "Mr.Y"; //retailer Name
    items[_upc] = newProduce; // Add newProduce to items struct by upc
    uint placeholder; // Block number place holder
    Txblocks memory txBlock; // create new txBlock struct
    txBlock.MTW = placeholder; // assign placeholder values
    txBlock.WTR = placeholder;
    itemsHistory[_upc] = txBlock; // add txBlock to itemsHistory mapping by upc

    // Increment sku
    sku = sku + 1;

    // Emit the appropriate event
    // emit ProduceByManufacturer(_upc);

  }

 /*
  2nd step in supplychain
  Allows maufacturer to package product
  */
  function packageItemByManufacturer(uint _upc) public
    onlyManufacturer() // check msg.sender belongs to ManufacturerRole
    // producedByManufacturer(_upc)
    verifyCaller(items[_upc].ownerID) // check msg.sender is owner
    {
    items[_upc].itemState = State.PackageByManufacturer;
    // emit PackagedByManufacturer(_upc);
  }

/*
3rd step in supplychain
Allows manufacturer to sell product
*/
  function sellItemByManufacturer(uint _upc, uint _price) public
    onlyManufacturer() // check msg.sender belongs to manufacturerRole
    // packagedByManufacturer(_upc) // check items state has been produced
    verifyCaller(items[_upc].ownerID) // check msg.sender is owner
    {
      items[_upc].itemState = State.ForSaleByManufacturer;
      items[_upc].productPrice = _price;
      // emit ForSaleByManufacturer(_upc);
  }

/*
4th step in supplychain
Allows wholesaler to purchase product
*/
  function purchaseItemByWholesaler(uint _upc, string memory _wholesalerName) public payable
    onlyWholesaler() // check msg.sender belongs to wholesalerRole
    // forSaleByManufacturer(_upc) // check items state is for ForSaleByManufacturer
    paidEnough(items[_upc].productPrice) // check if wholesaler sent enough Ether for product
    checkValue(_upc, payable(msg.sender)) // check if overpayed return remaing funds back to msg.sender
    {
    address payable ownerAddressPayable = _make_payable(items[_upc].originManufacturerID); // make originFarmID payable
    ownerAddressPayable.transfer(items[_upc].productPrice); // transfer funds from wholesaler to manufacturer
    items[_upc].ownerID = msg.sender; // update owner
    items[_upc].wholesalerID = msg.sender; // update wholesaler
    items[_upc].wholesalerName = _wholesalerName; //wholesaler name
    items[_upc].itemState = State.PurchasedByWholesaler; // update state
    itemsHistory[_upc].MTW = block.number; // add block number
    // emit PurchasedByWholesaler(_upc);

  }

  /*
  5th step in supplychain
  Allows manufacturer to ship product purchased by wholesaler
  */
  function shippedItemByManufacturer(uint _upc) public payable
    onlyManufacturer() // check msg.sender belongs to ManufacturerRole
    // purchasedByWholesaler(_upc)
    verifyCaller(items[_upc].originManufacturerID) // check msg.sender is originFarmID
    {
    items[_upc].itemState = State.ShippedByManufacturer; // update state
    // emit ShippedByManufacturer(_upc);
  }

  /*
  6th step in supplychain
  Allows wholesaler to receive product
  */
  function receivedItemByWholesaler(uint _upc) public
    onlyWholesaler() // check msg.sender belongs to WholesalerRole
    // shippedByManufacturer(_upc)
    verifyCaller(items[_upc].ownerID) // check msg.sender is owner
    {
    items[_upc].itemState = State.ReceivedByWholesaler; // update state
    // emit ReceivedByWholesaler(_upc);
  }

  /*
  7th step in supplychain
  Allows wholesaler to sell product
  */
  function sellItemByWholesaler(uint _upc, uint _price) public
    onlyWholesaler() // check msg.sender belongs to WholesalerRole
    // receivedByWholesaler(_upc)
    verifyCaller(items[_upc].ownerID) // check msg.sender is owner
    {
        items[_upc].itemState = State.ForSaleByWholesaler;
        items[_upc].productPrice = _price;
        // emit ForSaleByWholesaler(upc);
  }

  /*
  8th step in supplychain
  Allows retailer to purchase product
  */
  function purchaseItemByRetailer(uint _upc, string memory _retailerName) public payable
    onlyRetailer() // check msg.sender belongs to RetailerRole
    // forSaleByWholesaler(_upc)
    paidEnough(items[_upc].productPrice)
    checkValue(_upc, payable(msg.sender))
    {
    address payable ownerAddressPayable = _make_payable(items[_upc].wholesalerID);
    ownerAddressPayable.transfer(items[_upc].productPrice);
    items[_upc].ownerID = msg.sender;
    items[_upc].retailerID = msg.sender;
    items[_upc].retailerName = _retailerName;
    items[_upc].itemState = State.PurchasedByRetailer;
    itemsHistory[_upc].WTR = block.number;
    // emit PurchasedByRetailer(_upc);
  }

  /*
  9th step in supplychain
  Allows Wholesaler to shipping
  */
  function shippedItemByWholesaler(uint _upc) public
    onlyWholesaler() // check msg.sender belongs to WholesalerRole
    // purchasedByRetailer(_upc)
    verifyCaller(items[_upc].wholesalerID) // check msg.sender is wholesalerID
    {
      items[_upc].itemState = State.ShippedByWholesaler;
      // emit ShippedByWholesaler(_upc);
  }

  /*
  11th step in supplychain
  */
  function receivedItemByRetailer(uint _upc) public
    onlyRetailer() // check msg.sender belongs to RetailerRole
    // shippedByWholesaler(_upc)
    verifyCaller(items[_upc].ownerID) // check msg.sender is ownerID
    {
      items[_upc].itemState = State.ReceivedByRetailer;
      // emit ReceivedByRetailer(_upc);
  }

  // Define a function 'fetchItemBufferOne' that fetches the data
  function fetchItemBufferOne(uint _upc) public view returns
    (
    uint    itemSKU,
    uint    itemUPC,
    address ownerID,
    address originManufacturerID,
    string memory  originManufacturerName,
    uint productDate,
    uint productPieces
    )
    {
    // Assign values to the 8 parameters
    Item memory item = items[_upc];

    return
    (
      item.sku,
      item.upc,
      item.ownerID,
      item.originManufacturerID,
      item.originManufacturerName,
      item.productDate,
      item.productPieces
    );
  }

  // Define a function 'fetchItemBufferTwo' that fetches the data
  function fetchItemBufferTwo(uint _upc) public view returns
    (
    uint    itemSKU,
    uint    itemUPC,
    uint    productID,
    string  memory productNotes,
    uint    productPrice,
    uint256 productDate,
    State   itemState,
    address wholesalerID,
    address retailerID,
    string memory wholesalerName,
    string memory retailerName
    )
    {
      // Assign values to the 9 parameters
    Item memory item = items[_upc];

    return
    (
      item.sku,
      item.upc,
      item.productID,
      item.productNotes,
      item.productPrice,
      item.productDate,
      item.itemState,
      item.wholesalerID,
      item.retailerID,
      item.wholesalerName,
      item.retailerName
    );

  }

    // Define a function 'fetchWholsaler' that fetches the data
  function fetchWholesaler(uint _upc) public view returns
    (
    uint    itemSKU,
    uint    itemUPC,
    uint    productID,
    string  memory productNotes,
    uint    productPrice,
    uint256 productDate,
    State   itemState,
    address wholesalerID,
    string memory wholesalerName
    )
    {
      // Assign values to the 9 parameters
    Item memory item = items[_upc];

    return
    (
      item.sku,
      item.upc,
      item.productID,
      item.productNotes,
      item.productPrice,
      item.productDate,
      item.itemState,
      item.wholesalerID,
      item.wholesalerName
    );

  }

    // Define a function 'fetchItemBufferTwo' that fetches the data
  function fetchRetailer(uint _upc) public view returns
    (
    uint    itemSKU,
    uint    itemUPC,
    uint    productID,
    string  memory productNotes,
    uint    productPrice,
    uint256 productDate,
    State   itemState,
    address retailerID,
    string memory retailerName
    )
    {
      // Assign values to the 9 parameters
    Item memory item = items[_upc];

    return
    (
      item.sku,
      item.upc,
      item.productID,
      item.productNotes,
      item.productPrice,
      item.productDate,
      item.itemState,
      item.retailerID,
      item.retailerName
    );

  }

  // Define a function 'fetchItemHistory' that fetaches the data
  function fetchitemHistory(uint _upc) public view returns
    (
      uint blockmanufacturerToWholesaler,
      uint blockWholesalerToRetailer
    )
    {
      // Assign value to the parameters
      Txblocks memory txblock = itemsHistory[_upc];
      return
      (
        txblock.MTW,
        txblock.WTR
      );

    }
}


