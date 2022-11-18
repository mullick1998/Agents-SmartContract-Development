
+!start
  <- .print("I am running");
     .wait(2000).

+!a : true
  <- .addManufacturer(X);
     .print("Hi, I am here, with account:", X);
     .wait(1000).

+!check_warehouse: true
    <- .print("Checking Warehouse, and Manufacturing");
        !manufacture;
        .wait(1000).

+!manufacture: true
    <- .print("Manufacturing Product");
        .produceItemByManufacturer(3, X);
        .print("Tx produceItemByManufacturer successful with hash:", X);
        !package;
        .wait(1000).

+!package: true
    <- .print("Packaging Product");
        .packageItemByManufacturer(3, X);
        .print("Tx packageItemByManufacturer successful with hash:", X);
        !sell;
        .wait(1000).

+!sell: true
    <- .print("Selling product to wholesalerAgent");
        .sellItemByManufacturer(3, X);
        .print("Tx sellItemByManufacturer successful with hash:", X);
       .send(wholesalerAgent, achieve, purchase);
       .wait(1000).

+!ship: true
    <- .print("Shipping product to wholesalerAgent");
        .shippedItemByManufacturer(3, X);
        .print("Tx shippedItemByManufacturer successful with hash:", X);
        .send(wholesalerAgent, achieve, receive);
        .wait(1000).