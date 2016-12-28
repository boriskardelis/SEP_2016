
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
                           templateUrl: "app/components/buy/views/buy.html",
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
            templateUrl: 'app/components/buy/views/buyFirstStep.html'
        })
       .state('buy.secondStep', {
            url: '/secondStep',
            templateUrl: 'app/components/buy/views/buySecondStep.html'
        })
         .state('buy.thirdStep', {
            url: '/thirdStep',
            templateUrl: 'app/components/buy/views/buyThirdStep.html'
        })
         .state('buy.fourthStep', {
            url: '/fourthStep',
            templateUrl: 'app/components/buy/views/buyFourthStep.html'
        })
         .state('buy.fifthStep', {
            url: '/fifthStep',
            templateUrl: 'app/components/buy/views/buyFifthStep.html'
        });


     //Koristim da bi izbacio # iz url-a. Jos u server.js koristim rewrite mehanizam // to ked osm pravel XO makso
    $locationProvider.html5Mode(true); 

        var eng =
        {
            cn : "Chuck Norris Insurance",
            home : "Home",
            buyInsurance : "Buy insurance",
            about : "About",
            sumToInsure : "Sum to insure:",
            selectAge : "-Select age-",
            selectDestination: "-Select destination-",
            region : "Region:",
            home : "Home",
            ageInsuranceCarrier : "Insurance carrier age:",
            numberOfInsurancedPersons : "Number of insuranced persons:",
            to18 : "to 18",
            over60 : "over 60",
            age_replacement : '{{name}}',
            durationOfInsurance : "Duration of insurance:",
            from : "From:",
            to : "To:",
            selectSport : "-Select sport-",
            firsts : "First step",
            seconds : "Second step",
            thirds : "Third step",
            fourths : "Fourth step",
            fifths : "Fifth step",
            travelInsuranceMessage : "Travel insurance",
            nextSection : "Next section",
            previousSection: "Previous section",
            additionalInsurance : "Additional insurance:",
            additionalPackages : "Additional packages:",
            towing : "Towing to a certain mileage:",
            selectMileage : "-Select mileage-",
            repairsTo : "Repairs to a certain price: ",
            selectPrice : "-Select price-",
            accommodation: "Accommodation in hotel to certain days:",
            selectNumberOfDays : "-Select number of days-",
            alternativeRide : "Alternative ride:",
            selectRide : "-Select ride-",
            vehicleInformations : "Vehcile informations:",
            registrationNumber: "Registration number:",
            vehicleMake : "Vehcile make:",
            vehicleOwnerFN : "Vehicle owner first name:",
            vehicleOwnerLN : "Vehicle owner last name:",
            vehicleOwnerJMBG : "Vehicle owner personal identification number:",
            vehicleType : "Vehicle type:",
            vinNumber : "Vin number:",
            yearOfProduction : "Year of production:",
            homeInfo : "Home informations:",
            address: "Address",
            homeOwnerFN : "Home owner first name:",
            homeOwnerLN : "Home owner last name:",
            homeOwnerJMBG : "Home owner identification number:",
            surface : "Surface of home:",
            selectSurface : "-Select surface-",
            ageOfHome : "Age of home:",
            estimatedValue : "Estimated value of home:",
            selectValue : "-Select value-",
            insureFrom : "Insure from:",
            selectType : "-Select type-",
            insurancePremium : "Insurance premium:",
            discount : "Discount:",
            tax : "Tax:",
            totalPayment : "Total payment:",
            insurancedPersons : "Insuranced persons:",
            insuranceContractorInfo : "Insurance contractor informations",
            firstName : "First name",
            lastName : "Last name",
            jmbg : "Identification number",
            passportNumber : "Passport number",
            phoneNumber : "Phone number",
            insuranceContractor : "Insurance contractor is:",
            spaic : " a same person as insurance carrier.",
            nspaic : "NOT a same person as insurance carrier.",
            insuranceInformation : "Insurance informations:",
            additionalInsurances : "Additional insurances:",
            to1 : "to",



          
        };

        var ser =
        {   
            cn : "Chuck Norris osiuguranje",
            home : "Početna",
            buyInsurance : "Kupi osiguranje",
            about : "O nama",
            selectDestination: "-Odaberite destinaciju-",
            selectAge : "-Odaberite godine-",
            region : "Region",
            home : "Početna",
            sumToInsure : "Osigurana suma:",
            ageInsuranceCarrier : "Uzrast nosioca osiguranja",
            numberOfInsurancedPersons : "Broj osiguranika",
            to18 : "do 18",
            over60 : "preko 60",
            age_replacement : '{{name}}',
            durationOfInsurance : "Trajanje osiguranja",
            from : "Od",
            to : "Do",
            selectSport : "-Odaberite sport-",
            firsts : "Prvi korak",
            seconds : "Drugi korak",
            thirds : "Treći korak",
            fourths : "Četvrti korak",
            fifths : "Peti korak",
            travelInsuranceMessage : "Putno osiguranje",
            nextSection : "Sledeći korak",
            previousSection: "Predhodni korak",
            additionalInsurance : "Dodatno osiguranje",
            additionalPackages : "Dodatni paketi",
            towing : "Šlepanje do određene kilometraže",
            selectMileage : "-Odaberite kilometražu-",
            repairsTo : "Popravka do određene cene",
            selectPrice : "-Odaberite cenu-",
            accommodation: "Smeštaj u hotelu do određenog broja dana",
            selectNumberOfDays : "-Odaberite broj dana-",
            alternativeRide : "Alternativni prevoz",
            selectRide : "-Odaberite prevoz-",
            vehicleInformations : "Informacije o vozilu",
            registrationNumber: "Broj registracije",
            vehicleMake : "Marka vozila",
            vehicleOwnerFN : "Ime vlasnika vozila",
            vehicleOwnerLN : "Prezime vlasnika vozila",
            vehicleOwnerJMBG : "JMBG vlasnika vozila",
            vehicleType : "Tip vozila",
            vinNumber : "Broj šasije",
            yearOfProduction : "Godina proizvodnje",
            homeInfo : "Informacije o kući/stanu",
            address: "Adresa",
            homeOwnerFN : "Ime vlasnika kuće/stana",
            homeOwnerLN : "Prezime vlasnika kuće/stana",
            homeOwnerJMBG : "JMBG vlasnika kuće/stana",
            surface : "Površina kuće/stana",
            selectSurface : "-Odaberite površinu",
            ageOfHome : "Starost kuće/stana",
            estimatedValue : "Procenjena vrednost kuće/stana",
            selectValue : "-Izaberite vrednost-",
            insureFrom : "Osigurati od",
            selectType : "-Odaberite tip-",
            insurancePremium : "Premija osiguranja",
            discount : "Popust",
            tax : "Porez",
            totalPayment : "Ukupno za uplatu",
            insurancedPersons : "Osigurane osobe",
            insuranceContractorInfo : "Informacije o ugovaraču osiguranja",
            firstName : "Ime",
            lastName : "Prezime",
            jmbg : "JMBG",
            passportNumber : "Broj pasoša",
            phoneNumber : "Broj telefona",
            insuranceContractor : "Ugovarač osiguranja je:",
            spaic : "nosilac osiguranja.",
            nspaic : "druga osoba koja nije nosilac osiguranja.",
            insuranceInformation : "Informacije o osiguranju",
            additionalInsurances : "Dodatna osiguranja",
            to1 : "do",




          

          
            
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