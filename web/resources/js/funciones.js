function cerraSesion(opcion) {
    document.getElementById('formCerrarSesion').opcion.value = opcion;
    document.getElementById('formCerrarSesion').submit();
}

function defineOpcion(opcion) {
    document.getElementById('menu').opcion.value = opcion;
    document.getElementById('menu').submit();
}

//Funcion para llamar al formulario de cotizacion
function realizarCotizacion(opcion) {
    var idSolicitud = $('#formSolicitudes').find('[name=idDetalleActual]').val();
    if (idSolicitud === "") {
        alert('Debe seleccionar una solicitud para realizar la cotización. ');
    } else {

        //Se asignan los valores correspondientes a las propiedades de formulario y se hace submit a este 
        $('#formSolicitudes').find('[name=id]').val(idSolicitud);
        $('#formSolicitudes').find('[name=opcion]').val(opcion);
        $('#formSolicitudes').submit();
    }
}

function insertarPedido(controlador, opcion) {
    var id = document.getElementById().idDetalleActual.value;
    $.post(controlador, {
        opcion: opcion,
        id: id
    }, function(responseText) {
        $('#inline3').html(responseText);
    });

    $(".fancybox").fancybox();
}

function responder(controlador, opcion) {
    var id = document.getElementById('formSolicitudes').idDetalleActual.value;
    if (id === "") {
        alert("Debe seleccionar un elemento para responder la solicitud");
    } else {
        $(document).ready(function() {
            $(".fancybox").fancybox();
        });

        $.post(controlador, {
            id: id,
            opcion: opcion
        }, function(responseText) {
            $('#inline3').html(responseText);
        });

    }
}

function buscar(controlador, opcion) {
    alert(controlador + opcion);
    $.post(controlador, {
        opcion: opcion,
        txtNombre: nombre
    }, function(responseText) {
        $('.contenedorIz').html(responseText);
    });
}

function traerLista(controlador, opcion) {
    $.post(controlador, {
        opcion: opcion
    }, function(responseText) {
        $('.contenedorLista').html(responseText);
    });
}


function insertar(controlador, opcion) {
    $(document).ready(function() {
        $(".fancybox").fancybox();
    });

    $.post(controlador, {
        opcion: opcion
    }, function(responseText) {
        $('#inline1').html(responseText);

    });

    $.fancybox.close();
}

function insertarPaquete(controlador, opcion) {
    $(document).ready(function() {
        $(".fancybox").fancybox();
    });

    $.post(controlador, {
        opcion: opcion
    }, function(responseText) {
        $('#inline3').html(responseText);

    });

    $.fancybox.close();
}

function actualizar(controlador, opcion, formulario) {
    var id = document.getElementById(formulario).idDetalleActual.value;
    if (id === "") {
        alert("Debe seleccionar un elemento para actualizar");
    } else {
        $(document).ready(function() {
            $(".fancybox").fancybox();
        });

        $.post(controlador, {
            id: id,
            opcion: opcion
        }, function(responseText) {
            $('#inline2').html(responseText);
        });
    }
}

function actualizarPaquete(controlador, opcion, formulario) {
    var id = document.getElementById(formulario).idDetalleActual.value;
    if (id === "") {
        alert("Debe seleccionar un elemento para actualizar");
    } else {
        $(document).ready(function() {
            $(".fancybox").fancybox();
        });

        $.post(controlador, {
            id: id,
            opcion: opcion
        }, function(responseText) {
            $('#inline3').html(responseText);
        });
    }

}

function cierra()
{
    parent.jQuery.fancybox.close();
    return false;
}

function pedido(controlador, opcion, formulario) {
    var id = document.getElementById(formulario).idDetalleActual.value;
    if (id === "") {
        alert("Debe seleccionar un elemento para actualizar");
    } else {
        $(document).ready(function() {
            $(".fancybox").fancybox();
        });

        $.post(controlador, {
            id: id,
            opcion: opcion
        }, function(responseText) {
            $('#inline2').html(responseText);
        });
    }
}

function cargarDivision(controlador, opcion, division) {
    $.post(controlador, {
        opcion: opcion
    }, function(responseText) {
        $(division).html(responseText);
    });

    $('.fancybox').fancybox();
}

function eliminar(opcion, formulario, controlador) {
    var idActual = document.getElementById(formulario).idDetalleActual.value;
    // var nombre = document.getElementById(formulario).nom.value;
    //alert(nombre);
    //alert("opcion "+opcion + " formulario "+formulario + " controlador "+controlador + " idActual "+idActual);
    if (idActual === "") {
        new Messi("Debe seleccionar un elemento para eliminar", {title: 'Mensaje', titleClass: 'info', buttons: [{id: 0, label: 'Aceptar', val: 'X'}]});
    } else if (confirm("¿Esta seguro de borrar al id " + idActual + "?")) {
        document.getElementById(formulario).id.value = idActual;

        var datos = {
            'opcion': opcion,
            'id': idActual
        };

        realizarPeticion(datos, controlador);
    }
}

