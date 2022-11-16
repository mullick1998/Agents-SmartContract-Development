## web3 py
- https://web3py.readthedocs.io/en/v5/
- https://docs.moonbeam.network/builders/build/eth-api/libraries/web3py/

```
python3 supplyChain.py 
```
output:

```
<---------------------SMART CONTRACTS AND AGENTS----------------------->
Deployed Contract Address: 0xc9f78D73aCAf603Fe2319682316268A39Cc5CBB7
Owner Address: accounts[0] 0xad0BC114B5CF3F0797346fF1Fb1Daf1Cf5123395
Manufacturer Address: accounts[1] 0x4A9fe326Edc88F1f22940DC9F70BD391fB4218f8
Wholesaler Address: accounts[2] 0x5fB0Cd136C7A19E8E12F062548002B4460B0dC0d
Retailer Address: accounts[3] 0xc7D1C50D87B82E85b959DBC2cD9959bfc0480A5E
------------------------------------------------------------------------

<---------------------TRANSACTION HASHES----------------------->
Tx produceItemByManufacturer successful with hash: 0x0b6d7ae819202163e531c9b297298142f7e9b1530c6968c8c802713c4d751050
Tx packageItemByManufacturer successful with hash: 0x18bb6c283a3ae492da0a6a1af364239de23005c7e3780b3d232ac8770146dbd5
Tx sellItemByManufacturer successful with hash: 0x3446b3c393e7be7e52c73bc3cf6182959cc866cd68cb904390884d9ea3a47c30
Tx purchaseItemByWholesaler successful with hash: 0x02f28c3dd55cce7b01cd4e449ab48770a95fa3b44d3748592b80ae85f0195847
Tx shippedItemByManufacturer successful with hash: 0x05b61e41f05f053b3cb52f484797a86bed4ce5735104ddd44305d948ad5c7d55
Tx shippedItemByManufacturer successful with hash: 0x06424a38cbc8ff76b5c881272e2eb4b5bd0dfba6745bd99688b5f09ab3ba4e58
Tx shippedItemByManufacturer successful with hash: 0x703fa33e4ab463d4d09238be97b7d3122b975d16f7bd775a41c956f89e105261
Tx purchaseItemByRetailer successful with hash: 0xf845412e28699ca37ac44a8c3825177b8dfe323788fea65ba4d1181fd8fdc64f
Tx shippedItemByWholesaler successful with hash: 0x3a847fb16efe3f00d6efb5fa5406298992fbf44501324fcab07702aa3766fab0
Tx receivedItemByRetailer successful with hash: 0xf9b631df98d1ee4a3ffafa1468d6ff513ab752f0b7bc03c87033e4d1e0870fe2
```
## Run Agents
```
pip install agentspeak
python3 env.py
```
![py_run_agents](../images/py_run_agents.png)