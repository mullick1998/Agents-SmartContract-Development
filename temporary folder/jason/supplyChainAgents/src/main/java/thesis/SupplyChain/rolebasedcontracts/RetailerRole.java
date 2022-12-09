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
public class RetailerRole extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061001a3361001f565b6100ef565b61003781600061006e60201b6100c51790919060201c565b6040516001600160a01b038216907f71ae26cad02663e3d92efd6ec56031a80d74a20c0ab4183faa8bf262261c9baa90600090a250565b6001600160a01b03811661008157600080fd5b61008b82826100ba565b1561009557600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19166001179055565b60006001600160a01b0382166100cf57600080fd5b506001600160a01b03166000908152602091909152604090205460ff1690565b610278806100fe6000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80635da09b88146100465780638ec4f5051461006d578063db0e6a2f14610082575b600080fd5b610059610054366004610212565b61008a565b604051901515815260200160405180910390f35b61008061007b366004610212565b61009c565b005b6100806100ba565b60006100968183610111565b92915050565b6100a53361008a565b6100ae57600080fd5b6100b781610146565b50565b6100c333610188565b565b6001600160a01b0381166100d857600080fd5b6100e28282610111565b156100ec57600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19166001179055565b60006001600160a01b03821661012657600080fd5b506001600160a01b03166000908152602091909152604090205460ff1690565b6101516000826100c5565b6040516001600160a01b038216907f71ae26cad02663e3d92efd6ec56031a80d74a20c0ab4183faa8bf262261c9baa90600090a250565b6101936000826101ca565b6040516001600160a01b038216907fdb7176e79cffef81cb01767dd0447a0b24bb72ca9778d4b245581086b2a7e6db90600090a250565b6001600160a01b0381166101dd57600080fd5b6101e78282610111565b6101f057600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19169055565b60006020828403121561022457600080fd5b81356001600160a01b038116811461023b57600080fd5b939250505056fea26469706673582212205b8b3deb70359022bd95cc7c04f7cbc4f49dae679259dbf1ea5598acd30d43b264736f6c63430008090033";

    public static final String FUNC_ADDRETAILER = "addRetailer";

    public static final String FUNC_ISRETAILER = "isRetailer";

    public static final String FUNC_RENOUNCERETAILER = "renounceRetailer";

    public static final Event RETAILERADDED_EVENT = new Event("RetailerAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event RETAILERREMOVED_EVENT = new Event("RetailerRemoved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected RetailerRole(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RetailerRole(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RetailerRole(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RetailerRole(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<RetailerAddedEventResponse> getRetailerAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RETAILERADDED_EVENT, transactionReceipt);
        ArrayList<RetailerAddedEventResponse> responses = new ArrayList<RetailerAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RetailerAddedEventResponse typedResponse = new RetailerAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RetailerAddedEventResponse> retailerAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RetailerAddedEventResponse>() {
            @Override
            public RetailerAddedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RETAILERADDED_EVENT, log);
                RetailerAddedEventResponse typedResponse = new RetailerAddedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RetailerAddedEventResponse> retailerAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RETAILERADDED_EVENT));
        return retailerAddedEventFlowable(filter);
    }

    public List<RetailerRemovedEventResponse> getRetailerRemovedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RETAILERREMOVED_EVENT, transactionReceipt);
        ArrayList<RetailerRemovedEventResponse> responses = new ArrayList<RetailerRemovedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RetailerRemovedEventResponse typedResponse = new RetailerRemovedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RetailerRemovedEventResponse> retailerRemovedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RetailerRemovedEventResponse>() {
            @Override
            public RetailerRemovedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RETAILERREMOVED_EVENT, log);
                RetailerRemovedEventResponse typedResponse = new RetailerRemovedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RetailerRemovedEventResponse> retailerRemovedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RETAILERREMOVED_EVENT));
        return retailerRemovedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addRetailer(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDRETAILER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isRetailer(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISRETAILER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceRetailer() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCERETAILER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static RetailerRole load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RetailerRole(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RetailerRole load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RetailerRole(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RetailerRole load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RetailerRole(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RetailerRole load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RetailerRole(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<RetailerRole> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RetailerRole.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<RetailerRole> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RetailerRole.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<RetailerRole> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RetailerRole.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<RetailerRole> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RetailerRole.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class RetailerAddedEventResponse extends BaseEventResponse {
        public String account;
    }

    public static class RetailerRemovedEventResponse extends BaseEventResponse {
        public String account;
    }
}
