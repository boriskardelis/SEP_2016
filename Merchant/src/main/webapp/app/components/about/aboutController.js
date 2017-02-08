(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('AboutCtrl', AboutCtrl);

	AboutCtrl.$inject = ['$scope','$rootScope','$translate'];
	function AboutCtrl($scope, $rootScope,  $translate) {
		var vm = this;
		console.log($translate.use());
		vm.language = $translate.use();
		console.log(vm.language);

	}
})();