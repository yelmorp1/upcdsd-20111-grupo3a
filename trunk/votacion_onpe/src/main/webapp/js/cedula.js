var votosLength;
var esEGG  =  false;

var listaVotosBlanco = new Array(3);
var codigoEleccion;
var codigoNodo;
var codigoSeleccion;
var descripcionSeleccion;
var tipo;
var usado;
var esVotoBlanco;
var codigoReferencia;

function votoBlanco(codigoEleccion, codigoNodo, codigoSeleccion, descripcionSeleccion, tipo, usado,esVotoBlanco) {
	this.codigoEleccion = codigoEleccion;
	this.codigoNodo = codigoNodo;
	this.codigoSeleccion = codigoSeleccion;
	this.descripcionSeleccion = descripcionSeleccion;
	this.tipo = tipo;
	this.usado = usado;
	this.esVotoBlanco = esVotoBlanco;
}

function votoNormal(codigoEleccion, codigoNodo, codigoSeleccion, descripcionSeleccion, tipo, usado,esVotoBlanco,codigoReferencia) {
	this.codigoEleccion = codigoEleccion;
	this.codigoNodo = codigoNodo;
	this.codigoSeleccion = codigoSeleccion;
	this.descripcionSeleccion = descripcionSeleccion;
	this.tipo = tipo;
	this.usado = usado;
	this.esVotoBlanco = esVotoBlanco;
	this.codigoReferencia = codigoReferencia;
}

function seleccionar(pcodigoEleccion, pnodoID, pcodigo, pdescripcion, pimg, ptipo, ptipoImg) {
	evento = '1';
	//pcodigo: es el id nombre de la etiqueta img
	//pimg: es el nombre del archivo jpg de la imagen
	//ptipoImg: indica si es logo (1) o foto (0)
	if(!elementoSeleccionado(pcodigo, pcodigoEleccion)) {
		if(!superaCantidadMaxSeleccion(pcodigoEleccion)) {			
			if(agregarSeleccion(pcodigoEleccion, pnodoID, pcodigo, pdescripcion, pimg, ptipo,ptipoImg)) {			
				marcar(pcodigo, pimg, ptipoImg, true);
			}
		} else {
			var objVotoAntiguo = null;			
			if(!esEGG)
			  objVotoAntiguo = obtenerVotoSeleccionadoPorEleccion(pcodigoEleccion);
			else objVotoAntiguo = obtenerVotoSeleccionadoPorEleccionEGG(pcodigoEleccion);
			if(objVotoAntiguo != null) {
				var flagQuitar = quitarSeleccion(objVotoAntiguo.codigoEleccion, objVotoAntiguo.codigoNodo, objVotoAntiguo.codigoSeleccion, objVotoAntiguo.descripcionSeleccion, objVotoAntiguo.tipo);
				if(flagQuitar){
					if(objVotoAntiguo.esVotoBlanco != 'true'){
						marcar(objVotoAntiguo.codigoSeleccion, objVotoAntiguo.codigoReferencia, ptipoImg, false);
					}
				}
				var flagAgregar = agregarSeleccion(pcodigoEleccion, pnodoID, pcodigo, pdescripcion, pimg, ptipo,ptipoImg);
				if(flagAgregar) {
					marcar(pcodigo, pimg, ptipoImg, true);
				}
			}
		}
	} else {		
		if(quitarSeleccion(pcodigoEleccion, pnodoID, pcodigo, pdescripcion, ptipo)) {
			marcar(pcodigo, pimg, ptipoImg, false);
		}		
	}	
}


function obtenerVotoSeleccionadoPorEleccion(pcodigoEleccion) {
	var objVoto = null;

	for(i=0; i<votosLength; i++) {
		var strCodigoEleccion = document.forms[0].elements['votos[' + i + '].codigoEleccion'].value;
		var strCodigoNodo;
		var strCodigoSeleccion;
		var strDescripcionSeleccion;
		var strTipo;
		var strUsado;
		var strEsVotoBlanco;
		var strCodigoReferencia;	
		if(strCodigoEleccion == pcodigoEleccion) {
			strCodigoNodo = document.forms[0].elements['votos[' + i + '].codigoNodo'].value;
			strCodigoSeleccion = document.forms[0].elements['votos[' + i + '].codigoSeleccion'].value;
			strDescripcionSeleccion = document.forms[0].elements['votos[' + i + '].descripcionSeleccion'].value;
			strTipo = document.forms[0].elements['votos[' + i + '].tipo'].value;
			strUsado = document.forms[0].elements['votos[' + i + '].usado'].value;
			strEsVotoBlanco = document.forms[0].elements['votos[' + i + '].votoBlanco'].value;
			strCodigoReferencia = document.forms[0].elements['votos[' + i + '].codigoReferencia'].value;

			objVoto = new votoNormal(strCodigoEleccion, strCodigoNodo, strCodigoSeleccion, strDescripcionSeleccion, strTipo, strUsado, strEsVotoBlanco, strCodigoReferencia);				
		}
	}

	return objVoto;
}

