angular.module('demo', [])
.controller('hello', function($scope, $http) {
    $http.get('http://localhost:4567/hello').
        then(function(response) {
            $scope.greeting = response.data;
        });
});