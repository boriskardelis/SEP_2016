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
							return response;
						});	
			};

		var pay = function(card) {	
			return $http.post("api/payment/pay", card)
						.then(function(response) {		
							return response;
						})
						.catch(function(response) {
							console.log("Kod SERVISA DOSLO DO CATCH");
							return response;
						});	
			};

		return {
			
			getAmount : getAmount,
			pay : pay,
			
		};


	}
})();