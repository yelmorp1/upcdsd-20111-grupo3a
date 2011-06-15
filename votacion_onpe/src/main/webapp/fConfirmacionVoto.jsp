<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>VENP Voto Electr&oacute;nico No Presencial</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/thickbox.css" type="text/css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jscript.js"></script>    
<style type="text/css">
		#header-top {
			border-bottom:3px solid red !important;
			height:57px !important;
		}
		#header-top h2{
			position:absolute; 986-476-946
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
<form action="<%=request.getContextPath()%>/votacion">

	<input type="hidden" name="tipo" value="votar"/>	
	
<div id="logo-app"><span>VENP Voto Electr&oacute;nico No Presencial</span></div>
</div>

	<div id="all"> <!-- antes wiewreport -->
		<div id="wrap">
	<div align="right" id="hora">&nbsp;</div>
<div id="cnt" style="background-color:#DFE8F5;">
<br />
<center><h2></h2></center>	
<div class="contentCondicionUso">
	<div class="block">
		<h3>
			<span>Mensaje para el Votante</span>
		</h3>
		<div class="inner">

			<div class="login-content">
				<p align="justify">
				  	<span class="boxText"><b>Estimado(a) Votante:</b><br><br></span>

					<p><strong>Su voto ha sido registrado satisfactoriamente.</strong></p>
					<br>
      				<p><strong>La constancia de votaci&oacute;n se enviar&aacute; al correo electr&oacute;nico registrado en el padr&oacute;n en las pr&oacute;ximas 24 horas.</strong></p>
				</p>
			</div>		
			<div>
				
			</div>

		<br>
		<table width="75%" border="0" cellspacing="0" "center">
			<tr>
				<td align="right" align="center">
					<input name="btncerrar" type="button" class="boton1" value="Salir" onclick="window.close();"/>
				</td>
			</tr>
		</table>

	</div><!-- Fin de inner -->
	</div><!-- Fin de block -->
</div><!-- Fin de content -->

</div>

	</div><!-- fin de wrap -->
	</div><!-- fin de all -->

	<div id="footer" style="background-color: #324B84">
		<span>Desarrollo de Sistemas Distribuidos 2011</span> 
	</div>	
</form>	
</body>
</html>