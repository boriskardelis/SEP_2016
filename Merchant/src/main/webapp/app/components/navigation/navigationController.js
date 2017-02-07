(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('NavigationCtrl', NavigationCtrl);

	NavigationCtrl.$inject = ['$scope', '$translate', '$rootScope', 'localStorageService', '$state'];
	function NavigationCtrl($scope, $translate, $rootScope, localStorageService, $state) {
		var vm = this;

		vm.changeCurrentLanguage = function(key){
            $translate.use(key);
            localStorageService.cookie.set('language', key);
            $state.reload();
            console.log($translate.use());
            console.log("Poziva metod");
        };

	}
})();