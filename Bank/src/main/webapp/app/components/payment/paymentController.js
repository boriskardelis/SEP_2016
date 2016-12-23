(function() {
	'use strict';

	angular
		.module('bankApp')
		.controller('PaymentCtrl', PaymentCtrl);

	PaymentCtrl.$inject = ['$scope', '$stateParams', '$timeout', 'PaymentService'];
	function PaymentCtrl($scope, $stateParams, $timeout, PaymentService) {
		var vm = this;

		vm.paymentId = $stateParams.paymentId;
		console.log(vm.paymentId);
		// $timeout(function() {
		// 			vm.paymentId = $stateParams.paymentId;
		// 	 		console.log($stateParams.paymentId);
  //       			console.log($stateParams);
  //       			console.log(vm.paymentId);
		// 		}, 3000);
		/*console.log("POZdrav od payment CTRL");
        console.log($stateParams.paymentID);
        console.log($stateParams);*/

		
		/*$http.get("api/payment/" + vm.paymentId)
						.then(function(response) {					
							return response;
						})
						.catch(function(response) {
							return response;
						});		*/
		PaymentService.getAmount(vm.paymentId).then(function(response) {
			 	console.log("Odgovor iz getAmount");
			 	vm.amount = response.data;
			 	console.log(vm.amount);
			 	
		 });

		vm.pay = function() {
			console.log("placeno");
			vm.card.paymentId = vm.paymentId;
			PaymentService.pay(vm.card).then(function(response) {
				console.log("URADJEN PAY");

			});
		};

	}
})();

// klijent se redirektuje na url: loclalhost:7070/payment/{{paymentID}}


// loclalhost:7070/payment/paymentId