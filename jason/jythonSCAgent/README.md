## Operate MAS with blockchain and jython

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
