(function (ng) {
    'use strict';
    var module = ng.module('lrInfiniteScroll', []);

    module.directive('lrInfiniteScroll', ['$timeout', function (timeout) {
        return{
            link: function (scope, element, attr) {
                var
                    lengthThreshold = attr.scrollThreshold || 50,
                    timeThreshold = attr.timeThreshold || 400,
                    handler = scope.$eval(attr.lrInfiniteScroll),
                    promise = null,
                    lastScrolled = -9999;

                lengthThreshold = parseInt(lengthThreshold, 10);
                timeThreshold = parseInt(timeThreshold, 10);

                if (!handler || !ng.isFunction(handler)) {
                    handler = ng.noop;
                }

                element.bind('scroll', function () {

                    var scrolled = element[0].scrollTop;
                    //if we have reached the threshold and we scroll up
                    if (scrolled < lengthThreshold && (scrolled - lastScrolled) < 0) {
                        //if there is already a timer running which has no expired yet we have to cancel it and restart the timer
                        if (promise !== null) {
                            timeout.cancel(promise);
                        }
                        promise = timeout(function () {
                            handler();
                            //scroll a bit againg
                            element[0].scrollTop=element[0].clientHeight/2;
                            promise = null;
                        }, timeThreshold);
                    }
                    lastScrolled = scrolled;
                });


                //scroll first to the bottom (with a delay so the elements are rendered)
                timeout(function(){
                    element[0].scrollTop=element[0].clientHeight;
                },0);
            }

        };
    }]);
})(angular);