function eliminar(id) {
	swal({
		title: "Realmente desea eliminar registro",
		text: "Si elimina el registro no se podran recuperar los datos",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url: "/eliminar/" + id,
					success: function(res) {
						console.log(res)
					},
				});
				swal("Elimino el registro correctamente", {
					icon: "success",
				}).then((ok) => {
					 if (ok) {
						 location.href = "/listar"; } })
			} else {
				swal("No se guardo ningun camnbio");
			}
		});
}