function obtenerVotoSeleccionadoPorEleccionEGG(pcodigoEleccion) {
	var objVoto = null;

	for(i=0; i<votosLength; i++) {
		var strCodigoEleccion = document.forms[0].elements['votos[' + i + '].codigoEleccion'].value;
		var strCodigoNodo;
		var strCodigoSeleccion;
		var strDescripcionSeleccion;
		var strTipo;
		var strUsado = document.forms[0].elements['votos[' + i + '].usado'].value;
		var strEsVotoBlanco;
		var strCodigoReferencia;	
		if(strCodigoEleccion == pcodigoEleccion && strUsado == 'S') {
			strCodigoNodo = document.forms[0].elements['votos[' + i + '].codigoNodo'].value;
			strCodigoSeleccion = document.forms[0].elements['votos[' + i + '].codigoSeleccion'].value;
			strDescripcionSeleccion = document.forms[0].elements['votos[' + i + '].descripcionSeleccion'].value;
			strTipo = document.forms[0].elements['votos[' + i + '].tipo'].value;
			strUsado = document.forms[0].elements['votos[' + i + '].usado'].value;
			strEsVotoBlanco = document.forms[0].elements['votos[' + i + '].votoBlanco'].value;
			strCodigoReferencia = document.forms[0].elements['votos[' + i + '].codigoReferencia'].value;

			objVoto = new votoNormal(strCodigoEleccion, strCodigoNodo, strCodigoSeleccion, strDescripcionSeleccion, strTipo, strUsado, strEsVotoBlanco, strCodigoReferencia);				
		}
	}

	return objVoto;
}

function superaCantidadMaxSeleccion(pcodigoEleccion) {
	var cantidadMaxSeleccion = eval(document.forms[0].elements['ELE' + pcodigoEleccion + '_cantidadSeleccion'].value);
	var cantidadSeleccionPorEleccion = 0;
	for(i=0; i<votosLength; i++) {
		var strCodigoEleccion = document.forms[0].elements['votos[' + i + '].codigoEleccion'].value;
		var strUsado = document.forms[0].elements['votos[' + i + '].usado'].value;
		if(strUsado == 'S' && strCodigoEleccion == pcodigoEleccion) {
			cantidadSeleccionPorEleccion++;
		}
	}
	if(cantidadSeleccionPorEleccion >= cantidadMaxSeleccion)
		return true;
	else 
		return false;
}

function marcar(pcodigo, pimg, ptipoImg, status) {	
	var imgId = ((ptipoImg == '0') ? 'img' : 'logo') + '' + pcodigo;	
	var img = document.getElementById(imgId);
	var vContextPath = document.forms[0].contextPath.value;
	var vCodigoInstitucion = document.forms[0].codigoInstitucion.value;
	var vCodigoProceso = document.forms[0].codigoProceso.value;
	
	if(status){		
		img.src = vContextPath + '/upload/' + vCodigoInstitucion + '/' + vCodigoProceso + '/cedulas/fotos/' + pimg + '_on.jpg';
	} else {		
		if(ptipoImg == '0')
			pimg = document.getElementById("hiddenFoto" + pcodigo).value;
		else 
			pimg = document.getElementById("hiddenLogo" + pcodigo).value;
		img.src = vContextPath + '/upload/' + vCodigoInstitucion + '/' + vCodigoProceso + '/cedulas/fotos/' + pimg + '.jpg';
	}
}

function seleccionarVotosRef() {
	with(document.forms[0]) {
		for(i=0; i<votosLength; i++) {
			var bEsVotoBlanco = elements['votos[' + i + '].votoBlanco'].value;
			var strCodigoSeleccion = "";
			var strImg = "";
			if(bEsVotoBlanco != 'true') {
				strCodigoSeleccion = elements['votos[' + i + '].codigoSeleccion'].value;
				strImg = elements['votos[' + i + '].img'].value;
				strUsado = elements['votos[' + i + '].usado'].value;
				
				var vContextPath = document.forms[0].contextPath.value;
				var vCodigoInstitucion = document.forms[0].codigoInstitucion.value;
				var vCodigoProceso = document.forms[0].codigoProceso.value;
				
				var img = document.getElementById('img' + strCodigoSeleccion);
				var img2 = document.getElementById('logo' + strCodigoSeleccion);
				
				if(strUsado == 'S'){
					
					img.src = vContextPath + '/upload/' + vCodigoInstitucion + '/' + vCodigoProceso + '/cedulas/fotos/' + strImg + '_on.jpg';
					
					
				} else if(strUsado == 'N') {
					
					img2.src = vContextPath + '/upload/' + vCodigoInstitucion + '/' + vCodigoProceso + '/cedulas/fotos/' + strImg + '_on.jpg';
					
				}
			}
		}
	}
}

