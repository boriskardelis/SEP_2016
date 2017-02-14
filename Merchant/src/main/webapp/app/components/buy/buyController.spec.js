describe("BuyCtrl",function(){
	var BuyCtrl,scope,$state,$translate,localStorageService,$httpBackend;
	var spec = this;
	beforeEach(module('merchantApp'));


	// Create controller
	beforeEach(inject(function($rootScope,$controller,Mock,_$httpBackend_) {
		$state = Mock.$stateMock();
		$translate = Mock.$translateMock();
		localStorageService = Mock.localStorageServiceMock();
		scope = $rootScope.$new();
		$httpBackend = _$httpBackend_;
		localStorageService.cookie.set('sumToSelected',"10.000EUR");
		//$httpBackend.when('GET', 'https://localhost:8080/api/risksubcategories').respond({ages:[]});
		//console.log(ages);
		localStorageService.cookie.set('vehicleOwnerJmbg',"130299112986");
		
						
		buyCtrl = $controller("BuyCtrl", {
			
			$scope:scope,
			$state:$state,
			localStorageService:Mock.localStorageServiceMock(),
			$translate:$translate
		});
	}));
	
	
	it(' should be able to  validate,submit form and go to next state',inject(function(){
		
		
		expect(localStorageService.cookie.get('sumToSelected')).toEqual("10.000EUR");
		expect(localStorageService.cookie.get('vehicleOwnerJmbg')).toEqual("130299112986");
		
	}));

	it(' should change state',inject(function(){
		
		expect($state.current).toEqual('buy.firstStep');
		buyCtrl.form = {$invalid:false};
		buyCtrl.ages = ["a", "vb", "fgbg"];
		buyCtrl.calculateFirstStep();
		expect($state.current).toEqual('buy.secondStep');
		console.log("u drugom stanju :D");
		buyCtrl.formSecondRoad = {$invalid:false};
		buyCtrl.formSecondHome = {$invalid:false};
		//localStorageService.cookie.set('ageTyped');
		//buyCtrl.calculateSecondStep();
	
		
		
	}));

	
	
	
	
	
});