var app = angular.module('myproj', []);


app.controller('showproj', function($scope, $http,$interval) {
   load_project();
  
   $scope.propertyName = 'idProjekt';
  
   $scope.reverse = false;
   $interval(function(){
	   load_project();
   },100000);
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


app.controller("newproject", ['$scope', '$http', function($scope, $http) {

 

    $scope.addnewproject = function(){             

           $scope.message ="schade";

            // Writing it to the server

            //              

            var dataObj = {

                              idProjekt : $scope.idProjekt,

                              Projekt_TITLE : $scope.Projekt_TITLE,

                              Projekt_DESC : $scope.Projekt_DESC,
                              
                              idProjektstatus : $scope.idProjektstatus,
                              
                              Projektstatus_DESC : $scope.Projektstatus_DESC
                              

            };      

            var res = $http.post('/newprojekt', dataObj);

            res.success(function(data, status, headers, config) {

                     $scope.message = data;

            });

            res.error(function(data, status, headers, config) {

                     alert( "failure message: " + JSON.stringify({data: data}));

            });             

            // Making the fields empty

            //

            $scope.name='';

            $scope.employees='';

            $scope.headoffice='';

    };

}]);


app.controller('showctrl', function($scope) {
    $scope.showMe = false;
    $scope.myFunc = function() {
        $scope.showMe = !$scope.showMe;
    }
});

