/* Initial goals */
!check_warehouse.
!order.
!receive.
!sell.
!ship.

+!check_warehouse: true
    <- !sell.
-!check_warehouse: false
    <- !order.

+!order : true //purchaseItemByWholesaler
    <- .send(manufacturer, achieve, has(wholesaler,product))
        //&& purchaseItemByWholesaler()
        && .print("Item purchased by wholesaler").

+has(wholesaler,product): true
    <- !sell.
-has(wholesaler,product): true
    <- !order.

+!receive_product: true
    <- //receivedItemByWholesaler()
        && .print("Item received by wholesaler")

+sell: true
    <- .print("Sell to Retailer")
        //&& sellItemByWholesaler()
        && !ship.

+!ship: true
     <- .print("Ship to Retailer, Payment received already!")
        //&& shippedItemByWholesaler()

