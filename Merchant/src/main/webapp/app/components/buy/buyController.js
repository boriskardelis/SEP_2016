(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('BuyCtrl', BuyCtrl);

	BuyCtrl.$inject = ['$scope', '$rootScope', 'BuyService', '$state', '$timeout', '$window', '$translate', 'localStorageService'];
	function BuyCtrl($scope, $rootScope, BuyService, $state, $timeout, $window, $translate, localStorageService) {
		var vm = this;
		
		console.log($translate.use());

		vm.isDisabled = false;
		//Zasto ne radi sa VM (this)?!
	    $scope.buttonDisable = function() {
	   	    console.log("USAO U FUNK");  
	        $timeout(function() {
		        $scope.isDisabled = true;
		        console.log('update with timeout fired');
		    }, 0);
	    }

		//vm.proba = localStorageService.cookie.get('proba');
		vm.regionSelected = localStorageService.cookie.get('regionSelected');
		vm.sumToSelected = localStorageService.cookie.get('sumToSelected');
		vm.sportSelected = localStorageService.cookie.get('sportSelected');
		//vm.startDate = localStorageService.cookie.get('startDate');
		//vm.endDate = localStorageService.cookie.get('endDate');
		//vm.towingSelected = localStorageService.cookie.get('towingSelected');
		
		/*console.log("DATUM");
		console.log(vm.endDate);
		console.log(new Date());*/


	/*	$scope.$watch('vm.proba', function(newVal){
		    localStorageService.cookie.set('proba', newVal);	   
	    });*/
		$scope.$watch('vm.regionSelected', function(newVal){
		    localStorageService.cookie.set('regionSelected', newVal);
	    });
	    $scope.$watch('vm.sumToSelected', function(newVal){
		    localStorageService.cookie.set('sumToSelected', newVal);
	    });
	    $scope.$watch('vm.sportSelected', function(newVal){
		    localStorageService.cookie.set('sportSelected', newVal);
	    });
	   /* $scope.$watch('vm.startDate', function(newVal){
		    localStorageService.cookie.set('startDate', newVal);
	    });
	     $scope.$watch('vm.towingSelected', function(newVal){
	     	console.log("WATCH");
		    localStorageService.cookie.set('towingSelected', newVal);
	    });*/
	   /* $scope.$watch('vm.endDate', function(newVal){
		    localStorageService.cookie.set('endDate', newVal);
	    });*/

		BuyService.getRiskSubcategoriesBasedOnLanguage($translate.use()).then(function(response) {
			console.log(response.data);
			console.log(response.data[0].nameTranslate.name);
			console.log(response.data[0].nameTranslate);

			//@subcategories, @category
			vm.regions = BuyService.getSubsForCat(response.data, "Region");
			vm.ages  = BuyService.getSubsForCat(response.data, "Age");
			vm.sumTo = BuyService.getSubsForCat(response.data, "Sum insured");
			vm.sports = BuyService.getSubsForCat(response.data, "Sport");

			vm.towings = BuyService.getSubsForCat(response.data, "Towing");
			vm.repairs = BuyService.getSubsForCat(response.data, "Repairs");
			vm.accommodations = BuyService.getSubsForCat(response.data, "Accommodation");
			vm.alternativeRides = BuyService.getSubsForCat(response.data, "Alternative ride");

			vm.surfaces = BuyService.getSubsForCat(response.data, "Surface");
			vm.ageApartments = BuyService.getSubsForCat(response.data, "Age apartment");
			vm.valueApartments = BuyService.getSubsForCat(response.data, "Value apartment estimated");
			vm.disasters = BuyService.getSubsForCat(response.data, "Insured disaster");

			console.log("regions:");
			console.log(vm.regions);
		});

		//ne koristim trenutno
		BuyService.getRiskCategories().then(function(response) {
			vm.catgories = response.data;	
		});

		BuyService.getInsuranceTypes().then(function(response) {
			vm.insuranceTypes = response.data;
		});

		BuyService.getVehicle().then(function(response) {
			vm.vehciles = response.data;
		});

	    vm.processForm = function() {

	    	vm.language = $translate.use();
  
       		var persons = [];
       		var personFormating = {};
       		console.log(vm.person);
       		for (var i=0;  i < vm.totalPersons - 1; i++) {
				personFormating = {address: vm.person.address[i], firstName: vm.person.firstName[i], lastName: vm.person.lastName[i], address: vm.person.address[i], 
					passportNumber: vm.person.passportNumber[i], phoneNumber: vm.person.phoneNumber[i], jmbg: vm.person.jmbg[i]};

				persons.push(personFormating);		
			}
			console.log("LISTA PERSONA");
			console.log(persons);

       		var insuranceInfo = {};
       		insuranceInfo = {contractor: vm.contractor, vehicle: vm.vehicle, home: vm.home, personHolder: vm.personHolder, persons: persons,
       		 buyer: vm.buyer, itemsForDrools: vm.itemsForDrools, premiumPrice: vm.droolPrices.premiumPrice, language: vm.language, 
       		 discountPrice: vm.droolPrices.discountPrice, taxPrice: vm.droolPrices.taxPrice, totalPrice: vm.droolPrices.totalPrice};
			
			console.log("InsuranceInfo: ");
       		console.log(insuranceInfo);
       	
       		BuyService.buy(insuranceInfo).then(function(response) {
			 	console.log("Odgovor iz buy");
			 	vm.paymentUrlAndID = response.data;
			 	console.log(vm.paymentUrlAndID);
			 	//url paymentId
			 
				   $window.location = vm.paymentUrlAndID.url;
			
		    });
    	};

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
		vm.calculateFirstStep = function() {
			localStorageService.cookie.set('regionSelected', vm.regionSelected);
			localStorageService.cookie.set('endDate', vm.endDate);

			//Parsiranje datuma za prikazevanje u petom koraku
			var startDay = vm.startDate.getDate();
			var startMonth = vm.startDate.getMonth()+1;
			var startYear = vm.startDate.getFullYear();
			var startDate = startDay + '.' + startMonth +'.' + startYear;
			vm.startDateParsed = startDate;

			var endDay = vm.endDate.getDate();
			var endMonth = vm.endDate.getMonth()+1;
			var endYear = vm.endDate.getFullYear();
			var endDate = endDay + '.' + endMonth +'.' + endYear;
			vm.endDateParsed = endDate;

			var size = Object.keys(vm.ages).length;

			console.log(vm.ages);
			for (var i=0;  i <size; i++) {
				
					console.log(vm.ages[i]);
				
			}

			//deo koji proveri ako neki broj osoba nije unet, da setuje na 0.	
			for (var i=0;  i <size; i++) {
				if (vm.ageTyped[i] == undefined) {
					vm.ageTyped[i] = "0";
				}
			}
			//saberem sve ukupne osobe koliko ih ima
			var sum = 0;
			for (var i=0;  i <size; i++) {
				 //var sum = parseInt(vm.ageTyped[i]);
				  sum = sum + parseInt(vm.ageTyped[i]);
			}
			vm.totalPersons = sum;

			console.log(vm.totalPersons);

			//metoda da bi iterirao kroz ng-repeat sa odredjenim brojem
			vm.getNumber = function(num) {
			    return new Array(num);   
			}
			 console.log(localStorageService.cookie.get('regionSelected'));

		};

		vm.calculateSecondStep = function() {
			console.log(vm.towingSelected);
			localStorageService.cookie.set('towingSelected', vm.towingSelected);
			console.log("nakon");
			console.log(vm.towingSelected);

			console.log("CALCULATE");
			//Napravim objeka koji kasnije saljem za drools da bi se izracunala cena
			var ageId = [];
			var ageCount = [];
			var ageList = [];
			var sizeAge = Object.keys(vm.ages).length;
			console.log(vm.ageTyped.idAgeSub[0]);
			for (var i=0;  i <sizeAge; i++) {
				 ageId[i] = vm.ageTyped.idAgeSub[i];
				ageCount[i] = vm.ageTyped[i];
				ageList.push({ageId: ageId[i], ageCount: ageCount[i]})
			}
			console.log("LISTA");
			console.log(ageList);

			//napravim listu itema koji uticu na cenu, koje treba da posaljem bekendu da bi izracuno cenu
			var listItemsForDrools = [vm.regionSelected, vm.sumToSelected, vm.sportSelected,  vm.towingSelected,
			 vm.repairSelected, vm.accommodationSelected, vm.alternativeRideSelected,
			 vm.surfaceSelected, vm.ageApartmentSelected, vm.valueApartmentSelected, vm.disasterSelected];

			 //napravim objekat
			 vm.itemsForDrools = {itemsListForDrools: listItemsForDrools, ageList: ageList, startDate: vm.startDate, endDate: vm.endDate};
			//vm.itemsForDrools = itemsForDrools;

			console.log("ITEMS FOR DROOLS");
			console.log(vm.itemsForDrools);

			BuyService.postCalculate(vm.itemsForDrools)
				.then(function(response) {
			 		vm.droolPrices = response.data;
			});
		};

		


	}

})();