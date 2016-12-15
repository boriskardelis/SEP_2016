
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
      .state('about', {
        url: "/about",
        templateUrl: "app/components/about/about.html",
        controller: "AboutCtrl",
        controllerAs: "vm"
      })    
      .state('buy', {
        url: "/buy",
        templateUrl: "app/components/buy/buy.html",
        controller: "BuyCtrl",
        controllerAs: "vm"
      })//Nested Views for buy
       .state('buy.firstStep', {
            url: '/firstStep',
            templateUrl: 'app/components/buy/buyFirstStep.html'
        })
       .state('buy.secondStep', {
            url: '/secondStep',
            templateUrl: 'app/components/buy/buySecondStep.html'
        })
         .state('buy.thirdStep', {
            url: '/thirdStep',
            templateUrl: 'app/components/buy/buyThirdStep.html'
        })
         .state('buy.fourthStep', {
            url: '/fourthStep',
            templateUrl: 'app/components/buy/buyFourthStep.html'
        })
         .state('buy.fifthStep', {
            url: '/fifthStep',
            templateUrl: 'app/components/buy/buyFifthStep.html'
        });


     //Koristim da bi izbacio # iz url-a. Jos u server.js koristim rewrite mehanizam // to ked osm pravel XO makso
    $locationProvider.html5Mode(true); 
    


  }

  function run($rootScope, $state) {
   

  }

}());