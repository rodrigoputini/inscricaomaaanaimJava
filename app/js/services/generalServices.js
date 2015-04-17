'use strict';
app.factory('generalServices',function($http, $location, sessionService){
	return{
		listMembersLoadMembers:function(scope){
			var sessionto = "{\"codIgreja\":\""+sessionService.get('codigreja')+"\"}";
		    $http.post('http://10.110.112.120:8080/eventoscwb-war/rest/pessoa/all',sessionto)
		    .success(function(response) {scope.membros = response;});
		},
		loadProfissoes:function(scope){
		    $http.post('http://10.110.112.120:8080/eventoscwb-war/rest/profissao/all')
		    .success(function(response) {scope.profissoes = response;});
		},
		loadCategorias:function(scope){
		    $http.post('http://10.110.112.120:8080/eventoscwb-war/rest/categoriamembro/all')
		    .success(function(response) {scope.categorias = response;});
		},
		loadIgreja:function(scope){
			var sessionto = "{\"codIgreja\":\""+sessionService.get('codigreja')+"\"}";
		    $http.post('http://10.110.112.120:8080/eventoscwb-war/rest/igreja/bycodpes',sessionto)
		    .success(function(response) {scope.igreja = response;});
		},
		loadNotMembers:function(scope, nomePessoa){
		    $http.post('http://10.110.112.120:8080/eventoscwb-war/rest/pessoa/autonotmember',{ "nomePessoa" : nomePessoa})
		    .success(function(response) {scope.nomes = response;});

		},
        loadMemberByCpf:function(scope,cpf){
			var pessoato = "{\"cpf\":\""+cpf+"\",\"codPresbiterio\":\""+sessionService.get('codigreja')+"\"}";
			$http.post('http://10.110.112.120:8080/eventoscwb-war/rest/pessoa/findbycpf', pessoato).then(function(response){
				scope.member = response.data;});
    	}, 
		getHttp:function(){
		    return $http;
		},		
		setMsg:function(msg){
		    sessionService.set('msg',msg);
		},	
		getMsg:function(){
		    return sessionService.get('msg');
		},

		destroyMsg:function(){
		    sessionService.destroy('msg');
		},
		setCpf:function(cpf){
		    sessionService.set('cpf',cpf);
		},	
		getCpf:function(){
		    return sessionService.get('cpf');
		},
		removeCpf:function(){
		    sessionService.destroy('cpf');
		},
		loadServer:function(){
			return '10.110.112.120';
		},
		redirect:function(path){
			$location.path(path);
		}		
	}

});


