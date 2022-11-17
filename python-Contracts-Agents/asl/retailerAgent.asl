+!start
  <- .print("I am running");
     .wait(2000).

+!a : true
  <- .addRetailer(X);
     .print("Hi, I am here, with account:", X);
     .wait(1000).

+!check_warehouse: true
    <- .print("Checking Warehouse, and order");
        !order;
        .wait(1000).

+!order: true
    <- .print("Ordering to wholesalerAgent");
        .send(supplyChainAgent, achieve, create_wholesaler);
        .wait(1000).

+!purchase: true
    <- .print("Purchasing product from wholesalerAgent");
        .purchaseItemByRetailer(3, X);
        .print("Tx purchaseItemByRetailer successful with hash:", X);
        .send(wholesalerAgent, achieve, ship);
        .wait(1000).

+!receive: true
    <-  .print("Received product from wholesalerAgent");
        .receivedItemByRetailer(3, X);
        .print("Tx receivedItemByRetailer successful with hash:", X);
        .print("NOW SELL TO CUSTOMER!!");
        .send(supplyChainAgent, achieve, a).