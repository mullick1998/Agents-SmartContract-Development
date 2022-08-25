
App = {
    web3Provider: null,
    contracts: {},
    upc: 0,
    metamaskAccountID: "0x0000000000000000000000000000000000000000",
    ownerID: "0x0000000000000000000000000000000000000000",
    manufacturerID: "0x0000000000000000000000000000000000000000",
    productName: null,
    productPrice: 0,
    wholesalerID: "0x0000000000000000000000000000000000000000",
    retailerID: "0x0000000000000000000000000000000000000000",


    init: async function () {
        App.readForm();
        return await App.initWeb3();
    },


    readForm: function () {
        App.upc = $("#upc").val();
        App.productName = $("#PN").val();
        App.productPrice = $("#PP").val();
    },

    initWeb3: async function () {
        if (window.ethereum) {
            App.web3Provider = window.ethereum;
            console.log(App.web3Provider);
            try {
                await window.ethereum.enable();
            } catch (error) {
                console.error("User denied account access")
            }
        }
        else if (window.web3) {
            App.web3Provider = window.web3.currentProvider;
        }
        else {
            App.web3Provider = new Web3.providers.HttpProvider('http://localhost:9545');
        }
        return App.initSupplyChain();
    },

    getMetaskAccountID: function () {
        web3 = new Web3(App.web3Provider);

        web3.eth.getAccounts(function(err, res) {
            if (err) {
                console.log('Error:',err);
                return;
            }

            App.metamaskAccountID = res[0];
            if (res.length > 1){
            document.getElementById("divType").innerText = "Ganache Address"
            console.log("Using Ganache");
            App.manufacturerID = res[1];
            document.getElementById("manufacturerID").value = App.manufacturerID;
            App.wholesalerID = res[2];
            document.getElementById("wholesalerID").value = App.wholesalerID;
            App.retailerID = res[3];
            document.getElementById("retailerID").value = App.retailerID;
          }else{
            document.getElementById("divType").innerText = "Using MetaMask Address"
            App.manufacturerID = document.getElementById("manufacturerID").value;
            App.wholesalerID = document.getElementById("wholesalerID").value;
            App.retailerID = document.getElementById("retailerID").value;
          }

        })
    },

    initSupplyChain: function () {
        var jsonSupplyChain='../../build/contracts/SupplyChain.json';
        $.getJSON(jsonSupplyChain, function(data) {
            console.log('data',data);
            var SupplyChainArtifact = data;
            App.contracts.SupplyChain = TruffleContract(SupplyChainArtifact);
            App.contracts.SupplyChain.setProvider(App.web3Provider);
        });

        return App.bindEvents();
    },

    bindEvents: function() {
        $(document).on('click', App.handleButtonClick);
    },

    handleButtonClick: async function(event) {
        event.preventDefault();
        App.getMetaskAccountID();
        var processId = parseInt($(event.target).data('id'));
        console.log('processId',processId);

        switch(processId) {
            case 1:
                return await App.addManufacturer(event);
                break;
            case 2:
                return await App.addWholesaler(event);
                break;
            case 3:
                return await App.addRetailer(event);
                break;
            case 4:
                return await App.fetchItemBufferOne(event);
                break;
            case 5:
                return await App.fetchWholesaler(event);
                break;
            case 6:
                return await App.fetchItemHistory(event);
                break;
            case 7:
                return await App.produceItemByManufacturer(event);
                break;
            case 8:
                return await App.processedItemByManufacturer(event);
                break;
            case 9:
                return await App.packageItemByManufacturer(event);
                break;
            case 10:
                return await App.sellItemByManufacturer(event);
                break;
            case 11:
                return await App.purchaseItemByWholesaler(event);
                break;
            case 12:
                return await App.shippedItemByManufacturer(event);
                break;
            case 13:
                return await App.receivedItemByWholesaler(event);
                break;
            case 14:
                return await App.sellItemByWholesaler(event);
                break;
            case 15:
                return await App.purchaseItemByRetailer(event);
                break;
            case 16:
                return await App.shippedItemByWholesaler(event);
                break;
            case 17:
                return await App.receivedItemByRetailer(event);
                break;
            case 18:
                return await App.fetchRetailer(event);
                break;

            }

    },
    //1
    addManufacturer: function(event) {
        event.preventDefault();
        var resultTag = document.getElementById("isManufacturer");
        App.contracts.SupplyChain.deployed().then( async function(instance) {
            var checkRole = await instance.isManufacturer(App.manufacturerID);
            if (checkRole == false){
              await instance.addManufacturer(
                  App.manufacturerID,
                  {from: App.metamaskAccountID}
              );
            }
            sleep(800);
            checkRole = await instance.isManufacturer(App.manufacturerID);
            return checkRole;
        }).then(function(result) {
            resultTag.className = " font";
            resultTag.innerText = result;
            if (result == true){
                resultTag.style.color = "green"
            }else{
                resultTag.style.color = "red"

            }
        }).catch(function(err) {
          resultTag.className = " font";
          resultTag.innerText = "  Error: "+err.message;

        });
    },
    //2
    addWholesaler: function(event) {
        event.preventDefault();
        var resultTag = document.getElementById("isWholesaler");
        App.contracts.SupplyChain.deployed().then( async function(instance) {
            var checkRole = await instance.isWholesaler(App.wholesalerID);
            if(checkRole == false){
              await instance.addWholesaler(App.wholesalerID,
                  {from: App.metamaskAccountID, gas:3000000}

              );
            }
            sleep(800);
            checkRole = await instance.isWholesaler(App.wholesalerID);
            return checkRole
        }).then(function(result) {
            resultTag.className = " font";
            resultTag.innerText = result;
            if (result == true){
                resultTag.style.color = "green"
            }else{
                resultTag.style.color = "red"

            }

        }).catch(function(err) {
          resultTag.className = " font";
          resultTag.innerText = "  Error: "+err.message;
        });
    },
    //3
    addRetailer: function(event) {
        event.preventDefault();
        var resultTag = document.getElementById("isRetailer");
        App.contracts.SupplyChain.deployed().then(async function(instance) {
            var checkRole = await instance.isRetailer(App.retailerID);
            if (checkRole == false){
              await instance.addRetailer(
                  App.retailerID,
                  {from: App.metamaskAccountID, gas:3000000}
              );
            }
            sleep(800);
            checkRole = await instance.isRetailer(App.retailerID);
            return checkRole;
        }).then(function(result) {
            resultTag.className = " font";
            resultTag.innerText = result;
            if (result == true){
                resultTag.style.color = "green"
            }else{
                resultTag.style.color = "red"
            }
        }).catch(function(err) {
          resultTag.className = " font";
          resultTag.innerText = "  Error: "+err.message;
        });
    },
    

    //5
    produceItemByManufacturer: function(event) {
        event.preventDefault();
        var resultTag = document.getElementById("pr");
        App.contracts.SupplyChain.deployed().then(function(instance) {
            return instance.produceItemByManufacturer(
                App.upc,
                App.productName,
                App.productPrice,
                {from: App.manufacturerID}
            );
        }).then(function(result) {
            resultTag.className = " font";
            resultTag.innerText = "  Tx Hash: "+result.tx;
        }).catch(function(err) {
          resultTag.className = " font";
          resultTag.innerText = "  Error: "+err.message;
        });
    },

    packageItemByManufacturer : function (event) {
        event.preventDefault();
        var upc = document.getElementById("packageupc").value;
        var resultTag = document.getElementById("paibd");
        App.contracts.SupplyChain.deployed().then(function(instance) {
            return instance.packageItemByManufacturer(upc, {from: App.manufacturerID});
        }).then(function(result) {
            resultTag.className = " font";
            resultTag.innerText = "  Tx Hash: "+result.tx;
        }).catch(function(err) {
            resultTag.className = " font";
            resultTag.innerText = "  Error: "+err.message;
        });
    },

    //6
    sellItemByManufacturer: function (event) {
        event.preventDefault();
        var price = document.getElementById("sellprice").value;
        var upc = document.getElementById("sellupc").value;
        var resultTag = document.getElementById("srf");
        App.contracts.SupplyChain.deployed().then(function(instance) {
            return instance.sellItemByManufacturer(upc,price, {from: App.manufacturerID});
        }).then(function(result) {
          resultTag.className = " font";
          resultTag.innerText = "  Tx Hash: "+result.tx;
        }).catch(function(err) {
          resultTag.className = " font";
          resultTag.innerText = "  Error: "+err.message;
        });
    },

    purchaseItemByWholesaler: function (event) {
        event.preventDefault();
        var upc = document.getElementById("purchaseupc").value;
        var wholesalerName = document.getElementById("wholesalerName").value;
        var resultTag = document.getElementById("pid");
        App.contracts.SupplyChain.deployed().then(function(instance) {
            return instance.fetchItemBufferTwo(upc);
          }).then(function(result) {
            var price = result[4];
            var balance = window.web3.utils.toWei(price, 'ether');
            App.contracts.SupplyChain.deployed().then(function(instance) {
              return instance.purchaseItemByWholesaler(upc, wholesalerName, {from: App.wholesalerID, value:balance });
            }).then(function(result) {
              resultTag.className = " font";
              resultTag.innerText = "  Tx Hash: "+result.tx;
          }).catch(function(err) {
              resultTag.className = " font";
              resultTag.innerText = "  Error: "+err.message;

          });
        }).catch(function(err) {
          resultTag.className = " font";
          resultTag.innerText = "  Error: "+err.message;

        });

    },


    shippedItemByManufacturer: function (event) {
      event.preventDefault();
      var upc = document.getElementById("shipupc").value;
      var resultTag = document.getElementById("sibf");
      App.contracts.SupplyChain.deployed().then(function(instance) {
          return instance.shippedItemByManufacturer(upc, {from: App.ManufacturerID});
      }).then(function(result) {
          resultTag.className = " font";
          resultTag.innerText = "  Tx Hash: "+result.tx;
      }).catch(function(err) {
          resultTag.className = " font";
          resultTag.innerText = "  Error: "+err.message;
      });
    },

    receivedItemByWholesaler: function (event) {
      event.preventDefault();
      var upc = document.getElementById("receiveupc").value;
      var resultTag = document.getElementById("ribd");
      App.contracts.SupplyChain.deployed().then(function(instance) {
          return instance.receivedItemByWholesaler(upc, {from: App.wholesalerID});
      }).then(function(result) {
        resultTag.className = " font";
        resultTag.innerText = "  Tx Hash: "+result.tx;
      }).catch(function(err) {
        resultTag.className = " font";
        resultTag.innerText = "  Error: "+err.message;
      });
    },

    sellItemByWholesaler: function (event) {
      event.preventDefault();
      var upc = document.getElementById("sellupc").value;
      var price = document.getElementById("sellprice").value;
      var resultTag = document.getElementById("srd");
      App.contracts.SupplyChain.deployed().then(function(instance) {
          return instance.sellItemByWholesaler(upc,price ,{from: App.wholesalerID});
      }).then(function(result) {
          resultTag.className = " font";
          resultTag.innerText = "  Tx Hash: "+result.tx;
          console.log('sellItemByWholesaler',result);
      }).catch(function(err) {
          resultTag.className = " font";
          resultTag.innerText = "  Error: "+err.message;
          console.log(err.message);
      });
    },

    purchaseItemByRetailer: function (event) {
      event.preventDefault();
      var upc = document.getElementById("purchaseupc").value;
      var retailerName = document.getElementById("retailerName").value;
      var resultTag = document.getElementById("pir");
      App.contracts.SupplyChain.deployed().then(function(instance) {
          return instance.fetchItemBufferTwo(upc);
        }).then(function(result) {
          var price = result[4];
          var balance = window.web3.utils.toWei(price, 'ether');
          App.contracts.SupplyChain.deployed().then(function(instance) {
              return instance.purchaseItemByRetailer(upc, retailerName, {from: App.retailerID,value:balance,gas:3000000});
          }).then(function(result) {
              resultTag.className = " font";
              resultTag.innerText = "  Tx Hash: "+result.tx;
              console.log('purchaseItemByRetailer',result);
          }).catch(function(err) {
              resultTag.className = " font";
              resultTag.innerText = "  Error: "+err.message;
              console.log(err.message);
          });
        }).catch(function(err) {
            resultTag.className = " font";
            resultTag.innerText = "  Error: "+err.message;
            console.log(err.message);
        });
    },

    shippedItemByWholesaler: function (event) {
      event.preventDefault();
      var upc = document.getElementById("shipupc").value;
      var resultTag = document.getElementById("sibd");
      App.contracts.SupplyChain.deployed().then(function(instance) {
          return instance.shippedItemByWholesaler(upc, {from: App.wholesalerID});
      }).then(function(result) {
          resultTag.className = " font";
          resultTag.innerText = "  Tx Hash: "+result.tx;
          console.log('shippedItemByWholesaler',result);
      }).catch(function(err) {
          resultTag.className = " font";
          resultTag.innerText = "  Error: "+err.message;
          console.log(err.message);
      });
    },

    receivedItemByRetailer: function (event) {
      event.preventDefault();
      var upc = document.getElementById("receiveupc").value;
      var resultTag = document.getElementById("ribr");
      App.contracts.SupplyChain.deployed().then(function(instance) {
          return instance.receivedItemByRetailer(upc, {from: App.retailerID});
      }).then(function(result) {
          resultTag.className = " font";
          resultTag.innerText = "  Tx Hash: "+result.tx;
          console.log('receivedItemByRetailer',result);
      }).catch(function(err) {
          resultTag.className = " font";
          resultTag.innerText = "  Error: "+err.message;
          console.log(err.message);
      });
    },
    
    fetchItemBufferOne: function () {
        event.preventDefault();
        var displayTo = document.getElementById("BlockInfoBufferOne");
        var upc = $('#upc1').val();
        App.contracts.SupplyChain.deployed().then(function(instance) {
          return instance.fetchItemBufferOne(upc);
        }).then(function(result) {
          while (displayTo.firstChild) {
              displayTo.removeChild(displayTo.firstChild);
          };
          displayTo.innerHTML = (

          "Stock Keeping Unit: "+result[0]+"<br>"+
          "Universal Product Code: "+result[1]+"<br>"+
          "Owner ID: "+result[2]+"<br>"+
          "Origin Manufacturer ID: "+result[3]+"<br>");

        }).catch(function(err) {
          console.log(err.message);
        });
    },

    fetchWholesaler: function () {
        event.preventDefault();
        var displayTo = document.getElementById("BlockInfoBufferOne");
        var upc = $('#upc1').val();
        App.contracts.SupplyChain.deployed().then(function(instance) {
          return instance.fetchWholesaler.call(upc);
        }).then(function(result) {
          while (displayTo.firstChild) {
              displayTo.removeChild(displayTo.firstChild);
          }
          console.log(result)
          let today = new Date().toISOString().slice(0, 10)
          displayTo.innerHTML = (
          "SKU: "+result[0]+"<br>"+
          "UPC: "+result[1]+"<br>"+
          "Product ID: "+result[2]+"<br>"+
          "Product Name: "+result[3]+"<br>"+
          "Product Price: "+result[4]+"<br>"+
          "Item State: "+result[6]+"<br>"+
          "Product Date: "+today+"<br>"+
          "Wholesaler ID: "+result[7]+"<br>"+
          "Wholesaler Name: "+result[8]);
        }).catch(function(err) {
          console.log(err.message);
        });
    },

    fetchRetailer: function () {
        event.preventDefault();
        var displayTo = document.getElementById("BlockInfoBufferOne");
        var upc = $('#upc1').val();
        App.contracts.SupplyChain.deployed().then(function(instance) {
          return instance.fetchRetailer.call(upc);
        }).then(function(result) {
          while (displayTo.firstChild) {
              displayTo.removeChild(displayTo.firstChild);
          }
          console.log(result)
          let today = new Date().toISOString().slice(0, 10)
          displayTo.innerHTML = (
          "SKU: "+result[0]+"<br>"+
          "UPC: "+result[1]+"<br>"+
          "Product ID: "+result[2]+"<br>"+
          "Product Name: "+result[3]+"<br>"+
          "Product Price: "+result[4]+"<br>"+
          "Item State: "+result[6]+"<br>"+
          "Product Date: "+today+"<br>"+
          "Retailer ID: "+result[7]+"<br>"+
          "Retailer Name: "+result[8]);
        }).catch(function(err) {
          console.log(err.message);
        });
    },

    fetchItemHistory: function () {
        event.preventDefault();
        var upc = $('#upc1').val();
        var displayTo = document.getElementById("BlockInfoBufferOne");
        App.contracts.SupplyChain.deployed().then(function(instance) {
            return instance.fetchitemHistory(upc);
        }).then(function(result) {
          displayTo.innerHTML = (
          "Manufacturer To Wholesaler transaction at block "+result[0]+"<br>"+
          "Wholesaler To Retailer transaction at block "+result[1]+"<br>");
        }).catch(function(err) {
            console.log(err.message);
        });
    },

};

$(function () {
    $(window).on ('load', function () {
        App.init();
    });
});

function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}