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
        	templateUrl: 'app/components/buy/views/buyPersonsDirective.html',
        	scope: {
        		ageTyped: '=',
                        personIndex: "=",
                        person: "="
			
			}
		};
		return buyPersonsDirective;
	}
})();