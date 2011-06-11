<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>:::PR&Aacute;CTICA DE CEDULA GENERAL DE VOTACION:::</title>
<script language="javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/jscript.js">
</script><script language="javascript" src="${pageContext.request.contextPath}/js/dojo/dojo.js">
</script><script src="${pageContext.request.contextPath}/js/cronometro.js" type="text/javascript">
</script><script src="/modvotacion/js/cedula.js" type="text/javascript"></script>
<style type="text/css">
	
	body{
		font-family: verdana,geneva,lucida,'lucida grande',arial,helvetica,sans-serif
	}

</style>
<script type="text/javascript">
	function selec(imagen){
		if(imagen=='logo17'){
			if(document.forms[0].voto1.value=='logo17_on'){
				document.forms[0].voto1.value='';		
				document.getElementById('logo500099203').src = '${pageContext.request.contextPath}/images/practique_como_votar_imgs/logoKeiko.jpg';				
			}else{
				document.forms[0].voto1.value='logo17_on';
				document.forms[0].seleccion.value="500099203";
				document.getElementById('logo500099203').src = '${pageContext.request.contextPath}/images/practique_como_votar_imgs/logoKeiko_on.jpg';	
				document.forms[0].voto2.value='';		
				document.getElementById('logo500099204').src = '${pageContext.request.contextPath}/images/practique_como_votar_imgs/logoOllanta.jpg';								
			}			
		}
		if(imagen=='logo23'){
			if(document.forms[0].voto2.value=='logo23_on'){
				document.forms[0].voto2.value='';		
				document.getElementById('logo500099204').src = '${pageContext.request.contextPath}/images/practique_como_votar_imgs/logoOllanta.jpg';
			}else{
				document.forms[0].voto2.value='logo23_on';		
				document.forms[0].seleccion.value="500099204";
				document.getElementById('logo500099204').src = '${pageContext.request.contextPath}/images/practique_como_votar_imgs/logoOllanta_on.jpg';	
				document.forms[0].voto1.value='';		
				document.getElementById('logo500099203').src = '${pageContext.request.contextPath}/images/practique_como_votar_imgs/logoKeiko.jpg';				
			}
		}		
	}
	
	function siguiente(){
		document.forms[0].tipo.value = "resumenPractica";
		document.forms[0].submit();
	}	
	
	
</script>
</head>
<body bgcolor="DFE8F5" bottommargin="0" leftmargin="0" onload="fn_onload();" rightmargin="0" topmargin="0">
<form action="${pageContext.request.contextPath}/Votacion" method="post">
<input type="hidden" name="tipo" value="resumenVoto"/>

<input id="voto1" name="voto1" type="hidden" value="">
<input id="voto2" name="voto2" type="hidden" value="">
<input id="seleccion" name="seleccion" type="hidden" value="">
<table align="center" bgcolor="FFFFFF" border="0" cellpadding="0" cellspacing="0" height="680px" width="900px">
<tr>
<td align="right" bgcolor="BFD0EA">
<div align="right" id="hora"></div>
</td>
</tr>
<tr>
<td align="center" colspan="2" height="98" valign="top" width="1024px">
<img src="${pageContext.request.contextPath}/images/practique_como_votar_imgs/cabecera-internas.jpg" width="100%"></td>
</tr>
<tr>
<td align="center" background="images/bg.gif" valign="top">
<table border="0">
<tr>
<td bgcolor="CCCCCC" height="40px" style="border:solid 1px;" valign="middle" width="640px" align="center">
	<h2>ELECCI&Oacute;N DE REPRESENTANTES TITULAR Y ALTERNO</h2>
</td>
</tr>
<tr>
<td colspan="1" height="10px"> </td>
</tr>
<tr>
<td class="celda" valign="top" width="640px">
<table align="center" cellpadding="1" cellspacing="1" width="100%">

<c:forEach items="${candidatos}" var="candidato">
	<tr >
		<td class="TEXTOclass" height="70px" preferencial="N" seleccionable="N" style="border:1px solid #000;border-width: 1px 1px 1px 1px; border-color:#000 #000 #000 #000" valign="middle" width="100%">
		<p style="font-family: arial,helvetica,sans-serif; font-size: 14px; color: rgb(0, 0, 0)">${candidato.nombre}&nbsp;${candidato.apellidos}</p>
		</td>
		<td align="center" class="LOGOclass" height="70px" preferencial="N" seleccionable="S" style="border:1px solid #000;border-width: 1px 1px 1px 1px; border-color:#000 #000 #000 #000" valign="middle" width="140px">
			<img border="0" height="70px" src="${pageContext.request.contextPath}/images/practique_como_votar_imgs/${candidato.foto}" >
		</td>
		<td align="center" class="LOGOclass" height="70px" preferencial="N" seleccionable="S" style="border:1px solid #000;border-width: 1px 1px 1px 1px; border-color:#000 #000 #000 #000" valign="middle" width="70px">
			<a href="javascript:selec('${candidato.codSeleccion}');" onClick="evento='1';">
				<img border="0" height="70px" id="logo${candidato.codReferencia}" name="logo${candidato.codReferencia}" src="${pageContext.request.contextPath}/images/practique_como_votar_imgs/${candidato.logo}">
			</a>
		</td>
	</tr>
</c:forEach>

</table>
</td>
</tr>
<tr>
<td align="center" colspan="1" valign="middle" width="100%">
<input type="button" onclick="siguiente();" id="btnSiguiente" style="font-family: Arial; font-size: 18px; border: 1px #666666 solid; font-weight: bold; height: 30px; width: 140px; padding: 1px; color: #FFFFFF; background: #cc6600;" value="Votar"/>
</td>
</tr>
</table>
</td>
</tr>
</table>
</form>
</body>
</html>
