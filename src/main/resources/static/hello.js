var app = angular.module('myproj', []);


app.controller('showproj', function($scope, $http,$interval) {
   load_project();
  
   $scope.propertyName = 'idProjekt';
  
   $scope.reverse = false;
   $interval(function(){
	   load_project();
	 
	   
   },5000);
   function load_project(){
	$http.get('http://localhost:4567/projektoverview').
        then(function(response) {
            $scope.projects = response.data;
        });
   };
   
   $scope.sortBy = function (propertyName) {
	    $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
	    $scope.propertyName = propertyName;
	  };


});


app.controller('showctrl', function($scope) {
    $scope.showMe = false;
    $scope.myFunc = function() {
        $scope.showMe = !$scope.showMe;
    }
});

