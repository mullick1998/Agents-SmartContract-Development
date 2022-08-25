const SupplyChain = artifacts.require('SupplyChain')

contract('SupplyChain', function(accounts) {

    beforeEach('Initialize parameter', async () => {
        supplyChain = await SupplyChain.deployed(); 
    });
    let supplyChain;
    var sku = 1
    var upc = 1
    var ownerID = accounts[0]
    const originManufacturerID = accounts[1]
    const originManufacturerName = "Mostakim Mullick"
    var productID = upc + sku
    const productNotes = "Best beans for Espresso"
    const productPrice = web3.utils.toWei('1', "ether")
    var itemState = 0
    const wholesalerID = accounts[2]
    const wholesalerName = "Mr. Mullick"
    const retailerID = accounts[3]
    const retailerName = "Mrs. Mullick" 
    
    console.log("<----------------ACCOUNTS----------------> ")
    console.log("Contract Owner: accounts[0] ", accounts[0])
    console.log("Manufacturer: accounts[1] ", accounts[1])
    console.log("Wholesaler: accounts[2] ", accounts[2])
    console.log("Retailer: accounts[3] ", accounts[3]) 

    console.log("<-------TESTING CONTRACT FUNCTIONS------->")
    // 1st Test
    it("Testing smart contract function produceItem() that allows a manufacturer to produce product", async() => {
        // const supplyChain = await SupplyChainInstance.deployed();
        await supplyChain.addManufacturer(originManufacturerID)
        var eventEmitted = false;

        await supplyChain.produceItemByManufacturer(upc, originManufacturerName, productNotes, productPrice, {from:originManufacturerID})
    
        const resultBufferOne = await supplyChain.fetchItemBufferOne.call(upc)
        const resultBufferTwo = await supplyChain.fetchItemBufferTwo.call(upc)

        await supplyChain.getPastEvents('ProduceByManufacturer', {
            fromBlock: 0,
            toBlock: 'latest'
        }, (error, events) => { console.log(events,error); })
        .then((events) => {
            eventEmitted = true;
        });

        ownerID = originManufacturerID;

        assert.equal(resultBufferOne[0], sku, 'Error: Invalid item SKU')
        assert.equal(resultBufferOne[1], upc, 'Error: Invalid item UPC')
        assert.equal(resultBufferOne[2], ownerID, 'Error: Missing or Invalid ownerID')
        assert.equal(resultBufferTwo[2], productID,'Error: Missing or Invalid productID')
        assert.equal(resultBufferOne[3], originManufacturerID, 'Error: Missing or Invalid originManufacturerID')
        assert.equal(resultBufferOne[4], originManufacturerName, 'Error: Missing or Invalid originManufacturerName')
        assert.equal(resultBufferTwo[6], itemState, 'Error: Invalid item State')
        assert.equal(eventEmitted, true, 'Invalid event emitted')

    })

    
    // 2nd Test
    it("Testing smart contract function packageItemByManufacturer() that allows a Manufacturer to package product", async() => {
        var eventEmitted = false;
        itemState = 1;
        await supplyChain.packageItemByManufacturer(upc,{from: originManufacturerID});
        const resultBufferOne = await supplyChain.fetchItemBufferOne.call(upc);
        const resultBufferTwo = await supplyChain.fetchItemBufferTwo.call(upc);
        await supplyChain.getPastEvents('PackagedByManufacturer', {
            fromBlock: 0,
            toBlock: 'latest'
        }, (error, events) => { console.log(events,error); })
        .then((events) => {
            eventEmitted = true;
        });

        assert.equal(resultBufferOne[0], sku, 'Error: Invalid item SKU')
        assert.equal(resultBufferOne[1], upc, 'Error: Invalid item UPC')
        assert.equal(resultBufferTwo[2], productID,'Error: Missing or Invalid productID')
        assert.equal(resultBufferOne[2], originManufacturerID, 'Error: Missing or Invalid ownerID')
        assert.equal(resultBufferTwo[6], itemState, 'Error: Invalid item State')
        assert.equal(resultBufferOne[3], originManufacturerID, 'Error: Invalid originManufacturerID ')
        assert.equal(eventEmitted, true, 'Invalid event emitted')

    })

    // 3rd Test
    it("Testing smart contract function sellItemByManufacturer() that allows a manufacturer to sell product", async() => {
        var eventEmitted = false;
        itemState = 2;
        await supplyChain.sellItemByManufacturer(upc,productPrice,{from: originManufacturerID});

        const resultBufferOne = await supplyChain.fetchItemBufferOne.call(upc)
        const resultBufferTwo = await supplyChain.fetchItemBufferTwo.call(upc)

        await supplyChain.getPastEvents('ForSaleByManufacturer', {
            fromBlock: 0,
            toBlock: 'latest'
        }, (error, events) => { console.log(events,error); })
        .then((events) => {
            eventEmitted = true;
        });

        assert.equal(resultBufferOne[0], sku, 'Error: Invalid item SKU')
        assert.equal(resultBufferOne[1], upc, 'Error: Invalid item UPC')
        assert.equal(resultBufferOne[2], ownerID, 'Error: Missing or Invalid ownerID')
        assert.equal(resultBufferTwo[2], productID,'Error: Missing or Invalid productID')
        assert.equal(resultBufferOne[3], originManufacturerID, 'Error: Missing or Invalid originManufacturerID')
        assert.equal(resultBufferOne[4], originManufacturerName, 'Error: Missing or Invalid originManufacturerName')
        assert.equal(resultBufferTwo[6], itemState, 'Error: Invalid item State')
        assert.equal(eventEmitted, true, 'Invalid event emitted')

    })

    // 4th Test
    it("Testing smart contract function purchaseItemByWholesaler() that allows a wholesaler to buy product", async() => {

        await supplyChain.addWholesaler(wholesalerID);

        var eventEmitted = false;
        itemState = 3;
        var balance = web3.utils.toWei('1', "ether")

        await supplyChain.purchaseItemByWholesaler(upc, wholesalerName, {from: wholesalerID,value: balance});
        
        const resultBufferOne = await supplyChain.fetchItemBufferOne.call(upc)
        const resultBufferTwo = await supplyChain.fetchItemBufferTwo.call(upc)

        await supplyChain.getPastEvents('PurchasedByWholesaler', {
            fromBlock: 0,
            toBlock: 'latest'
        }, (error, events) => { console.log(events,error); })
        .then((events) => {
            eventEmitted = true;

        });

        assert.equal(resultBufferOne[0], sku, 'Error: Invalid item SKU')
        assert.equal(resultBufferOne[1], upc, 'Error: Invalid item UPC')
        assert.equal(resultBufferOne[2], wholesalerID, 'Error: Missing or Invalid ownerID')
        assert.equal(resultBufferTwo[2], productID,'Error: Missing or Invalid productID')
        assert.equal(resultBufferOne[3], originManufacturerID, 'Error: Missing or Invalid originManufacturerID')
        assert.equal(resultBufferOne[4], originManufacturerName, 'Error: Missing or Invalid originManufacturerName')
        assert.equal(resultBufferTwo[6], itemState, 'Error: Invalid item State')
        assert.equal(resultBufferTwo[9], wholesalerName, 'Error: Invalid item State')
        assert.equal(eventEmitted, true, 'Invalid event emitted')
    })

    // 5th Test
    it("Testing smart contract function shippedItemByManufacturer() that allows a manufacturer to ship product ", async() => {
        // const supplyChain = await SupplyChainInstance.deployed()

        var eventEmitted = false;
        itemState = 4;
        await supplyChain.shippedItemByManufacturer(upc,{from: originManufacturerID});
        const resultBufferOne = await supplyChain.fetchItemBufferOne.call(upc)
        const resultBufferTwo = await supplyChain.fetchItemBufferTwo.call(upc)

        await supplyChain.getPastEvents('ShippedByManufacturer', {
            fromBlock: 0,
            toBlock: 'latest'
        }, (error, events) => { console.log(events,error); })
        .then((events) => {
            eventEmitted = true;

        });
        assert.equal(resultBufferOne[0], sku, 'Error: Invalid item SKU')
        assert.equal(resultBufferOne[1], upc, 'Error: Invalid item UPC')
        assert.equal(resultBufferOne[2], wholesalerID, 'Error: Missing or Invalid ownerID')
        assert.equal(resultBufferTwo[2], productID,'Error: Missing or Invalid productID')
        assert.equal(resultBufferOne[3], originManufacturerID, 'Error: Missing or Invalid originManufacturerID')
        assert.equal(resultBufferOne[4], originManufacturerName, 'Error: Missing or Invalid originManufacturerName')
        assert.equal(resultBufferTwo[6], itemState, 'Error: Invalid item State')
        assert.equal(resultBufferTwo[4], productPrice, 'Error: Invalid price')
        assert.equal(eventEmitted, true, 'Invalid event emitted')

    })

    // 6th Test
    it("Testing smart contract function receivedItemByWholesaler() that allows a wholesaler to receive product", async() => {

        var eventEmitted = false;
        itemState = 5;
        await supplyChain.receivedItemByWholesaler(upc,{from: wholesalerID});

        
        const resultBufferOne = await supplyChain.fetchItemBufferOne.call(upc)
        const resultBufferTwo = await supplyChain.fetchItemBufferTwo.call(upc)

        await supplyChain.getPastEvents('ReceivedByWholesaler', {
            fromBlock: 0,
            toBlock: 'latest'
        }, (error, events) => { console.log(events,error); })
        .then((events) => {
            eventEmitted = true;
        });

        assert.equal(resultBufferOne[0], sku, 'Error: Invalid item SKU')
        assert.equal(resultBufferOne[1], upc, 'Error: Invalid item UPC')
        assert.equal(resultBufferTwo[2], productID,'Error: Missing or Invalid productID')
        assert.equal(resultBufferOne[2], wholesalerID, 'Error: Missing or Invalid ownerID')
        assert.equal(resultBufferTwo[6], itemState, 'Error: Invalid item State')
        assert.equal(resultBufferTwo[7], wholesalerID, 'Error: Invalid wholesalerID ')
        assert.equal(eventEmitted, true, 'Invalid event emitted')
    })



    // 7th Test
    it("Testing smart contract function sellItemByWholesaler() that allows a wholesaler to sell product", async() => {

        var eventEmitted = false;
        itemState = 6;

        await supplyChain.sellItemByWholesaler(upc,productPrice,{from: wholesalerID});

        const resultBufferOne = await supplyChain.fetchItemBufferOne.call(upc);
        const resultBufferTwo = await supplyChain.fetchItemBufferTwo.call(upc);

        await supplyChain.getPastEvents('ForSaleByWholesaler', {
            fromBlock: 0,
            toBlock: 'latest'
        }, (error, events) => { console.log(events,error); })
        .then((events) => {
            eventEmitted = true;
        });
        assert.equal(resultBufferOne[0], sku, 'Error: Invalid item SKU')
        assert.equal(resultBufferOne[1], upc, 'Error: Invalid item UPC')
        assert.equal(resultBufferTwo[2], productID,'Error: Missing or Invalid productID')
        assert.equal(resultBufferOne[2], wholesalerID, 'Error: Missing or Invalid ownerID')
        assert.equal(resultBufferTwo[6], itemState, 'Error: Invalid item State')
        assert.equal(resultBufferTwo[7], wholesalerID, 'Error: Invalid wholesalerID ')
        assert.equal(eventEmitted, true, 'Invalid event emitted')

    })

    // 8th Test
    it("Testing smart contract function purchaseItemByRetailer() that allows a retailer to purchase product", async() => {
        
        await supplyChain.addRetailer(retailerID);
        var eventEmitted = false;
        itemState = 7;
        var balance = web3.utils.toWei('1', "ether");

        await supplyChain.purchaseItemByRetailer(upc, retailerName, {from: retailerID,value: balance});
        
        const resultBufferOne = await supplyChain.fetchItemBufferOne.call(upc);
        const resultBufferTwo = await supplyChain.fetchItemBufferTwo.call(upc)
    
        await supplyChain.getPastEvents('PurchasedByRetailer', {
            fromBlock: 0,
            toBlock: 'latest'
        }, (error, events) => { console.log(events,error); })
        .then((events) => {
            eventEmitted = true;
        });
        assert.equal(resultBufferOne[0], sku, 'Error: Invalid item SKU')
        assert.equal(resultBufferOne[1], upc, 'Error: Invalid item UPC')
        assert.equal(resultBufferTwo[2], productID,'Error: Missing or Invalid productID')
        assert.equal(resultBufferOne[2], retailerID, 'Error: Missing or Invalid ownerID')
        assert.equal(resultBufferTwo[6], itemState, 'Error: Invalid item State')
        assert.equal(resultBufferTwo[8], retailerID, 'Error: Invalid retailerID ')
        assert.equal(resultBufferTwo[10], retailerName, 'Error: Invalid retailerID ')
        assert.equal(eventEmitted, true, 'Invalid event emitted')

    })

    // 9th Test
    it("Testing smart contract function shippedItemByWholesaler() that allows a wholesaler to ship product", async() => {

        var eventEmitted = false;
        itemState = 8;
        await supplyChain.shippedItemByWholesaler(upc,{from: wholesalerID});

        
        const resultBufferOne = await supplyChain.fetchItemBufferOne.call(upc);
        const resultBufferTwo = await supplyChain.fetchItemBufferTwo.call(upc);
        await supplyChain.getPastEvents('ShippedByWholesaler', {
            fromBlock: 0,
            toBlock: 'latest'
        }, (error, events) => { console.log(events,error); })
        .then((events) => {
            eventEmitted = true;
        });
        assert.equal(resultBufferOne[0], sku, 'Error: Invalid item SKU')
        assert.equal(resultBufferOne[1], upc, 'Error: Invalid item UPC')
        assert.equal(resultBufferTwo[2], productID,'Error: Missing or Invalid productID')
        assert.equal(resultBufferOne[2], retailerID, 'Error: Missing or Invalid ownerID')
        assert.equal(resultBufferTwo[6], itemState, 'Error: Invalid item State')
        assert.equal(resultBufferTwo[7], wholesalerID, 'Error: Invalid wholesalerID ')
        assert.equal(eventEmitted, true, 'Invalid event emitted')

    })

    // 10th Test
    it("Testing smart contract function receivedItemByRetailer() that allows a retailer to receive product", async() => {

        var eventEmitted = false;
        itemState = 9;
        await supplyChain.receivedItemByRetailer(upc,{from: retailerID});
        
        const resultBufferOne = await supplyChain.fetchItemBufferOne.call(upc);
        const resultBufferTwo = await supplyChain.fetchItemBufferTwo.call(upc);
        await supplyChain.getPastEvents('ReceivedByRetailer', {
            fromBlock: 0,
            toBlock: 'latest'
        }, (error, events) => { console.log(events,error); })
        .then((events) => {
            eventEmitted = true;
        });
        assert.equal(resultBufferOne[0], sku, 'Error: Invalid item SKU')
        assert.equal(resultBufferOne[1], upc, 'Error: Invalid item UPC')
        assert.equal(resultBufferTwo[2], productID,'Error: Missing or Invalid productID')
        assert.equal(resultBufferOne[2], retailerID, 'Error: Missing or Invalid ownerID')
        assert.equal(resultBufferTwo[6], itemState, 'Error: Invalid item State')
        assert.equal(resultBufferTwo[8], retailerID, 'Error: Invalid wholesalerID ')
        assert.equal(eventEmitted, true, 'Invalid event emitted')

    })

    // 11th Test
    it("Testing smart contract function fetchItemBufferOne()", async() => {

        const resultBufferOne = await supplyChain.fetchItemBufferOne(upc);
        assert.equal(resultBufferOne[0],sku,"Error: Invalid item SKU")
        assert.equal(resultBufferOne[1],upc,"Error: Invalid item UPC")
        assert.equal(resultBufferOne[2],retailerID,"Error: Invalid OwnerID")
        assert.equal(resultBufferOne[3],originManufacturerID,"Error: Invalid originFarmID")
        assert.equal(resultBufferOne[4],originManufacturerName,"Error: Invalid originManufacturerName")

    })

    // 12th Test
    it("Testing smart contract function fetchItemBufferTwo()", async() => {
        const resultBufferTwo = await supplyChain.fetchItemBufferTwo(upc);
        assert.equal(resultBufferTwo[0],sku, "Error: Invalid item SKU")
        assert.equal(resultBufferTwo[1],upc, "Error: Invalid item UPC")
        assert.equal(resultBufferTwo[2],productID, "Error: Invalid item productID")
        assert.equal(resultBufferTwo[3],productNotes, "Error: Invalid productnote")
        assert.equal(resultBufferTwo[4],productPrice, "Error: Invalid productPrice")
        assert.equal(resultBufferTwo[6],itemState, "Error: Invalid itemState")
        assert.equal(resultBufferTwo[7],wholesalerID, "Error: Invalid wholesalerID")
        assert.equal(resultBufferTwo[8],retailerID, "Error: Invalid retailerID")

    })

    // 13th Test
    it("Testing smart contract function fetchWholesaler()", async() => {
        const resultWholesaler = await supplyChain.fetchWholesaler(upc);
        assert.equal(resultWholesaler[0],sku, "Error: Invalid item SKU")
        assert.equal(resultWholesaler[1],upc, "Error: Invalid item UPC")
        assert.equal(resultWholesaler[2],productID, "Error: Invalid item productID")
        assert.equal(resultWholesaler[3],productNotes, "Error: Invalid productnote")
        assert.equal(resultWholesaler[4],productPrice, "Error: Invalid productPrice")
        assert.equal(resultWholesaler[6],itemState, "Error: Invalid itemState")
        assert.equal(resultWholesaler[7],wholesalerID, "Error: Invalid wholesalerID")
        assert.equal(resultWholesaler[8],wholesalerName, "Error: Invalid wholesalerName")

    })

    // 14th Test
    it("Testing smart contract function fetchRetailer()", async() => {
        const resultRetailer = await supplyChain.fetchRetailer(upc);
        assert.equal(resultRetailer[0],sku, "Error: Invalid item SKU")
        assert.equal(resultRetailer[1],upc, "Error: Invalid item UPC")
        assert.equal(resultRetailer[2],productID, "Error: Invalid item productID")
        assert.equal(resultRetailer[3],productNotes, "Error: Invalid productnote")
        assert.equal(resultRetailer[4],productPrice, "Error: Invalid productPrice")
        assert.equal(resultRetailer[6],itemState, "Error: Invalid itemState")
        assert.equal(resultRetailer[7],retailerID, "Error: Invalid retailerID")
        assert.equal(resultRetailer[8],retailerName, "Error: Invalid retailerName")

    })

async function getTx(blockNumber){
    let tx1 = await web3.eth.getBlock(blockNumber);
    return  (await web3.eth.getTransaction(tx1.transactions[0]));
}

    // 15th Test
    it("Testing smart contract function fetchItemHistory()", async() => {
        const resultItemHistory = await supplyChain.fetchitemHistory(upc);
        const MTW = await getTx(resultItemHistory[0].toString());
        const WTR = await getTx(resultItemHistory[1].toString());
        assert.equal(WTR.from,retailerID,"Error: Invalid transaction between retailer and wholesaler")
        assert.equal(MTW.from,wholesalerID,"Error: Invalid transaction between manufacturer and wholesaler")

    })

});