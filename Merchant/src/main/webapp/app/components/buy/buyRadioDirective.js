

(function() {
    'use strict';
    
    angular
        .module('merchantApp')
        .directive('radioTrackBy', radioTrackBy);

    function radioTrackBy() {
        return {
                restrict: "A",
                scope: {
                    ngModel: "=",
                    ngValue: "=",
                    radioTrackBy: "@"
                },
                link: function (ng) {
                    /*console.log("IZ DIREKTIVE RADIO");
                    console.log(ng.ngValue);
                    console.log(ng.radioTrackBy);
                    console.log(ng.ngModel);*/

                    if (ng.ngModel !== null) {
                            //mapiram
                        if (ng.ngValue[ng.radioTrackBy] === ng.ngModel[ng.radioTrackBy]) {                                
                            ng.ngModel = ng.ngValue;
                        }
                    }
                }
            };

      }
})();