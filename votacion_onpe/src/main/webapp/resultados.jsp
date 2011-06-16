<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/thickbox.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/style-login.css"/>
<title>Consulta de Resultados</title>
<script type="text/javascript">
function enviar(){
	document.forms[0].tipo.value = "resultados";
	document.forms[0].submit();
}	
</script>
</head>
<body>
<form action="<%=request.getContextPath()%>/Votacion" method="post">
<center>
	<input type ="button" value="Ver Resultados" class="boton" onclick="enviar();"/>
	<br/>
	<c:if test="${resultados!=null}">
		<table>
			<tr>
				<td>Candidato</td>
				<td>Cantidad Votos</td>
			</tr>
			<c:forEach items="${resultados}" var="r">
				<tr>
					<td>${r.nomCandidato}</td>
					<td>${r.cantVotos}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</center>
</form>
</body>
</html>
