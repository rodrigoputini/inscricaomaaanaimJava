'use strict';

app.controller('homeCtrl', ['$scope','loginService', function($scope,loginService){
	$scope.txt='/Inicio';
	loginService.setMenus($scope);
	$scope.logout=function(){
		loginService.logout();
	}
}])