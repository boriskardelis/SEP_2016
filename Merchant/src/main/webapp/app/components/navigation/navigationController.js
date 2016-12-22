(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('NavigationCtrl', NavigationCtrl);

	NavigationCtrl.$inject = ['$scope', '$translate', '$rootScope'];
	function NavigationCtrl($scope, $translate, $rootScope) {
		var vm = this;
		$rootScope.currentLanguage = 'en';

		vm.changeCurrentLanguage = function(key){
            $translate.use(key);
            $rootScope.currentLanguage = key;
            console.log($rootScope.currentLanguage);

            console.log("Poziva metod");
        };

	}
})();