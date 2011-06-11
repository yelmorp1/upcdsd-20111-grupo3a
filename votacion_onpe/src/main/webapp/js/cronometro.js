dojo.require("dojo.io.*");
dojo.require("dojo.event.*");
dojo.require("dojo.html.*");

var vContextPath;
function sincronizar(pTipo){
	var params = new Array();	
	params['rnd'] = (Math.random() * 1000000000000);
	params['tipo'] = pTipo;

	var bindArgs = {
		url: vContextPath + "/votacion.do",
		error: function(type, data, evt){/*alert("error");*/},
		mimetype: "text/json",
		content: params
	};

	var req = dojo.io.bind(bindArgs);

	dojo.event.connect(req, "load", this, "procesarRespuesta");
}





var vProceso = null;
function procesarRespuesta(type, data, evt){
	if (!data) {
		vProceso = null;
	} else {
		if(data.timer != "EXPIRADO"){
			document.getElementById("hora").innerHTML = data.timer;
		} else {
			expirarSession();
		}		
	}
}





function iniciarReloj(){
	sincronizar('preguntarHora');
	setTimeout("iniciarReloj()",1000);
}

function expirarSession(){
	with(document.forms[0]){
		action = vContextPath + "/votacion.do";
		tipo.value = "expirarSession";
		submit(); 
	}
}
