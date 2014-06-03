var upeu = (function($) {

	var inicio = function() {
		console.log("me cargue", "yupiii");
	};

	$(document).on("ready", inicio);

	return {
		cargarUrl : function(url) {
			var xhr = $.get(url);
			xhr.done(function(data) {
				$("#contenido").html(data);
			});
		}
	};

})(jQuery);