'use strict';
app.factory('loginService',function($http, $location, sessionService){
	return{
		login:function(data,scope){
			var $promise=$http.post('http://localhost:8080/eventoscwb-war/rest/login/auth',data); //send data to backend java
			$promise.then(function(msg){
				var uid=msg.data;
				if(uid.uid){
					//scope.msgtxt='Correct information';
					sessionService.set('uid',uid.uid);
					sessionService.set('role',uid.role);
					sessionService.set('uname',uid.nomeCompleto);
					sessionService.set('username',uid.username);
					sessionService.set('codigreja',uid.codIgreja);
					$location.path('/home');
				}	       
				else  {
					scope.msgtxt='Login e senha desconhecidos!';
					$location.path('/login');
				}				   
			});
		},
		logout:function(){
			sessionService.destroy('uid');
			sessionService.destroy('uname');
			sessionService.destroy('role');
			sessionService.destroy('username');
			sessionService.destroy('codigreja');
			$location.path('/login');
		},
		islogged:function(){
			var $checkSessionServer=false;
			if (sessionService.get('uid')) {
				$checkSessionServer=true;
			};
			return $checkSessionServer;
		},
		loadSessionId:function(){
			return sessionService.get('uid');
		},
		loadSessionRole:function(){
			return sessionService.get('role');
		},
		loadSessionName:function(){
			return sessionService.get('uname');
		},
		loadSessionUserName:function(){
			return sessionService.get('username');
		},
		loadSessionCodIgreja:function(){
			return sessionService.get('codigreja');
		},
		setMenus:function(scope){
			var sessionto = "{\"role\":\""+sessionService.get('role')+"\",\"sistema\":\"eventos\"}";
			var $retMenu=$http.post('http://localhost:8080/eventoscwb-war/rest/menu/loadmenu',sessionto); //send data to backend java
			$retMenu.then(function(msg){
				var lstMenu=msg.data;
				scope.menus = lstMenu;
				scope.usuario = sessionService.get('uname');
			});
		}
	}

});


