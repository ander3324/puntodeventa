setInterval('cerrar()', 3000);
function cerrar() {
	$(".msj-editar").delay(300).slideUp(50, function() {
		$(this).hide();
	});

}