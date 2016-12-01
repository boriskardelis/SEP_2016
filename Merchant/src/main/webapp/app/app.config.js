(function() {
	'use strict';

	angular
		.module('merchantapp')
		.config(config)
		.run(run);

	function config($stateProvider, $locationProvider) {
		console.log('Doslo je do catch');
	$stateProvider
	    .state('home', {
	      url: "/",
	      templateUrl: "components/home/home.html",
	      controller: "HomeCtrl",
	      controllerAs: "vm"
	    }),
	    .state('homePage', {
	      url: "/home",
	      templateUrl: "components/home/home.html",
	      controller: "HomeCtrl",
	      controllerAs: "vm"
	    });

	    //Koristim da bi izbacio # iz url-a. Jos u server.js koristim rewrite mehanizam
     	$locationProvider.html5Mode(true); 
	}

	function run(function($rootScope,  $state)) {
		console.log('Doslo je do catch RUN');

	}


	}
})();