(function() {
	'use strict';

	angular
		.module('merchantApp')
		.controller('NavigationCtrl', NavigationCtrl);

	NavigationCtrl.$inject = ['$scope', '$translate'];
	function NavigationCtrl($scope, $translate) {
		var vm = this;

		vm.changeCurrentLanguage = function(key){
            $translate.use(key);
            console.log("Poziva metod");
        };

	}
})();