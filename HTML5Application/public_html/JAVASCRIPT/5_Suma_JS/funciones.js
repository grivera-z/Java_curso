function sumar(){
    try{
        var a = prompt("Valor a:","");
        var b = prompt("Valor b:","");
        if(!a || isNaN(a) || !b || isNaN(b)){
            throw new Error("Valor invalido de a or b: "+ a + " - " + b);
        }
        var c = parseInt(a) + parseInt(b);
        alert("La suma es: "+ c );
    }
    catch (e){
        alert("El error es: "+e.message)
    }
}