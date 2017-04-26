var MainController = angular.module("MainController", []);

MainController.controller("MainController", function($scope, $mdDialog, $mdSidenav){


    $scope.user = {
        username: localStorage.getItem("username"),
        id: localStorage.getItem("id"),
        role: localStorage.getItem("role")
    }  


    $scope.showLogin = function()
    {
        $mdDialog.show({
            controller: "AuthController",
            templateUrl: "../views/login.html",
            clickOutsideToClose: true
        })
    }

    $scope.openSideNav = function()
    {
        $mdSidenav("left").toggle();
    }

    $scope.hideSidenav = function()
    {
        $mdSidenav("left").toggle();
    }

    $scope.studentSidenavOptions = [

        ["Show Games", "games"],
        ["Show Courses", "courses"],
        ["Logout", "logout"]

    ]
    $scope.teacherSidenavOptions = [

        ["Create Game" , "createGame"],
        ["Create Course", "createCourse"],
        ["Show Games", "games"],
        ["Show Courses", "courses"],
        ["Logout", "logout"]

    ]



});