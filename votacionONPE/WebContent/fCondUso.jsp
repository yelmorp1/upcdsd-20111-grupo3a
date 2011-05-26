<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>VENP Voto Electr&oacute;nico No Presencial</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/thickbox.css" type="text/css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    
    <script type="text/javascript" src="js/jquery.js"></script>
     
	<script language="javascript" src="${pageContext.request.contextPath}/js/dojo/dojo.js"></script>
	<script src="${pageContext.request.contextPath}/js/cronometro.js" type="text/javascript"></script>
 
    <script language="javascript" type="text/javascript">
	<!--
		window.name = 'fCondUso${pageContext.session.id}';		
		
		function fn_finalizar_onclick() {
			with(document.forms[0]) {
				if(confirm('<bean:message key="votacion.disclaimer.finalizar.confirmar"/>')){
					flag.value = "yes";
					evento='1';
					tipo.value = 'finalizar';
					submit();					
					window.close();   
				}
				flag.value = "no";
			}
		}
	
		function openWindow(winName,features){
			return window.open("", winName, features);
		}
	
	
		function fn_enviar(){		
			document.getElementsByName("btnSubmit")[0].disabled=true;
			var checkbox  = document.getElementsByName("flagCondicionUso")[0];
			if(checkbox!=null){
				if (!checkbox.checked){								
					document.getElementById("mensaje").style.display = '';
					document.getElementsByName("btnSubmit")[0].disabled=false;
				}else{					
					abrirCedula();
				}
			}else{
				abrirCedula();
			}
		}		
		
		function abrirCedula(){
			document.forms[0].flag.value = 'cedula';
			var vTarget = document.forms[0].target;			
			var ancho = screen.width - 10;			
			var alto = screen.height - 48;
			document.getElementsByName("btnSubmit")[0].disabled=true;
			winPreview =  window.open("",'cedula${pageContext.session.id}View','scrollbars=yes,width='+ancho+',height='+alto);
			document.forms[0].target = 'cedula${pageContext.session.id}View';			
			document.forms[0].tipo.value = 'fCedula';			
			document.forms[0].submit();	
			document.forms[0].target = vTarget;
			cedulaAbierta = true;
			setTimeout('verCedula()',2000);		
		}
		
		function verCedula(){
			window.close();
		}
		
		var statSend = false;
		function checkSubmit() {
		 	if (!statSend) {
				statSend = true;
				return true;
			} else {				
				return false;
			}		
		}
		
		
		
		
		
	//-->
</script>

<style type="text/css">
		#header-top {
			border-bottom:3px solid red !important;
			height:57px !important;
		}
		#header-top h2{
			position:absolute;
			right:25%;
			top:17px;
			font-family: arial;
			font-size: 18px;
		}
		
		#cnt{
			padding-top:100px !important;
			min-height:413px !important;
			padding-top:145px !important;
		}
		#logo-app{
			left: 35%;
			top: 24%;
		}
			
</style>
</head> 
<body  bgcolor="DFE8F5">
<div class="ClaseDiv">
      		<table cellspacing="0" cellpadding="0" border="0" background="images/bg_head.jpg" width="100%">
        		<tbody>
        			<tr>
         				<th valign="top" align="center" width="12%" scope="row">
         					&nbsp;
         				</th>
         				<th align="center" width="63%" scope="row">
         					<div class="ClaseTitulo1">
            					<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            					&nbsp;&nbsp;&nbsp;
            					&nbsp;&nbsp;&nbsp;
            					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            					&nbsp;&nbsp;&nbsp;VOTO ELECTRONICO</h2>	
                			</div>
         				</th>
         				<th valign="top" align="center" width="25%" scope="row">
         					&nbps;
         				</th>     	
        			</tr>
      			</tbody>
      		</table>
</div>
<form action="/Votacion" onsubmit="return checkSubmit();">
<input type="hidden" id="flag" value=""/>
<!--<div id="logo-app"><span>VENP Voto Electr&oacute;nico No Presencial</span></div>-->


	<div id="all"> <!-- antes wiewreport -->

		<!-- <div id="header"> 
			<div id="header-top">
				<div id="logo-org-login"><span>ONPE</span></div>
				<h2>OFICINA NACIONAL DE PROCESOS ELECTORALES</h2>	
			</div> 
			<div style="clear: both;"></div>		
		</div> --> 

		<div id="wrap">
<div align="right" id="hora"></div>	
		
<div id="cnt" style="background-color:#DFE8F5;">

<div class="contentCondicionUso">
	<div class="block">
		<h3>
			<span>Condiciones de uso para el Voto</span>
		</h3>
		<div class="inner">
			<div class="login-content">
				<p align="justify">
				  	<span class="boxText"><b>Estimado(a) Votante:</b><br><br>
				  	</span>- Sólo podrá emitir su voto una (1) sola vez.</p>
				  <p align="justify">- S&oacute;lo podr&aacute; ingresar al sistema tres 3 veces como máximo antes de votar.</p>	
				  <p align="justify" class="boxText">- El tiempo de la sesión es 5 min. </p>
				  <p align="justify" class="boxText">- Recuerde que debe utilizar el Scroll (Barra desplegable) para desplazarse en la cédula. </p>
				  <p align="justify" class="boxText">- Cualquier duda comuniquese con Aló ONPE: (511)417-0630. </p>
				  <p align="justify" class="boxText">- Si actualiza la p&aacute;gina o presiona F5 se cerrará su sesi&oacute;n y se descontar&aacute; un ingreso. </p>
				  <br />
				  <p align="center">
				  	<span style="color:blue;font-size:20px;font-weight: bold;">N&uacute;mero de Accesos: (<bean:write name="VotacionForm" property="cantidadAccesos"/>) de (<bean:message key="votacion.numeroaccesos"/>)</span>
				  </p>

				  <p align="center" class="boxText">
				  		<input type="checkbox" id="flagCondicionUso" name="flagCondicionUso" />
				  		 Acepto las condiciones de Uso
				  </p>
				  
				  <p>
					<div class="inforbarError" id="mensaje" style="display:none;">Debe aceptar las condiciones de uso</div>
				  </p>
			</div>		
			<div>
				
			</div>

		<br>
		<center>
		<table border="0" cellspacing="0">
			<tr>
				<td>				
				<input type="button" id="btnSubmit" value="Ir a C&eacute;dula de Votaci&oacute;n" class="boton" onclick="fn_enviar();" />
				</td>
				<td width="20px">&nbsp;</td>
				<td>
				<input type="button" id="btnFinalizar" value="Salir" class="boton" onclick="fn_finalizar_onclick();" />
				</td>
			</tr>
		</table>
		</center>
	</div><!-- Fin de inner -->
	</div><!-- Fin de block -->
</div><!-- Fin de content -->

</div>

	</div><!-- fin de wrap -->
	</div><!-- fin de all -->

	<div id="footer" style="background-color: #324B84">
		<span>VENP 2011</span>
	</div>
	</form>	
</body>
</html>