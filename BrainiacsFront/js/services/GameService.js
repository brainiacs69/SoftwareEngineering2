var GameService = angular.module("GameService", []);

GameService.service("Game", function(){
   
    var game =
    {
        questions: new Array(),
        course: null,
        name: null,
        score: 0
    }

    
    return{
        getGame: function()
        {
            return game;
        },
        setGame: function(g)
        {
            game = g;
        },
        addQuestion: function(question)
        {
            game.questions.push(question);
        },
        setCourse: function(c)
        {
            game.course = c;
        },
        setName: function(name)
        {
            game.name = name;
        }
        
    }
    
});