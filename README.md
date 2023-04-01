# SMART CONTRACT DEVELOPMENT WITH JASON BDI AGENTS
**Agent-oriented programming** has been developed over the few decades in order to comprehend the relationship between dynamic environments and software applications. 

**Belief-Desire-Intention agents can implement a plan execution library that consists of objectives and goals.** Beliefs are the environmental status, and these agents can update the status of the environment. For instance, weather degree is a dynamic environment variable that can be updated by agents to use with rule-based conditions such as desires and intentions. 

Agents can plan to reach a common goal, which is the fundamental objective for dynamic simulations in various domains such as traffic, transportation, supply chain, and aviation. However, agent-oriented programming follows a different approach than object-oriented programming design, for instance, you can develop rule-based smart applications without using machine learning techniques in an object-oriented language. 

**JASON framework is one of the Belief-Desire-Intention Framework** that comprises Java-based interpreter and AgentSpeak language. A supply chain simulation can be implemented with JASON-based agents and smart contracts. 

A manufacturer, wholesaler, and retailer can realize a product flow. **A retailer can take products from a wholesaler and manufacturer(factory) and a warehouse of the retailer can be updated by rule-based agents upon requesting an order.** This sort of simulation can interact with smart contracts so that one can follow traces of interactions between supply chain network members (retailer, manufacturer, and wholesaler) in a detailed way. Every transaction (operation) between supply chain members are stored in a blockchain network and then one can use this simulation tool without applying an external distributed logging framework.

