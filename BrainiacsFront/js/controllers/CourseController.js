var CourseController = angular.module("CourseController", []);

CourseController.controller("CourseController", function($scope, $http){
    
    $scope.course = { teachers:  [JSON.parse(localStorage.getItem("user"))]};
    
    $scope.courses;
    
    $scope.saveCourse = function()
    {
        
         $http({
            method: "post",
            url: "http://localhost:8080/courses/create",
            data: $scope.course
        }).success(function(data){
            
        }).error(function(data){
            console.log(data);
        })
        
    }
    
    
     $http({
            method: "post",
            url: "http://localhost:8080/courses",
            data: $scope.course
        }).success(function(data){
            $scope.courses = data;
        }).error(function(data){
            console.log(data);
        })
    
});