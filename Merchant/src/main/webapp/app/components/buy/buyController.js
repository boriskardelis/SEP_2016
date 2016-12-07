(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('BuyCtrl', BuyCtrl);

	BuyCtrl.$inject = ['$scope', 'BuyService', '$state'];
	function BuyCtrl($scope, BuyService, $state) {
		var vm = this;

		
		
		
		vm.sumTo = BuyService.getSumTo();
		vm.ageCarrier = BuyService.getAgeCarrire();
		vm.numberOfPersons = [1,2,3,4,5];

		 
	    BuyService.getRegions().then(function(response) {
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
						});

	    /*BuyService.getAges().then(function(response) {
	    	vm.ages = response.data;
	    });*/
	    vm.ages = BuyService.getAges();

	     vm.processForm = function() {
       		 alert('awesome!');  
    	};

    	vm.insuranceType = ["Putno", "Home"];
    	vm.checked = [];

    	//Prepravi jer kad reloadujes prelazi na prvo stanje
	   	$state.go('buy.firstStep');

	}

})();