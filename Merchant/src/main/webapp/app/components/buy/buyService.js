(function() {
	'use strict';

	angular
		.module('merchantApp')
		.factory('BuyService', BuyService);

	BuyService.$inject = ['$http'];
	function BuyService($http) {

		var getRiskSubcategories = function() {
			console.log("USAO U METODU getRiskSubcategories");
			return $http.get("api/risksubcategories")
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

		var getRiskCategories = function() {
			console.log("USAO U METODU getRiskCategories");
			return $http.get("api/riskcategories")
						.then(function(response) {					
							return response;
						})
						.catch(function(response) {
							return response;
						});
			
		};

		//Get all subcategories for specific category. @subCategories, @category
		var getSubsForCat = function (subCategories, category) {
			var cat = [];
			for (var i = 0; i < subCategories.length; i++) {
				if (subCategories[i].riskCategory.name == category) {
					console.log(subCategories[i].name);
					cat.push(subCategories[i]);
				}
			}
			return cat;
		};

		var getSumTo = function() {
			return ["10.000 EUR", "50.0000 EUR"];
		};


		return {
			
			getRiskSubcategories : getRiskSubcategories,
			getRiskCategories : getRiskCategories,
			getSumTo : getSumTo,
			getSubsForCat : getSubsForCat
		
			
		};


	}
})();