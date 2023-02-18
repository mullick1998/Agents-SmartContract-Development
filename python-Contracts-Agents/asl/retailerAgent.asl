
inventory(2).
order(8).

+!start
  <- .print("I am running");
     .wait(2000).

+!a : true
  <- .addRetailer(X);
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
        !noneedofreceive;
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

+!noneedofreceive: true
    <-  .print("Giving products to supplyChainAgent");
        .send(supplyChainAgent, achieve, a).

+!receive: true
    <-  .print("Received product from wholesalerAgent and Inventory full!!");
        .receivedItemByRetailer(3, X);
        .print("Tx receivedItemByRetailer successful with hash:", X);
        .print("Giving products to supplyChainAgent");
        .send(supplyChainAgent, achieve, a).