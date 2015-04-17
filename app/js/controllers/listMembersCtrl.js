'use strict';

app.controller('listMembersCtrl', ['$scope','loginService','generalServices', function($scope,loginService,generalServices){
	$scope.txt='/Inicio/Listar Membros';
	loginService.setMenus($scope);
	generalServices.listMembersLoadMembers($scope);
	generalServices.loadProfissoes($scope);
	generalServices.loadCategorias($scope);
	generalServices.loadIgreja($scope);
	var http = generalServices.getHttp();
	var bycpf = ''+generalServices.getCpf();
	if (bycpf) {
		generalServices.loadMemberByCpf($scope,bycpf);
		generalServices.removeCpf();
	};

	$scope.logout=function(){
		loginService.logout();
	},
	$scope.newMember=function(){
		generalServices.redirect("/newMember");
	},
	$scope.findByCpf = function(member){
		var pessoato = "{\"cpf\":\""+member.cpf+"\",\"codPresbiterio\":\""+loginService.loadSessionCodIgreja()+"\"}";
		return http.post('http://'+generalServices.loadServer()+':8080/eventoscwb-war/rest/pessoa/findbycpf', pessoato).then(function(response){
			$scope.member = response.data;
	  });
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
	},
	$scope.savemember = function(member){
		if(member.status == 'novo'){
			member.codigreja = loginService.loadSessionCodIgreja();
		}
		http.post('http://'+generalServices.loadServer()+':8080/eventoscwb-war/rest/pessoa/savemember', member).then(function(response){
			var msg = response.data;
			alert(msg.mensagem);
			generalServices.redirect("/listMembers");
	  });
	},
	$scope.loadMember = function(cpf){
		generalServices.setCpf(cpf);
		generalServices.redirect("/newMember");
	}
	


	//,	
	//$scope.loadingMembers=function(){
	//	var sessionto = "{\"codIgreja\":\""+sessionService.get('codigreja')+"\"}";
	//	var $retPessoas=$http.post('http://'+generalServices.loadServer()+':8080/eventoscwb-war/rest/pessoa/all',sessionto); //send data to backend java
	//	$retPessoas.then(function(msg){
//			var lstPessoas=msg.data;/
//			scope.pessoas = lstPessoas;
//		});
	//}

}])

