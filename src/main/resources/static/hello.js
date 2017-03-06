var app = angular.module('myproj', []);



app.controller('showproj', function($scope, $http) {
    $http.get('http://localhost:4567/hello').
        then(function(response) {
            $scope.greeting = response.data;
        });
});


app.controller('showctrl', function($scope) {
    $scope.showMe = false;
    $scope.myFunc = function() {
        $scope.showMe = !$scope.showMe;
    }
});


app.controller('refresh_control',function($scope,$interval){
var c=0;
$scope.message="This DIV is refreshed "+c+" time.";
$interval(function(){
$scope.message="This DIV is refreshed "+c+" time.";
c++;
},1000);
});