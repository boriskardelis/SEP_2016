(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('UrlCtrl', UrlCtrl);

	UrlCtrl.$inject = ['$scope', '$stateParams', 'UrlService', '$window','$translate'];
	function UrlCtrl($scope, $stateParams, UrlService, $window, $translate) {
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
			
			//status 0-SUCCESSFUL 1-FAILED 2-ERROR
			//result 0-SUCCESSFUL, 1-INSUFFICIENT_FUNDS, 2-INVALID_DATE, 3-CVC_INVALID
			if ($translate.use() == "English") {
				if (vm.status == "SUCCESSFUL") {
					vm.message = "Your payment hes been successfull. Check your email for the report"; 
				} else if (vm.status == "FAILED" && vm.result == "INSUFFICIENT_FUNDS") {
					vm.message = "Insufficient funds on your bank account";
				} else if (vm.status == "FAILED" && vm.result == "INVALID_DATE") {
					vm.message = "Your card date is not valid";
				} else if (vm.status == "FAILED" && vm.result == "CVC_INVALID") {
					vm.message = "Your CVV2/CVC2 is invalid.";
				} else if (vm.status == "ERROR") {
					vm.message = "Error has occurred on server side, please try again later";
				} else if (vm.status == "FAILED" && vm.result == "INVALID_CARD") {
					vm.message = "The credit card is invalid";
				}
			}

			if ($translate.use() == "Serbian") {
				if (vm.status == "SUCCESSFUL") {
					vm.message = "Plaćanje je uspešno. Provertite vaš email za izveštaj"; 
				} else if (vm.status == "FAILED" && vm.result == "INSUFFICIENT_FUNDS") {
					vm.message = "Nedovoljno sredstava na vašem bankovnom računu";
				} else if (vm.status == "FAILED" && vm.result == "INVALID_DATE") {
					vm.message = "Datum na kartici nije validan";
				} else if (vm.status == "FAILED" && vm.result == "CVC_INVALID") {
					vm.message = "Bezbednosti kod nije validan";
				} else if (vm.status == "ERROR") {
					vm.message = "Desila se greška na serveru, pokušajte ponovo";
				} else if (vm.status == "FAILED" && vm.result == "INVALID_CARD") {
					vm.message = "Nevažeća kreditna kartica";
				}	
			}			
		});

		 vm.redirectBackOnBank = function() {
		 	$window.location = "https://localhost:7070/payment?paymentId="+ paymentId;
		 }
	}
})();