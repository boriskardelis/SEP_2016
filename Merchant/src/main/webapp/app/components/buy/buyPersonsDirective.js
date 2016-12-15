(function() {
	'use strict';
	
	angular
		.module('merchantApp')
		.directive('buyPersonsDirective', buyPersonsDirective);

	function buyPersonsDirective() {
		var buyPersonsDirective = {       	
        	restrict: 'E',
        	link: function(scope, element, attrs, ctrl) {
        		var vm = this;
 
        		console.log("asdasd");
        		/*console.log(scope.i);
        		
        		if (scope.i == undefined) {
        			console.log("ulazi u IF");
        			scope.i = 0;
        			console.log(scope.i);
        		}*/
        		// console.log(scope.iter);
        		// vm.newIter = scope.iter;
        		// console.log(vm.newIter);
        
        	
        		

        		
        		

        		
        	},
        	templateUrl: 'app/components/buy/buyPersonsDirective.html',
        	scope: {
        		ageTyped: '=',

				


				
				//očekuje se u HTMLu atribut koji ide uz direktivu i koji se zove employee.
				//kada stavimo '=' prosleđujemo referencu na neku vrednost iz nekog roditeljskog scope-a,
				//i ako ga promenimo u direktivi menjamo ga i tamo odakle je došao
				//inputTitle: '@'
				//kada se stavi '@' prosleđuje se vrednost, u vidu stringa, znači običan tekst koji možemo obrađivati
				//bez da rizikujemo da ga menjamo na još nekom mestu.

				//= -dvostruka veza   @-jednostruka veza
			}
		};
		return buyPersonsDirective;
	}
})();