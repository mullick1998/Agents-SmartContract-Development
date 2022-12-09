!start. // initial goal

+!start : true
   <- .print("Creating Retailer");
      .create_agent(bob, "bob.asl");
      .send(bob, achieve, a);
      .wait(100);
      .print("Killing agent bob!");
      .kill_agent(bob);

      .print("Creating agent with internal action");

      !end(10000).

+!end(T) : T <= 0 <- .stopMAS.
+!end(T) : true
   <- .print("The MAS will stop in ",T/1000," seconds!");
      .wait(2000); !end(T-5000).
