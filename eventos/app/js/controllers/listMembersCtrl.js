'use strict';

app.controller('listMembersCtrl', ['$scope','loginService','generalServices', function($scope,loginService,generalServices){
	$scope.txt='/Inicio/Listar Membros';
	loginService.setMenus($scope);
	generalServices.listMembersLoadMembers($scope);
	$scope.logout=function(){
		loginService.logout();
	}//,	
	//$scope.loadingMembers=function(){
	//	var sessionto = "{\"codIgreja\":\""+sessionService.get('codigreja')+"\"}";
	//	var $retPessoas=$http.post('http://localhost:8080/eventoscwb-war/rest/pessoa/all',sessionto); //send data to backend java
	//	$retPessoas.then(function(msg){
//			var lstPessoas=msg.data;/
//			scope.pessoas = lstPessoas;
//		});
	//}

}])