# Contents
- [Directory Structure](#directory-structure)
- [Sequence DIagram](#sequence-diagrams)
- [MAS Implementation with smart-contracts](#check-agents-with-smart-contracts)

## Overall Class Diagram
<img src="diagrams/OverallClassDiagram.svg" alt="Overall Class Diagram"/>

# Sequence Diagrams

## Agent Interaction Sequence Diagram

```plantuml
@startuml
!pragma teoz true
actor Customer

box "Supply Chain Agents" #Yellow
entity MainAgent
Participant ManufacturerAgent
Participant WholesalerAgent
Participant RetailerAgent
end box


note over Customer: Want to buy
activate Customer #LightGrey
Customer -> MainAgent : Approch Framework
activate MainAgent #LightGrey

MainAgent -> RetailerAgent : Activates ""RetailerAgent""
activate RetailerAgent #DarkSalmon
RetailerAgent -> RetailerAgent: Checks Warehouse
note right RetailerAgent #Pink : //If it has product then sell// \n //to Customer otherwise it// \n will let the ""MainAgent"" \n //to activate// ""WholesalerAgent"". \n  **(Assume insufficient stock)**

RetailerAgent -> MainAgent : request to activate ""WholesalerAgent""

MainAgent-> WholesalerAgent: Activates ""WholesalerAgent""
activate WholesalerAgent #DarkSalmon
WholesalerAgent -> WholesalerAgent : Checks Warehouse
note over WholesalerAgent #Pink :  **(Assume insufficient stock)**
WholesalerAgent -> MainAgent : request to activate ""ManufacturerAgent""

MainAgent-> ManufacturerAgent: Activates ""ManufacturerAgent""
activate ManufacturerAgent #DarkSalmon
ManufacturerAgent -> ManufacturerAgent : Checks Warehouse
note over ManufacturerAgent #Pink : **(Assume insufficient stock)**

note over ManufacturerAgent: //Manufactures product//

note over ManufacturerAgent: //Packages product//


ManufacturerAgent -> WholesalerAgent: //Out for Sale//


note over WholesalerAgent: //Purchase Product by paying// \n //the desire amount by Manufacturer//


ManufacturerAgent -> WholesalerAgent: //Sending Product to Wholesaler//

note over WholesalerAgent: //Receives Product//

WholesalerAgent -> WholesalerAgent : Checks Warehouse if Inventory is full, \n **If not** then order more product.
note over WholesalerAgent #Pink :  **(Assume sufficient stock)**

WholesalerAgent -> RetailerAgent : //Out for Sale//


note over RetailerAgent: //Purchase Product by paying// \n //the desire amount by ""WholesalerAgent""//


WholesalerAgent -> RetailerAgent : //Sending Product to Retailer//

deactivate WholesalerAgent


note over RetailerAgent: //Receives Product//

RetailerAgent --> MainAgent: Confirmation of Product's availablity
deactivate RetailerAgent


MainAgent --> Customer : Sells Product
deactivate MainAgent
deactivate Customer
@enduml
```

## Smart Contract Sequence Diagram

```plantuml
@startuml

box "Supply Chain Roles" #LightBlue

Participant Manufacturer
Participant Wholesaler
Participant Retailer
end box

box #Yellow
entity SmartContractGenerator as App
end box

box "Blockchain Network" #LightGreen
database EthereumVirtualMachine as EVM
end box

note over Manufacturer: //Manufactures product//
Manufacturer -> App: invoking ""produceItemByManufacturer()""
activate Manufacturer #DarkSalmon
activate App
App -> EVM : generating smart contract
activate EVM #FFBBBB
note over EVM #Orange: Generating ""Transaction Hash""
note right #yellow: **""Tx hash""** for \n Product manufactured
EVM --> App: Fetching **""Tx hash""** from Blockchain network

note over Manufacturer: //Packages product//
Manufacturer -> App: invoking ""packageItemByManufacturer()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""** for \n Product packaged
EVM --> App: Fetching **""Tx hash""** from Blockchain network

note over Manufacturer: //Out for Sale//
Manufacturer-> App: invoking ""sellItemByManufacturer()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""** for \n Product sold
EVM --> App: Fetching **""Tx hash""** from Blockchain network

note over Wholesaler: //Purchase Product by paying// \n //the desire amount by Manufacturer//
Wholesaler -> Manufacturer : Purchases product
activate Wholesaler #DarkSalmon
Wholesaler -> App  : invoking ""purchaseItemByWholesaler()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""**  for \n Product purchased
EVM --> App: Fetching **""Tx hash""** from Blockchain network

note over Manufacturer: //Sending Product to Wholesaler//
Manufacturer -> Wholesaler: Ships Product
Manufacturer -> App: invoking ""shippedItemByManufacturer()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""**  for \n Product shipped
EVM --> App: Fetching **""Tx hash""** from Blockchain network

deactivate Manufacturer 

note over Wholesaler: //Receives Product//
Wholesaler -> App: invoking ""receivedItemByWholesaler()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""**  for \n Product received
EVM --> App: Fetching **""Tx hash""** from Blockchain network

note over Wholesaler: //Out for Sale//
Wholesaler-> App: invoking ""sellItemByWholesaler()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""**  for \n Product sold
EVM --> App: Fetching **""Tx hash""** from Blockchain network

note over Retailer: //Purchase Product by paying// \n //the desire amount by Wholesaler//

Retailer -> Wholesaler : Purchases product
activate Retailer #DarkSalmon
Retailer -> App  : invoking ""purchaseItemByRetailer()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""**  for \n Product purchased
EVM --> App: Fetching **""Tx hash""** from Blockchain network

note over Wholesaler: //Sending Product to Retailer//
Wholesaler -> Retailer: Ships Product
Wholesaler -> App: invoking ""shippedItemByWholesaler()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""**  for \n Product shipped
EVM --> App: Fetching **""Tx hash""** from Blockchain network

deactivate Wholesaler

note over Retailer: //Receives Product//
Retailer -> App: invoking ""receivedItemByRetailer()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""**  for \n Product received
EVM --> App: Fetching **""Tx hash""** from Blockchain network
deactivate EVM
deactivate App
deactivate Retailer

@enduml
```

## Agent and Smart Contract Sequence Diagram

```plantuml
@startuml
!pragma teoz true
actor Customer
box "Supply Chain (Jason BDI Agents and Smart Contrcats)" #LightYellow

box "Supply Chain Agents" #LightBlue
entity MainAgent
Participant ManufacturerAgent
Participant WholesalerAgent
Participant RetailerAgent
end box

box #Yellow
entity SmartContractGenerator as App
end box

end box

note over Customer: Want to buy
activate Customer #LightGrey
Customer -> MainAgent : Approch Framework
activate MainAgent #LightGrey

MainAgent -> RetailerAgent : Activates ""RetailerAgent""
activate RetailerAgent #DarkSalmon
RetailerAgent -> RetailerAgent: Checks Warehouse
note right RetailerAgent #Pink : //If it has product then sell// \n //to Customer otherwise it// \n will let the ""MainAgent"" \n //to activate ""WholesalerAgent"".// \n  **(Assume insufficient stock)**

RetailerAgent -> MainAgent : request to activate ""WholesalerAgent""
MainAgent-> WholesalerAgent: Activates ""WholesalerAgent""
activate WholesalerAgent #DarkSalmon
WholesalerAgent -> WholesalerAgent : Checks Warehouse
note over WholesalerAgent #Pink :  **(Assume insufficient stock)**
WholesalerAgent -> MainAgent : request to activate ""ManufacturerAgent""
MainAgent-> ManufacturerAgent: Activates ""ManufacturerAgent""
activate ManufacturerAgent #DarkSalmon
ManufacturerAgent -> ManufacturerAgent : Checks Warehouse
note over ManufacturerAgent #Pink : **(Assume insufficient stock)**

box "Blockchain Network" #LightGreen
database EthereumVirtualMachine as EVM
end box

note over ManufacturerAgent: //Manufactures product//
ManufacturerAgent -> App: invoking ""produceItemByManufacturer()""
activate App
App -> EVM : generating smart contract
activate EVM #FFBBBB
note over EVM #Orange: Generating ""Transaction Hash""
note right #yellow: **""Tx hash""** for \n Product manufactured
EVM --> App: Fetching **""Tx hash""** from Blockchain network

note over ManufacturerAgent: //Packages product//
ManufacturerAgent -> App: invoking ""packageItemByManufacturer()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""** for \n Product packaged
EVM --> App: Fetching **""Tx hash""** from Blockchain network

note over ManufacturerAgent: //Out for Sale//
ManufacturerAgent-> App: invoking ""sellItemByManufacturer()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""** for \n Product sold
EVM --> App: Fetching **""Tx hash""** from Blockchain network

note over WholesalerAgent: //Purchase Product by paying// \n //the desire amount by Manufacturer//
WholesalerAgent -> ManufacturerAgent : Purchases product
WholesalerAgent -> App  : invoking ""purchaseItemByWholesaler()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""**  for \n Product purchased
EVM --> App: Fetching **""Tx hash""** from Blockchain network

note over ManufacturerAgent: //Sending Product to Wholesaler//
ManufacturerAgent -> WholesalerAgent: Ships Product
ManufacturerAgent -> App: invoking ""shippedItemByManufacturer()""
deactivate ManufacturerAgent
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""**  for \n Product shipped
EVM --> App: Fetching **""Tx hash""** from Blockchain network
 

note over WholesalerAgent: //Receives Product//
WholesalerAgent -> App: invoking ""receivedItemByWholesaler()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""**  for \n Product received
EVM --> App: Fetching **""Tx hash""** from Blockchain network

WholesalerAgent -> WholesalerAgent : Checks Warehouse if Inventory is full, \n **If not** then order more product.
note over WholesalerAgent #Pink :  **(Assume sufficient stock)**

note over WholesalerAgent: //Out for Sale//
WholesalerAgent -> App: invoking ""sellItemByWholesaler()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""**  for \n Product sold
EVM --> App: Fetching **""Tx hash""** from Blockchain network

note over RetailerAgent: //Purchase Product by paying// \n //the desire amount by// ""WholesalerAgent""

RetailerAgent -> WholesalerAgent : Purchases product
RetailerAgent -> App  : invoking ""purchaseItemByRetailer()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""**  for \n Product purchased
EVM --> App: Fetching **""Tx hash""** from Blockchain network

note over WholesalerAgent: //Sending Product to Retailer//
WholesalerAgent -> RetailerAgent: Ships Product
WholesalerAgent -> App: invoking ""shippedItemByWholesaler()""
deactivate WholesalerAgent
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""**  for \n Product shipped
EVM --> App: Fetching **""Tx hash""** from Blockchain network

note over RetailerAgent: //Receives Product//
RetailerAgent -> App: invoking ""receivedItemByRetailer()""
App -> EVM: generating smart contract
note right #yellow: **""Tx hash""**  for \n Product received
EVM --> App: Fetching **""Tx hash""** from Blockchain network
deactivate EVM
deactivate App
RetailerAgent --> MainAgent: Confirmation of Product's availablity
deactivate RetailerAgent


MainAgent --> Customer : Sells Product
deactivate MainAgent
deactivate Customer
@enduml
```

## Test smart Contracts
```
cd smartcontracts/
truffle test --network development
```
![Test](/images/Screenshot%20from%202023-02-25%2014-43-07.png)
**show ganache page also, transaction page**

# Check Agents with smart Contracts

```
cd ..
cd python-Contracts-Agents/
```
Cases:
1. RetailerAgent been asked and it send and sells products because retailer warehouse has sufficient inventory.

```
python3 env.py
```

![Test](/images/Screenshot%20from%202023-02-25%2018-46-53.png)

2. Retailer been asked but retailer warehouse has unsufficient inventory, so ask wholesaleagent, and wholesaler warehouse has sufficient inventory

```
python3 env.py
```
![Test](/images/Screenshot%20from%202023-02-25%2018-48-18.png)

3. Retailer been asked but retailer warehouse has unsufficient inventory, so ask wholesaleragent, and wholesaler warehouse has also insufficient inventory, so ask manufactureragent, and manufacturer warehouse has also sufficient inventory

```
python3 env.py
```


![Test](/images/Screenshot%20from%202023-02-25%2018-49-15.png)

4. Retailer been asked but retailer warehouse has unsufficient inventory, so ask wholesaleragent, and wholesaler warehouse has also insufficient inventory, so ask manufactureragent, and manufacturer warehouse has also insufficient inventory, so manufacture product.

```
python3 env.py
```
![Test](/images/Screenshot%20from%202023-02-25%2018-50-46.png)


## Directory Structure

```
.gitignore
diagrams
images
Master_thesis.pdf
Master thesis
|-- thesis.tex
|-- includes
|  |-- *.tex
|  |-- figures
papers
|-- Related Paper
meeting (Orçun Oruç)
|-- meeting_description.md
|-- small_presentation.pdf
python-Contracts-Agents
|-- asl
|-- env.py
smartcontracts
|-- README.md
|-- package-lock.json
|-- package.json
|-- truffle-config.js
|-- contracts
|  |-- *.sol
|-- migrations
|  |-- 1_initial_migration.js
|  |-- 2_deploy_contracts.js
|-- test
|  |-- TestSupplychain.js
jason
|-- jedit
|-- libs
|-- scripts
|-- jasonAgent
|   |-- src
|   |   |-- asl
|-- supplyChainAgents
|   |-- src
|   |   |-- asl
|   |   |-- main
|   |   |   |-- java
|   |   |   |   |-- thesis
|   |   |   |   |   |-- SupplyChain
|   |   |   |   |   |   |-- SupplyChain.java
|   |   |   |   |   |   |-- accessControl.java
|   |   |   |-- resources
|   |-- supplyChainAgents.mas2j
|   |-- pom.xml
|-- jythonSCAgents
|   |-- src
|   |   |-- asl
|   |   |-- main
|   |   |   |-- java
|   |   |   |   |-- thesis
|   |   |   |   |   |-- SupplyChain
|   |   |   |   |   |   |-- jythonFile.java
|   |   |   |-- resources
|   |-- supplyChainAgents.mas2j
|   |-- pom.xml
```

[Thesis Paper](https://www.overleaf.com/project/62dfc9e6c07bbf02dc82519e)
