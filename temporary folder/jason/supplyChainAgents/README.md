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


# Solution for the jar file problem of JASON

```bash
mvn install:install-file -Dfile=libs/jason-3.1.jar -DgroupId=org.jason -DartifactId=supplyChainAgents -Dversion=1.0 -Dpackaging=jar
```

Open a folder named libs and put the jason-3.1.jar into the folder

Put the following configuration

```bash
<dependency>
    <groupId>org.jason</groupId>
    <artifactId>jason</artifactId>
    <version>3.1</version>
    <scope>system</scope>
    <systemPath>${basedir}/libs/jason-3.1.jar</systemPath>
</dependency>
```

Put the following property configuration into the maven file

```bash
<properties>
    <maven.compiler.source>11 </maven.compiler.source>
    <maven.compiler.target>11 </maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
</properties>
```


Do not use the following configuration in the web3j maven configuration

```
<scope>runtime</scope>
```

Runtime scope is only useful for unit tests at runtime or database connection parameters for JDBC drivers. We need compile time features of Web3j.

When I run the main method with the following command, there is no runtime issue.

```bash
mvn compile exec:java -Dexec.mainClass="thesis.SupplyChain.accessControl"
```


@Source: https://intellipaat.com/community/6786/how-to-add-local-jar-files-to-a-maven-project 


Generate your contracts with the following code

```bash
mvn web3j:generate-sources
``` 

You can find your contracts under rolebasedcontracts folder.