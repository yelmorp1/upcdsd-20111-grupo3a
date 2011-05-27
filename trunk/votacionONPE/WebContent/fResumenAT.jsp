<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>VENP Voto Electr&oacute;nico No Presencial</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />	
	<link rel="stylesheet" href="css/thickbox.css" type="text/css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    
    <script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jscript.js"></script>
   
   <!-- Referentes al dojo -->
	<script language="javascript" src="js/dojo/dojo.js"></script>
	<script type="text/javascript" src="js/cronometro.js"></script>
   <!-- Fin de dojo -->
   
    <script language="javascript" type="text/javascript">
	<!--
	    
		function fn_corregirVoto() {
			with(document.forms[0]) {
				evento='1';
				tipo.value = 'cambiarVoto';
				document.getElementsByName("btnVotar")[0].disabled=true;
				submit();
				document.getElementsByName("btnCambiar")[0].disabled=true;
			}
		}		
	
		function votar(){
			evento='1';
			document.getElementsByName("btnCambiar")[0].disabled=true;
			document.forms[0].submit();
			document.getElementsByName("btnVotar")[0].disabled=true;
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
<body bgcolor="DFE8F5">
<div class="ClaseDiv">
      		<!--<table cellspacing="0" cellpadding="0" border="0" background="images/bg_head.jpg" width="100%">
        		<tbody>
        			<tr>
         				<th valign="top" align="center" width="12%" scope="row">
         					<img height="95" width="86" alt="" src="images/logo_onpe2.jpg"/>
         				</th>
         				<th align="center" width="63%" scope="row">
         					<div class="ClaseTitulo1">
            					<h2>OFICINA NACIONAL DE PROCESOS ELECTORALES</h2>	
                			</div>
         				</th>
         				<th valign="top" align="center" width="25%" scope="row">
         					<img height="95" width="199" longdesc="VOTO ELECTRONICO NO PRESENCIAL" alt="VENP" src="images/logo_venp.jpg"/>
         				</th>     	
        			</tr>
      			</tbody>
      		</table>-->
      	<img src="${imagenCabecera}" width="100%" />
</div>
<form action="<%=request.getContextPath()%>/Votacion">
<input type="hidden" name="tipo" value="votar"/>
	
<!--<div id="logo-app"><span>VENP Voto Electr&oacute;nico No Presencial</span></div> -->


	<div id="all"> <!-- antes wiewreport -->

		<!--  <div id="header"> 
			<div id="header-top">
				<div id="logo-org-login"><span>ONPE</span></div>
				<h2>OFICINA NACIONAL DE PROCESOS ELECTORALES</h2>	
			</div> 
			<div style="clear: both;"></div>			
		</div> -->

		<div id="wrap">
    <div align="right" id="hora"></div>	
<div id="cnt" style="background-color:#DFE8F5;">
<center><h2>${sessionScope.proceso}</h2></center>	
<div class="contentCondicionUso">
	<div class="block">
		<h3>
			<span>Confirmación de candidatos elegidos</span>
		</h3>
		
		<div class="inner">
			<table width="98%" border="0" align="center">
				<logic:present name="CedulaForm">
					<logic:notEmpty name="CedulaForm" property="votos">
						<logic:iterate name="CedulaForm" property="votos" id="voto">
							<!-- logic:notEqual name="voto" property="descripcionSeleccion" value="BLANCO" -->
							  <tr bgcolor="#FFFFFF">
							    <td width="321" align="center" bordercolor="#CCCCCC" bgcolor="#FFFFFF">
							    	<div align="center">
							    		<span class="label1 style10 style16">
							    			<strong><bean:write name="voto" property="descripcionEleccion"/></strong>
							    		</span>
							    	</div>
							    </td>
							    <td width="297" align="left" valign="middle" bordercolor="#CCCCCC" bgcolor="#FFFFFF">
							    	<strong class="title1">
							    		<bean:write name="voto" property="descripcionSeleccion"/>
							    	</strong>
							    </td>
							    <bean:define id="vurlLogo"><c:out value="${pageContext.request.contextPath}"/>/<bean:message key="votacion.cedula.imagenes.candidatos" arg0="${sessionScope.codigoInstitucion}" arg1="${sessionScope.codigoProceso}"/>/<c:out value="${voto.candidato.urlLogo}"/></bean:define>
								<bean:define id="vurlFoto"><c:out value="${pageContext.request.contextPath}"/>/<bean:message key="votacion.cedula.imagenes.candidatos" arg0="${sessionScope.codigoInstitucion}" arg1="${sessionScope.codigoProceso}"/>/<c:out value="${voto.candidato.urlFoto}"/></bean:define>
							    <td width="100" align="right" valign="middle" bordercolor="#CCCCCC" bgcolor="#FFFFFF">
							    	<div align="right" >
							      		<div align="center">
													<bean:define id="vurlLogo"><c:out value="${pageContext.request.contextPath}"/>/images/blanco.jpg</bean:define>													
													<table>
														<tr><td><img src="${vurlLogo}" width="85" height="90" border="1" id="img${voto.codigoSeleccion}"/></td></tr>
													</table>												
							      		</div>
							    	</div>
							    </td>
							    							    
								<td width="100" align="right" valign="middle" bordercolor="#CCCCCC" bgcolor="#FFFFFF">
							    	<div align="right" >
							      		<div align="center">										
													<bean:define id="vurlFoto"><c:out value="${pageContext.request.contextPath}"/>/images/blanco.jpg</bean:define>
													<table>
														<tr><td><img src="${vurlFoto}" width="85" height="90" border="1" id="img${voto.codigoSeleccion}"/></td></tr>
													</table>												
							      		</div>
							    	</div>
							    </td>
							  </tr>
							<!-- /logic:notEqual -->
					 	</logic:iterate>
					</logic:notEmpty>
				</logic:present>
			</table>
			
			<br>
			
			<table align="center" width="75%">
			  <tr>
			    <td align="center" valign="middle" class="">
			    	<input type="button" id="btnCambiar" value="Cambiar" onclick="fn_corregirVoto();" class="botonRojo"/>
			    </td>
			    <td align="center">
			    	<input type="button" id="btnVotar" class="botonVerde" value="Votar" onclick="votar(); "/>
			    </td>
			  </tr>
			</table>
		</div>

	</div><!-- Fin de inner -->
	</div><!-- Fin de block -->
</div><!-- Fin de content -->

</div>

	</div><!-- fin de wrap -->
	</div><!-- fin de all -->

	<div id="footer" style="background-color: #324B84">
		<span>VENP</span>&nbsp;&nbsp;&nbsp;Copyright &copy; 2011 ONPE&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Este sistema se ve mejor con una resoluci&oacute;n de 1024x768. 
	</div>
	
	
</form>
</body>
</html>