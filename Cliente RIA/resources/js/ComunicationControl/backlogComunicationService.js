(function(angular) {
	'use strict';
	// EstruturaBase para um controller
	function factoryBacklog($http) {
		var baseUrl="https://service-scrumtool.herokuapp.com/backlogs"
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
			return $http.get(baseUrl);
		};

		function eventSource(){
			if(typeof(EventSource) !== "undefined") {
				var source = new EventSource("https://service-scrumtool.herokuapp.com/backlogs/stream");
				return source;
			}
		}
		
		
		return {
			salvar : salvar,
			listar: listar,
			update: update,
			remover: remover,
			eventSource: eventSource
		}
	}

	angular.module('app').factory('factoryBacklog', factoryBacklog);
	factoryBacklog.$inject = [ '$http' ];
})(window.angular);