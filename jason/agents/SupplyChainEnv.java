package thesis.SupplyChain;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.Ethereum;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.utils.Convert;

import javax.swing.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

import static java.math.BigInteger.*;


public class accessControl {
    private final static String PRIVATE_KEY = "eeb24f34479018eb70f91b3303cf16a03a3ab1123baef04de480dd3b82cbc31c";
    private final static BigInteger GAS_LIMIT = valueOf(6721975L);
    private final static BigInteger GAS_PRICE = valueOf(20000000000L);
    private final static String CONTRACT_ADDRESS= "0xffe3447f24fcDA08d607D27869Fbf3939246ca18";

    public static void main(String[] args) {
        try {
            new accessControl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private accessControl() throws Exception {
        Web3j web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:9545"));
        String manufacturerID = "0x94585c20c6316De674c59715a2D0D31575A90E0f";
        String wholesalerID= "0xA3d3D8F776610dF70050adEa82EA306BdFf22919";
        String retailerID ="0x08Bdaf79dC5F27116A13e704107a8cE1A7351f0d";

        deployContract(web3j, getCredentialsFromPrivateKey());
        SupplyChain supplychain= loadContract(CONTRACT_ADDRESS, web3j, getCredentialsFromPrivateKey());

        supplychain.addManufacturer(manufacturerID).send();
        supplychain.addWholesaler(wholesalerID).send();
        supplychain.addRetailer(retailerID).send();

        supplychain.produceItemByManufacturer(valueOf(1), "mullick", "Best beans for Espresso", valueOf(1)).send();
        supplychain.packageItemByManufacturer(valueOf(1)).send();
        supplychain.sellItemByManufacturer(valueOf(1), valueOf(1)).send();
        supplychain.purchaseItemByWholesaler(valueOf(1), "mr. mullick", BigInteger.valueOf(1)).send();
        supplychain.shippedItemByManufacturer(valueOf(1), BigInteger.valueOf(1)).send();
        supplychain.receivedItemByWholesaler(valueOf(1)).send();
        supplychain.sellItemByWholesaler(valueOf(1), BigInteger.valueOf(1)).send();
        supplychain.purchaseItemByRetailer(valueOf(1),"mrs. mullick", BigInteger.valueOf(1)).send();
        supplychain.shippedItemByWholesaler(valueOf(1)).send();
        supplychain.receivedItemByRetailer(valueOf(1)).send();
        supplychain.fetchItemBufferOne(valueOf(1)).send();
        supplychain.fetchItemBufferTwo(valueOf(1)).send();
        supplychain.fetchWholesaler(valueOf(1)).send();
        supplychain.fetchRetailer(valueOf(1)).send();
        supplychain.fetchitemHistory(valueOf(1)).send();

    }

    private Credentials getCredentialsFromPrivateKey() {
        return Credentials.create(PRIVATE_KEY);
    }

    private String deployContract(Web3j web3j, Credentials credentials) throws Exception {
        return SupplyChain.deploy(web3j, credentials, GAS_PRICE, GAS_LIMIT).send().getContractAddress();
    }

    private SupplyChain loadContract(String contractAddress, Web3j web3j, Credentials credentials) throws Exception {
        return SupplyChain.load(CONTRACT_ADDRESS, web3j, credentials, GAS_PRICE, GAS_LIMIT);
    }

}