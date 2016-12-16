(function() {
	'use strict';

	angular
		.module('bankApp')
		.factory('PaymentService', PaymentService);

	PaymentService.$inject = ['$http'];
	function PaymentService($http) {


		var getAmount = function(paymentId) {
		console.log(paymentId);			
			return $http.get("api/payment/" + paymentId)
						.then(function(response) {	
							console.log("Vracen odgovor from Payment");				
							return response;
						})
						.catch(function(response) {
							console.log("doslo do CATCH Payment");	
							return response;
						});	
			};


		return {
			
			getAmount : getAmount
			
		};


	}
})();