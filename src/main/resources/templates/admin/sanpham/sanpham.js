    let url = "/api/product/phantrang";
var app = angular.module("myApp",[]);
app.controller("ctrl", function ($scope,$http,$location){
    $scope.list = [];
    $http.get(url).then(function (response){
       if (response.status === 200){
           $scope.list = response.data.content;
       }
    })
})