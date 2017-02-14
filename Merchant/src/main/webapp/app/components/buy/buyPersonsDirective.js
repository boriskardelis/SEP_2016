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
        		
        	},
        	templateUrl: 'app/components/buy/views/buyPersonsDirective.html',
        	scope: {
                        person: "=",
                        formFourth: "=",
                        submittedFourth: "="
			
			}
		};
		return buyPersonsDirective;
	}
})();