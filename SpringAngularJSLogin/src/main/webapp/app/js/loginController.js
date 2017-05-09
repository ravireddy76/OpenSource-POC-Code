'use strict';

var sapocApp = angular.module('sapocApp');
sapocApp.controller('LoginController', function($scope, $http, $location) {
	alert("Inside LoginController ......");
	
	$scope.users = [], 
	$scope.vm = {
		userId : "",
		password : ""
	};
	
	$scope.login = function() {
		alert("Request Body :: " + angular.toJson($scope.vm));
		$http({
			method : 'POST',
			url : 'user',
			data : angular.toJson($scope.vm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			$scope.users = response.data;
			alert("Inside success users length :: "+$scope.users.length);
		    $location.path('/home');
		}, function errorCallback(response) {
			console.log(response.statusText);
			$location.path('/');
		});
	}
});