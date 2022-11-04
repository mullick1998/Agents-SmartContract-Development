## Operate MAS with blockchain

### Directory structure
```
|-- supplyChainAgents
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
```
> Task :processResources UP-TO-DATE
> Task :classes

> Task :accessControl.main()
Web3j client version: EthereumJS TestRPC/v2.13.1/ethereum-js
<-------------------ACCOUNTS----------------------->
CONTRACT ADDRESS: 0x41a8d1153234b0bf690840f2f5f0f4378a9d8d8e
Contract Owner: 0xad0bc114b5cf3f0797346ff1fb1daf1cf5123395
Manufacturer ID: 0x4a9fe326edc88f1f22940dc9f70bd391fb4218f8
Wholesaler ID: 0x5fb0cd136c7a19e8e12f062548002b4460b0dc0d
Retailer ID: 0xc7d1c50d87b82e85b959dbc2cd9959bfc0480a5e

BUILD SUCCESSFUL in 17s
3 actionable tasks: 2 executed, 1 up-to-date
12:46:39: Execution finished ':accessControl.main()'.
```
### Error while running the agents (Check **error.md**)
- Gets the following _**`Pacakge error` while running `MAS`, reason might be solidity version's incompatibility with the gradle's version.**_
  - **Solution:** Check **meeting folder** (Mr. Orçun Oruç)