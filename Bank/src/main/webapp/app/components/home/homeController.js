(function() {
	'use strict';

	angular
		.module('bankApp')
		.controller('HomeCtrl', HomeCtrl);

	HomeCtrl.$inject = ['$scope', 'HomeService' ];
	function HomeCtrl($scope, HomeService) {
		var vm = this;

		vm.proba = "RADI";
		vm.hello = HomeService.sayHello();
		vm.test = "aaaa";
	


	}
})();