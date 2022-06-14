/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

var backend="http://localhost:8080/BackEndDoctores1/api";

function loaded(event){	
       agregarInfoDoc();
  }


function agregarInfoDoc(){
    var doc = JSON.parse(localStorage.getItem('doctor'));
    var div = $('#infoMedico');
    div.html(`<p>Dr. ${doc.nombre}</p>
              <img src='${backend}/doctores/${doc.cedula}/imagen' class="mb-3 rounded" style="height: 60px; width:60px;">`);
}

document.addEventListener("DOMContentLoaded",loaded);
