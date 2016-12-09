(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('BuyCtrl', BuyCtrl);

	BuyCtrl.$inject = ['$scope', 'BuyService', '$state'];
	function BuyCtrl($scope, BuyService, $state) {
		var vm = this;

		
		vm.sumTo = BuyService.getSumTo();
		
		BuyService.getRiskSubcategories().then(function(response) {
			console.log(response.data[1].name);
			console.log(response.data[1].coefficient);
			console.log(response.data[1]);
			console.log(response.data[1].riskCategory);
			console.log(response.data[1].riskCategory.name);
			vm.subcategories = response.data;

			console.log(response.data[1].riskCategory.id)

			/*vm.ages = [];
			for (var i = 0; i < response.data.length; i++) {
				if (response.data[i].riskCategory.name == "age") {
					console.log(response.data[i].name);
					vm.ages.push(response.data[i]);
				}
			}*/

	
			//@subcategories, @category
			vm.regions = BuyService.getSubsForCat(response.data, "region");
			vm.ages = BuyService.getSubsForCat(response.data, "age");
			

		});

		BuyService.getRiskCategories().then(function(response) {
			vm.catgories = response.data;
			
		});
		 
	   /* BuyService.getRegions().then(function(response) {
							console.log('response.data');
							console.log(response.data);
							console.log('res prvog elementa, response.data[0]');
							console.log(response.data[0]);
							console.log('region njegovog elementa, response.data[0].region');
							console.log(response.data[0].region);
							console.log(' response');
							console.log(response);
							console.log("HttpStatus");
							console.log(response.status);
							
							vm.HttpStatus = response.status;
							vm.region = response.data;							
						});*/



	     vm.processForm = function() {
       		 alert('awesome!');  
    	};

    	vm.insuranceType = ["Putno", "Home"];
    	vm.checked = [];

    	//Prepravi jer kad reloadujes prelazi na prvo stanje
	   	$state.go('buy.firstStep');

	}

})();