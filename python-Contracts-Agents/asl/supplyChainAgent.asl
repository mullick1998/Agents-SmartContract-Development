!start. // initial goal

+!start : true
   <- .print("Creating RetailerAgent");
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