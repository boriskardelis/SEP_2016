(function() {
	'use strict';

	angular
		.module('merchantApp')
		.factory('UrlService', UrlService);

	UrlService.$inject = ['$http'];
	function UrlService($http) {

		var getMessageByPaymentId = function(paymentId) {
			return $http.post("api/paymentMessage", paymentId)
						.then(function(response) {					
							return response;
						})
						.catch(function(response) {
							console.log("DOSLO DO CATCH PAYMENTMESSAGE");
							return response;
						});		
		};

		return {		

			getMessageByPaymentId : getMessageByPaymentId		
		};


	}
})();