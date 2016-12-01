(function() {
	'use strict';

	angular
		.module('merchantapp')
		.factory('HomeService', HomeService);

	HomeService.$inject = ['$http'];
	function HomeService($http) {

		var sayHello = function() {
			return "Hello madafaka";
		};


		return {
			//createGame : createGame,
			sayHello : sayHello
			
		};


	}
})();