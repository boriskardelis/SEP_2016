(function() {
	'use strict';

	angular
		.module('bankApp')
		.factory('HomeService', HomeService);

	HomeService.$inject = ['$http'];
	function HomeService($http) {

		var sayHello = function() {
			return "Hello madafaka";
		};


		return {
			
			sayHello : sayHello
			
		};


	}
})();