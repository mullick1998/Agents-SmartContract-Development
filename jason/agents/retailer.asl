/* Initial goals */
!check_warehouse.
!order.
!receive.
!sell.

+!check_warehouse: true
    <- !sell.
-!check_warehouse: false
    <- !order.

+!order : true //purchaseItemByRetailer
    <- .send(wholesaler, achieve, has(retailer,product))
        //&& purchaseItemByRetailer()
        && .print("Item purchased by Retailer").

+has(retailer,product): true
    <- !sell.
-has(retailer,product): true
    <- !order.

+!receive_product: true
    <- //receivedItemByRetailer()
        && .print("Item received by Retailer").

+sell: true
    <- .print("Supply Chain Complete");
