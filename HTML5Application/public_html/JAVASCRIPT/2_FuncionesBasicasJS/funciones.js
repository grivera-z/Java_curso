window.onload = iniciaDatos;
// ⋀ Funcion que se manda llamar al cargar la pagina HTML


function iniciaDatos(){
    document.getElementById("link").onclick = validaSalir;
    document.getElementById("linkSearch").onclick = busqueda;
}

function validaSalir(){
    if(confirm("Desea salir de sitio?")){
        alert("Nos vamos a google");
        return true;
    }else{
        alert("Nos quedamos");
        return false; 
    }
}

function busqueda(){
    // Con la funcion "prompt" capturamos informacion del usuario 
    var respuesta = prompt("Escribe la cadena a buscar:","");
    alert("this: "+this)
    if(respuesta){
        alert("Tu Respuesta fue: "+ respuesta);
        var nuevoLink = this + "search?q=" + respuesta;
        window.location = nuevoLink;
        return false;
    }
    else{
        alert("No Proporcionaste ninguna cadena a buscar");
        return false;
    }
}