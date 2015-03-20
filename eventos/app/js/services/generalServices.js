'use strict';
app.factory('generalServices',function($http, $location, sessionService){
	return{
		listMembersLoadMembers:function(scope){
			var sessionto = "{\"codIgreja\":\""+sessionService.get('codigreja')+"\"}";
		    $http.post('http://localhost:8080/eventoscwb-war/rest/pessoa/all',sessionto)
		    .success(function(response) {scope.membros = response;});
		}
	}

});


