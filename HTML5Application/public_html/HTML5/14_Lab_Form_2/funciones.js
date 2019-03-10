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

    var email = forma.email;
    return ValidateEmail(email)

    // document.getElementById("mensajeHtml").innerHTML =  "Formulario Valido, Enviando Datos...";
    setTimeout( function ( ) { alert( "Formulario Valido, Enviando Datos..." ); }, 3000 );
    return true
    // alert("Formulario Valido, Enviando Datos...")
    
}



function ValidateEmail(mail) 
{
    console.log(mail);
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(mail.value.match(mailformat))
    {
        alert("Todo bien");
        return true;
    }
    else
    {
    alert("You have entered an invalid email address!");
    return false;
    }
}