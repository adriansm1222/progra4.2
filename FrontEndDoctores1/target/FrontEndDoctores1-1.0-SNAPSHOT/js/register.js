var doctores = new Array();
var doc = {cedula:"", clave:"", nombre:"", especialidad:"", costoConsulta:"", localidad:"", duracion:"",horario:[]};
var check = false;
var backend="http://localhost:8080/BackEndDoctores1/api";
var id = "";


function loaded(event){	
    document.getElementById("schedule").addEventListener("click",listen);
    document.getElementById("inlineCheckbox1").addEventListener("change",checkBox);
    document.getElementById("inlineCheckbox2").addEventListener("change",checkBox);
    document.getElementById("inlineCheckbox3").addEventListener("change",checkBox);
    document.getElementById("inlineCheckbox4").addEventListener("change",checkBox);
    document.getElementById("inlineCheckbox5").addEventListener("change",checkBox);
    document.getElementById("save").addEventListener("click",save);
    document.getElementById("register").addEventListener("click",saveDoc);
}

function logIn(){
    
    if(verificaLogin){
             const request = new Request(backend+'/doctores', {method: 'GET', headers: { }});
    (async ()=>{
        try{
            const response = await fetch(request);
            if (!response.ok) {errorMessage(console.log(response.status));return;} 
            docs = await response.json();           
            var docStor = verificaDoc(docs);
            if (docStor !== null){               
              localStorage.setItem("doctor", JSON.stringify(docStor));                         
            }else{console.log("error");return;}
            
        }
        catch(e){
            errorMessage(NET_ERR,$("#buscarDiv #errorDiv"));
        }         
    })();  
    }else{
         //to do
     }
      
}

function verificaDoc(docs){
    docs.forEach((e)=>{
       
        if($("#username").val === e.id && $("#pass").val === e.clave){
            return e;
        }
        
    });
    
    return null;
}



function verificaLogin(){
    if($("#username").val === "" || $("#pass").val === "" ){
        return false;
    }else{return true;}
   
}


function saveDoc(){
     if(load()){
        const request =new Request(backend+'/doctores/insertarDoc', {method: 'POST', headers: { 'Content-Type': 'application/json'},body: JSON.stringify(doc)});
    (async () =>{
        try{
            const response = await fetch(request);
            if (!response.ok) {console.log(response.status);return;}
            await addImagen();
            limpiar();
            window.location.href="index.html";
        }
        catch (e){
          console.log(response.status);  
        }
        
        
    })(); 
     }else{
         //to do
     }
    
    
}

function limpiar(){
    doc.cedula= "";
    doc.clave = "";
    doc.nombre = "";
    doc.especialidad = "";
    doc.costoConsulta = "";
    doc.localidad = "";
    doc.duracion = "";
    doc.horario = [];
}

function verificaHorario(){
    doc.horario.forEach((e)=>{
        var error = true;
        if(e.mon === true){
            if(e.desde !== "0" &&  e.hasta!=="0" ){
                error=false;
            } else{
                error=true;
                e.mon = false;
            }
        }
        if(e.tue === true){
            if(e.desde !== "0" &&  e.hasta!=="0" ){
                error=false;
            }
            else{
                error=true;
                e.tue = false;
            }
        }
        if(e.wed === true){
            if(e.desde !== "0" &&  e.hasta!=="0" ){
                error=false;
            } else{
                error=true;
                e.wed = false;
            }
        }
        if(e.thu === true){
           if(e.desde !== "0" &&  e.hasta!=="0" ){
                error=false;
            } else{
                error=true;
            }
        }
        if(e.fri === true){
            if(e.desde !== "0" &&  e.hasta!=="0" ){
                error=false;
            } else{
                error=true;
                e.fri = false;
            }
        }
        return true; //para probar 
    });
    
}

function load(){
    
     if(true){
        doc.cedula = $("#address").val();
        doc.clave = $("#password").val();
        doc.nombre = $("#name").val();
        doc.especialidad = $("#especiality").val();
        doc.costoConsulta = $("#fee").val();
        doc.localidad = $("#location").val(); 
        doc.especialidad = $('#duration').val();
        return true;
     }else{
         return false;
     }
}

function save(){
    
    if($("#inlineCheckbox1").is(':checked')){
        var dia = {dia:"",desde:"", hasta:""};
        dia.dia = "Lunes";
        dia.desde=document.getElementById("selectMondayD").value+":00";
        dia.hasta=document.getElementById("selectMondayH").value+":00";
        doc.horario.push(dia);
    }
    if($("#inlineCheckbox2").is(':checked')){
        var dia = {dia:"",desde:"", hasta:""};
        dia.dia = "Martes";
        dia.desde=document.getElementById("selectTuesdayD").value+":00";
        dia.hasta=document.getElementById("selectTuesdayH").value+":00";
        doc.horario.push(dia);
    }
    if($("#inlineCheckbox3").is(':checked')){
        var dia = {dia:"",desde:"", hasta:""};
        dia.dia = "Miercoles";
        dia.desde=document.getElementById("selectWednesdayD").value+":00";
        dia.hasta=document.getElementById("selectWednesdayH").value+":00";
        doc.horario.push(dia);  
    }
    if($("#inlineCheckbox4").is(':checked')){
        var dia = {dia:"",desde:"", hasta:""};
        dia.dia = "Jueves";
        dia.desde=document.getElementById("selectThursdayD").value+":00";
        dia.hasta=document.getElementById("selectThursdayH").value+":00";
        doc.horario.push(dia);  
    }
    if($("#inlineCheckbox5").is(':checked')){   
        var dia = {dia:"",desde:"", hasta:""};
        dia.dia = "Viernes";
        dia.desde=document.getElementById("selectFridayD").value+":00";
        dia.hasta=document.getElementById("selectFridayH").value+":00";
        doc.horario.push(dia);
    }
    $("#add-modal").modal('hide');
}

function listen(){
   $('#add-modal').modal('show');     
}

function checkBox(){
     if (this.checked) {      
        $("#"+this.attributes.item(2).value+"D").removeClass("invisible");
        
  } else {
        $("#"+this.attributes[2].value+"D").addClass("invisible");
  }
}

async function addImagen(){
    var imagenData = new FormData();
    imagenData.append("cedula", doc.cedula);
    imagenData.append("imagen", $("#imagen").get(0).files[0]); 
    let request = new Request(backend+'/doctores/'+doc.cedula+'/imagen', {method: 'POST',body: imagenData});
    const response = await fetch(request);     
    if (!response.ok) {
        console.log('leo puto');
    }              
}

document.addEventListener("DOMContentLoaded",loaded);



