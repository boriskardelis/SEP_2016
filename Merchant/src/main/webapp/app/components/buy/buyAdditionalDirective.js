(function() {
	'use strict';
	
	angular
		.module('merchantApp')
		.directive('buyAdditionalDirective', buyAdditionalDirective);

	function buyAdditionalDirective() {
		var buyAdditionalDirective = {       	
        	restrict: 'E',
        	transclude: true,
        	link: function(scope, element, attrs, ctrl) {
        		
        		 var vm = this;
        		 // vm.insuranceTypess = scope.insuranceType;
        		 // console.log(vm.insuranceTypess);
        		
        	
        		//vm.vehicle = [];
        		//scope.isChecked = false;
        	// 	scope.checked = "";
      			// scope.$watch('checked', function(newVal, oldVal) {
      			// 	if(!angular.equals(newVal, oldVal)) {
      			// 		console.log("USPELO");
      			// 	}
      			// }, true);
      			vm.vehcile = scope.vehicle;

        		
        	},
        	templateUrl: 'app/components/buy/buyAdditionalDirective.html',
        	scope: {
				insuranceType: '=',
				towings: '=',
				repairs: '=',
				accommodations: '=',
				alternativeRides: '=',
				surfaces: '=',
				ageApartments: '=',
				valueApartments: '=',
				disasters: '=',
				towingSelected: '=',
				repairSelected: '=',
				accommodationSelected: '=',
				alternativeRideSelected:'=',
				vehicle: '=',
				home: "=",
				surfaceSelected: "=",
				ageApartmentSelected: "=",
				valueApartmentSelected: "=",
				disasterSelected: "="


				
				
				//očekuje se u HTMLu atribut koji ide uz direktivu i koji se zove employee.
				//kada stavimo '=' prosleđujemo referencu na neku vrednost iz nekog roditeljskog scope-a,
				//i ako ga promenimo u direktivi menjamo ga i tamo odakle je došao
				//inputTitle: '@'
				//kada se stavi '@' prosleđuje se vrednost, u vidu stringa, znači običan tekst koji možemo obrađivati
				//bez da rizikujemo da ga menjamo na još nekom mestu.

				//= -dvostruka veza   @-jednostruka veza
			}
		};
		return buyAdditionalDirective;
	}
})();