var AuthController = angular.module("AuthController", []);

AuthController.controller("AuthController", function($scope, $http, $state, $mdDialog){


    $scope.user = {};
    $scope.newUser = {};


    $scope.logout = function()
    {
       localStorage.clear();
        window.location.reload(); 
        console.log(localStorage.getItem("user"));
    }

    $scope.login = function()
    {
        $http({
            method: "post",
            url: "http://localhost:8080/authenticate/login",
            data: $scope.user
        }).success(function(data){
            console.log(data);
            localStorage.setItem("id", data.id);
            localStorage.setItem("username", data.username);
            localStorage.setItem("role", data.role);
            localStorage.setItem("name", data.name);
            localStorage.setItem("user", JSON.stringify(data));
            $mdDialog.hide();
            window.location.reload(); 

            console.log(localStorage.getItem("user"));

        }).error(function(data){
            console.log("Error");
        })

    }


    $scope.register = function()
    {
        var user =
            {
                name: $scope.newUser.name,
                password: $scope.newUser.password,
                username: $scope.newUser.username,
                role: $scope.newUser.role

            }
        $http({
            method: "post",
            url: "http://localhost:8080/authenticate/register",
            dataType: "json",
            data: $scope.newUser,
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            }
        }).success(function(data){
            console.log();

        }).error(function(data){
            console.log(data);
        })
    }


});