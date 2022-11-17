## Smart Contracts

Each supply chain agent's solidity file is included in the directory, along with SupplyChain.sol, which initiates the work flow amongst all the agents.

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
<img src="../images/test_ss.png" alt="Unit Test Screenshot"/>