//se invoca en AT durante el onLoad
function seleccionarVotos() {
	with(document.forms[0]) {
		for(i=0; i<votosLength; i++) {
			var bEsVotoBlanco = elements['votos[' + i + '].votoBlanco'].value;			
			var strCodigoSeleccion = "";
			var strImg = "";
			var seleccionFotoLogo = "";
			if(bEsVotoBlanco != 'true') {
				strCodigoSeleccion = elements['votos[' + i + '].codigoSeleccion'].value; 			
				strImg = elements['votos[' + i + '].img'].value; 			
				seleccionFotoLogo = elements['votos[' + i + '].seleccionFotoLogo'].value; 			
				//marcar(strCodigoSeleccion, strImg, '0', true);
				//seleccionFotoLogo es 0 cuando se marca la foto y 1 cuando se marca el logo
				marcar(strCodigoSeleccion, strImg, seleccionFotoLogo, true);
			}
		}
	}
}


function hayVotoBlanco() {
	for(i=0; i<votosLength; i++) {
		var strUsado = document.forms[0].elements['votos[' + i + '].usado'].value;
		var bVotoBlanco = document.forms[0].elements['votos[' + i + '].votoBlanco'].value;
		if(bVotoBlanco == 'true' && strUsado == 'N') {
			return true;
		}
	}

	return false;
}

function obtenerVotoBlanco(pcodigoEleccion) {
	for(i=0; i<listaVotosBlanco.length; i++) {
		 var votoBlanco = listaVotosBlanco[i];
		 if(votoBlanco.codigoEleccion ==  pcodigoEleccion)
		 	return votoBlanco;
	}
	
	return null;
}

function quitarSeleccion(pcodigoEleccion, pnodoID, pcodigo, pdescripcion, ptipo) {
	////("quitar seleccion");
	var objVotoBlanco = obtenerVotoBlanco(pcodigoEleccion);
	////(objVotoBlanco);
	if(objVotoBlanco != null) {
		for(i=0; i<votosLength; i++){
			var strCodigoSeleccion = document.forms[0].elements['votos[' + i + '].codigoSeleccion'].value;			
			if(strCodigoSeleccion == pcodigo) {
				document.forms[0].elements['votos[' + i + '].codigoEleccion'].value = objVotoBlanco.codigoEleccion;
				document.forms[0].elements['votos[' + i + '].codigoNodo'].value = objVotoBlanco.codigoNodo;
				document.forms[0].elements['votos[' + i + '].codigoSeleccion'].value = objVotoBlanco.codigoSeleccion;
				document.forms[0].elements['votos[' + i + '].descripcionSeleccion'].value = objVotoBlanco.descripcionSeleccion;
				document.forms[0].elements['votos[' + i + '].img'].value = '';
				document.forms[0].elements['votos[' + i + '].tipo'].value = objVotoBlanco.tipo;
				document.forms[0].elements['votos[' + i + '].usado'].value = objVotoBlanco.usado;
				document.forms[0].elements['votos[' + i + '].votoBlanco'].value = objVotoBlanco.esVotoBlanco;
				document.forms[0].elements['votos[' + i + '].codigoReferencia'].value = objVotoBlanco.codigoReferencia;
				return true;						
			}
		}
	}

	return false;
}

function agregarSeleccion(pcodigoEleccion, pnodoID, pcodigo, pdescripcion, pimg, ptipo, seleccionFotoLogo) {
	for(i=0; i<votosLength; i++){
		var strCodigoEleccion = document.forms[0].elements['votos[' + i + '].codigoEleccion'].value;
		var strUsado = document.forms[0].elements['votos[' + i + '].usado'].value;		
		if(strCodigoEleccion == pcodigoEleccion && strUsado == 'N') {
			document.forms[0].elements['votos[' + i + '].codigoEleccion'].value = pcodigoEleccion;
			document.forms[0].elements['votos[' + i + '].codigoNodo'].value = pnodoID;
			document.forms[0].elements['votos[' + i + '].codigoSeleccion'].value = pcodigo;
			document.forms[0].elements['votos[' + i + '].img'].value = pimg;
			document.forms[0].elements['votos[' + i + '].descripcionSeleccion'].value = pdescripcion;
			document.forms[0].elements['votos[' + i + '].tipo'].value = ptipo;
			document.forms[0].elements['votos[' + i + '].usado'].value = 'S';
			document.forms[0].elements['votos[' + i + '].votoBlanco'].value = 'false';
			//para saber si se marca FOTO o LOGO
			document.forms[0].elements['votos[' + i + '].seleccionFotoLogo'].value = seleccionFotoLogo;	
			return true;						
		}
	}
	return false;
}


