(function() {
	"use strict";

	angular.module('merchantApp').service('Mock',
		Mock);

	Mock.$inject = [ '$q' ];
	function Mock($q) {

		return {


			$stateMock : function() {
				return {
					current : 'buy.firstStep',
					go : function(newState) {
						this.current = newState;
					}

				};

			},

			localStorageServiceMock : function() {
				return {

					cookie : {
						count : 0,
						isSupported : true,
						get : function(mock) {

							var obj = this.storage[mock];

							if (typeof obj !== 'undefined') {
								return obj;
							} else {
								return 'mock value ' + this.count++;
							}

						},
						storage : {

							
							regionSelected : '',
							sumToSelected : '',
							sportSelected : '',
							insuranceTypeRoadCheck : false,
							insuranceTypeHomeCheck : false,
							towingCheck : false,
							repairsCheck : false,
							accommodationsCheck : false,
							alternativeRidesCheck : false,
							home : []
						},
						set : function(name, value, a, b) {

							this.storage[name] = value;

						},
						remove: function(name){
							delete this.storage[name];
						},
						clearAll: function(){
							this.storage = {};
						}

					}

				}
			},


			$translateMock : function() {
				return {
					current : 'English',
					use : function(key) {
						if (key) {
							this.current = key;
						} else {
							return this.current;
						}

					}

				};

			}


	}

}

})();