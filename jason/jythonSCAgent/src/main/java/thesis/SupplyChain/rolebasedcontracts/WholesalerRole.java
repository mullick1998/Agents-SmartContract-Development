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
public class WholesalerRole extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061001a3361001f565b6100ef565b61003781600061006e60201b6100c51790919060201c565b6040516001600160a01b038216907fd8a7ad7929975a375d2b12bf49040286b5b105df0fe351f10df6d85e5b7142f790600090a250565b6001600160a01b03811661008157600080fd5b61008b82826100ba565b1561009557600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19166001179055565b60006001600160a01b0382166100cf57600080fd5b506001600160a01b03166000908152602091909152604090205460ff1690565b610278806100fe6000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806364d1ba1f14610046578063de63bdb91461006d578063fe19d15214610082575b600080fd5b610059610054366004610212565b61008a565b604051901515815260200160405180910390f35b61008061007b366004610212565b61009c565b005b6100806100ba565b60006100968183610111565b92915050565b6100a53361008a565b6100ae57600080fd5b6100b781610146565b50565b6100c333610188565b565b6001600160a01b0381166100d857600080fd5b6100e28282610111565b156100ec57600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19166001179055565b60006001600160a01b03821661012657600080fd5b506001600160a01b03166000908152602091909152604090205460ff1690565b6101516000826100c5565b6040516001600160a01b038216907fd8a7ad7929975a375d2b12bf49040286b5b105df0fe351f10df6d85e5b7142f790600090a250565b6101936000826101ca565b6040516001600160a01b038216907f7f865f710a7604537eb2bc0334f082fa642d210a705398937f53663384485b2890600090a250565b6001600160a01b0381166101dd57600080fd5b6101e78282610111565b6101f057600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19169055565b60006020828403121561022457600080fd5b81356001600160a01b038116811461023b57600080fd5b939250505056fea2646970667358221220de04d218d2630a7dc4c31e8c6252835f44767591e8399d93102019e6d427bcc164736f6c63430008090033";

    public static final String FUNC_ADDWHOLESALER = "addWholesaler";

    public static final String FUNC_ISWHOLESALER = "isWholesaler";

    public static final String FUNC_RENOUNCEWHOLESALER = "renounceWholesaler";

    public static final Event WHOLESALERADDED_EVENT = new Event("WholesalerAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event WHOLESALERREMOVED_EVENT = new Event("WholesalerRemoved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected WholesalerRole(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected WholesalerRole(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected WholesalerRole(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected WholesalerRole(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<WholesalerAddedEventResponse> getWholesalerAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WHOLESALERADDED_EVENT, transactionReceipt);
        ArrayList<WholesalerAddedEventResponse> responses = new ArrayList<WholesalerAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WholesalerAddedEventResponse typedResponse = new WholesalerAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<WholesalerAddedEventResponse> wholesalerAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, WholesalerAddedEventResponse>() {
            @Override
            public WholesalerAddedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WHOLESALERADDED_EVENT, log);
                WholesalerAddedEventResponse typedResponse = new WholesalerAddedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<WholesalerAddedEventResponse> wholesalerAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WHOLESALERADDED_EVENT));
        return wholesalerAddedEventFlowable(filter);
    }

    public List<WholesalerRemovedEventResponse> getWholesalerRemovedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WHOLESALERREMOVED_EVENT, transactionReceipt);
        ArrayList<WholesalerRemovedEventResponse> responses = new ArrayList<WholesalerRemovedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WholesalerRemovedEventResponse typedResponse = new WholesalerRemovedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<WholesalerRemovedEventResponse> wholesalerRemovedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, WholesalerRemovedEventResponse>() {
            @Override
            public WholesalerRemovedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WHOLESALERREMOVED_EVENT, log);
                WholesalerRemovedEventResponse typedResponse = new WholesalerRemovedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<WholesalerRemovedEventResponse> wholesalerRemovedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WHOLESALERREMOVED_EVENT));
        return wholesalerRemovedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addWholesaler(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDWHOLESALER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isWholesaler(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISWHOLESALER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceWholesaler() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEWHOLESALER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static WholesalerRole load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new WholesalerRole(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static WholesalerRole load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new WholesalerRole(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static WholesalerRole load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new WholesalerRole(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static WholesalerRole load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new WholesalerRole(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<WholesalerRole> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(WholesalerRole.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<WholesalerRole> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(WholesalerRole.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<WholesalerRole> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(WholesalerRole.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<WholesalerRole> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(WholesalerRole.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class WholesalerAddedEventResponse extends BaseEventResponse {
        public String account;
    }

    public static class WholesalerRemovedEventResponse extends BaseEventResponse {
        public String account;
    }
}
