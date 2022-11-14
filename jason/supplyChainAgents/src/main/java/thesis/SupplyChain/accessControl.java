package thesis.SupplyChain;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import java.io.IOException;
import java.math.BigInteger;
import static java.math.BigInteger.*;
//import thesis.SupplyChain.rolebasedcontracts.SupplyChain;

public class accessControl {
    Web3j web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:9545"));
    private final static String PRIVATE_KEY = "9eaa5c8d7371549db1d603b4c0d7806458fc2422ab667c9e87b9ab7e0e42fb97";
    private final static String account1_privatekey = "a8cd0df511cd0be2a7b5c6a3ce3f748a83dc136fb5ffdc825c911da6252a352a";
    private final static String account2_privatekey = "3569487769620b9267b739939d5a6267396b4106c36f671c9392d738017d4ff2";
    private final static String account3_privatekey = "0c0ad94a324b3c3c4faa6707b4b6524fe93f352e5961351f040c415fec469690";
    private final static BigInteger GAS_LIMIT = valueOf(6721975L);
    private final static BigInteger GAS_PRICE = valueOf(20000000000L);
    String ownerID = web3j.ethAccounts().send().getAccounts().get(0);
    String manufacturerID =  web3j.ethAccounts().send().getAccounts().get(1);
    String wholesalerID = web3j.ethAccounts().send().getAccounts().get(2);
    String retailerID = web3j.ethAccounts().send().getAccounts().get(3);
    private final String CONTRACT_ADDRESS = deployContract(web3j, getCredentialsFromPrivateKey());
    public static void main(String[] args) {
        try {
            new accessControl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private accessControl() throws Exception {

        printWeb3Version(web3j);

        System.out.println("<-------------------ACCOUNTS----------------------->");
        System.out.println("CONTRACT ADDRESS: " + CONTRACT_ADDRESS);
        System.out.println("Contract Owner: " + ownerID);
        System.out.println("Manufacturer ID: " + manufacturerID);
        System.out.println("Wholesaler ID: " + wholesalerID);
        System.out.println("Retailer ID: " + retailerID);

        //System.out.println("DA: "+deployAddress);

        SupplyChain supplychain= loadContract(CONTRACT_ADDRESS, web3j, getCredentialsFromPrivateKey());

        supplychain.addRetailer(retailerID).send();
        supplychain.addWholesaler(wholesalerID).send();
        supplychain.addManufacturer(manufacturerID).send();

        supplychain.produceItemByManufacturer(valueOf(1), "mullick", "milk", valueOf(1)).send();
        supplychain.packageItemByManufacturer(valueOf(1)).send();
        supplychain.sellItemByManufacturer(valueOf(1), valueOf(1)).send();
        supplychain.purchaseItemByWholesaler(valueOf(1), "mr. mullick", valueOf(1)).send();
        supplychain.shippedItemByManufacturer(valueOf(1)).send();
        supplychain.receivedItemByWholesaler(valueOf(1)).send();
        supplychain.sellItemByWholesaler(valueOf(1), valueOf(1)).send();
        supplychain.purchaseItemByRetailer(valueOf(1),"mrs. mullick", valueOf(1)).send();
        supplychain.shippedItemByWholesaler(valueOf(1)).send();
        supplychain.receivedItemByRetailer(valueOf(1)).send();

    }

    private void printWeb3Version(Web3j web3j) {
        Web3ClientVersion web3ClientVersion = null;
        try {
            web3ClientVersion = web3j.web3ClientVersion().send();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert web3ClientVersion != null;
        String web3ClientVersionString = web3ClientVersion.getWeb3ClientVersion();
        System.out.println("Web3j client version: " + web3ClientVersionString);
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