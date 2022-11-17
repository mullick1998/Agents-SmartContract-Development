// migrating the appropriate contracts
var ManufacturerRole = artifacts.require("./ManufacturerRole.sol");
var WholesalerRole = artifacts.require("./WholesalerRole.sol");
var RetailerRole = artifacts.require("./RetailerRole.sol");
var SupplyChain = artifacts.require("./SupplyChain.sol");

module.exports = function(deployer) {
  deployer.deploy(ManufacturerRole);
  deployer.deploy(WholesalerRole);
  deployer.deploy(RetailerRole);
  deployer.deploy(SupplyChain);
};
