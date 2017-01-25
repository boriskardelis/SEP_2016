
(function () {
	'use strict';
  angular
       .module('bankApp')
      .config(config)
     .run(run);	

 function config($stateProvider, $urlRouterProvider, $locationProvider, $translateProvider) {
  
 	//$urlRouterProvider.otherwise('/home');
 		
     $stateProvider
      
      .state('home', {
	      url: "/home",
        views: {
                 'content': {
                           templateUrl: 'app/components/home/home.html',
                           controller: "HomeCtrl",
                           controllerAs: "vm"
                       },
                  'navigation':{
                           templateUrl: 'app/components/navigation/navigation.html',
                           controller: "NavigationCtrl",
                           controllerAs: "vm"
                       }
                } 
      })
      .state('payment', {
        url: "/payment?paymentId",
        views: {
                 'content': {
                           templateUrl: "app/components/payment/payment.html",
                           controller: "PaymentCtrl",
                           controllerAs: "vm"
                       },
                  'navigation':{
                           templateUrl: 'app/components/navigation/navigation.html',
                           controller: "NavigationCtrl",
                           controllerAs: "vm"
                       }
                } 
      });
      


     //Koristim da bi izbacio # iz url-a. Jos u server.js koristim rewrite mehanizam // to ked osm pravel XO makso
    $locationProvider.html5Mode(true); 

    var eng =
        {
            
            home : "Home",
            sumToInsure : "Sum to insure:"
          
        };

        var ser =
        {
            
            home : "Početna",
            sumToInsure : "Osigurana:"

            
        };


    $translateProvider
		.translations('en', eng)
		.translations('sr', ser)
    .preferredLanguage('en');
    
    $translateProvider.useSanitizeValueStrategy('escaped');

  }

  function run($rootScope, $state) {
   

  }

}());