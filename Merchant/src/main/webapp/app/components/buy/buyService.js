(function() {
	'use strict';

	angular
		.module('merchantApp')
		.factory('BuyService', BuyService);

	BuyService.$inject = ['$http'];
	function BuyService($http) {

		var getRiskSubcategories = function() {
			return $http.get("api/risksubcategories")
						.then(function(response) {					
							//console.log('RESPONSE OD SERVISA  ' + response.data[2].region);
							//console.log('RESPONSE OD SERVISA  ' + response.data);
							//console.log(JSON.stringify(response.data))
							return response;
						})
						.catch(function(response) {
							console.log("USAO JE U CATCH");
							return response;
						});	
		};

		var getRiskCategories = function() {
			return $http.get("api/riskcategories")
						.then(function(response) {					
							return response;
						})
						.catch(function(response) {
							return response;
						});		
		};

		var getInsuranceTypes = function() {
			return $http.get("api/insurancetypes")
						.then(function(response) {					
							return response;
						})
						.catch(function(response) {
							return response;
						});		
		};

		var getVehicle = function() {			
			return $http.get("api/vehicles")
						.then(function(response) {					
							return response;
						})
						.catch(function(response) {
							return response;
						});	
		};

		/*var postCalculate = function(region, sum, ageCarrire) {
			return $http.post('api/price', {region: region, sum: sum, ageCarrire: ageCarrire})
						.then(function(response) {
							console.log("CKEDA ODGOVOR");
							return response;
						})
						.catch(function(response) {
							console.log("DOSLO DO CATCH");
							return response;
						});	
		};*/

		var postCalculate = function(region, sum, ageCarrier) {		
			return $http.post('api/price', {region: region, sum: sum, ageCarrier: ageCarrier})
						.then(function(response) {
							console.log("CKEDA ODGOVOR");
							return response;
						})
						.catch(function(response) {
							console.log("DOSLO DO CATCH");
							return response;
						});	
		};


		//Get all subcategories for specific category. @subCategories, @category
		var getSubsForCat = function (subCategories, category) {
			var cat = [];
			for (var i = 0; i < subCategories.length; i++) {
				if (subCategories[i].riskCategory.name == category) {
					//console.log(subCategories[i].name);
					cat.push(subCategories[i]);
				}
			}
			return cat;
		};

		


		return {
			
			getRiskSubcategories : getRiskSubcategories,
			getRiskCategories : getRiskCategories,
			getSubsForCat : getSubsForCat,
			getInsuranceTypes : getInsuranceTypes,
			postCalculate : postCalculate,
			getVehicle : getVehicle
		
			
		};


	}
})();