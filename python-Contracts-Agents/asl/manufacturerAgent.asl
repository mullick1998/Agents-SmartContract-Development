<<<<<<< HEAD
inventory(9).
order(8).
=======
>>>>>>> fdc260c2e0c9b57baf96b7b4c28f1d1f893b1466

+!start
  <- .print("I am running");
     .wait(2000).

+!a : true
  <- .addManufacturer(X);
     .print("Hi, I am here, with account:", X);
     .wait(1000).

<<<<<<< HEAD
+!check_warehouse: inventory(A) & order(B) & A >= B
    <- .print("Checking Warehouse");
        .print("Quantity alread exist in inventory, dont need to manufacture!");
        -inventory(10);
        !sell;
        .wait(1000).

+!check_warehouse: inventory(A) & order(B) & A < B
    <- +inventory(10);
        .print("Checking Warehouse");
=======
+!check_warehouse: true
    <- .print("Checking Warehouse, and Manufacturing");
>>>>>>> fdc260c2e0c9b57baf96b7b4c28f1d1f893b1466
        !manufacture;
        .wait(1000).

+!manufacture: true
<<<<<<< HEAD
    <- .print("INSUFFICIENT INVENTORY!! Manufacturing Product..");
        .produceItemByManufacturer(3, X);
        +inventory(10);
=======
    <- .print("Manufacturing Product");
        .produceItemByManufacturer(3, X);
>>>>>>> fdc260c2e0c9b57baf96b7b4c28f1d1f893b1466
        .print("Tx produceItemByManufacturer successful with hash:", X);
        !package;
        .wait(1000).

<<<<<<< HEAD
+!package: inventory(A) & order(B) & A < B
=======
+!package: true
>>>>>>> fdc260c2e0c9b57baf96b7b4c28f1d1f893b1466
    <- .print("Packaging Product");
        .packageItemByManufacturer(3, X);
        .print("Tx packageItemByManufacturer successful with hash:", X);
        !sell;
        .wait(1000).

<<<<<<< HEAD
+!package: inventory(A) & order(B) & A >= B
    <- .packageItemByManufacturer(3, X);
        !sell;
        .wait(1000).

=======
>>>>>>> fdc260c2e0c9b57baf96b7b4c28f1d1f893b1466
+!sell: true
    <- .print("Selling product to wholesalerAgent");
        .sellItemByManufacturer(3, X);
        .print("Tx sellItemByManufacturer successful with hash:", X);
<<<<<<< HEAD
        .send(wholesalerAgent, achieve, purchase);
        .wait(1000).

+!sellAgain: true
    <- .print("Selling product to wholesalerAgent Again");
        .sellItemByManufacturer(3, X);
        .print("Tx sellItemByManufacturer successful with hash:", X);
        .send(wholesalerAgent, achieve, purchaseAgain);
        .wait(1000).
=======
       .send(wholesalerAgent, achieve, purchase);
       .wait(1000).
>>>>>>> fdc260c2e0c9b57baf96b7b4c28f1d1f893b1466

+!ship: true
    <- .print("Shipping product to wholesalerAgent");
        .shippedItemByManufacturer(3, X);
        .print("Tx shippedItemByManufacturer successful with hash:", X);
        .send(wholesalerAgent, achieve, receive);
<<<<<<< HEAD
        .wait(1000).

+!shipAgain: true
    <- .print("Shipping product to wholesalerAgent");
        .shippedItemByManufacturer(3, X);
        .print("Tx shippedItemByManufacturer successful with hash:", X);
        .send(wholesalerAgent, achieve, receiveAgain);
=======
>>>>>>> fdc260c2e0c9b57baf96b7b4c28f1d1f893b1466
        .wait(1000).