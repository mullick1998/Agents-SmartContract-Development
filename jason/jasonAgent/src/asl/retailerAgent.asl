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
        .wait(5000).

+!order: true
    <- .print("Ordering to wholesalerAgent");
        .send(supplyChainAgent, achieve, create_wholesaler);
        .wait(5000).

+!purchase: true
    <- .print("Purchasing product from wholesalerAgent");
        .send(wholesalerAgent, achieve, ship);
        .wait(5000).

+!receive: true
    <- .print("Received product from wholesalerAgent");
        !end(10000).

+!end(T) : T <= 0 <- .stopMAS.
+!end(T) : true
   <- .print("The MAS will stop in ",T/1000," seconds!");
      .wait(2000); !end(T-5000).