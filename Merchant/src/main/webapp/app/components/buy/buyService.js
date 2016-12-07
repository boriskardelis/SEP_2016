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
							console.log('RESPONSE OD SERVISA  ' + response.data[2].region);
							console.log('RESPONSE OD SERVISA  ' + response.data);
							//console.log(JSON.stringify(response.data))
							return response;
						})
						.catch(function(response) {
							console.log("USAO JE U CATCH");
							return response;
						});
			
		};

		var getSumTo = function() {
			return ["10.000 EUR", "50.0000 EUR"];
		};

		var getAgeCarrire = function() {
			return ["1-2", "17-36"];
		};

		/*var getAges = function() {
			return $http.get("api/ages")
						.then(function(response) {										
							return response;
						})
						.catch(function(response) {
							return response;
						});
		};*/

		var getAges = function() {
			return ["1-2", "17-36", "15-232"];
		};



		return {
			
			getRegions : getRegions,
			getSumTo : getSumTo,
			getAgeCarrire : getAgeCarrire,
			getAges : getAges
			
		};


	}
})();