
(function () {
	'use strict';
  angular
       .module('merchantApp')
      .config(config)
     .run(run);	

 function config($stateProvider, $urlRouterProvider, $locationProvider, $translateProvider) {
  
 	$urlRouterProvider.otherwise('/home');
 		
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
      .state('about', {
        url: "/about",
        views: {
                 'content': {
                           templateUrl: "app/components/about/about.html",
                           controller: "AboutCtrl",
                           controllerAs: "vm"
                       },
                  'navigation':{
                           templateUrl: 'app/components/navigation/navigation.html',
                           controller: "NavigationCtrl",
                           controllerAs: "vm"
                       }
                } 
       }) 
      .state('buy', {
        url: "/buy",
        views: {
                 'content': {
                           templateUrl: "app/components/buy/buy.html",
                           controller: "BuyCtrl",
                           controllerAs: "vm"
                       },
                  'navigation':{
                           templateUrl: 'app/components/navigation/navigation.html',
                           controller: "NavigationCtrl",
                           controllerAs: "vm"
                       }
                } 
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