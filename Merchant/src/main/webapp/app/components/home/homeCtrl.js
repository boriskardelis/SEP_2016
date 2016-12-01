(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('HomeCtrl', HomeCtrl)

	HomeCtrl.$inject = ['$scope' ];
	function HomeCtrl($scope) {
		var vm = this;

		vm.proba = "RADI";
		//vm.hello = HomeService.sayHello();

	


	}
})();