## Multi-Agent System

### Directory Structure
```bash
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
<img src="/thesis/diagrams/Flow Chart.svg" alt="Multi-Agent Flow Chart"/>

### Run Agent File
```
jason ~/thesis/jason/jasonAgent/jasonAgent.mas2j
```
### main directories
- `libs` and `scripts`: to build and run `MAS`
- **supplyChainAgents**
  - Includes `src` which has `asl` files and ``main file
  - `asl` contains all agent files
  - `main` includes `thesis.SupplyChain` package which contains a java-wrapper file generated from `SupplyChain.sol`
  - _**`Error.txt` file shows generated error while running `MAS`, reason might be solidity version.**_ 
  - **Solution:** Check the compatibilty between gradle and solidity version(Orçun Oruç)
- **jasonAgents**
  - merely to test the `asl` files without smart contracts, I created this folder.
  - Includes `asl` directory containing all the `asl` files
  - running of MAS shows:
    <img src="/thesis/images/agents_run.png" alt="Agent Run Screenshot"/>