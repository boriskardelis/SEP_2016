(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('BuyCtrl', BuyCtrl);

	BuyCtrl.$inject = ['$scope', 'BuyService', '$state', '$timeout', '$window'];
	function BuyCtrl($scope, BuyService, $state, $timeout, $window) {
		var vm = this;
		
		/*BuyService.getRiskSubcategories().then(function(response) {
			
			vm.subcategories = response.data;

			console.log(response.data[1].riskCategory.id);
			console.log(response.data);
	
			//@subcategories, @category
			vm.regions = BuyService.getSubsForCat(response.data, "region");
			vm.ages  = BuyService.getSubsForCat(response.data, "age");
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
		
		});*/

		BuyService.getRiskSubcategoriesBasedOnLanguage("English").then(function(response) {
			console.log(response.data);
			console.log(response.data[0].nameTranslate.name);
			console.log(response.data[0].nameTranslate);

			//@subcategories, @category
			vm.regions = BuyService.getSubsForCat(response.data, "region");
			vm.ages  = BuyService.getSubsForCat(response.data, "age");
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
  
       		var persons = [];
       		var personFormating = {};
       		console.log(vm.person);
       		for (var i=0;  i < vm.totalPersons - 1; i++) {
				personFormating = {address: vm.person.address[i], firstName: vm.person.firstName[i], address: vm.person.address[i], 
					passportNumber: vm.person.passportNumber[i], phoneNumber: vm.person.phoneNumber[i], jmbg: vm.person.jmbg[i]};

				persons.push(personFormating);		
			}
			console.log("LISTA PERSONA");
			console.log(persons);

       		var insuranceInfo = {};
       		insuranceInfo = {contractor: vm.contractor, vehicle: vm.vehicle, home: vm.home, personHolder: vm.personHolder, persons: persons,
       		 buyer: vm.buyer, itemsForDrools: vm.itemsForDrools, premiumPrice: vm.droolPrices.premiumPrice, 
       		 discountPrice: vm.droolPrices.discountPrice, taxPrice: vm.droolPrices.taxPrice, totalPrice: vm.droolPrices.totalPrice};
			
			console.log("InsuranceInfo: ");
       		console.log(insuranceInfo);
       	
       		BuyService.buy(vm.droolPrices.totalPrice).then(function(response) {
			 	console.log("Odgovor iz buy");
			 	vm.paymentUrlAndID = response.data;
			 	console.log(vm.paymentUrlAndID);
			 	//url paymentId
			 	$timeout(function() {
			 		console.log("proslo");
				   $window.location = vm.paymentUrlAndID.url;
				}, 1000);
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
			//Parsiranje datuma za prikazevanje u petom koraku
			var startDay = vm.startDate.getDate();
			var startMonth = vm.startDate.getMonth()+1;
			var startYear = vm.startDate.getFullYear();
			var startDate = startDay + '.' + startMonth +'.' + startYear;
			vm.startDateParsed = startDate;

			var endDay = vm.startDate.getDate();
			var endMonth = vm.startDate.getMonth()+1;
			var endYear = vm.startDate.getFullYear();
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

		};

		vm.calculateSecondStep = function() {

			
			console.log("CALCULATE");
			/*console.log(vm.regionSelected);
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
			console.log(vm.ageTyped);
			
			console.log(vm.vehicle);
			console.log(vm.home);
			*/	

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

    	//.insuranceType = ["Putno", "Home"];
    	vm.checked = [];

    	//Prepravi jer kad reloadujes prelazi na prvo stanje
	   	$state.go('buy.firstStep');

	}

})();