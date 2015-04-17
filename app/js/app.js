'use strict';
// Declare app level module which depends on filters, and services
var app= angular.module('eventosApp', ['ngRoute']);
app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login', {templateUrl: 'partials/login.html', controller: 'loginCtrl'});
  $routeProvider.when('/home', {templateUrl: 'partials/home.html', controller: 'homeCtrl'});
  $routeProvider.when('/listMembers', {templateUrl: 'partials/listMembers.html', controller: 'listMembersCtrl'});
  $routeProvider.when('/newMember', {templateUrl: 'partials/newMember.html', controller: 'listMembersCtrl'});
  $routeProvider.when('/listEvents', {templateUrl: 'partials/listEvents.html', controller: 'eventsCtrl'});
  $routeProvider.otherwise({redirectTo: '/login'});
}]);


app.run(function($rootScope, $location, loginService){
	var routespermission=['/home','/listMembers','/newMember','/listEvents'];  //route that require login
	$rootScope.$on('$routeChangeStart', function(){
		if( routespermission.indexOf($location.path()) !=-1)
		{
			var connected=loginService.islogged();
			if (!connected) {
				$location.path('/login');
			};
			
		}
	});
});