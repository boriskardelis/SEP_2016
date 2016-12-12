(function() {
	'use strict';
	
	angular
		.module('merchantApp')
		.directive('buyDirective', buyDirective);

	function buyDirective() {
		var buyDirective = {       	
        	restrict: 'E',
        	link: function(scope, element, attrs, ctrl) {
        		console.log("USAO U LINK");
        		//vm.ageTyped - age-vi
        		// var vm = this;
        		// vm.age = scope.age;
        		//console.log(vm.age);
        		
        	},
        	templateUrl: 'app/components/buy/buyDirective.html',
        	scope: {
				age: '=',
				
				//očekuje se u HTMLu atribut koji ide uz direktivu i koji se zove employee.
				//kada stavimo '=' prosleđujemo referencu na neku vrednost iz nekog roditeljskog scope-a,
				//i ako ga promenimo u direktivi menjamo ga i tamo odakle je došao
				//inputTitle: '@'
				//kada se stavi '@' prosleđuje se vrednost, u vidu stringa, znači običan tekst koji možemo obrađivati
				//bez da rizikujemo da ga menjamo na još nekom mestu.

				//= -dvostruka veza   @-jednostruka veza
			}
		};
		return buyDirective;
	}
})();