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
      host: "127.0.0.1",     // Localhost (default: none)
      port: 9545,            // Standard Ethereum port (default: none)
      network_id: "*",       // Any network (default: none)
     },
    rinkeby: {
      provider: () => new HDWalletProvider(secretkey, `https://rinkeby.infura.io/v3/9a27455b3ee74500bbbad6f0090ee57f`),
      network_id: 4,       // rinkeby id
      gas: 5500000,        // rinkeby has a lower block limit than mainnet
      confirmations: 2,    // # of confirmations to wait between deployments. (default: 0)
      timeoutBlocks: 200,  // # of blocks before a deployment times out  (minimum/default: 50)
      skipDryRun: true     // Skip dry run before migrations? (default: false for public nets )
    },
  },

  // Set default mocha options here, use special reporters, etc.
  mocha: {
    // timeout: 100000
  },

  // Configure your compilers
  compilers: {
    solc: {
      version: "0.8.15",      // Fetch exact version from solc-bin (default: truffle's version)
      // docker: true,        // Use "0.5.1" you've installed locally with docker (default: false)
      // settings: {          // See the solidity docs for advice about optimization and evmVersion
      //  optimizer: {
      //    enabled: false,
      //    runs: 200
      //  },
      //  evmVersion: "byzantium"
      // }
    }
  },
};
