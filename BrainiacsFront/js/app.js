var app = angular.module("app", ["ui.router", "ngMaterial", "AuthController", "MainController", "CourseController", "GameController", "GameService"]);

app.config(function($stateProvider, $urlRouterProvider, $mdThemingProvider){
    
    $urlRouterProvider.otherwise("/");

    $mdThemingProvider.theme('default')
        .primaryPalette('blue')
        .accentPalette('pink');

    $stateProvider
        .state('createGame', {
        url: '/games/create',
        templateUrl: 'views/createGame.html',
        controller: 'GameController'
    })
    .state('createCourse', {
        url: "/courses/create",
        templateUrl: "views/createCourse.html",
        controller: "CourseController"
    })
    .state('games', {
        url: "/games/show",
        templateUrl: "views/games.html",
        controller: "GameController"
    })
    .state('courses', {
        url: "/courses/show",
        templateUrl: "views/courses.html",
        controller: "CourseController"
    })
    .state("playgame", {
        url: "/games/play",
        templateUrl: "views/playgame.html",
        controller: "GameController",
        params: {game: {}}
    })
    .state("logout", {
        templateUrl: "views/logout.html",
        controller:"AuthController"
    })
    
    
});