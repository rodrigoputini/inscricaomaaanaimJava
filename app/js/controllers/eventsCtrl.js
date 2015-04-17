'use strict';

app.controller('eventsCtrl', ['$scope','loginService','generalServices', function($scope,loginService,generalServices){
	$scope.txt='/Inicio/Listar Eventos';
	loginService.setMenus($scope);
	//generalServices.listMembersLoadMembers($scope);
	generalServices.loadIgreja($scope);
	var http = generalServices.getHttp();


	$scope.logout=function(){
		loginService.logout();
	},
	$scope.newEvent=function(){
		generalServices.redirect("/newEvent");
	},
	$scope.findCep = function(member){
		var pessoato = "{\"cep\":\""+member.cep+"\"}";
		return http.post('http://'+generalServices.loadServer()+':8080/eventoscwb-war/rest/endereco/findbycep', pessoato).then(function(response){
		var enderecoto = response.data;
		if (enderecoto) {
	        member.logradouro = enderecoto.logradouro;
	        member.bairro = enderecoto.bairro;
	        member.cidade = enderecoto.cidade;
	        member.estado = enderecoto.estado;
	        member.pais = enderecoto.pais;
	        member.cep = enderecoto.cep;
        };
	  });
	}

}])