/* Initial goals */
last_order_id(1).

!check_warehouse.
!manufacture.
!package.
!sell.
!ship.

+!check_warehouse: true
    <- !sell.
-!check_warehouse: false
    <- !manufacture.

+!manufacture : true //produceItemByManufacturer()
    <- ?last_order_id(N);
        OrderId = N + 1;
        -+last_order_id(OrderId)// produceItemByManufacturer()
        && .print("Item manufactured by manufacturer").
        && !package.

+!package : true
    <- // packageItemByManufacturer()
        && .print("Item packaged by manufacturer").

+has(manufacturer,product): true
    <- !sell.
-has(manufacturer,product): true
    <- !manufacture.

+sell: true
    <- .print("Sell to Wholesaler").
        //&& sellItemByManufacturer()
        && !ship.

+!ship: true
     <- .print("Ship to Wholesaler, Payment received already!")
        //&& shippedItemByManufacturer()

