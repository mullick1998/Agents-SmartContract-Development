## command 
```
jason /home/mostakim/thesis/jason/supplyChainAgents/supplyChainAgents.mas2j
```
## error:
```
mostakim@mostakim:~/thesis$ jason /home/mostakim/thesis/jason/supplyChainAgents/supplyChainAgents.mas2j
Executing /usr/lib/jvm/jdk-18/bin/java -classpath /home/mostakim/thesis/jason/libs/ant-launcher-1.10.5.jar org.apache.tools.ant.launch.Launcher -e -f bin/supplyChainAgents.xml run
Buildfile: /home/mostakim/thesis/jason/supplyChainAgents/bin/supplyChainAgents.xml

init:

user-init:

compile:
Compiling 4 source files to /home/mostakim/thesis/jason/supplyChainAgents/bin/classes
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:3: error: package io.reactivex does not exist
import io.reactivex.Flowable;
                   ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:4: error: package io.reactivex.functions does not exist
import io.reactivex.functions.Function;
                             ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:12: error: package org.web3j.abi does not exist
import org.web3j.abi.EventEncoder;
                    ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:13: error: package org.web3j.abi does not exist
import org.web3j.abi.TypeReference;
                    ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:14: error: package org.web3j.abi.datatypes does not exist
import org.web3j.abi.datatypes.Address;
                              ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:15: error: package org.web3j.abi.datatypes does not exist
import org.web3j.abi.datatypes.Bool;
                              ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:16: error: package org.web3j.abi.datatypes does not exist
import org.web3j.abi.datatypes.Event;
                              ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:17: error: package org.web3j.abi.datatypes does not exist
import org.web3j.abi.datatypes.Type;
                              ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:18: error: package org.web3j.abi.datatypes does not exist
import org.web3j.abi.datatypes.Utf8String;
                              ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:19: error: package org.web3j.abi.datatypes.generated does not exist
import org.web3j.abi.datatypes.generated.Uint256;
                                        ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:20: error: package org.web3j.abi.datatypes.generated does not exist
import org.web3j.abi.datatypes.generated.Uint8;
                                        ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:21: error: package org.web3j.crypto does not exist
import org.web3j.crypto.Credentials;
                       ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:22: error: package org.web3j.protocol does not exist
import org.web3j.protocol.Web3j;
                         ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:23: error: package org.web3j.protocol.core does not exist
import org.web3j.protocol.core.DefaultBlockParameter;
                              ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:24: error: package org.web3j.protocol.core does not exist
import org.web3j.protocol.core.RemoteCall;
                              ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:25: error: package org.web3j.protocol.core does not exist
import org.web3j.protocol.core.RemoteFunctionCall;
                              ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:26: error: package org.web3j.protocol.core.methods.request does not exist
import org.web3j.protocol.core.methods.request.EthFilter;
                                              ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:27: error: package org.web3j.protocol.core.methods.response does not exist
import org.web3j.protocol.core.methods.response.BaseEventResponse;
                                               ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:28: error: package org.web3j.protocol.core.methods.response does not exist
import org.web3j.protocol.core.methods.response.Log;
                                               ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:29: error: package org.web3j.protocol.core.methods.response does not exist
import org.web3j.protocol.core.methods.response.TransactionReceipt;
                                               ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:30: error: package org.web3j.tuples.generated does not exist
import org.web3j.tuples.generated.Tuple11;
                                 ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:31: error: package org.web3j.tuples.generated does not exist
import org.web3j.tuples.generated.Tuple2;
                                 ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:32: error: package org.web3j.tuples.generated does not exist
import org.web3j.tuples.generated.Tuple7;
                                 ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:33: error: package org.web3j.tuples.generated does not exist
import org.web3j.tuples.generated.Tuple9;
                                 ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:34: error: package org.web3j.tx does not exist
import org.web3j.tx.Contract;
                   ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:35: error: package org.web3j.tx does not exist
import org.web3j.tx.TransactionManager;
                   ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:36: error: package org.web3j.tx.gas does not exist
import org.web3j.tx.gas.ContractGasProvider;
                       ^
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:48: error: cannot find symbol
public class SupplyChain extends Contract {
                                 ^
  symbol: class Contract
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:109: error: cannot find symbol
    public static final Event FORSALEBYMANUFACTURER_EVENT = new Event("ForSaleByManufacturer",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:113: error: cannot find symbol
    public static final Event FORSALEBYWHOLESALER_EVENT = new Event("ForSaleByWholesaler",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:117: error: cannot find symbol
    public static final Event MANUFACTURERADDED_EVENT = new Event("ManufacturerAdded",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:121: error: cannot find symbol
    public static final Event MANUFACTURERREMOVED_EVENT = new Event("ManufacturerRemoved",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:125: error: cannot find symbol
    public static final Event PACKAGEDBYMANUFACTURER_EVENT = new Event("PackagedByManufacturer",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:129: error: cannot find symbol
    public static final Event PRODUCEBYMANUFACTURER_EVENT = new Event("ProduceByManufacturer",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:133: error: cannot find symbol
    public static final Event PURCHASEDBYRETAILER_EVENT = new Event("PurchasedByRetailer",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:137: error: cannot find symbol
    public static final Event PURCHASEDBYWHOLESALER_EVENT = new Event("PurchasedByWholesaler",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:141: error: cannot find symbol
    public static final Event RECEIVEDBYRETAILER_EVENT = new Event("ReceivedByRetailer",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:145: error: cannot find symbol
    public static final Event RECEIVEDBYWHOLESALER_EVENT = new Event("ReceivedByWholesaler",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:149: error: cannot find symbol
    public static final Event RETAILERADDED_EVENT = new Event("RetailerAdded",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:153: error: cannot find symbol
    public static final Event RETAILERREMOVED_EVENT = new Event("RetailerRemoved",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:157: error: cannot find symbol
    public static final Event SHIPPEDBYMANUFACTURER_EVENT = new Event("ShippedByManufacturer",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:161: error: cannot find symbol
    public static final Event SHIPPEDBYWHOLESALER_EVENT = new Event("ShippedByWholesaler",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:165: error: cannot find symbol
    public static final Event TRANSFEROWNERSHIP_EVENT = new Event("TransferOwnership",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:169: error: cannot find symbol
    public static final Event WHOLESALERADDED_EVENT = new Event("WholesalerAdded",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:173: error: cannot find symbol
    public static final Event WHOLESALERREMOVED_EVENT = new Event("WholesalerRemoved",
                        ^
  symbol:   class Event
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:185: error: cannot find symbol
    protected SupplyChain(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
                                                  ^
  symbol:   class Web3j
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:185: error: cannot find symbol
    protected SupplyChain(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
                                                               ^
  symbol:   class Credentials
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:189: error: cannot find symbol
    protected SupplyChain(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
                                                  ^
  symbol:   class Web3j
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:189: error: cannot find symbol
    protected SupplyChain(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
                                                               ^
  symbol:   class Credentials
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:189: error: cannot find symbol
    protected SupplyChain(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
                                                                                        ^
  symbol:   class ContractGasProvider
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:194: error: cannot find symbol
    protected SupplyChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
                                                  ^
  symbol:   class Web3j
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:194: error: cannot find symbol
    protected SupplyChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
                                                               ^
  symbol:   class TransactionManager
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:198: error: cannot find symbol
    protected SupplyChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
                                                  ^
  symbol:   class Web3j
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:198: error: cannot find symbol
    protected SupplyChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
                                                               ^
  symbol:   class TransactionManager
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:198: error: cannot find symbol
    protected SupplyChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
                                                                                                      ^
  symbol:   class ContractGasProvider
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:202: error: cannot find symbol
    public List<ForSaleByManufacturerEventResponse> getForSaleByManufacturerEvents(TransactionReceipt transactionReceipt) {
                                                                                   ^
  symbol:   class TransactionReceipt
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:1077: error: cannot find symbol
    public static class ForSaleByManufacturerEventResponse extends BaseEventResponse {
                                                                   ^
  symbol:   class BaseEventResponse
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:214: error: cannot find symbol
    public Flowable<ForSaleByManufacturerEventResponse> forSaleByManufacturerEventFlowable(EthFilter filter) {
                                                                                           ^
  symbol:   class EthFilter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:214: error: cannot find symbol
    public Flowable<ForSaleByManufacturerEventResponse> forSaleByManufacturerEventFlowable(EthFilter filter) {
           ^
  symbol:   class Flowable
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:227: error: cannot find symbol
    public Flowable<ForSaleByManufacturerEventResponse> forSaleByManufacturerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
                                                                                           ^
  symbol:   class DefaultBlockParameter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:227: error: cannot find symbol
    public Flowable<ForSaleByManufacturerEventResponse> forSaleByManufacturerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
                                                                                                                             ^
  symbol:   class DefaultBlockParameter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:227: error: cannot find symbol
    public Flowable<ForSaleByManufacturerEventResponse> forSaleByManufacturerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
           ^
  symbol:   class Flowable
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:233: error: cannot find symbol
    public List<ForSaleByWholesalerEventResponse> getForSaleByWholesalerEvents(TransactionReceipt transactionReceipt) {
                                                                               ^
  symbol:   class TransactionReceipt
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:1081: error: cannot find symbol
    public static class ForSaleByWholesalerEventResponse extends BaseEventResponse {
                                                                 ^
  symbol:   class BaseEventResponse
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:245: error: cannot find symbol
    public Flowable<ForSaleByWholesalerEventResponse> forSaleByWholesalerEventFlowable(EthFilter filter) {
                                                                                       ^
  symbol:   class EthFilter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:245: error: cannot find symbol
    public Flowable<ForSaleByWholesalerEventResponse> forSaleByWholesalerEventFlowable(EthFilter filter) {
           ^
  symbol:   class Flowable
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:258: error: cannot find symbol
    public Flowable<ForSaleByWholesalerEventResponse> forSaleByWholesalerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
                                                                                       ^
  symbol:   class DefaultBlockParameter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:258: error: cannot find symbol
    public Flowable<ForSaleByWholesalerEventResponse> forSaleByWholesalerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
                                                                                                                         ^
  symbol:   class DefaultBlockParameter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:258: error: cannot find symbol
    public Flowable<ForSaleByWholesalerEventResponse> forSaleByWholesalerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
           ^
  symbol:   class Flowable
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:264: error: cannot find symbol
    public List<ManufacturerAddedEventResponse> getManufacturerAddedEvents(TransactionReceipt transactionReceipt) {
                                                                           ^
  symbol:   class TransactionReceipt
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:1085: error: cannot find symbol
    public static class ManufacturerAddedEventResponse extends BaseEventResponse {
                                                               ^
  symbol:   class BaseEventResponse
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:276: error: cannot find symbol
    public Flowable<ManufacturerAddedEventResponse> manufacturerAddedEventFlowable(EthFilter filter) {
                                                                                   ^
  symbol:   class EthFilter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:276: error: cannot find symbol
    public Flowable<ManufacturerAddedEventResponse> manufacturerAddedEventFlowable(EthFilter filter) {
           ^
  symbol:   class Flowable
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:289: error: cannot find symbol
    public Flowable<ManufacturerAddedEventResponse> manufacturerAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
                                                                                   ^
  symbol:   class DefaultBlockParameter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:289: error: cannot find symbol
    public Flowable<ManufacturerAddedEventResponse> manufacturerAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
                                                                                                                     ^
  symbol:   class DefaultBlockParameter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:289: error: cannot find symbol
    public Flowable<ManufacturerAddedEventResponse> manufacturerAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
           ^
  symbol:   class Flowable
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:295: error: cannot find symbol
    public List<ManufacturerRemovedEventResponse> getManufacturerRemovedEvents(TransactionReceipt transactionReceipt) {
                                                                               ^
  symbol:   class TransactionReceipt
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:1089: error: cannot find symbol
    public static class ManufacturerRemovedEventResponse extends BaseEventResponse {
                                                                 ^
  symbol:   class BaseEventResponse
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:307: error: cannot find symbol
    public Flowable<ManufacturerRemovedEventResponse> manufacturerRemovedEventFlowable(EthFilter filter) {
                                                                                       ^
  symbol:   class EthFilter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:307: error: cannot find symbol
    public Flowable<ManufacturerRemovedEventResponse> manufacturerRemovedEventFlowable(EthFilter filter) {
           ^
  symbol:   class Flowable
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:320: error: cannot find symbol
    public Flowable<ManufacturerRemovedEventResponse> manufacturerRemovedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
                                                                                       ^
  symbol:   class DefaultBlockParameter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:320: error: cannot find symbol
    public Flowable<ManufacturerRemovedEventResponse> manufacturerRemovedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
                                                                                                                         ^
  symbol:   class DefaultBlockParameter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:320: error: cannot find symbol
    public Flowable<ManufacturerRemovedEventResponse> manufacturerRemovedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
           ^
  symbol:   class Flowable
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:326: error: cannot find symbol
    public List<PackagedByManufacturerEventResponse> getPackagedByManufacturerEvents(TransactionReceipt transactionReceipt) {
                                                                                     ^
  symbol:   class TransactionReceipt
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:1093: error: cannot find symbol
    public static class PackagedByManufacturerEventResponse extends BaseEventResponse {
                                                                    ^
  symbol:   class BaseEventResponse
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:338: error: cannot find symbol
    public Flowable<PackagedByManufacturerEventResponse> packagedByManufacturerEventFlowable(EthFilter filter) {
                                                                                             ^
  symbol:   class EthFilter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:338: error: cannot find symbol
    public Flowable<PackagedByManufacturerEventResponse> packagedByManufacturerEventFlowable(EthFilter filter) {
           ^
  symbol:   class Flowable
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:351: error: cannot find symbol
    public Flowable<PackagedByManufacturerEventResponse> packagedByManufacturerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
                                                                                             ^
  symbol:   class DefaultBlockParameter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:351: error: cannot find symbol
    public Flowable<PackagedByManufacturerEventResponse> packagedByManufacturerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
                                                                                                                               ^
  symbol:   class DefaultBlockParameter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:351: error: cannot find symbol
    public Flowable<PackagedByManufacturerEventResponse> packagedByManufacturerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
           ^
  symbol:   class Flowable
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:357: error: cannot find symbol
    public List<ProduceByManufacturerEventResponse> getProduceByManufacturerEvents(TransactionReceipt transactionReceipt) {
                                                                                   ^
  symbol:   class TransactionReceipt
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:1097: error: cannot find symbol
    public static class ProduceByManufacturerEventResponse extends BaseEventResponse {
                                                                   ^
  symbol:   class BaseEventResponse
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:369: error: cannot find symbol
    public Flowable<ProduceByManufacturerEventResponse> produceByManufacturerEventFlowable(EthFilter filter) {
                                                                                           ^
  symbol:   class EthFilter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:369: error: cannot find symbol
    public Flowable<ProduceByManufacturerEventResponse> produceByManufacturerEventFlowable(EthFilter filter) {
           ^
  symbol:   class Flowable
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:382: error: cannot find symbol
    public Flowable<ProduceByManufacturerEventResponse> produceByManufacturerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
                                                                                           ^
  symbol:   class DefaultBlockParameter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:382: error: cannot find symbol
    public Flowable<ProduceByManufacturerEventResponse> produceByManufacturerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
                                                                                                                             ^
  symbol:   class DefaultBlockParameter
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:382: error: cannot find symbol
    public Flowable<ProduceByManufacturerEventResponse> produceByManufacturerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
           ^
  symbol:   class Flowable
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:388: error: cannot find symbol
    public List<PurchasedByRetailerEventResponse> getPurchasedByRetailerEvents(TransactionReceipt transactionReceipt) {
                                                                               ^
  symbol:   class TransactionReceipt
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:1101: error: cannot find symbol
    public static class PurchasedByRetailerEventResponse extends BaseEventResponse {
                                                                 ^
  symbol:   class BaseEventResponse
  location: class SupplyChain
/home/mostakim/thesis/jason/supplyChainAgents/src/main/java/thesis/SupplyChain/SupplyChain.java:400: error: cannot find symbol
    public Flowable<PurchasedByRetailerEventResponse> purchasedByRetailerEventFlowable(EthFilter filter) {
                                                                                       ^
  symbol:   class EthFilter
  location: class SupplyChain
100 errors
only showing the first 100 errors, of 835 total; use -Xmaxerrs if you would like to see more

BUILD FAILED
/home/mostakim/thesis/jason/supplyChainAgents/bin/supplyChainAgents.xml:45: Compile failed; see the compiler error output for details.
```