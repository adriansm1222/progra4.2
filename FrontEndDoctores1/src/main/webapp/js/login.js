/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

var backend="http://localhost:8080/BackEndDoctores1/api";

function loaded(event){	
      
       document.getElementById("logIn").addEventListener("click",logIn);

  }
  
  
  function logIn(){
    
    if(verificaLogin){
            var ced = $("#username").val();
            var pas = $("#pass").val();
            var user = {id:ced,clave:pas};
            var doctor;
             const request = new Request(backend+'/doctores/login', {method: 'POST',  headers: { 'Content-Type': 'application/json'},body: JSON.stringify(user)});
    (async ()=>{
        try{
            const response = await fetch(request);
            if (!response.ok) {errorMessage(console.log(response.status));return;} 
            doctor = await response.json();
            
            
            
//            var docStor = verificaDoc(docs);
//            if (docStor !== null){  
//                console.log(docStor);
//                
//              localStorage.setItem('doctor', JSON.stringify(docStor));                         
//            }else{console.log("error");return;}
            
        }
        catch(error){
            alert(error);
        }         
    })();  
    }else{
         //to do
     }
      
}

function verificaDoc(docs){
    var aux = null;
    docs.forEach((e)=>{
       var user = $("#username").val();
       var pas = $("#pass").val(); 
        if( user === e.id && pas === e.pass){
            aux = e;
        }
        
    });
    
    return aux;
}



function verificaLogin(){
    if($("#username").val === "" || $("#pass").val === "" ){
        return false;
    }else{return true;}
   
}
  
  

  document.addEventListener("DOMContentLoaded",loaded);
