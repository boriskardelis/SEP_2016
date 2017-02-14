
(function () {
	'use strict';
  angular
       .module('merchantApp')
      .config(config)
     .run(run);	

 function config($stateProvider, $urlRouterProvider, $locationProvider, $translateProvider) {
  

   //localStorageServiceProvider.setPrefix('merchantApp');
  
 	$urlRouterProvider.otherwise('/home');
  //Posto koristim nested views, treba mi da kada pogodim parenta (buy), redirektuje me na child (firstStep), a pritom da ostavim url
  $urlRouterProvider.when('/buy', '/buy/firstStep' );

 		
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
      .state('paymentSuccessful', {
        url: "/paymentSuccessful?paymentId",
        views: {
                 'content': {
                           templateUrl: "app/components/url/url.html",
                           controller: "UrlCtrl",
                           controllerAs: "vm"
                       },
                  'navigation':{
                           templateUrl: 'app/components/navigation/navigation.html',
                           controller: "NavigationCtrl",
                           controllerAs: "vm"
                       }
                } 
       })
       .state('paymentFailed', {
        url: "/paymentFailed?paymentId",
        views: {
                 'content': {
                           templateUrl: "app/components/url/url.html",
                           controller: "UrlCtrl",
                           controllerAs: "vm"
                       },
                  'navigation':{
                           templateUrl: 'app/components/navigation/navigation.html',
                           controller: "NavigationCtrl",
                           controllerAs: "vm"
                       }
                } 
       }) 
       .state('paymentError', {
        url: "/paymentError?paymentId",
        views: {
                 'content': {
                           templateUrl: "app/components/url/url.html",
                           controller: "UrlCtrl",
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
                },
        abstract:true
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
            insuranceCarrire : "Insurance carrier informations",
            mustBe : "Must be ",
            passportErrShort : "Pass num must be ",
            jmbgErrShort : "JMBG must be ",
            passportErr : "Passport num. must be 9 characters.",
            jmbgErr : "JMBG must be 13 characters.",
            selectPackage : "Select at least one package",
            requiredPerson : "At least one person has to be insured",
            homeUrl : "Return to homepage of ChuckNorris insruance",
            bankUrl : "Return to bank to change data of card",
            successfulPayment : "Successful payment",
            errorPayment : "Error has occurred",
            failedPayment : "Payment failed",
            durationMust : "Duration must be at least 1 day",
            specLength : "Characters length must be ",
            minLength : "Min characters is ",
            maxLength : "Max characters is ",
            invalidEmail : "This is not a valid email",
            requiredFieldPackage : "Field required or uncheck package",
            requiredOption : "Option required",
            requiredField : "Field required",
            requiredFields : "Fill up all required fields for person",
            cn : "Chuck Norris Insurance",
            eng : "English (En)",
            srb : "Serbian (Sr)",
            language : "Language",
            home : "Home",
            buyInsurance : "Buy insurance",
            about : "About us",
            sumToInsure : "Sum to insure:",
            selectAge : "-Select age-",
            selectDestination: "-Select destination-",
            region : "Region:",
            ageInsuranceCarrier : "Insurance carrier age:",
            numberOfInsurancedPersons : "Number of insuranced persons:",
            to18 : "to 18",
            over60 : "over 60",
            age_replacement : '{{name}}',
            durationOfInsurance : "Duration of insurance:",
            from : "From:",
            to : "To:",
            selectSport : "-Select sport-",
            firsts : "Basic info",
            seconds : "Packages",
            thirds : "Price",
            fourths : "Persons info",
            fifths : "Confirmation",
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
            selectNumberOfDays : "-Select days-",
            alternativeRide : "Alternative ride:",
            selectRide : "-Select ride-",
            vehicleInformations : "Vehicle informations:",
            registrationNumber: "Registration number:",
            vehicleMake : "Vehcile make:",
            vehicleOwnerFN : "Vehicle owner first name:",
            vehicleOwnerLN : "Vehicle owner last name:",
            vehicleOwnerJMBG : "Vehicle owner JMBG:",
            vehicleType : "Vehicle type:",
            vinNumber : "Vin number:",
            yearOfProduction : "Year of production:",
            homeInfo : "Home informations:",
            address: "Address",
            homeOwnerFN : "Home owner first name:",
            homeOwnerLN : "Home owner last name:",
            homeOwnerJMBG : "Home owner JMBG:",
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
            passportNumber : "Passport num.",
            phoneNumber : "Phone num.",
            insuranceContractor : "Insurance contractor is:",
            spaic : " a same person as insurance carrier.",
            nspaic : "NOT a same person as insurance carrier.",
            insuranceInformation : "Insurance informations:",
            additionalInsurances : "Additional insurances:",
            to1 : "to",
            cni : "Hello, we are Chuck Norris insurance company.",
            moto : "Our moto is",
            question : "But the question is, are we safe enough?!",
            answer : "Answer is simple... We are NOT.",
            so : "So,",
            buy : "buy",
            rest : "Chuck Norris insurace and travel safe.",
            withangels : "-Travel with angles & Chuck Norris insurance-",




          
        };

        var ser =
        {   
            insuranceCarrire : "Podaci o nosiocu osiguranja",
            mustBe : "Mora biti ",
            passportErrShort : "Br. pasoša tačno ",
            jmbgErrShort : "JMBG mora biti ",
            passportErr : "Pasoš mora da ima 9 karaktera.",
            jmbgErr : "JMBG mora da bude 13 karaktera.",
            selectPackage : "Odaberite bar jedan paket",
            requiredPerson : "Barem jedna osoba mora biti osigurana",
            homeUrl : "Vratite se na početak stranice Chuck Norris osiguranja",
            bankUrl : "Vratite se na banku da promenite podatke o kartici",
            successfulPayment : "Uspešno plaćanje",
            errorPayment : "Dogodila se greška",
            failedPayment : "Neuspešno plaćanje",
            durationMust :"Razlika datuma mora biti barem 1 dan",
            specLength : "Broj karaktera mora biti ",
            minLength : "Najmanja dužina je ",
            maxLength : "Najveća dužina je ",
            invalidEmail : "Email nije validan",
            requiredFieldPackage : "Obavezno polje ili odstiklirati paket",
            requiredOption : "Obavezna opcija",
            requiredField : "Obavezno polje",
            requiredFields : "Popunite sva obavezna polja za osobu",
            cn : "Chuck Norris osiguranje",
            eng : "Engleski (En)",
            srb : "Srpski (Sr)",
            language : "Jezik",
            home : "Početna",
            buyInsurance : "Kupi osiguranje",
            about : "O nama",
            selectDestination: "-Odaberite destinaciju-",
            selectAge : "-Odaberite godine-",
            region : "Region",
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
            firsts : "Osnovni podaci",
            seconds : "Paketi",
            thirds : "Cena",
            fourths : "Podaci osoba",
            fifths : "Potvrda",
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
            passportNumber : "Br. pasoša",
            phoneNumber : "Br. telefona",
            insuranceContractor : "Ugovarač osiguranja je:",
            spaic : "nosilac osiguranja.",
            nspaic : "druga osoba koja nije nosilac osiguranja.",
            insuranceInformation : "Informacije o osiguranju",
            additionalInsurances : "Dodatna osiguranja",
            to1 : "do",        
            cni : "Mi smo Chuck Norris osiguravajuća kompanija.",
            moto : "Naš moto je",
            question : "Ali pitanje je, da li smo dovoljno bezbedni?!",
            answer : "Odgovor je jednostavan... NISMO.",
            so : "Zato,",
            buy : "kupite",
            rest : "Chuck Norris osiguranje i putujte bezbedno.",
            withangels : "-Putujte sa anđelima & Chuck Norris osiguranjem-",
            
        };


    $translateProvider
		.translations('English', eng)
		.translations('Serbian', ser)
    .preferredLanguage('English');

    
    $translateProvider.useSanitizeValueStrategy('escaped');

  }

  function run($rootScope, $state, localStorageService, $translate) {

    $translate.use(localStorageService.cookie.get('language'));

    /* $scope.$watch('vm.proba', function(newVal){
      console.log("newVal:");
      console.log(newVal);
        localStorageService.cookie.set('proba', newVal);
        console.log('U WATCH: ');
        console.log(localStorageService.cookie.get('proba'));
      });
*/

   

  }

}());