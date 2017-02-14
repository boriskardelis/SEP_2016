describe("NavigationCtrl",function(){
	var NavigationCtrl,scope,$state,$translate;
	var spec = this;
	beforeEach(module('merchantApp'));


	// Create controller
	beforeEach(inject(function($rootScope,$controller,Mock) {
		$state = Mock.$stateMock();
		$translate = Mock.$translateMock();
		scope = $rootScope.$new();
		navCtrl = $controller("NavigationCtrl", {
			
			$scope:scope,
			$state:$state,
			$translate:$translate
		});
	}));
	
	
	it(' should be able to change language',inject(function(){
		
		expect($translate.use()).toEqual('English');
		navCtrl.changeCurrentLanguage('Serbian');
		expect($translate.use()).toEqual('Serbian');
	
		
	}));
	
	
	
	
	
});