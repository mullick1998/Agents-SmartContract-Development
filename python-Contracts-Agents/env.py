#!/usr/bin/env python

import os

import agentspeak
import agentspeak.runtime
import agentspeak.stdlib
import json
from web3 import Web3

print(f'\n<---------------------SMART CONTRACTS AND AGENTS----------------------->')

ganache_url = 'HTTP://127.0.0.1:9545'
web3 = Web3(Web3.HTTPProvider(ganache_url))

# Reading abi and bin from .json file
with open("../build/contracts/SupplyChain.json", "r") as file:
    supplyChain = json.loads(file.read())
abi = supplyChain["abi"]
bin = supplyChain["bytecode"]

# Took depolyed Address
contract_address = web3.toChecksumAddress("0xa237d3944DbCD22b44462a1d8C6b8e764EC499Ef")
# variable to be used to call function ('contract.functions.name.transact()')
contract = web3.eth.contract(address=contract_address, abi=abi)
print(f'Deployed Contract Address: {contract.address}')


# Assigning Addresses
owner_id = web3.eth.accounts[0]
manufacturer_id = web3.eth.accounts[1] 
wholesaler_id = web3.eth.accounts[2] 
retailer_id = web3.eth.accounts[3]

print(f'Owner Address: accounts[0] {owner_id}')
print(f'Manufacturer Address: accounts[1] {manufacturer_id}')
print(f'Wholesaler Address: accounts[2] {wholesaler_id}')
print(f'Retailer Address: accounts[3] {retailer_id}')
print(f'<------------------------------------------------------------------------>')
print(f'\n<---------------------INTERACTION BETWEEN AGENTS-------------------->')




actions = agentspeak.Actions(agentspeak.stdlib.actions)

@actions.add_function(".addOwner", ())
def addOwner(): 
    return owner_id

@actions.add_function(".addManufacturer", ())
def addManufacturer(): 
    #contract.functions.addManufacturer(manufacturer_id).call()
    return manufacturer_id

@actions.add_function(".addWholesaler", ())
def addWholesaler(): 
    #contract.functions.addWholesaler(wholesaler_id).call()
    return wholesaler_id

@actions.add_function(".addRetailer", ())
def addRetailer(): 
    #contract.functions.addRetailer(retailer_id).call()
    return retailer_id

@actions.add_function(".produceItemByManufacturer", (int, ))
def produceItemByManufacturer(upc): 
    tx1 = contract.functions.produceItemByManufacturer(upc, "mullick", "milk", 1).transact({
         'from': manufacturer_id
        })
    tx_receipt = web3.eth.wait_for_transaction_receipt(tx1)
    hash = tx_receipt.transactionHash.hex()
    return hash

@actions.add_function(".packageItemByManufacturer", (int, ))
def packageItemByManufacturer(upc):
    tx2 = contract.functions.packageItemByManufacturer(upc).transact({
            'from': manufacturer_id
        })
    tx_receipt = web3.eth.wait_for_transaction_receipt(tx2)
    hash = tx_receipt.transactionHash.hex()
    return hash  

@actions.add_function(".sellItemByManufacturer", (int, ))
def sellItemByManufacturer(upc):
    tx3 = contract.functions.sellItemByManufacturer(upc, 1).transact({
            'from': manufacturer_id
        })
    tx_receipt = web3.eth.wait_for_transaction_receipt(tx3)
    hash = tx_receipt.transactionHash.hex()
    return hash

@actions.add_function(".purchaseItemByWholesaler", (int, ))
def purchaseItemByWholesaler(upc):
    tx4 = contract.functions.purchaseItemByWholesaler(upc, "mullick").transact(
    {   
        'gasPrice': web3.eth.gas_price,
        'to': manufacturer_id,
        'from': wholesaler_id,
        'nonce': web3.eth.get_transaction_count(wholesaler_id),
    }
    )
    tx_receipt = web3.eth.wait_for_transaction_receipt(tx4)
    hash = tx_receipt.transactionHash.hex()
    return hash

@actions.add_function(".shippedItemByManufacturer", (int, ))
def shippedItemByManufacturer(upc):
    tx5 = contract.functions.shippedItemByManufacturer(upc).transact({
            'gasPrice': web3.eth.gas_price,
            'to': wholesaler_id,
            'from': manufacturer_id
        })
    tx_receipt = web3.eth.wait_for_transaction_receipt(tx5)
    hash = tx_receipt.transactionHash.hex()
    return hash

@actions.add_function(".receivedItemByWholesaler", (int, ))
def receivedItemByWholesaler(upc):
    tx6 = contract.functions.receivedItemByWholesaler(upc).transact({
            'gasPrice': web3.eth.gas_price,
            'from': wholesaler_id,
            'to': manufacturer_id
        })
    tx_receipt = web3.eth.wait_for_transaction_receipt(tx6)
    hash = tx_receipt.transactionHash.hex()
    return hash

@actions.add_function(".sellItemByWholesaler", (int, ))
def sellItemByWholesaler(upc):
    tx7 = contract.functions.sellItemByWholesaler(upc, 1).transact({
            'from': wholesaler_id,
            'to': retailer_id
        })
    tx_receipt = web3.eth.wait_for_transaction_receipt(tx7)
    hash = tx_receipt.transactionHash.hex()
    return hash

@actions.add_function(".purchaseItemByRetailer", (int, ))
def purchaseItemByRetailer(upc):
    tx8 = contract.functions.purchaseItemByRetailer(upc,"mrs. mullick").transact(
    {
        'gasPrice': web3.eth.gas_price,
        'to': wholesaler_id,
        'from': retailer_id,
        'nonce': web3.eth.get_transaction_count(retailer_id),
    }
    )
    tx_receipt = web3.eth.wait_for_transaction_receipt(tx8)
    hash = tx_receipt.transactionHash.hex()
    return hash

@actions.add_function(".shippedItemByWholesaler", (int, ))
def shippedItemByWholesaler(upc):
    tx9 = contract.functions.shippedItemByWholesaler(upc).transact({
            'from': wholesaler_id,
            'to': retailer_id
        })
    tx_receipt = web3.eth.wait_for_transaction_receipt(tx9)
    hash = tx_receipt.transactionHash.hex()
    return hash

@actions.add_function(".receivedItemByRetailer", (int, ))
def receivedItemByRetailer(upc):
    tx10 = contract.functions.receivedItemByRetailer(upc).transact({
            'from': retailer_id,
            'to': wholesaler_id
        })
    tx_receipt = web3.eth.wait_for_transaction_receipt(tx10)
    hash = tx_receipt.transactionHash.hex()
    return hash

# Agents running .asl files
env = agentspeak.runtime.Environment()

with open(os.path.join(os.path.dirname(__file__), "asl/supplyChainAgent.asl")) as source:
    agents = env.build_agents(source, 1, actions)

with open(os.path.join(os.path.dirname(__file__), "asl/manufacturerAgent.asl")) as source:
    agents.append(env.build_agent(source, actions))
    
with open(os.path.join(os.path.dirname(__file__), "asl/wholesalerAgent.asl")) as source:
    agents.append(env.build_agent(source, actions))

with open(os.path.join(os.path.dirname(__file__), "asl/retailerAgent.asl")) as source:
    agents.append(env.build_agent(source, actions))
    

if __name__ == "__main__":
    env.run()