+!start
  <- .print("I am running");
     .wait(2000).

+!a : true
  <- .print("Ok, I am here");
     .wait(2000).

+!check_warehouse: true
    <- .print("Checking Warehouse, and order");
        !order;
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

+!receive: true
    <- .print("Received product from manufacturerAgent");
        .receivedItemByWholesaler(3, X);
        .print("Tx receivedItemByWholesaler successful with hash:", X);
        !sell;
        .wait(1000).

+!sell: true
    <- .print("Selling product to retailerAgent");
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