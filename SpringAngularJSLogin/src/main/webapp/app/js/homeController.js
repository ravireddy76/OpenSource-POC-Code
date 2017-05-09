'use strict';

var sapocApp = angular.module('sapocApp');
sapocApp.controller('HomeController', function($scope, $http, $location) {
	alert("Inside HomeController ... 1");
	$scope.users = [], 

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

