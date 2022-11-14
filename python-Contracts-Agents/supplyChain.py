import json
from web3 import Web3
from web3 import EthereumTesterProvider
from solcx import compile_standard, install_solc

print("---------------------SMART CONTRACTS AND AGENTS-----------------------")

ganache_url = 'HTTP://127.0.0.1:9545'
web3 = Web3(Web3.HTTPProvider(ganache_url))

# Reading abi file
with open("../python-Contracts-Agents/abi-bin/SupplyChain.abi", "r") as file:
    abi = json.loads(file.read())

# Took depolyed Address
contract_address = web3.toChecksumAddress("0xc9f78D73aCAf603Fe2319682316268A39Cc5CBB7")
# variable to be used to call function ('contract.functions.name.transact()')
contract = web3.eth.contract(address=contract_address, abi=abi)
print("Deployed Contract Address: "+contract.address)


# Assigning Addresses
owner_id = web3.eth.accounts[0]
manufacturer_id = web3.eth.accounts[1] 
wholesaler_id = web3.eth.accounts[2] 
retailer_id = web3.eth.accounts[3]

print("Owner's Address: "+owner_id)
print("Manufacturer's Address: "+manufacturer_id)
print("Wholesaler's Address: "+wholesaler_id)
print("Retailer's Address: "+retailer_id)

#latest_block = w3.eth.get_block('latest')
#print(latest_block)
#wallet = w3.toChecksumAddress('0x4A9fe326Edc88F1f22940DC9F70BD391fB4218f8')
#print(w3.eth.get_balance(wallet))
#print(w3.fromWei(w3.eth.get_balance(wallet), 'ether'))