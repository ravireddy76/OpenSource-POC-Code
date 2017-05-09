'use strict';

var sapocApp = angular.module('sapocApp', [ 'ngRoute' ]);

sapocApp.config(['$routeProvider', function ($routeProvider) {
	
	alert("Inside the Router......");
	
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
