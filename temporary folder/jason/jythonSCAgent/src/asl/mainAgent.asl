!start. // initial goal

+!start : true
   <- .print("Creating RetailerAgent");
      .create_agent(retailerAgent, "retailerAgent.asl");
      .send(retailerAgent, achieve, a);
      .wait(5000);
      .send(retailerAgent, achieve, check_warehouse);
      .wait(5000).

+!create_wholesaler: true
    <- .print("Creating WholesalerAgent");
       .create_agent(wholesalerAgent, "wholesalerAgent.asl");
       .send(wholesalerAgent, achieve, a);
       .wait(5000);
       .send(wholesalerAgent, achieve, check_warehouse);
       .wait(5000).


+!create_manufacturer: true
    <- .print("Creating ManufacturerAgent");
       .create_agent(manufacturerAgent, "manufacturerAgent.asl");
       .send(manufacturerAgent, achieve, a);
       .wait(5000);
       .send(manufacturerAgent, achieve, check_warehouse);
       .wait(5000).