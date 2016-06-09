var app = angular.module('asd', []);
app.controller('Hello', function($scope) {
    $scope.Hello = function ($scope, $http) {
        $http.get("http://localhost:8080/rest/Sample").success(function(data){
            $scope.greeting;
            $scope.greeting = data;
        });
    };
});