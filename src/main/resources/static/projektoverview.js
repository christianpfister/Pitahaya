var app = angular.module('myproj', []);


app.controller('showproj', function($scope, $http,$interval) {
   load_project();
  
   $scope.propertyName = 'idProjekt';
  
   $scope.reverse = false;
   $interval(function(){
	   load_project();
   },10000);
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


app.controller("projektedit", ['$scope', '$http', function($scope, $http) {

 

    $scope.addnewproject = function(){             
            // Writing it to the server

            //              

            var dataObj = {        
                              Projekt_TITLE : $scope.Projekt_TITLE,

                              Projekt_DESC : $scope.Projekt_DESC,
                                              
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
            $scope.Projekt_TITLE='';

            $scope.Projekt_DESC='';
    };
    
    $scope.deleteprojekt = function(test){             
        // Writing it to the server

        //         
   
    $scope.test = test;

        var dataObj = {        
                          idProjekt : $scope.test,

                                          
        };      

        var res = $http.post('/deleteProjekt', dataObj);

        res.success(function(data, status, headers, config) {

                 $scope.message = data;

        });

        res.error(function(data, status, headers, config) {

                 alert( "failure message: " + JSON.stringify({data: data}));

        });             

        // Making the fields empty

        //          
      
};
    

}]);


app.controller('showctrl', function($scope) {
    $scope.showMe = false;
    $scope.myFunc = function() {
        $scope.showMe = !$scope.showMe;
    }
});

