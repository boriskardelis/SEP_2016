(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('TestCtrl', TestCtrl)

	TestCtrl.$inject = ['$scope'];
	function TestCtrl($scope) {
		var vm = this;

		vm.te = "Test podaci sa test kontrolera";
	
	


	}
})();