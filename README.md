# SMART CONTRACT DEVELOPMENT WITH JASON BDI AGENTS
**Agent-oriented programming** has been developed over the few decades in order to comprehend the relationship between dynamic environments and software applications. 

**Belief-Desire-Intention agents can implement a plan execution library that consists of objectives and goals.** Beliefs are the environmental status, and these agents can update the status of the environment. For instance, weather degree is a dynamic environment variable that can be updated by agents to use with rule-based conditions such as desires and intentions. 

Agents can plan to reach a common goal, which is the fundamental objective for dynamic simulations in various domains such as traffic, transportation, supply chain, and aviation. However, agent-oriented programming follows a different approach than object-oriented programming design, for instance, you can develop rule-based smart applications without using machine learning techniques in an object-oriented language. 

**JASON framework is one of the Belief-Desire-Intention Framework** that comprises Java-based interpreter and AgentSpeak language. A supply chain simulation can be implemented with JASON-based agents and smart contracts. 

A manufacturer, wholesaler, and retailer can realize a product flow. **A retailer can take products from a wholesaler and manufacturer(factory) and a warehouse of the retailer can be updated by rule-based agents upon requesting an order.** This sort of simulation can interact with smart contracts so that one can follow traces of interactions between supply chain network members (retailer, manufacturer, and wholesaler) in a detailed way. Every transaction (operation) between supply chain members are stored in a blockchain network and then one can use this simulation tool without applying an external distributed logging framework.

# Contents
- [Directory Structure](#directory-structure)
- [Implement Smart-contracts](#compile-contract)
- [MAS Implementation using JASON](#jason-agentspeak)

## Overall Class Diagram
<img src="diagrams/OverallClassDiagram.svg" alt="Overall Class Diagram"/>

## Activity Diagram
<img src="diagrams/Activity Diagram.svg" alt="Activity Diagram"/>

## Contract Data Model Diagram
<img src="diagrams/Data Model diagram.svg" alt="Contract Data Model Diagram"/>

## Contract Sequence Diagram
<img src="diagrams/Sequence diagram.svg" alt="Contract Sequence Diagram"/>

## Compile Contract
```
truffle compile
```

## Deploy Contract
```
truffle migrate --network <network-name>
truffle migrate --network <network-name> --reset --all
```
Available networks: `development`, `rinkeby`,  `alfajores`

*Note: Multiple network configuration can be find inside `truffle-config.js`*
## Test Contract
```
truffle test --network <network-name>
```
Sample Usage
```
truffle test --network sampledevelopment
```
<img src="images/test_ss.png" alt="Unit Test Screenshot"/>

### Generate java wrapper class web3j
```
web3j generate truffle --truffle-json /home/mostakim/thesis/build/contracts/SupplyChain.json -o /home/mostakim/thesis/jason/supplyChainAgents/src/main/java -p thesis.SupplyChain
```

## JASON (AgentSpeak)
Install JASON from [here](https://github.com/jason-lang/jason/blob/master/doc/tutorials/getting-started/shell-based.adoc).

set the Jason home directory with the following command:
```
export JASON_HOME=~/thesis/jason/
export PATH=$JASON_HOME/scripts:$PATH
```
## Multi-Agent Flow Chart
<img src="diagrams/Flow Chart.svg" alt="Multi-Agent Flow Chart"/>

### Run Agent File
```
jason ~/thesis/jason/jasonAgent/jasonAgent.mas2j
```
Output ( without connecting to contracts):

<img src="images/agents_run.png" alt="Agent Run Screenshot"/>

### Run Agent on IDE
```
jason-ide
```
## Directory Structure

```
.gitignore
README.md
package-lock.json
package.json
truffle-config.js
meeting (Orçun Oruç)
|-- meeting_description.md
|-- small_presentation.pdf
Papers
|-- Related Paper
|-- Master thesis paper
contracts
|-- ManufacturerRole.sol
|-- Migrations.sol
|-- Ownable.sol
|-- RetailerRole.sol
|-- Roles.sol
|-- SupplyChain.sol
|-- SupplyChainUpgradeable.sol
|-- WholesalerRole.sol
migrations
|-- 1_initial_migration.js
|-- 2_deploy_contracts.js
test
|-- TestSupplychain.js
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
diagrams
|-- Activity Diagram.svg
|-- Data Model diagram.svg
|-- Flow Chart.svg
|-- OverallClassDiagram.svg
|-- Sequence diagram.svg
gantt chart
|-- Gantt_Chart.xlsx
images
|-- agents_run.png
|-- test_ss.png
```

[Thesis Paper](https://www.overleaf.com/project/62dfc9e6c07bbf02dc82519e)
