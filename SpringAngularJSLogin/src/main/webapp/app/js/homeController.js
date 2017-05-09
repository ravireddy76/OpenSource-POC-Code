'use strict';

var HomeController = function($scope, $http) {
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
}