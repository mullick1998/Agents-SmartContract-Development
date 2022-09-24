# Meeting Description

## 1st meeting (21st September 2022) [15:05 - 15:25]

- Discussed the current implementations and asked about the solution to change contract owner in web3j.
- solution provided ~ Proxy contract, use cli(not a good option, might have to use shell file or change everytime using cli), interface separator(no good)
- increase solidity version to use @openzeppelin/contracts-upgradeable
- also asked to create 1 agent at a time (e.g. retailer agent) and check if it's running by checking string