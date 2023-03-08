## Test smart Contracts
```
cd smartcontracts/
truffle test --network development
```
**show ganache page also, transaction page**

## Check Agents with smart Contracts

```
cd ..
cd python-Contracts-Agents/
```
Cases:
1. RetailerAgent been asked and it send and sells products because retailer warehouse has sufficient inventory.

```
python3 env.py
```

2. Retailer been asked but retailer warehouse has unsufficient inventory, so ask wholesaleagent, and wholesaler warehouse has sufficient inventory

```
python3 env.py
```

3. Retailer been asked but retailer warehouse has unsufficient inventory, so ask wholesaleragent, and wholesaler warehouse has also insufficient inventory, so ask manufactureragent, and manufacturer warehouse has also sufficient inventory

```
python3 env.py
```


4. Retailer been asked but retailer warehouse has unsufficient inventory, so ask wholesaleragent, and wholesaler warehouse has also insufficient inventory, so ask manufactureragent, and manufacturer warehouse has sufficient inventory

```
python3 env.py
```


3. Retailer been asked but retailer warehouse has unsufficient inventory, so ask wholesaleragent, and wholesaler warehouse has also insufficient inventory, so ask manufactureragent, and manufacturer warehouse has also insufficient inventory, so manufacture product.

```
python3 env.py
```

1. dont change anything
2. Change retailer
3. change wholesaler
4. change retailer and wholesaler
5. change retailer
6. change wholesaler and manufacturer