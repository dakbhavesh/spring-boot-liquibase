angular.module('mainApp',['lrInfiniteScroll'])
    .controller('LogController',['$scope','$timeout',function($scope, $timeout){

        var id=0;
        var authors=['bob','raymond','elisa'];

        function createRandomMessage(id){
            return {
                id:id,
                author:authors[Math.floor(Math.random()*2)],
                message:'whout whout'
            }
        }

        function loadBunch(n){
            var data=[];
            var i=0, l=n || 20;
            for(i=0;i<l;i++){
                data.push(createRandomMessage(++id));
            }
            return data;
        }

        $scope.messages=[].concat(loadBunch(30));
        $scope.isLoading=false;

        //fake call to the server and insert new nodes at the begining
        $scope.loadOlder=function(){
            $scope.isLoading=true
            $timeout(function(){
                loadBunch(20).map(function(val){
                    $scope.messages.unshift(val);
                })
                $scope.isLoading=false;
            },1000);
        }

    }]);
