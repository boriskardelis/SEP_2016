
(function () {
	'use strict';
  angular
       .module('merchantApp')
      .config(config)
     .run(run);

 function config($stateProvider, $urlRouterProvider, $locationProvider) {
  
  
  $urlRouterProvider.otherwise('/');

 
     $stateProvider
      .state('pocetak', {
        url: "/",
        controller: "HomeCtrl",
        controllerAs: "vm"
      })
      	.state('home', {
	      url: "/home",
	      templateUrl: "app/components/home/home.html",
	      controller: "HomeCtrl",
	      controllerAs: "vm"
    });


     //Koristim da bi izbacio # iz url-a. Jos u server.js koristim rewrite mehanizam // to ked osm pravel XO makso
     //$locationProvider.html5Mode(true); 


  }

  function run($rootScope, $state) {
   

  }

}());