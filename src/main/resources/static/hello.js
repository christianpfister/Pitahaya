var app = angular.module('myproj', []);



app.controller('showproj', function($scope, $http,$interval) {
   load_project();
   $interval(function(){
	   load_project();
	   
   },5000);
   function load_project(){
	$http.get('http://localhost:4567/hello').
        then(function(response) {
            $scope.projects = response.data;
        });
   };
});


app.controller('showctrl', function($scope) {
    $scope.showMe = false;
    $scope.myFunc = function() {
        $scope.showMe = !$scope.showMe;
    }
});

