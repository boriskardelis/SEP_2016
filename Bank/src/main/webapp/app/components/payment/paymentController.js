(function() {
	'use strict';

	angular
		.module('bankApp')
		.controller('PaymentCtrl', PaymentCtrl);

	PaymentCtrl.$inject = ['$scope', '$stateParams', '$timeout', 'PaymentService'];
	function PaymentCtrl($scope, $stateParams, $timeout, PaymentService) {
		var vm = this;

		var date = new Date();
		vm.currentYear = date.getFullYear();

		vm.months = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
		vm.years = [vm.currentYear, vm.currentYear+1,vm.currentYear+2, vm.currentYear+3, vm.currentYear+4, vm.currentYear+5, vm.currentYear+6,vm.currentYear+7, 
		vm.currentYear+8, vm.currentYear+9, vm.currentYear+10];

		vm.paymentId = $stateParams.paymentId;
		console.log(vm.paymentId);
		
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