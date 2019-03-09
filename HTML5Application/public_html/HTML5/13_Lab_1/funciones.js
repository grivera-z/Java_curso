var arr = [];

function hola(event){
    if (event.keyCode == 13 || event.which == 13){
        if(document.getElementById("usuario").value=="" || document.getElementById("usuario").value == null){
            alert("Es necesario intruducir algun usuario")
        }else{
            arr.push(document.getElementById("usuario").value);
            var ul = document.getElementById("list");
            var li = document.createElement("li");
            li.appendChild(document.createTextNode(arr[arr.length-1]));
            ul.appendChild(li);
            document.getElementById("usuario").value = '';
            alert("The lenght: "+arr.length);
        }
    }
};


//Variables globales
var usuarios = new Array();
var contadorUsuarios = 0;

function agregarUsuario(entrada) {
    var usuario = entrada.value.trim();
    usuarios[contadorUsuarios++] = usuario;
    //Desplegamos el catálogo actual de usuarios
    mostrarUsuarios();
    //Limpiamos la caja de texto y la seleccionamos
    entrada.value = "";
    entrada.focus();
}

function mostrarUsuarios() {
    limpiar("listado");
    var usuario = null;
    for (i = 0; i < usuarios.length; i++) {
        usuario = usuarios[i];
        var resultado = i + " - " + usuario;
        imprimir(resultado, "listado");
    }
}

function buscarUsuario(entrada) {
    for (i = 0; i <= usuarios.length; i++) {
        if ((usuarios[i] == entrada.value)) {
            document.getElementById("busqueda").innerHTML = "El usuario tiene la posición:" + [i];
            break; //si encuentra el usuario indica la posicion, si no lo encuentra sigue buscando
        }
        else {
            document.getElementById("busqueda").innerHTML = "No se encontró ningún resultado.";
        }
    }
}

function imprimir(valor, campo) {
    var resultado = document.getElementById(campo);
    resultado.innerHTML += valor + " <br/>";
}

function limpiar(campo) {
    document.getElementById(campo).innerHTML = "";
}
