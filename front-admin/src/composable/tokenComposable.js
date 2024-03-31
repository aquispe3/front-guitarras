export function registrarToken(token){
    if(token){
        console.log("token: "+token)
        localStorage.setItem('token', JSON.stringify(token).valueOf());
    }
}
export function headerConfig(){
    const token =   localStorage.getItem('token');
    
    let tok = token.slice(1, -1);
    tok.slice(0, tok.length - 1);

    const  headers = {
        "Content-Type": "application/json;charset=UTF-8",
        Authorization: `Bearer ${tok}`
    }
    const configuracion = {
        headers
    };
    return configuracion;
}
export function limpiarToken (){
    localStorage.clear();
}