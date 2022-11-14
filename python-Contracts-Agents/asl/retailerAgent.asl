init.
+init : true
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
    <- .print("Ordering to wholesalerAgent");
        .send(supplyChainAgent, achieve, create_wholesaler);
        .wait(1000).

+!purchase: true
    <- .print("Purchasing product from wholesalerAgent");
        .send(wholesalerAgent, achieve, ship);
        .wait(1000).

+!receive: true
    <- .print("Received product from wholesalerAgent").