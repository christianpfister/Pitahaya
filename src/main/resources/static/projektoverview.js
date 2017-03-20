var app = angular.module('myproj', ["ngRoute"]);

app.config(function($routeProvider) {
	  $routeProvider
	  .when("/", {
	    templateUrl : "projektoverview.html",
		controller : "projektoverview"

		
	  })
	  .when("/red", {
	    template : "<h1>bullshit<h1>"
	  })
	  .when("/green", {
	    templateUrl : ""
	  })
	  .when("/blue", {
	    templateUrl : ""
	  });
	});

//Projektübersicht Controller
app.controller('projektoverview', function($scope, $http, $interval) {
   load_project();
  
   $scope.propertyName = 'idProjekt';
  
   $scope.reverse = false;
   //Interval Funktion um die Projektübersicht zu aktualisieren
   $interval(function(){
	   load_project();
   },50000);
   		//get Projektoverview von Spark
   		function load_project(){

	    $http.get('http://localhost:4567/projektoverview').
	   		then(function(response) {
	   			//Objekt mit Projekten
	   			$scope.projects = response.data;
	   		});
   		};
   
   		$scope.sortBy = function (propertyName) {
	   		$scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
	   		$scope.propertyName = propertyName;
   		};

   		// Writing New Projekt to Spark
	  	$scope.addnewproject = function(){             
	         
	            var dataObj = {        
	                              Projekt_TITLE : $scope.Projekt_TITLE,
	                              Projekt_DESC : $scope.Projekt_DESC,
	                              name: $scope.Nachname,
	                              vorname: $scope.Vorname,
	            };      

	            var res = $http.post('/newprojekt', dataObj);

	            res.success(function(data, status, headers, config) {
	            	 //Objiekt mit Projekten aktualisieren nach Insert
	            	 $scope.projects = data;
	            	 //Erfolgsmeldung
	            	 $scope.message = data;
	            });

	            res.error(function(data, status, headers, config) {
	                     alert( "failure message: " + JSON.stringify({data: data}));
	            });             

	            // Making the fields empty         
	            $scope.Projekt_TITLE='';
	            $scope.Projekt_DESC='';
	            $scope.Nachname='';
	            $scope.Vorname='';
	    };

	    
	    
	    // Projekt löschen mittels ProjektID
	    $scope.deleteprojekt = function(projektid){             

	    	$scope.id = projektid;

	        var dataObj = {        
	                          idProjekt : $scope.id,                                  
	        };      

	        var res = $http.post('/deleteProjekt', dataObj);

	        res.success(function(data, status, headers, config) {
	        	 	//Objiekt mit Projekten aktualisieren nach Delete
	        		$scope.projects = data;  
	        		//Erfolgsmeldung
	        		$scope.message = '';
	        });

	        res.error(function(data, status, headers, config) {
	                 alert( "failure message: " + JSON.stringify({data: data}));
	        });             	      
	    };
});



