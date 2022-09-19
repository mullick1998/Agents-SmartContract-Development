import jason.asSyntax.*;
import jason.environment.Environment;

import java.util.logging.Logger;
public class SupplyChainEnv extends Environment {

    public static final Literal hrp = Literal.parseLiteral("has(retailer, product)");
    public static final Literal hwp = Literal.parseLiteral("has(wholesaler, product)");
    public static final Literal hmp = Literal.parseLiteral("has(manufacturer, product)");

    public static final Literal hpribm = Literal.parseLiteral("has(produceItemByManufacturer");
    public static final Literal hpaibm = Literal.parseLiteral("has(packageItemByManufacturer");
    public static final Literal hseibm = Literal.parseLiteral("has(sellItemByManufacturer");
    public static final Literal hpibw = Literal.parseLiteral("has(purchaseItemByWholesaler");
    public static final Literal hshibm = Literal.parseLiteral("has(shippedItemByManufacturer");
    public static final Literal hribw = Literal.parseLiteral("has(receivedItemByWholesaler");
    public static final Literal hseibw = Literal.parseLiteral("has(sellItemByWholesaler");
    public static final Literal hpibr = Literal.parseLiteral("has(purchaseItemByRetailer");
    public static final Literal hshibw = Literal.parseLiteral("has(shippedItemByWholesaler");
    public static final Literal hribr = Literal.parseLiteral("has(receivedItemByRetailer");

    static Logger logger = Logger.getLogger(SupplyChainEnv.class.getName());

    public void init(String[] args){

    }

    public boolean executeAction(String ag, Structure action){
        logger.info(ag+ "doing: "+ action);
        return false;
    }

    void updatePercepts(){

    }
}