package thesis.SupplyChain;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import java.lang.String;
import java.lang.*;

import java.util.concurrent.ExecutionException;

public class accessControl {
    public static void main(String[] args) throws ExecutionException, InterruptedException, ExecutionException {
        Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:9545/"));
        EthBlockNumber result = web3.ethBlockNumber().sendAsync().get();
        System.out.println(" The Block Number is: " + result.getBlockNumber().toString());
    }
}