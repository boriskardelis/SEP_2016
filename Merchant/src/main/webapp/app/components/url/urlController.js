(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('UrlCtrl', UrlCtrl);

	UrlCtrl.$inject = ['$scope'];
	function UrlCtrl($scope) {
		var vm = this;

		vm.paymentId = $stateParams.paymentId;
		console.log("paymentiD je : ");
		console.log(vm.paymentId);

		$http.post("api/paymentMessage", vm.paymentId)
						.then(function(response) {					
							 console.log(response.data);
							 //vm.message = response.data.message;
						})
						.catch(function(response) {
							console.log("DOSLO DO CATCH PAYMENTMESSAGE");
							console.log(response);
						});	

	


	}
})();