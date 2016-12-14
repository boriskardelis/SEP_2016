(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('BuyCtrl', BuyCtrl);

	BuyCtrl.$inject = ['$scope', 'BuyService', '$state', '$timeout'];
	function BuyCtrl($scope, BuyService, $state, $timeout) {
		var vm = this;
		
			//samo da sebi stavim sta sam pokupio... obrisace se
		 	vm.regionSelected;
	   		vm.sumToSelected;
	   		vm.ageSelected;
	   		vm.sportSelected;
	   		vm.ageTyped; //from directive


	   		


		BuyService.getRiskSubcategories().then(function(response) {
			/*console.log(response.data[1].name);
			console.log(response.data[1].coefficient);
			console.log(response.data[1]);
			console.log(response.data[1].riskCategory);
			console.log(response.data[1].riskCategory.name);*/
			vm.subcategories = response.data;

			console.log(response.data[1].riskCategory.id)
	
			//@subcategories, @category
			vm.regions = BuyService.getSubsForCat(response.data, "region");
			vm.ages = BuyService.getSubsForCat(response.data, "age");
			vm.sumTo = BuyService.getSubsForCat(response.data, "sumTo");
			vm.sports = BuyService.getSubsForCat(response.data, "sport");

			vm.towings = BuyService.getSubsForCat(response.data, "towing");
			vm.repairs = BuyService.getSubsForCat(response.data, "repairs");
			vm.accommodations = BuyService.getSubsForCat(response.data, "accommodation");
			vm.alternativeRides = BuyService.getSubsForCat(response.data, "alternativeRide");

			vm.surfaces = BuyService.getSubsForCat(response.data, "surface");
			vm.ageApartments = BuyService.getSubsForCat(response.data, "ageApartment");
			vm.valueApartments = BuyService.getSubsForCat(response.data, "valueApartment");
			vm.disasters = BuyService.getSubsForCat(response.data, "disaster");
			

		});

		BuyService.getRiskCategories().then(function(response) {
			vm.catgories = response.data;
			
		});

		BuyService.getInsuranceTypes().then(function(response) {
			vm.insuranceTypes = response.data;
		});

		BuyService.getVehicle().then(function(response) {
			vm.vehciles = response.data;
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

    	/* vm.start = new Date('11/20/13');
		 vm.start = new Date();
		 vm.end = new Date();
		  
		  vm.minStartDate = new Date(); //fixed date
		  vm.maxStartDate = vm.end; //init value
		  vm.minEndDate = vm.start; //init value
		  vm.maxEndDate = new Date('12/12/16'); //fixed date same as $scope.maxStartDate init value
		  
		  $scope.$watch('start', function(v){
		    vm.minEndDate = v;
		  });
		  $scope.$watch('end', function(v){
		   vm.maxStartDate = v;
		  });

		  vm.openStart = function() {
		    $timeout(function() {
		      vm.startOpened = true;
		    });
		  };

		  vm.openEnd = function() {
		    $timeout(function() {
		      vm.endOpened = true;
		    });
		  };

		  vm.dateOptions = {
		    'year-format': "'yy'",
		    'starting-day': 1
		  };

		  vm.format = 'dd/MM/yyyy';*/

		vm.startDate = new Date();
		vm.endDate = new Date();

		vm.openStart = function() {
		   	console.log("OPENED");
		   	$timeout(function() {
		      vm.startOpened = true;
		    });		
		};

		vm.openEnd = function() {
		   	console.log("OPENED");
		   	$timeout(function() {
		      vm.endOpened = true;
		    });		
		};

		vm.startDatePicked = function() {
			if (vm.endDate < vm.startDate)
				vm.endDate = vm.startDate;
		};
		vm.endDatePicked = function() {
			if (vm.endDate < vm.startDate)
				vm.startDate = vm.endDate;
		};

		vm.dateOptions = {
		    //formatYear: 'yy',
		    maxDate: new Date(2020, 5, 22),
		    minDate: new Date(),
		    startingDay: 1
		};

		vm.calculate = function() {
			console.log("CALCULATE");
			console.log(vm.regionSelected);
			console.log(vm.sumToSelected);
			console.log(vm.ageSelected);
			console.log(vm.sportSelected);
			console.log(vm.ageTyped);

			//DOdaj u listu ako treba
			console.log(vm.startDate);
			console.log(vm.endDate);

			//Ne ulaze u cenu
			//console.log(vm.vehicle);
			//console.log(vm.home);
			
			console.log(vm.towingSelected);
			console.log(vm.repairSelected);
			console.log(vm.accommodationSelected);
			console.log(vm.alternativeRideSelected);
			console.log(vm.surfaceSelected);
			console.log(vm.valueApartmentSelected);
			console.log(vm.disasterSelected);

			
			BuyService.postCalculate(vm.regionSelected, vm.sumToSelected, vm.ageSelected,
			 vm.sportSelected, vm.ageTyped,  vm.towingSelected, vm.repairSelected, vm.accommodationSelected, vm.alternativeRideSelected,
			 vm.surfaceSelected, vm.ageApartmentSelected, vm.valueApartmentSelected, vm.disasterSelected);

		};

    	vm.insuranceType = ["Putno", "Home"];
    	vm.checked = [];

    	//Prepravi jer kad reloadujes prelazi na prvo stanje
	   	//$state.go('buy.firstStep');



	}

})();