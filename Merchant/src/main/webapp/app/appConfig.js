
(function () {
	'use strict';
  angular
       .module('merchantApp')
      .config(config)
     .run(run);

 function config($stateProvider, $urlRouterProvider, $locationProvider) {
  
  
  $urlRouterProvider.otherwise('/home');

 
     $stateProvider
      
      .state('home', {
	      url: "/home",
	      templateUrl: "app/components/home/home.html",
	      controller: "HomeCtrl",
	      controllerAs: "vm"
      })  
      .state('pocetak', {
        url: "/buy",
        templateUrl: "app/components/buy/buy.html",
        controller: "BuyCtrl",
        controllerAs: "vm"
      });


     //Koristim da bi izbacio # iz url-a. Jos u server.js koristim rewrite mehanizam // to ked osm pravel XO makso
     //$locationProvider.html5Mode(true); 


  }

  function run($rootScope, $state) {
   

  }

}());