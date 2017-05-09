'use strict';

var sapocApp = angular.module('sapocApp', [ 'ngRoute' ]);

sapocApp.config(['$routeProvider', function ($routeProvider) {
	
	alert("Inside the ROuter......");
	
	$routeProvider.when('/', {
		templateUrl : 'app/views/login.jsp',
		controller : 'LoginController',
	}).when('/home', {
		templateUrl : 'app/views/home.jsp',
		controller : 'HomeController',
	}).otherwise({
		redirectTo : '/'
	});
}]);

//sapocApp.controller('LoginController', function($scope, $http, $location) {
//	alert("Inside LoginController ... 1");
//	$scope.users = [], 
//	$scope.vm = {
//		userId : "",
//		password : ""
//	};
//	
//	$scope.login = function() {
//		alert("Request Body :: " + angular.toJson($scope.vm));
//		$http({
//			method : 'POST',
//			url : 'user',
//			data : angular.toJson($scope.vm),
//			headers : {
//				'Content-Type' : 'application/json'
//			}
//		}).then().success(function(data) {
//			$scope.users = data
//			$location.path('/home');
//		});
//	}
//	
//});

sapocApp.controller('HomeController', function($scope, $http, $location) {
	alert("Inside HomeController ... 1");
	$scope.users = [], 
	$scope.users = []

	getUserDetails();

	function getUserDetails() {
		$http({
			method : 'GET',
			url : 'loginusers'
		}).then(function successCallback(response) {
			$scope.users = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}
});