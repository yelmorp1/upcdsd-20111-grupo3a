<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/thickbox.css" type="text/css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/style-login.css" />
<title>Consulta de Resultados</title>
<script type="text/javascript">
	function enviar() {
		document.forms[0].tipo.value = "resultados";
		document.forms[0].submit();
	}
</script>

</head>
<body bgcolor="DFE8F5">
	<div class="ClaseDiv">
		<table cellspacing="0" cellpadding="0" border="0"
			background="images/bg_head.jpg" width="100%">
			<tbody>
				<tr>
					<th valign="top" align="center" width="10%" scope="row">
						&nbsp;</th>
					<th align="center" width="80%" scope="row">
						<div class="ClaseTitulo1">
							<h2>RESULTADOS DEL VOTO ELECTRONICO</h2>
						</div>
					</th>
					<th valign="top" align="center" width="10%" scope="row">
						&nbsp;</th>
				</tr>
			</tbody>
		</table>
	</div>
	<form action="<%=request.getContextPath()%>/Votacion" method="post">
		<div class="cnt">
			<div class="content">
				<div class="block">
					<input type="hidden" name="tipo" id="tipo" value="" />
					<center>
						<br /> <br /> <input type="button" value="Ver Resultados"
							class="boton" onclick="enviar();" /> <br /> <br />
						<c:if test="${resultados!=null}">
							<table border="1">
								<tr class="subtitulo">
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
					<br> <br>
				</div>
			</div>
		</div>
	</form>
	<div class="ClaseDiv2">Desarrollo de Sistemas Distribuidos</div>
</body>
</html>
