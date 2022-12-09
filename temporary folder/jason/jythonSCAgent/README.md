## Jython (Operate MAS with blockchain)
Issues with jython:
- No stable version for maven
- found one stable version ie `jython-standalone@2.7.3`
- when run the ``.mas2j`` file, it gives again the error that can't find `PythonInterpreter` package
```
compile:
Compiling 1 source file to /home/mostakim/Agents-SmartContract-Development/jason/jythonSCAgent/bin/classes
/home/mostakim/Agents-SmartContract-Development/jason/jythonSCAgent/src/main/java/thesis/SupplyChain/jythonFIle.java:4: error: package org.python.util does not exist
import org.python.util.PythonInterpreter;
^
/home/mostakim/Agents-SmartContract-Development/jason/jythonSCAgent/src/main/java/thesis/SupplyChain/jythonFIle.java:3: error: package org.python does not exist
import org.python.*;
^
/home/mostakim/Agents-SmartContract-Development/jason/jythonSCAgent/src/main/java/thesis/SupplyChain/jythonFIle.java:8: error: cannot find symbol
try(PythonInterpreter pyInterp = new PythonInterpreter()) {
^
symbol:   class PythonInterpreter
location: class JythonHelloWorld
/home/mostakim/Agents-SmartContract-Development/jason/jythonSCAgent/src/main/java/thesis/SupplyChain/jythonFIle.java:8: error: cannot find symbol
try(PythonInterpreter pyInterp = new PythonInterpreter()) {
^
symbol:   class PythonInterpreter
location: class JythonHelloWorld
4 errors

BUILD FAILED
```

### Directory structure
```
|-- jythonSCAgent
|   |-- impl.java #code to run with jython
|   |-- src
|   |   |-- asl
|   |   |   |-- mainAgent.asl
|   |   |   |-- manufacturer.asl
|   |   |   |-- retailer.asl
|   |   |   |-- wholesaler.asl
|   |   |-- main
|   |   |   |-- java
|   |   |   |   |-- SupplyChainEnv.java
|   |   |   |   |-- thesis
|   |   |   |   |   |-- SupplyChain
|   |   |   |   |   |   |-- SupplyChain.java
|   |   |   |   |   |   |-- accessControl.java
|   |   |   |   |   |   |-- connect.java
|   |   |   |-- resources
|   |-- supplyChainAgents.mas2j
```
 - Includes `src` which has `asl` files and `main
 - `asl` contains all agent files
 - `main/java` includes `thesis.SupplyChain` package which contains a java-wrapper file generated from `SupplyChain.sol`
 - `accessControl.java` runs the java-wrappper class and success in deploying and also does all the transaction as shown by printing all the details:
    - **Problem:** Unable to change the owner of the contract.
    - **Solution:** _Proxy contract_ can be used, but can't find anything related to Java.
