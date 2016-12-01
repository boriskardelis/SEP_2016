(function() {
	'use strict';

	angular
		.module('merchantApp')
		.factory('BuyService', BuyService);

	BuyService.$inject = ['$http'];
	function BuyService($http) {

		var getRegions = function() {
			console.log("USAO U METODU GETregions");
			return $http.get("api/regions")
						.then(function(response) {
							console.log('RESPONSE OD SERVISA');
							return response;
						});
			
		};

		var getSumTo = function() {
			return ["10.000 EUR", "50.0000 EUR"];
		};

		var getAgeCarrire = function() {
			return ["1-2", "17-36"];
		};


		return {
			
			getRegions : getRegions,
			getSumTo : getSumTo,
			getAgeCarrire : getAgeCarrire
			
		};


	}
})();