'use strict';

var sapocApp = angular.module('sapocApp', [ 'ngRoute' ]);

sapocApp.config(['$routeProvider', function ($routeProvider) {
	
	$routeProvider.when('/', {
		templateUrl : 'views/login.jsp',
		controller : 'LoginController',
		controllerAs : 'vm'
	}).when('/home', {
		templateUrl : 'views/home.jsp',
		controller : 'HomeController',
		controllerAs : 'vm'
	}).otherwise({
		redirectTo : '/'
	});
}]);

