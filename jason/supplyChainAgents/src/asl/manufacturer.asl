init.
+init : true
  <- .print("I am running");
     .wait(2000).

+!a : true
  <- .print("Ok, I am here");
     .wait(2000).

+!check_warehouse: true
    <- .print("Checking Warehouse, and Manufacturing");
        !manufacture;
        .wait(5000).

+!manufacture: true
    <- .print("Manufacture Product");
        !package;
        .wait(5000).

+!package: true
    <- .print("Packaging Product");
        !sell;
        .wait(5000).

+!sell: true
    <- .print("Selling product to wholesalerAgent");
       .send(wholesalerAgent, achieve, purchase);
       .wait(5000).

+!ship: true
    <- .print("Shipping product to wholesalerAgent");
        .send(wholesalerAgent, achieve, receive);
        .wait(5000).