## Multi-Agent System

### Generate java wrapper class web3j
```
web3j generate truffle --truffle-json /home/mostakim/Agents-SmartContract-Development/build/contracts/SupplyChain.json -o /home/mostakim/Agents-SmartContract-Development/jason/supplyChainAgents/src/main/java -p thesis.SupplyChain
```

## JASON (AgentSpeak)
Install JASON from [here](https://github.com/jason-lang/jason/blob/master/doc/tutorials/getting-started/shell-based.adoc).

set the Jason home directory with the following command:
```
export JASON_HOME=~/Agents-SmartContract-Development/jason/
export PATH=$JASON_HOME/scripts:$PATH
```
## Multi-Agent Flow Chart
<img src="../diagrams/Flow Chart.svg" alt="Multi-Agent Flow Chart"/>

### Run Agent File
```
jason ~/Agents-SmartContract-Development/jason/jasonAgent/jasonAgent.mas2j
```
Output ( without connecting to contracts):

<img src="../images/agents_run.png" alt="Agent Run Screenshot"/>

### Run Agent on IDE
```
jason-ide
```

### Directory Structure
```
jason
|-- jedit
|-- libs
|-- scripts
|-- jasonAgent
|   |-- src
|   |   |-- asl
|   |   |   |-- manufacturerAgent.asl
|   |   |   |-- retailerAgent.asl
|   |   |   |-- supplyChainAgent.asl
|   |   |   |-- wholesalerAgent.asl
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


### Run Agent File
```
jason ~/thesis/jason/jasonAgent/jasonAgent.mas2j
```
### main directories
- `libs` and `scripts`: to build and run `MAS`
- **supplyChainAgents** : Connects MAS via blockchain
- **jasonAgents** : merely to test the `asl` files without smart contracts


### TASK - IMPORTANT

We need to solve the following error: 

```bash
[ERROR] /Users/orcunoruc/Desktop/papers/TU_Dresden_Proposal/MyProposal/PHD-Presentations/Student-Projects/Mostakim-Work/MostakimThesisNewVersion/JASONBDIConnectionWeb3j/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/accessControl.java:[58,20] method purchaseItemByWholesaler in class thesis.SupplyChain.rolebasedcontracts.SupplyChain cannot be applied to given types;
[ERROR]   required: java.math.BigInteger,java.lang.String
[ERROR]   found:    java.math.BigInteger,java.lang.String,java.math.BigInteger
[ERROR]   reason: actual and formal argument lists differ in length
[ERROR] /Users/orcunoruc/Desktop/papers/TU_Dresden_Proposal/MyProposal/PHD-Presentations/Student-Projects/Mostakim-Work/MostakimThesisNewVersion/JASONBDIConnectionWeb3j/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/accessControl.java:[62,20] method purchaseItemByRetailer in class thesis.SupplyChain.rolebasedcontracts.SupplyChain cannot be applied to given types;
[ERROR]   required: java.math.BigInteger,java.lang.String
[ERROR]   found:    java.math.BigInteger,java.lang.String,java.math.BigInteger
[ERROR]   reason: actual and formal argument lists differ in length
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
```
