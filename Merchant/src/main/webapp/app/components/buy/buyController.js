(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('BuyCtrl', BuyCtrl);

	BuyCtrl.$inject = ['$scope', 'BuyService'];
	function BuyCtrl($scope, BuyService) {
		var vm = this;

		vm.region = BuyService.getRegions();
		vm.sumTo = BuyService.getSumTo();
		vm.ageCarrier = BuyService.getAgeCarrire();
		vm.numberOfPersons = [1,2,3,4,5]
		

	}
})();