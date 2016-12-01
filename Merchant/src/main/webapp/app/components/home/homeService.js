(function() {
	'use strict';

	angular
		.module('merchantApp')
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