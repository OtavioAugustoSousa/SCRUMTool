(function(angular) {
	'use strict';
	// EstruturaBase para um controller
	function factoryProjeto($http) {
		var baseUrl="https://service-scrumtool.herokuapp.com/projetos"
		function salvar(objeto) {
			return $http.post(baseUrl,objeto);
		};
		
		function update(objeto) {
			return $http.put(baseUrl,objeto);
		};
		
		function remover(id) {
			return $http.delete(baseUrl+"/"+id);
		};
		
		function listar(){
			$http.get(baseUrl).then(function(sucesso){
			}, function(error){});
		};
		
		return {
			salvar : salvar,
			listar: listar,
			update: update,
			remover: remover
		}
	}

	angular.module('app').factory('factoryProjeto', factoryProjeto);
	factoryProjeto.$inject = [ '$http' ];
})(window.angular);