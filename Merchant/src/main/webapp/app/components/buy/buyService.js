(function() {
	'use strict';

	angular
		.module('merchantApp')
		.factory('BuyService', BuyService);

	BuyService.$inject = ['$http'];
	function BuyService($http) {

		var getRegions = function() {
			return ["Monaco", "Serbia"];
		};


		return {
			
			getRegions : getRegions
			
		};


	}
})();