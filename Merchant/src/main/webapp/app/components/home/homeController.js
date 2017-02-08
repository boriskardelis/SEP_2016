(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('HomeCtrl', HomeCtrl);

	HomeCtrl.$inject = ['$scope', 'HomeService','$translate' ];
	function HomeCtrl($scope, HomeService,$translate) {
		var vm = this;

		vm.proba = "RADI";
		vm.hello = HomeService.sayHello();
		vm.test = "aaaa";
		vm.language = $translate.use();
	


	}
})();