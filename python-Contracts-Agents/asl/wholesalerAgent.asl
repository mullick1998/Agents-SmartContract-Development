inventory(2).
order(8).

+!start
  <- .print("I am running");
     .wait(2000).

+!a : true
  <- .addWholesaler(X);
     .print("Hi, I am here, with account:", X);
     .wait(1000).

+!check_warehouse: inventory(A) & order(B) & A < B 
    <- .print("Checking Warehouse");
        .print("INSUFFICIENT INVENTORY!! Ordering Product..");
        !order;
        .wait(1000).

+!check_warehouse: inventory(A) & order(B) & A >= B
    <-  +inventory(10);
        .print("Checking Warehouse, and no need to order");
        !sell;
        .wait(1000).

+!order: true
    <- .print("Ordering to manufacturerAgent");
        .send(supplyChainAgent, achieve, create_manufacturer);
        .wait(1000).

+!purchase: true
    <- .print("Purchasing product from manufacturerAgent");
        .purchaseItemByWholesaler(3, X);
        .print("Tx purchaseItemByWholesaler successful with hash:", X);
        .send(manufacturerAgent, achieve, ship);
        .wait(1000).

+!purchaseAgain: true
    <- .print("Purchasing product from manufacturerAgent Again");
        .purchaseItemByWholesaler(3, X);
        .print("Tx purchaseItemByWholesaler successful with hash:", X);
        .send(manufacturerAgent, achieve, shipAgain);
        .wait(1000).

+!receive: true
    <-  +inventory(10);
        .print("Received product from manufacturerAgent, and added to the inventory and Inventory not full yet!!");
        .receivedItemByWholesaler(3, X);
        .print("Tx receivedItemByWholesaler successful with hash:", X);
        .send(manufacturerAgent, achieve, sellAgain);
        .wait(1000).

+!receiveAgain: true
    <-  +inventory(10);
        .print("Received product from manufacturerAgent, and added to the inventory and Inventory FULL!!");
        .receivedItemByWholesaler(3, X);
        .print("Tx receivedItemByWholesaler successful with hash:", X);
        !sell;
        .wait(1000).

+!sell: true
    <- .print("Selling product to retailerAgent");
        -inventory(10);
        .sellItemByWholesaler(3, X);
        .print("Tx sellItemByWholesaler successful with hash:", X);
        .send(retailerAgent, achieve, purchase);
        .wait(1000).

+!ship: true
    <-  .print("Shipping product to retailerAgent");
        .shippedItemByWholesaler(3, X);
        .print("Tx shippedItemByWholesaler successful with hash:", X);
        .send(retailerAgent, achieve, receive);
        .wait(1000).