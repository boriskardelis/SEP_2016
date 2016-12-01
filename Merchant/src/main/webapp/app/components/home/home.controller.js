(function() {
	'use strict';

	angular
		.module('merchantapp')
		.controller('HomeCtrl', HomeCtrl)

	HomeCtrl.$inject = ['$scope', 'HomeService'];
	function HomeCtrl($scope, HomeService) {
		var vm = this;

		vm.hello = HomeService.sayHello();



	}
})();