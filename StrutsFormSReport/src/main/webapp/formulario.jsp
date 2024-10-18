<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FORMULARIO</title>
</head>
<s:head />
<sx:head />
<body>
	<sx:tabbedpanel id="formularioAlta">
		<sx:div label="FORMULARIO ALTA SREPORT">
			<s:form action="alta.action" method="post">
				<s:textfield key="tipo" label="TIPO" />
				<s:textfield key="version" label="VERSION" />
				<s:textfield key="comentario" label="COMENTARIO" />
				<s:submit value="Enviar Datos" />
			</s:form>
		</sx:div>
	</sx:tabbedpanel>
</body>
</html>