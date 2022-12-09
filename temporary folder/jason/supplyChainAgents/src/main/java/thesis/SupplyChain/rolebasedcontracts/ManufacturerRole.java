package thesis.SupplyChain.rolebasedcontracts;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.8.9.
 */
@SuppressWarnings("rawtypes")
public class ManufacturerRole extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061001a3361001f565b6100ef565b61003781600061006e60201b6100c51790919060201c565b6040516001600160a01b038216907f561138658ca49a8540dc70dcfe64c9026c1c5b9344642242dd6562970f9c127890600090a250565b6001600160a01b03811661008157600080fd5b61008b82826100ba565b1561009557600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19166001179055565b60006001600160a01b0382166100cf57600080fd5b506001600160a01b03166000908152602091909152604090205460ff1690565b610278806100fe6000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806317d4a491146100465780635f8a5afa1461006d578063de07f34e14610082575b600080fd5b610059610054366004610212565b61008a565b604051901515815260200160405180910390f35b61008061007b366004610212565b61009c565b005b6100806100ba565b60006100968183610111565b92915050565b6100a53361008a565b6100ae57600080fd5b6100b781610146565b50565b6100c333610188565b565b6001600160a01b0381166100d857600080fd5b6100e28282610111565b156100ec57600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19166001179055565b60006001600160a01b03821661012657600080fd5b506001600160a01b03166000908152602091909152604090205460ff1690565b6101516000826100c5565b6040516001600160a01b038216907f561138658ca49a8540dc70dcfe64c9026c1c5b9344642242dd6562970f9c127890600090a250565b6101936000826101ca565b6040516001600160a01b038216907f2fed5abf6a80d6dfe30b4895481b2fc5d7dce5f8f7b931832f4a2947d5040c7f90600090a250565b6001600160a01b0381166101dd57600080fd5b6101e78282610111565b6101f057600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19169055565b60006020828403121561022457600080fd5b81356001600160a01b038116811461023b57600080fd5b939250505056fea26469706673582212207deafc46f6ad16f4bcd435f55f680025d286134b3b36f21090a1fe740886316064736f6c63430008090033";

    public static final String FUNC_ADDMANUFACTURER = "addManufacturer";

    public static final String FUNC_ISMANUFACTURER = "isManufacturer";

    public static final String FUNC_RENOUNCEMANUFACTURER = "renounceManufacturer";

    public static final Event MANUFACTURERADDED_EVENT = new Event("ManufacturerAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event MANUFACTURERREMOVED_EVENT = new Event("ManufacturerRemoved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected ManufacturerRole(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ManufacturerRole(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ManufacturerRole(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ManufacturerRole(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ManufacturerAddedEventResponse> getManufacturerAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MANUFACTURERADDED_EVENT, transactionReceipt);
        ArrayList<ManufacturerAddedEventResponse> responses = new ArrayList<ManufacturerAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ManufacturerAddedEventResponse typedResponse = new ManufacturerAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ManufacturerAddedEventResponse> manufacturerAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ManufacturerAddedEventResponse>() {
            @Override
            public ManufacturerAddedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MANUFACTURERADDED_EVENT, log);
                ManufacturerAddedEventResponse typedResponse = new ManufacturerAddedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ManufacturerAddedEventResponse> manufacturerAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MANUFACTURERADDED_EVENT));
        return manufacturerAddedEventFlowable(filter);
    }

    public List<ManufacturerRemovedEventResponse> getManufacturerRemovedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MANUFACTURERREMOVED_EVENT, transactionReceipt);
        ArrayList<ManufacturerRemovedEventResponse> responses = new ArrayList<ManufacturerRemovedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ManufacturerRemovedEventResponse typedResponse = new ManufacturerRemovedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ManufacturerRemovedEventResponse> manufacturerRemovedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ManufacturerRemovedEventResponse>() {
            @Override
            public ManufacturerRemovedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MANUFACTURERREMOVED_EVENT, log);
                ManufacturerRemovedEventResponse typedResponse = new ManufacturerRemovedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ManufacturerRemovedEventResponse> manufacturerRemovedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MANUFACTURERREMOVED_EVENT));
        return manufacturerRemovedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addManufacturer(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDMANUFACTURER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isManufacturer(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISMANUFACTURER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceManufacturer() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEMANUFACTURER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ManufacturerRole load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ManufacturerRole(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ManufacturerRole load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ManufacturerRole(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ManufacturerRole load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ManufacturerRole(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ManufacturerRole load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ManufacturerRole(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ManufacturerRole> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ManufacturerRole.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<ManufacturerRole> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ManufacturerRole.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ManufacturerRole> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ManufacturerRole.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ManufacturerRole> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ManufacturerRole.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class ManufacturerAddedEventResponse extends BaseEventResponse {
        public String account;
    }

    public static class ManufacturerRemovedEventResponse extends BaseEventResponse {
        public String account;
    }
}