function seleccionarRef(pcodigoEleccion, pnodoID, pcodigo, pdescripcion, pimg, ptipo, ptipoImg) {
	
	evento = '1';	

	var img = document.getElementById('img' + pcodigo);
	var img2 = document.getElementById('logo' + pcodigo);

	if(ptipoImg == '0') {

		pimgAux = document.getElementById("hiddenLogo" + pcodigo).value;
		marcarRef(img, img2, pimg, pimgAux, pcodigoEleccion, pnodoID, pcodigo, pdescripcion, ptipo,'S');

	} else if(ptipoImg == '1') {

		pimgAux = document.getElementById("hiddenFoto" + pcodigo).value;
		marcarRef(img2, img, pimg, pimgAux, pcodigoEleccion, pnodoID, pcodigo, pdescripcion, ptipo,'N');

	}
	
}

function marcarRef(img, img2, pimg, pimgAux, pcodigoEleccion, pnodoID, pcodigo, pdescripcion, ptipo, pmarca) {

	var vContextPath = document.forms[0].contextPath.value;
	var vCodigoInstitucion = document.forms[0].codigoInstitucion.value;
	var vCodigoProceso = document.forms[0].codigoProceso.value;
	
	if(img.src.substring(img.src.length -7) == '_on.jpg') {
		quitarSeleccion(pcodigoEleccion, pnodoID, pcodigo, pdescripcion, ptipo);
		img.src = vContextPath + '/upload/' + vCodigoInstitucion + '/' + vCodigoProceso + '/cedulas/fotos/' + pimg + '.jpg';
	} else {
		agregarSeleccionRef(pcodigoEleccion, pnodoID, pcodigo, pdescripcion, pimg, ptipo, pmarca);
		img2.src = vContextPath + '/upload/' + vCodigoInstitucion + '/' + vCodigoProceso + '/cedulas/fotos/' + pimgAux + '.jpg';
		img.src = vContextPath + '/upload/' + vCodigoInstitucion + '/' + vCodigoProceso + '/cedulas/fotos/' + pimg + '_on.jpg';
	}

}

function agregarSeleccionRef(pcodigoEleccion, pnodoID, pcodigo, pdescripcion, pimg, ptipo, pusado) {
	
	for(i=0; i<votosLength; i++){
		var strCodigoEleccion = document.forms[0].elements['votos[' + i + '].codigoEleccion'].value;
		
		if(strCodigoEleccion == pcodigoEleccion) {		
			document.forms[0].elements['votos[' + i + '].codigoEleccion'].value = pcodigoEleccion;
			document.forms[0].elements['votos[' + i + '].codigoNodo'].value = pnodoID;		
			document.forms[0].elements['votos[' + i + '].codigoSeleccion'].value = pcodigo;		
			document.forms[0].elements['votos[' + i + '].img'].value = pimg;
			document.forms[0].elements['votos[' + i + '].descripcionSeleccion'].value = pdescripcion;
			document.forms[0].elements['votos[' + i + '].tipo'].value = ptipo;
			document.forms[0].elements['votos[' + i + '].usado'].value = pusado;
			document.forms[0].elements['votos[' + i + '].votoBlanco'].value = 'false';			

			return true;						
		}
	}

	return false;

}

function elementoSeleccionado(pcodigo, pcodigoEleccion) {	
	////(pcodigo+", "+pcodigoEleccion);
	////(votosLength);
	for(i=0; i<votosLength; i++) {
		var strCodigoSeleccion = document.forms[0].elements['votos[' + i + '].codigoSeleccion'].value;
		var strCodigoEleccion = document.forms[0].elements['votos[' + i + '].codigoEleccion'].value;	
		////((i+1)+") "+strCodigoSeleccion+", "+pcodigo+"  ------ "+strCodigoEleccion+", "+pcodigoEleccion);
		if(pcodigoEleccion == strCodigoEleccion && strCodigoSeleccion == pcodigo) {
			return true;
		}
	}
	return false;
}
