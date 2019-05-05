function cambiarClave(opcion) {
    $.post('controladorUsuarios', {
        opcion: opcion
    }, function(responseText) {
        $("#contenedorClave").html(responseText);
    });

    $(".fancybox").fancybox({padding: 0, margin: 0});
}

function ayuda(opcion) {
    $.post('controladorUsuarios', {
        opcion: opcion
    }, function(responseText) {
        $("#inline3").html(responseText);
    });

    $(".fancybox").fancybox();
}

function cargarUsuarios(opcion) {
    $.post('controladorUsuarios', {
        opcion: opcion
    }, function(responseText) {
        $("#contenedorUsuarios").html(responseText);
    });

    $(".fancybox").fancybox();
}

function eliminarUsuario(id, opcion, formulario) {
        confirm("¿Esta seguro de borrar al id " + id + "?"); 
        document.getElementById(formulario).opcion.value = opcion;
        document.getElementById(formulario).id.value = id;
        document.getElementById(formulario).submit();    
}



