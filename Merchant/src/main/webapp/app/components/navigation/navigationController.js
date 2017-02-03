(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('NavigationCtrl', NavigationCtrl);

	NavigationCtrl.$inject = ['$scope', '$translate', '$rootScope'];
	function NavigationCtrl($scope, $translate, $rootScope) {
		var vm = this;

		vm.changeCurrentLanguage = function(key){
            $translate.use(key);
            console.log($translate.use());
            console.log("Poziva metod");
        };

	}
})();