function eliminaFormaNormal(opcion, formulario, controlador) {
    var idActual = document.getElementById(formulario).idDetalleActual.value;
    //alert("opcion "+opcion + " formulario "+formulario + " controlador "+controlador + " idActual "+idActual);
    if (idActual === "") {
        new Messi("Debe seleccionar un elemento para eliminar", {title: 'Mensaje', titleClass: 'info', buttons: [{id: 0, label: 'Aceptar', val: 'X'}]});
    } else if (confirm("¿Esta seguro de borrar al id " + idActual + "?")) {
        document.getElementById(formulario).opcion.value = opcion;
        document.getElementById(formulario).id.value = idActual;
        document.getElementById(formulario).submit();
    }
}


//Metodo para cargar el detalle de cualquier registro
function cargaDetalle(controlador, id, opcion, formulario, objeto) {
    $.post(controlador, {
        id: id,
        opcion: opcion
    }, function(responseText) {
        $('#infoDerecho').html(responseText);
    });

    //Modificar el estilo 
    if (objeto.attr('class') === "elementoNoVisto") {
        objeto.removeClass("elementoNoVisto").addClass("elemento2");
        //Se actualiza campo visto
        realiza_proceso(controlador, {
            opcion: 13,
            id: id
        }, function(respuesta) {
            if (respuesta === false) {
                alert('Ocurrio un error al actualizar la solicitud. ');
            }
        });
    } else {
        objeto.removeClass("elemento").addClass("elemento2");
    }

    objeto.siblings("li.elemento2").removeClass("elemento2").addClass("elemento");

    //asignar el valor del id a un campo oculto 
    document.getElementById(formulario).idDetalleActual.value = id;
}

function cargaDetallePaquete(controlador, tipo, opcion) {
    $.post(controlador, {
        tipo: tipo,
        opcion: opcion
    }, function(responseText) {
        $('#contenido').html(responseText);
    });
}

function cargaCategoria(controlador, tipo, opcion) {
    $.post(controlador, {
        tipo: tipo,
        opcion: opcion
    }, function(responseText) {
        var divLista = $('#imagenes').html('');
        
        $.each(responseText, function(i, item) {
            var div = '<img src="archivos/imagenesProductos/' + item.foto + '"  width="220" height="220"/ ><br/><input type="text" id="valores5" value="' + item.precioUnidad + '" size="4" readonly>';
       
            divLista.append(div);
        });

        $('#imagenes').html(responseText);
    });
}



function eliminarProveedor(opcion, formulario) {
    var idActual = document.getElementById(formulario).idDetalleActual.value;
    if (idActual === "") {
        alert("Debe seleccionar un proveedor para eliminar");
    } else if (confirm("¿Esta seguro de borrar este proveedor? ")) {
        document.getElementById(formulario).opcion.value = opcion;
        document.getElementById(formulario).id.value = idActual;
        document.getElementById(formulario).submit();
    }
}

function reporte(controlador, opcion) {
    $.post(controlador, {
        opcion: opcion
    }, function(responseText) {
        $('#inline2').html(responseText);
    });

    $(".fancybox").fancybox();
}


function traerLista(controlador, opcion) {
    $.post(controlador, {
        opcion: opcion
    }, function(responseText) {
        $('.contenedorLista').html(responseText);
    });
}

function actualizarEstado(controlador, opcion, formulario, estado) {
    var id = document.getElementById(formulario).idDetalleActual.value;
    if (id === "") {
        alert("Debe seleccionar un elemento para actualizar el estado");
    } else {
        $.post(controlador, {
            opcion: opcion,
            id: id,
            estado: estado
        });
        if (estado === 2) {
            new Messi('evento actualizado a abonado', {title: 'Mensaje', titleClass: 'info', buttons: [{id: 0, label: 'Aceptar', val: 'X'}]});
        } else if (estado === 3) {
            new Messi('evento actualizado a cancelado', {title: 'Mensaje', titleClass: 'info', buttons: [{id: 0, label: 'Aceptar', val: 'X'}]});
        } else if (estado === 4) {
            new Messi('evento actualizado a finalizado', {title: 'Mensaje', titleClass: 'info', buttons: [{id: 0, label: 'Aceptar', val: 'X'}]});
        }
    }
}



