(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('BuyCtrl', BuyCtrl);

	BuyCtrl.$inject = ['$scope', '$rootScope', 'BuyService', '$state', '$timeout', '$window', '$translate', 'localStorageService'];
	function BuyCtrl($scope, $rootScope, BuyService, $state, $timeout, $window, $translate, localStorageService) {
		var vm = this;

		console.log($translate.use());
		console.log(vm.form);

		vm.onlyNumbers = /^\d+$/;

		vm.isDisabled = false;
		//Zasto ne radi sa VM (this)?!
	    $scope.buttonDisable = function() {
	   	    console.log("USAO U FUNK");  
	        $timeout(function() {
		        $scope.isDisabled = true;
		        console.log('update with timeout fired');
		    }, 0);
	    };

		vm.regionSelected = localStorageService.cookie.get('regionSelected');
		vm.sumToSelected = localStorageService.cookie.get('sumToSelected');
		vm.sportSelected = localStorageService.cookie.get('sportSelected');
		vm.startDate = localStorageService.cookie.get('startDate');
		vm.endDate = localStorageService.cookie.get('endDate');
		vm.ageTyped = localStorageService.cookie.get('ageTyped');

		vm.persons = localStorageService.cookie.get('persons');

	
		vm.droolPrices = {
			premiumPrice: localStorageService.cookie.get('droolPrices.premiumPrice'), 
			discountPrice: localStorageService.cookie.get('droolPrices.discountPrice'), 
			taxPrice: localStorageService.cookie.get('droolPrices.taxPrice'), 
			totalPrice: localStorageService.cookie.get('droolPrices.totalPrice') 
		};

		vm.insuranceTypeRoadCheck = localStorageService.cookie.get('insuranceTypeRoadCheck');
		vm.insuranceTypeHomeCheck = localStorageService.cookie.get('insuranceTypeHomeCheck');
		vm.towingCheck = localStorageService.cookie.get('towingCheck');
		vm.towingSelected = localStorageService.cookie.get('towingSelected');
		vm.repairsCheck = localStorageService.cookie.get('repairsCheck');
		vm.repairSelected = localStorageService.cookie.get('repairSelected');
		vm.accommodationsCheck = localStorageService.cookie.get('accommodationsCheck');
		vm.accommodationSelected = localStorageService.cookie.get('accommodationSelected');
		vm.alternativeRidesCheck = localStorageService.cookie.get('alternativeRidesCheck');
		vm.alternativeRideSelected = localStorageService.cookie.get('alternativeRideSelected');
		vm.surfaceSelected = localStorageService.cookie.get('surfaceSelected');
		vm.ageApartmentSelected = localStorageService.cookie.get('ageApartmentSelected');
		vm.valueApartmentSelected = localStorageService.cookie.get('valueApartmentSelected');
		vm.disasterSelected = localStorageService.cookie.get('disasterSelected');

		vm.vehicle = {
			make: localStorageService.cookie.get('vehicle.make'), 
			registrationNumber: localStorageService.cookie.get('vehicle.registrationNumber'),
			ownerFirstName: localStorageService.cookie.get('vehicle.ownerFirstName'),
			ownerLastName: localStorageService.cookie.get('vehicle.ownerLastName'),
			ownerJmbg: localStorageService.cookie.get('vehicle.ownerJmbg'),
			type: localStorageService.cookie.get('vehicle.type'), 
			vinNumber: localStorageService.cookie.get('vehicle.vinNumber'), 
			yearOfProduction: localStorageService.cookie.get('vehicle.yearOfProduction')
		};

		vm.home = {
			address: localStorageService.cookie.get('home.address'), 
			ownerFirstName: localStorageService.cookie.get('home.ownerFirstName'), 
			ownerLastName: localStorageService.cookie.get('home.ownerLastName'), 
			ownerJMBG: localStorageService.cookie.get('home.ownerJMBG')
		};

		vm.buyer = {
			firstName: localStorageService.cookie.get('buyer.firstName'), 
			lastName: localStorageService.cookie.get('buyer.lastName'),
			jmbg: localStorageService.cookie.get('buyer.jmbg'),
			passportNumber: localStorageService.cookie.get('buyer.passportNumber'),
			address: localStorageService.cookie.get('buyer.address'),
			phoneNumber: localStorageService.cookie.get('buyer.phoneNumber'), 
			email: localStorageService.cookie.get('buyer.email')	
		};

		vm.personHolder = {
			firstName: localStorageService.cookie.get('personHolder.firstName'), 
			lastName: localStorageService.cookie.get('personHolder.lastName'),
			address: localStorageService.cookie.get('personHolder.address'),
			jmbg: localStorageService.cookie.get('personHolder.jmbg'),
			passportNumber: localStorageService.cookie.get('personHolder.passportNumber'),
			phoneNumber: localStorageService.cookie.get('personHolder.phoneNumber')
		};

		vm.contractor = localStorageService.cookie.get('contractor');
		
		//Po defaultu da bude selektovan contractor, ukoliko iz cookia dobija default.
		if (vm.contractor === null) {
			vm.contractor = true;
		}

		vm.totalPersons = localStorageService.cookie.get('totalPersons');
		console.log(vm.totalPersons);
	
		//AKO HOCU DA BUDE REAL TIME SESIJA
	/*	$scope.$watch('vm.regionSelected', function(newVal){
		    localStorageService.cookie.set('regionSelected', newVal);
	    });
	    $scope.$watch('vm.sumToSelected', function(newVal){
		    localStorageService.cookie.set('sumToSelected', newVal);
	    });
	    $scope.$watch('vm.sportSelected', function(newVal){
		    localStorageService.cookie.set('sportSelected', newVal);
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
			vm.insuranceTypeRoad = vm.insuranceTypes[0];
			vm.insuranceTypeHome = vm.insuranceTypes[1];
		});

		BuyService.getVehicle().then(function(response) {
			vm.vehciles = response.data;
		});
   
    	//Date
    	//if (vm.startDate == null & vm.endDate == null) {
			vm.startDate = new Date();
			var forwardDate = new Date();
			forwardDate.setDate(forwardDate.getDate() + 1);
			vm.endDate = forwardDate;
		//}

		vm.dateOptionsStart = {
		    maxDate: new Date(2020, 5, 21),
		    minDate: new Date(),
		    startingDay: 1	//da pocinje od ponedeljka
		};

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

	    $scope.$watch("vm.startDate", function(newValue, oldValue) {			
			if(vm.startDate.getTime() > vm.endDate.getTime()) {		
				vm.endDate= vm.startDate;
			}	
			
			vm.dateOptionsEnd = {
			minDate : vm.startDate,
			};
		});
	
		vm.calculateFirstStep = function() {
			
			console.log("SA SESIJE");
			console.log(vm.persons);
			vm.submittedFirst = true;
			//proverim custom validaciju za age type i datum
			if (vm.form.$invalid || (vm.endDate.getTime() <= vm.startDate.getTime()) ||  ((vm.ageTyped[0] === undefined || vm.ageTyped[0] == '0' || vm.ageTyped[0] === '') && 
				(vm.ageTyped[1] == '0' || vm.ageTyped[1] === undefined || vm.ageTyped[1] === '') && 
				(vm.ageTyped[2] == '0' || vm.ageTyped[2] === undefined || vm.ageTyped[2] === ''))) return;
			vm.submittedFirst = false;

			localStorageService.cookie.set('regionSelected', vm.regionSelected);
			localStorageService.cookie.set('sumToSelected', vm.sumToSelected);
			localStorageService.cookie.set('sportSelected', vm.sportSelected);
			localStorageService.cookie.set('startDate', vm.startDate);
			localStorageService.cookie.set('endDate', vm.endDate);
			localStorageService.cookie.set('ageTyped', vm.ageTyped);

			//Parsiranje datuma za prikazevanje u petom koraku
			var startDay = vm.startDate.getDate();
			var startMonth = vm.startDate.getMonth()+1;
			var startYear = vm.startDate.getFullYear();
			var startDate = startDay + '.' + startMonth +'.' + startYear;
			vm.startDateParsed = startDate;

			var endDay = vm.endDate.getDate();
			var endMonth = vm.endDate.getMonth();
			var endYear = vm.endDate.getFullYear();
			var endDate = endDay + '.' + endMonth +'.' + endYear;
			vm.endDateParsed = endDate;

			var size = 0;
			vm.ages.forEach(function() {
				size++;
			});
			console.log("SIZE JE:");
			console.log(size);

			console.log(vm.ages);
			for (var i=0;  i <size; i++) {			
					console.log(vm.ages[i]);
			}

			//deo koji proveri ako neki broj osoba nije unet, da setuje na 0.	
			for (var j=0;   j<size; j++) {
				if (vm.ageTyped[j] === undefined) {
					vm.ageTyped[j] = "0";
				}
			}
			//saberem sve ukupne osobe koliko ih ima
			var sum = 0;
			for (var k=0;  k<size; k++) {
				 //var sum = parseInt(vm.ageTyped[i]);
				  sum = sum + parseInt(vm.ageTyped[k]);
			}
			vm.totalPersons = sum;

			localStorageService.cookie.set('totalPersons', vm.totalPersons);

			//Person init
			vm.persons = [];
	       	var personInit = {};
			for (var i=0;  i < vm.totalPersons -1; i++) {
				personInit= {address: "", firstName: "", lastName: "",
					passportNumber: "", phoneNumber: "", jmbg: ""};

				vm.persons.push(personInit);		
			}
			console.log("PERSON INIT");
			console.log(vm.persons);
			localStorageService.cookie.set('persons', vm.persons);

			$state.go("buy.secondStep");

		};

		vm.calculateSecondStep = function() {

			if (vm.insuranceTypeRoadCheck)
				vm.submittedSecondRoad = true;
			
			if (vm.insuranceTypeHomeCheck)
				vm.submittedSecondHome = true;
				
			if (vm.formSecondRoad.$invalid || vm.formSecondHome.$invalid || ((vm.towingCheck === false || vm.towingCheck === undefined) && (vm.repairsCheck === false || vm.repairsCheck === undefined) && 
				(vm.accommodationsCheck === false || vm.accommodationsCheck === undefined) && 
				(vm.alternativeRidesCheck === false || vm.alternativeRidesCheck === undefined) && vm.submittedSecondRoad)) return;

			vm.submittedSecondRoad = false;
			vm.submittedSecondHome = false;

			localStorageService.cookie.set('insuranceTypeRoadCheck', vm.insuranceTypeRoadCheck);
			localStorageService.cookie.set('insuranceTypeHomeCheck', vm.insuranceTypeHomeCheck);
			localStorageService.cookie.set('towingCheck', vm.towingCheck);
			localStorageService.cookie.set('towingSelected', vm.towingSelected);		
			
			localStorageService.cookie.set('repairsCheck', vm.repairsCheck);
			localStorageService.cookie.set('repairSelected', vm.repairSelected);
			localStorageService.cookie.set('accommodationsCheck', vm.accommodationsCheck);
			localStorageService.cookie.set('accommodationSelected', vm.accommodationSelected);
			localStorageService.cookie.set('alternativeRidesCheck', vm.alternativeRidesCheck);
			localStorageService.cookie.set('alternativeRidesCheck', vm.alternativeRidesCheck);
			localStorageService.cookie.set('surfaceSelected', vm.surfaceSelected);
			localStorageService.cookie.set('ageApartmentSelected', vm.ageApartmentSelected);
			localStorageService.cookie.set('valueApartmentSelected', vm.valueApartmentSelected);
			localStorageService.cookie.set('disasterSelected', vm.disasterSelected);

			localStorageService.cookie.set('vehicle.registrationNumber', vm.vehicle.registrationNumber);
			localStorageService.cookie.set('vehicle.make', vm.vehicle.make);
			localStorageService.cookie.set('vehicle.ownerFirstName', vm.vehicle.ownerFirstName);
			localStorageService.cookie.set('vehicle.ownerLastName', vm.vehicle.ownerLastName);
			localStorageService.cookie.set('vehicle.ownerJmbg', vm.vehicle.ownerJmbg);
			localStorageService.cookie.set('vehicle.type', vm.vehicle.type);
			localStorageService.cookie.set('vehicle.vinNumber', vm.vehicle.vinNumber);
			localStorageService.cookie.set('vehicle.yearOfProduction', vm.vehicle.yearOfProduction);

			localStorageService.cookie.set('home.address', vm.home.address);
			localStorageService.cookie.set('home.ownerFirstName', vm.home.ownerFirstName);
			localStorageService.cookie.set('home.ownerLastName', vm.home.ownerLastName);
			localStorageService.cookie.set('home.ownerJMBG', vm.home.ownerJMBG);
			
			//Napravim objeka koji kasnije saljem za drools da bi se izracunala cena
			var ageId = [];
			var ageCount = [];
			var ageList = [];

			var sizeAge = 0;
			vm.ages.forEach(function() {
				sizeAge++;
			});
	
			//console.log(vm.ageTyped.idAgeSub[0]);
			for (var i=0;  i <sizeAge; i++) {
				 ageId[i] = vm.ageTyped.idAgeSub[i];
				ageCount[i] = vm.ageTyped[i];
				ageList.push({ageId: ageId[i], ageCount: ageCount[i]});
			}

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

				    localStorageService.cookie.set('droolPrices.premiumPrice', vm.droolPrices.premiumPrice);
					localStorageService.cookie.set('droolPrices.discountPrice', vm.droolPrices.discountPrice);
					localStorageService.cookie.set('droolPrices.taxPrice', vm.droolPrices.taxPrice);
					localStorageService.cookie.set('droolPrices.totalPrice', vm.droolPrices.totalPrice);
			});

			$state.go("buy.thirdStep");	
	
		};

		vm.calculateFourthStep = function() {

			vm.submittedFourth = true;
			if (vm.formFourth.$invalid) return;
			vm.submittedFourth = false;

			localStorageService.cookie.set('buyer.firstName', vm.buyer.firstName);
			localStorageService.cookie.set('buyer.lastName', vm.buyer.lastName);
			localStorageService.cookie.set('buyer.jmbg', vm.buyer.jmbg);
			localStorageService.cookie.set('buyer.passportNumber', vm.buyer.passportNumber);
			localStorageService.cookie.set('buyer.address', vm.buyer.address);
			localStorageService.cookie.set('buyer.phoneNumber', vm.buyer.phoneNumber);
			localStorageService.cookie.set('buyer.email', vm.buyer.email);

			localStorageService.cookie.set('personHolder.firstName', vm.personHolder.firstName);
			localStorageService.cookie.set('personHolder.lastName', vm.personHolder.lastName);
			localStorageService.cookie.set('personHolder.address', vm.personHolder.address);
			localStorageService.cookie.set('personHolder.jmbg', vm.personHolder.jmbg);
			localStorageService.cookie.set('personHolder.passportNumber', vm.personHolder.passportNumber);
			localStorageService.cookie.set('personHolder.phoneNumber', vm.personHolder.phoneNumber);

			localStorageService.cookie.set('contractor', vm.contractor);	

			localStorageService.cookie.set('persons', vm.persons);
			
			$state.go("buy.fifthStep");	
		};

		vm.calculateFifthStep = function() {

			vm.submitted = true;
			if (vm.formFifth.$invalid) return;

	    	vm.language = $translate.use();
 
			console.log("LISTA PERSONA");
			console.log(vm.persons);

       		var insuranceInfo = {};
       		insuranceInfo = {contractor: vm.contractor, vehicle: vm.vehicle, home: vm.home, personHolder: vm.personHolder, persons: vm.persons,
       		 buyer: vm.buyer, itemsForDrools: vm.itemsForDrools, premiumPrice: vm.droolPrices.premiumPrice, language: vm.language, 
       		 discountPrice: vm.droolPrices.discountPrice, taxPrice: vm.droolPrices.taxPrice, totalPrice: vm.droolPrices.totalPrice};
			
			console.log("InsuranceInfo: ");
       		console.log(insuranceInfo);
       	
       		BuyService.buy(insuranceInfo).then(function(response) {
			 	console.log("Odgovor iz buy");
			 	vm.paymentUrlAndID = response.data;
			 	console.log(vm.paymentUrlAndID);
			 	//url paymentId
			 	$timeout(function() {
			     	$window.location = vm.paymentUrlAndID.url;	
			    }, 200000);
			    
		    });
    	};

		vm.towingChecking = function() {
			if (!vm.towingCheck)
				vm.towingSelected = null;
		};

		vm.repairsChecking = function() {
			if (!vm.repairsCheck) 
				vm.repairSelected = null;
		};

		vm.accommodationsChecking = function() {
			if (!vm.accommodationsCheck)
				vm.accommodationSelected = null;
		};

		vm.alternativeRidesChecking = function() {
			if (!vm.alternativeRidesCheck)
				vm.alternativeRideSelected = null;
		};

		vm.insuranceTypeChecking = function() {
			if (!vm.alternativeRidesCheck)
				vm.alternativeRideSelected = null;
		};

		vm.insuranceTypeRoadChecking =function() {
			if (!vm.insuranceTypeRoadCheck) {
				vm.submittedSecondRoad = false;
				vm.towingCheck = false;
				vm.towingSelected = null;
				vm.repairsCheck = false;
				vm.repairSelected = null;
				vm.accommodationsCheck = false;
				vm.accommodationSelected = null;
				vm.alternativeRidesCheck = false;
				vm.alternativeRideSelected = null;

				vm.vehicle = {make: "",
					registrationNumber: "", 
					ownerFirstName: "", 
					ownerLastName: "", 
					ownerJmbg: "", 
					type: "", 
					vinNumber: "",
					yearOfProduction: ""
				};		
			}
		};

		vm.insuranceTypeHomeChecking =function() {
			if (!vm.insuranceTypeHomeCheck) {
				vm.submittedSecondHome = false;
				vm.surfaceSelected = null;
				vm.ageApartmentSelected = null;
				vm.valueApartmentSelected = null;
				vm.disasterSelected = null;
				vm.home = {address: "", 
					ownerFirstName: "", 
					ownerLastName: "", 
					ownerJMBG: ""};
				
			}
		};

		vm.contractorChange = function() {
			vm.personHolder = {
				firstName: "",
				lastName: "", 
				address: "", 
				jmbg: "", 
				passportNumber: "", 
				phoneNumber: ""		
			};
		};

		vm.firstPremission = function() {
			console.log("JEJ");
		};
		vm.secondPremission = function() {
			console.log("dva");
			console.log($state.current.name);
			if ($state.is('buy.firstStep')) {	
				//zabrana za
				return true;
			} else {
				return false;
			}
		};
		vm.thirdPremission = function() {
			console.log("dva");
			console.log($state.current.name);
			if ($state.is('buy.firstStep') || $state.is('buy.secondStep')) {	
				//zabrana za
				return true;
			} else {
				return false;
			}
		};
		vm.fourthPremission = function() {
			console.log("dva");
			console.log($state.current.name);
			if ($state.is('buy.firstStep') || $state.is('buy.secondStep') || $state.is('buy.thirdStep')) {	
				//zabrana za
				return true;
			} else {
				return false;
			}
		};
		vm.fifthPremission = function() {
			console.log("dva");
			console.log($state.current.name);
			if ($state.is('buy.firstStep') || $state.is('buy.secondStep') || $state.is('buy.thirdStep') || $state.is('buy.fourthStep')) {	
				//zabrana za
				return true;
			} else {
				return false;
			}
		};
	}

})();