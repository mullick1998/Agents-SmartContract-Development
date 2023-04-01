!start. // initial goal

+!start : true
   <- .print("Starting SupplyChain with SmartContracts");
      .addOwner(X);
      .print("Hi, I am the owner of Contract, with account:", X);
      .print("Creating RetailerAgent");
      .send(retailerAgent, achieve, a);
      .wait(1000);
      .send(retailerAgent, achieve, check_warehouse);
      .wait(1000).

+!create_wholesaler: true
    <- .print("Creating WholesalerAgent");
       .send(wholesalerAgent, achieve, a);
       .wait(1000);
       .send(wholesalerAgent, achieve, check_warehouse);
       .wait(1000).


+!create_manufacturer: true
    <- .print("Creating ManufacturerAgent");
       .send(manufacturerAgent, achieve, a);
       .wait(1000);
       .send(manufacturerAgent, achieve, check_warehouse);
       .wait(1000).

+!a : true
<<<<<<< HEAD
  <-  .print("Selling to customers"); 
=======
  <-  .print("TxHashes stored in BLOCKCHAIN"); 
>>>>>>> fdc260c2e0c9b57baf96b7b4c28f1d1f893b1466
      .print("SUPPLYCHAIN COMPLETE");
      .wait(1000).