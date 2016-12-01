(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('BuyCtrl', BuyCtrl)

	BuyCtrl.$inject = ['$scope', 'BuyService'];
	function BuyCtrl($scope, BuyService) {
		var vm = this;

		vm.region = BuyService.getRegions();
		
	


	}
})();