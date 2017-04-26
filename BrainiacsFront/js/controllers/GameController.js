var GameController = angular.module("GameController", []);

GameController.controller("GameController", function($scope, $mdDialog, $compile, $rootScope, $http, $state, $stateParams, Game){


    $scope.allCourses;
    $scope.chosenCourse;
    $scope.gamesList;
    $scope.query;
    $scope.queryBy = '$';


    $scope.playedGame = $stateParams.game;



    /**
        Getting information from database.
    **/
    $http({
        method: "post",
        url: "http://localhost:8080/teacher/courses",
        data: localStorage.getItem("user")
    }).success(function(data){
        $scope.courses = data;
    }).error(function(data){
        console.log(data);
    })


    $http({
        method: "get",
        url: "http://localhost:8080/courses",
    }).success(function(data){
        $scope.allCourses = data;
    }).error(function(data){
        console.log(data);
    })

    $http({
        method: "get",
        url: "http://localhost:8080/games",
    }).success(function(data){
        $scope.gamesList = data;
        //console.log($scope.gamesList);
    }).error(function(data){
        console.log(data);
    })
    //.................................................

    $scope.play = function(gameId)
    { 
        var pickedGame = {};
        for(var i = 0; i < $scope.gamesList.length; i++)
        {
            if($scope.gamesList[i].id == gameId)
            {
                pickedGame = $scope.gamesList[i];
                break;
            }
        }

        $state.go("playgame", {game: pickedGame});
    }







    /**
    if(localStorage.getItem("game") != undefined || localStorage.getItem("game") != null || localStorage.getItem("game") != "-1")
    {
        $scope.game = JSON.parse(localStorage.getItem("game"));
        console.log($scope.game);
    }
    else
    {
        $scope.game = {
            questions: [],
            course: null
        }   
    }
    **/

    $scope.question = {answers:[]};
    $scope.answer={};
    $scope.name;
    $scope.description;
    $scope.userAnswers = [];
    $scope.score = localStorage.getItem("score");
 
    $scope.submitAnswers = function()
    {
        var score = 0;
        var correctAnswers = [];

        for(var i = 0; i < $scope.playedGame.questions.length; i++)
        {
            for(var k = 0; k < $scope.playedGame.questions[i].answers.length; k++)
            {
                if($scope.playedGame.questions[i].answers[k].correct == 1)
                {
                    correctAnswers.push($scope.playedGame.questions[i].answers[k].answer);
                }
            }
        }


        for(var i = 0; i < $scope.userAnswers.length; i++)
        {
            if($scope.userAnswers[i] == correctAnswers[i])
            {
                score++;
            }
        }
        $rootScope.score= score;
        localStorage.setItem("score", score);
        $mdDialog.show({
            controller: "GameController",
            templateUrl: "../views/score.html",
            clickOutsideToClose: true
        })

        
    }


    $scope.addQuestion = function()
    {
        $mdDialog.show({
            controller: "GameController",
            templateUrl: "../views/addQuestion.html",
            clickOutsideToClose: true
        })
    }


    $scope.addA = function()
    {
        $scope.question.answers.push($scope.answer);
        $scope.answer = {};
    }

    $scope.addQ = function()
    {   
        Game.addQuestion($scope.question);

        $scope.question = {answers:[]};
        $mdDialog.hide();

    }


    $scope.createGame = function()
    {
        for(var i  = 0; i < $scope.courses.length; i++)
        {
            if($scope.courses[i].name == $scope.game.course)
            {
                var course = {
                    name: $scope.courses[i].name,
                    description: $scope.courses[i].description,
                    id: $scope.courses[i].id,
                }
                Game.setCourse(course);         

            }
        }
        $scope.$apply;
        Game.setName($scope.name);
        Game.getGame.description = $scope.description;

        console.log(Game.getGame());
        $http({
            method: "post",
            url: "http://localhost:8080/games/create",
            data: Game.getGame()
        }).success(function(data){

        }).error(function(data){
            console.log(data);
        })
    }
});





/*var index = 0;
    $scope.answerHTML = function()
    {
        '<div layout="row" ><md-input-container><label>Answer</label><textarea style="width: 300px;"></textarea></md-input-container> <input aria-label="Switch 1" ng-model="'+ 'questions.answers[' + index+ ']' + '" type="radio"name="correct"> Correct </input> </div>'
        index++;
    }
    $scope.addChoice = function()
    {
        var element = angular.element(document.querySelector("#answers"));
        element.append($scope.answerHTML);
        $compile(element)($scope);
    }
*/