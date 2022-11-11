require('dotenv').config()
const HDWalletProvider = require("@truffle/hdwallet-provider");
const private_keys = [
  process.env.PRIVATE_KEY_1,
  process.env.PRIVATE_KEY_2,
]
const secretkey = process.env.SECRET_KEY

module.exports = {

  networks: {
    development: {
      host: "127.0.0.1",    
      port: 8545,        
      network_id: "*",
     },
    rinkeby: {
      provider: () => new HDWalletProvider(secretkey, `https://rinkeby.infura.io/v3/9a27455b3ee74500bbbad6f0090ee57f`),
      network_id: 4,       
      confirmations: 2,    
      timeoutBlocks: 200, 
      skipDryRun: true 
    },
    alfajores: {
      provider: () => new HDWalletProvider( 
          secretkey, 
          "https://alfajores-forno.celo-testnet.org"
        ),
      network_id: 44787,
      gas: 20000000,  
      skipDryRun: true 
    }
  },
  mocha: {
  },
  compilers: {
    solc: {
      version: "0.8.7",
  },
}
};
