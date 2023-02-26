inventory(2).
order(8).

+!start
  <- .print("I am running");
     .wait(2000).

+!a : true
  <- .addManufacturer(X);
     .print("Hi, I am here, with account:", X);
     .wait(1000).

+!check_warehouse: inventory(A) & order(B) & A >= B
    <- .print("Checking Warehouse");
        .print("Quantity alread exist in inventory, dont need to manufacture!");
        -inventory(10);
        !sell;
        .wait(1000).

+!check_warehouse: inventory(A) & order(B) & A < B
    <- +inventory(10);
        .print("Checking Warehouse");
        !manufacture;
        .wait(1000).

+!manufacture: true
    <- .print("INSUFFICIENT INVENTORY!! Manufacturing Product..");
        .produceItemByManufacturer(3, X);
        +inventory(10);
        .print("Tx produceItemByManufacturer successful with hash:", X);
        !package;
        .wait(1000).

+!package: inventory(A) & order(B) & A < B
    <- .print("Packaging Product");
        .packageItemByManufacturer(3, X);
        .print("Tx packageItemByManufacturer successful with hash:", X);
        !sell;
        .wait(1000).

+!package: inventory(A) & order(B) & A >= B
    <- .packageItemByManufacturer(3, X);
        !sell;
        .wait(1000).

+!sell: true
    <- .print("Selling product to wholesalerAgent");
        .sellItemByManufacturer(3, X);
        .print("Tx sellItemByManufacturer successful with hash:", X);
        .send(wholesalerAgent, achieve, purchase);
        .wait(1000).

+!sellAgain: true
    <- .print("Selling product to wholesalerAgent Again");
        .sellItemByManufacturer(3, X);
        .print("Tx sellItemByManufacturer successful with hash:", X);
        .send(wholesalerAgent, achieve, purchaseAgain);
        .wait(1000).

+!ship: true
    <- .print("Shipping product to wholesalerAgent");
        .shippedItemByManufacturer(3, X);
        .print("Tx shippedItemByManufacturer successful with hash:", X);
        .send(wholesalerAgent, achieve, receive);
        .wait(1000).

+!shipAgain: true
    <- .print("Shipping product to wholesalerAgent");
        .shippedItemByManufacturer(3, X);
        .print("Tx shippedItemByManufacturer successful with hash:", X);
        .send(wholesalerAgent, achieve, receiveAgain);
        .wait(1000).