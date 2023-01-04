# import json
# from web3 import Web3

# print(f'\n<---------------------SMART CONTRACTS AND AGENTS----------------------->')

# ganache_url = 'HTTP://127.0.0.1:9545'
# web3 = Web3(Web3.HTTPProvider(ganache_url))

# # Reading abi file
# with open("../python-Contracts-Agents/abi-bin/SupplyChain.abi", "r") as file:
#     abi = json.loads(file.read())

# # Took depolyed Address
# contract_address = web3.toChecksumAddress("0xc9f78D73aCAf603Fe2319682316268A39Cc5CBB7")
# # variable to be used to call function ('contract.functions.name.transact()')
# contract = web3.eth.contract(address=contract_address, abi=abi)
# print(f'Deployed Contract Address: {contract.address}')


# # Assigning Addresses
# owner_id = web3.eth.accounts[0]
# manufacturer_id = web3.eth.accounts[1] 
# wholesaler_id = web3.eth.accounts[2] 
# retailer_id = web3.eth.accounts[3]

# print(f'Owner Address: accounts[0] {owner_id}')
# print(f'Manufacturer Address: accounts[1] {manufacturer_id}')
# print(f'Wholesaler Address: accounts[2] {wholesaler_id}')
# print(f'Retailer Address: accounts[3] {retailer_id}')
# print(f'------------------------------------------------------------------------')
# print(f'\n<----------------------------TRANSACTION HASHES--------------------------->')

# # Calling functions for SupplyChain
# def produceItemByManufacturer(upc): 
#     tx1 = contract.functions.produceItemByManufacturer(upc, "mullick", "milk", 1).transact({
#             'from': manufacturer_id
#         })
#     tx_receipt = web3.eth.wait_for_transaction_receipt(tx1)
#     print(f'Tx produceItemByManufacturer successful with hash: { tx_receipt.transactionHash.hex() }')    


# def packageItemByManufacturer():
#     tx2 = contract.functions.packageItemByManufacturer(1).transact({
#             'from': manufacturer_id
#         })
#     tx_receipt = web3.eth.wait_for_transaction_receipt(tx2)
#     print(f'Tx packageItemByManufacturer successful with hash: { tx_receipt.transactionHash.hex() }')    


# def sellItemByManufacturer():
#     tx3 = contract.functions.sellItemByManufacturer(1, 1).transact({
#             'from': manufacturer_id
#         })
#     tx_receipt = web3.eth.wait_for_transaction_receipt(tx3)
#     print(f'Tx sellItemByManufacturer successful with hash: { tx_receipt.transactionHash.hex() }')


# def purchaseItemByWholesaler():
#     tx4 = contract.functions.purchaseItemByWholesaler(1, "mullick").transact(
#     {   
#         'gasPrice': web3.eth.gas_price,
#         'to': manufacturer_id,
#         'from': wholesaler_id,
#         'nonce': web3.eth.get_transaction_count(wholesaler_id),
#     }
#     )
#     tx_receipt = web3.eth.wait_for_transaction_receipt(tx4)
#     print(f'Tx purchaseItemByWholesaler successful with hash: { tx_receipt.transactionHash.hex() }')


# def shippedItemByManufacturer():
#     tx5 = contract.functions.shippedItemByManufacturer(1).transact({
#             'gasPrice': web3.eth.gas_price,
#             'to': wholesaler_id,
#             'from': manufacturer_id
#         })
#     tx_receipt = web3.eth.wait_for_transaction_receipt(tx5)
#     print(f'Tx shippedItemByManufacturer successful with hash: { tx_receipt.transactionHash.hex() }')


# def receivedItemByWholesaler():
#     tx6 = contract.functions.receivedItemByWholesaler(1).transact({
#             'gasPrice': web3.eth.gas_price,
#             'from': wholesaler_id,
#             'to': manufacturer_id
#         })
#     tx_receipt = web3.eth.wait_for_transaction_receipt(tx6)
#     print(f'Tx shippedItemByManufacturer successful with hash: { tx_receipt.transactionHash.hex() }')


# def sellItemByWholesaler():
#     tx7 = contract.functions.sellItemByWholesaler(1, 1).transact({
#             'from': wholesaler_id,
#             'to': retailer_id
#         })
#     tx_receipt = web3.eth.wait_for_transaction_receipt(tx7)
#     print(f'Tx shippedItemByManufacturer successful with hash: { tx_receipt.transactionHash.hex() }')


# def purchaseItemByRetailer():
#     tx8 = contract.functions.purchaseItemByRetailer(1,"mrs. mullick").transact(
#     {
#         'gasPrice': web3.eth.gas_price,
#         'to': wholesaler_id,
#         'from': retailer_id,
#         'nonce': web3.eth.get_transaction_count(retailer_id),
#     }
#     )
#     tx_receipt = web3.eth.wait_for_transaction_receipt(tx8)
#     print(f'Tx purchaseItemByRetailer successful with hash: { tx_receipt.transactionHash.hex() }')


# def shippedItemByWholesaler():
#     tx9 = contract.functions.shippedItemByWholesaler(1).transact({
#             'from': wholesaler_id,
#             'to': retailer_id
#         })
#     tx_receipt = web3.eth.wait_for_transaction_receipt(tx9)
#     print(f'Tx shippedItemByWholesaler successful with hash: { tx_receipt.transactionHash.hex() }')


# def receivedItemByRetailer():
#     tx10 = contract.functions.receivedItemByRetailer(1).transact({
#             'from': retailer_id,
#             'to': wholesaler_id
#         })
#     tx_receipt = web3.eth.wait_for_transaction_receipt(tx10)
#     print(f'Tx receivedItemByRetailer successful with hash: { tx_receipt.transactionHash.hex() }')


# produceItemByManufacturer(1)
# # packageItemByManufacturer()
# # sellItemByManufacturer()
# # purchaseItemByWholesaler()
# # shippedItemByManufacturer()
# # receivedItemByWholesaler()
# # sellItemByWholesaler()
# purchaseItemByRetailer()
# # shippedItemByWholesaler()
# # receivedItemByRetailer()

#!/usr/bin/env python

import os

import agentspeak
import agentspeak.runtime
import agentspeak.stdlib
import json
from web3 import Web3
actions = agentspeak.Actions(agentspeak.stdlib.actions)
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