	$(document).ready(function(){
      	$(document).bind("contextmenu",function(e){
            	return false;
	      });
	});

	var evento = '0';
	window.onbeforeunload = function() {		
		if(evento != "1"){			
			var vContextPath = document.forms[0].contextPath.value;
			var vURL =  vContextPath + '/votacion.do?rnd=' + (Math.random() * 1000000000000) + '&tipo=terminar';
			
			// This template uses no error checking, it's just concept code to be
			// expanded on.
	
			// Create a new XMLHttpRequest object
			//var AJAX = new XMLHttpRequest();			
			
			if(window.XMLHttpRequest)
				AJAX = new XMLHttpRequest();
			else if (window.ActiveXObject)
				AJAX = new ActiveXObject("Microsoft.XMLHTTP");
	
			// Handle ready state changes ( ignore them until readyState = 4 )
			AJAX.onreadystatechange = function() {if (AJAX.readyState!=4) return false;};
			//AJAX.onreadystatechange = procesarAJAX;
				
			// we're passing false so this is a syncronous request.
			// The script will stall until the document has been loaded.
			// the open statement depends on a global variable titled _userID.
			AJAX.open("GET", vURL, false);
			AJAX.send(null);
		}
	};

	function validatecla(tipo, textbox) {
		var tecla;
		if (navigator.appName.indexOf("Netscape") != -1)
			tecla = event.which;
		else
			tecla = event.keyCode;
		var key = String.fromCharCode(tecla);
		var numeros = "0123456789";
		var letras = "AaBbCcDdEeFfGgHhIiJjKkLlMmNn??OoPpQqRrSsTtUuVvWwXxYyZz??????????,";
		
		/*alert("tecla : " + tecla);
		alert("key : " + key);*/
		   
		if (tipo == 'letras') {
			if (tecla == 32)
				return true;
			if (letras.indexOf(key) != -1)
				return true;
			return false;
		}
	
		if (tipo == 'enteros') {
			if (numeros.indexOf(key) != -1)
				return true;
			else
				return false;
		}
	  
		if (tipo == 'decimales') {
			if (numeros.indexOf(key) != -1 )
				return true;
			var cadena = textbox.value;
			//if (cadena.indexOf(',') != -1 )
			if (cadena.indexOf('.') != -1 )
				return false; 
			//if (tecla == 44) // ","
			if (tecla == 46) // "."
				return true;
			return false; 
		}
		
		if (tipo == "NoNumeros") {
			if (tecla == 32)
				return true;
			if (numeros.indexOf( key ) != -1 )
				return false; 
			return true;
		}
	}
	
	function escribir1(A) {
		if (A.charCodeAt(0) != 160) {
			if (document.getElementById("contrasena").value.length < 13) {
				document.getElementById("contrasena").value = document.getElementById("contrasena").value+A;
				window.status = "";
				focusContinueControl();
				return true;
			}
		}
	}
	function escribir2(A) {
		if (A.charCodeAt(0) != 160) {
			if (document.getElementById("pin").value.length < 16) {
				document.getElementById("pin").value = document.getElementById("pin").value+A;
				window.status = "";
				focusContinueControl();
				return true
			}
		}
	}
	function focusContinueControl() {
		if (document.getElementById("Entrar") != null
				&& !document.getElementById("Entrar").disabled) {
			document.getElementById("Entrar").focus()
		}
	}
	function clearChar1(){
		var B=document.getElementById("contrasena").value;
		var A=document.getElementById("contrasena").value.length;
		document.getElementById("contrasena").value=B.substring(0,A-1);
		focusContinueControl();
	}
	function clearField1(){
		document.getElementById("contrasena").value="";
	}
	function clearCodigoPin(){
		document.getElementById("pin").value="";
	}
	function send(){
		alert("CODIGO PIN: "+document.getElementById("codigoPin").value);
		alert("PASSWORD: "+document.getElementById("Password").value);
	}