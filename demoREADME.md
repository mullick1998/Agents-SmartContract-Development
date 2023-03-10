## Test smart Contracts
```
cd smartcontracts/
truffle test --network development
```
![Test](/images/Screenshot%20from%202023-02-25%2014-43-07.png)
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
