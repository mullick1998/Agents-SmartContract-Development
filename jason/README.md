## Multi-Agent System

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
Install JASON from [here](https://github.com/jason-lang/jason/blob/master/doc/tutorials/getting-started/shell-based.adoc).

set the Jason home directory with the following command:
```
export JASON_HOME=~/thesis/jason/
export PATH=$JASON_HOME/scripts:$PATH
```
## Multi-Agent Flow Chart
<img src="../diagrams/Flow Chart.svg" alt="Multi-Agent Flow Chart"/>

### Run Agent File
```
jason ~/thesis/jason/jasonAgent/jasonAgent.mas2j
```
### main directories
- `libs` and `scripts`: to build and run `MAS`
- **supplyChainAgents** : Connects MAS via blockchain
- **jasonAgents** : merely to test the `asl` files without smart contracts