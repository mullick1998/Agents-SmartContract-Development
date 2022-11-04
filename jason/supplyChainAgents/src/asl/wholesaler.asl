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
    <- .print("Ordering to manufacturerAgent");
        .send(supplyChainAgent, achieve, create_manufacturer);
        .wait(5000).

+!purchase: true
    <- .print("Purchasing product from manufacturerAgent");
        .send(manufacturerAgent, achieve, ship);
        .wait(5000).

+!receive: true
    <- .print("Received product from manufacturerAgent");
        !sell;
        .wait(5000).

+!sell: true
    <- .print("Selling product to retailerAgent");
       .send(retailerAgent, achieve, purchase);
       .wait(5000).

+!ship: true
    <- .print("Shipping product to retailerAgent");
        .send(retailerAgent, achieve, receive);
        .wait(5000).