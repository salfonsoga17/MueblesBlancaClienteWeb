//Archivo javascript que permite la conexion con el servlet y realiza las operaciones basicas o CRUD

//Variable que permite la conexion por medio de ajax,para todas las acciones que se ejecuten se 
//debe incluir el número de la opcion en el controlador en el parametro denominado "params" 
var con = {
    ajax: function(params) {
        var data = {
            'url': params.url,
            'type': 'POST',
            'data': (params.data) ? params.data : null,
            'success': params.success,
            'error': con.error,
            'beforeSend': con.beforeSend
        };
        $.ajax(data);

    },
    error: function(error) {
        console.error(error);
    },
    beforeSend: function() {
        
        console.log('Enviando Petición');
    }
};

///Función estandar que se le envia url a conectar, datos a enviar y funcion que ejecuta cuando acaba de 
///realizar la conexion al servidor, util para llamar cualquier metodo de cualquier controlador que responda con un formato javascript
function realiza_proceso(url,datos,f_success){
    if(f_success === undefined){
        f_success = function (){};
    }
    
    con.ajax({
        url:url,
        data:(datos) ? datos : null,
        success:f_success
    });
}


//Función que realiza la petición al servidor dependiendo de la opción 
//y la url que se le envie
function realizarPeticion(datos,url){
    con.ajax({
        'url':url,
        'data':(datos) ? datos : null,
        'success':function (respuesta){
             
            //Muestro el mensaje 
            //new Messi(respuesta, {title: 'Mensaje', titleClass: 'info', buttons: [{id: 0, label: 'Aceptar', val: 'X'}]});
                      
            //Cargo la lista de nuevo con los cambios hechos, este metodo es generico y en 
            //todos los jsp que se use este javascript debe xistir un metodo con este nombre
            //importante que la opción de cargar la lista en todos los controladores sea la 1
            //$('#infoDerecho').html('');
            
            //cargarLista(1,url);
        }
    });
}

function retrasar(){
    window.location.reload();
}

//Funcion para traer las listas desde el servlet
function cargarLista(opcion,url){
    con.ajax({
        'url':url,
        'data':{
            'opcion':opcion
        },
        'success':function (respuesta){
             onCargarLista(respuesta);
        }
    });
}






