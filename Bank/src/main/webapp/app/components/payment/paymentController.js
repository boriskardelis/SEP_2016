(function() {
	'use strict';

	angular
		.module('bankApp')
		.controller('PaymentCtrl', PaymentCtrl);

	PaymentCtrl.$inject = ['$scope', '$stateParams', '$timeout'];
	function PaymentCtrl($scope, $stateParams, $timeout) {
		var vm = this;


		$timeout(function() {
			 		console.log($stateParams.paymentID);
        console.log($stateParams);
				}, 3000);
		/*console.log("POZdrav od payment CTRL");
        console.log($stateParams.paymentID);
        console.log($stateParams);*/

		
		// $http.get("api/payment/" + paymentID)
		// 				.then(function(response) {					
		// 					return response;
		// 				})
		// 				.catch(function(response) {
		// 					return response;
		// 				});		
	

	}
})();

// klijent se redirektuje na url: loclalhost:7070/payment/{{paymentID}}


// loclalhost:7070/payment/paymentId