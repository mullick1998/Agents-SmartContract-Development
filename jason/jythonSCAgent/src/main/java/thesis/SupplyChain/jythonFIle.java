package thesis.SupplyChain;

import org.python.*;
import org.python.util.PythonInterpreter;

class JythonSupplyChain {
    public static void main(String[] args) {
        try(PythonInterpreter pyInterp = new PythonInterpreter()) {
            pyInterp.exec("print('Hello! Create SupplyChain using Jython')");
        }
    }
}