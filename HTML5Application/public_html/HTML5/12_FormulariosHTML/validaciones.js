function validarForma(forma){
    //Validar Usuario
    var usuario = forma.usuario;
    if(usuario.value == "" || usuario.value == "Escribir Usuario"){
        alert("Debe proporcionar un nombre de usuario Valido");
        usuario.focus();
        usuario.select();
        return false;
    }

    //validar Password
    var password = forma.password;
    if(password.value == "" || password.value.length< 3 ){
        alert("Debe proporcionar password Valido");
        password.focus();
        password.select();
        return false;
    }

    //Validar Tecnologia
    var tecnologia = forma.tecnologia;
    var checkSeleccionadoo = false;
    for(i=0;i< tecnologia.length;i++){
        if(tecnologia[i].checked){
            checkSeleccionadoo = true;
        }
    }
    if(!checkSeleccionadoo){
        alert("Debe Proporcionar una Tecnologia");
        return false;
    }

    //Validar generos
    var generos = forma.genero;
    var radioSeleccionado = false;
    for(i=0;i< generos.length;i++){
        if(generos[i].checked){
            radioSeleccionado = true;
        }
    }
    if(!radioSeleccionado){
        alert("Debe Proporcionar un Genero");
        return false;
    }

    //Validar ocupacion
    var ocupacion = forma.ocupacion;
    if(ocupacion.value == ""){
        alert("Debe seleccionar una ocupacion");
        return false;
    }


    // document.getElementById("mensajeHtml").innerHTML =  "Formulario Valido, Enviando Datos...";
    setTimeout( function ( ) { alert( "Formulario Valido, Enviando Datos..." ); }, 3000 );
    return true
    // alert("Formulario Valido, Enviando Datos...")



}