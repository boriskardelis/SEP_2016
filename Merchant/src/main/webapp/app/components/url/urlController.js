(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('UrlCtrl', UrlCtrl);

	UrlCtrl.$inject = ['$scope', '$stateParams', 'UrlService'];
	function UrlCtrl($scope, $stateParams, UrlService) {
		var vm = this;

		var paymentId = $stateParams.paymentId;
		console.log("paymentiD je : ");
		console.log(paymentId);

		UrlService.getMessageByPaymentId(paymentId).then(function(response) {
			console.log(response.data);
			vm.status = response.data.status;
			vm.result = response.data.result;
			console.log(vm.status);
			console.log(vm.result);
			vm.status = "FAILED";
			vm.result = "INVALID_DATE";
			//status 0-SUCCESSFUL 1-FAILED 2-ERROR
			//result 0-SUCCESSFUL, 1-INSUFFICIENT_FUNDS, 2-INVALID_DATE, 3-CVC_INVALID
			if (vm.status == "SUCCESSFUL") {
				vm.message = "Your payment hes been successfull."; 
			} else if (vm.status == "FAILED" && vm.result == "INSUFFICIENT_FUNDS") {
				vm.message = "Insufficient funds on your bank account";
			} else if (vm.status == "FAILED" && vm.result == "INVALID_DATE") {
				vm.message = "Your card date is not valid";
			} else if (vm.status == "FAILED" && vm.result == "CVC_INVALID") {
				vm.message = "Your CVV2/CVC2 is invalid.";
			} else if (vm.status == "ERROR") {
				vm.message = "Error has occurred on server side, please try again later";
			}		
		});
	}
})();