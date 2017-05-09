'use strict';

var LoginController = function($scope, $http) {
	alert("Inside LoginController ... 1");
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
		}).then(getUserDetails(), clearForm()).success(function(data) {
			$scope.users = data
		});
	}
}