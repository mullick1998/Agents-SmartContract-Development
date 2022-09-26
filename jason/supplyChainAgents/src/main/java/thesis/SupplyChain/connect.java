package thesis.SupplyChain;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class connect {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        if (!(engine instanceof Invocable)) {
            System.out.println("Invoking methods is not supported.");
            return;
        }
        Invocable inv = (Invocable) engine;
        String scriptPath = "/home/mostakim/thesis/test/TestSupplychain.js";

        engine.eval("load('" + scriptPath + "')");

        Object SupplyChain = engine.get("SupplyChain");

        int x = 3;
        int y = 4;
        Object addResult = inv.invokeMethod(SupplyChain, "produceItemByManufacturer", 1,"mullick", "milk", 1);


        System.out.println(addResult);
    }
}
