<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>INVENTARIO</title>
</head>
<s:head />
<sx:head />
<body>

	<sx:tabbedpanel id="formulario">
		<sx:div label="FORMULARIO CRUD - INVENTARIO">
			<s:form action="alta.action" method="post">
				<s:push value="inventario">
					<s:hidden key="id" />
					<s:textfield key="producto" label="PRODUCTO" />
					<s:select name="categoria" label="CATEGORIA"
						list="#{'LAC':'LACTEOS','VER':'VERDURAS','FRU':'FRUTAS','BEV':'BEVIDAS'}"
						headerKey="1" headerValue="Selecciona categoria" />
					<s:submit value="Aceptar" />
					<s:reset value="Limpiar" />
				</s:push>
			</s:form>
		</sx:div>
	</sx:tabbedpanel>

	<table class="table table-dark table-striped-columns">
		<tr>
			<td>ID</td>
			<td>PRODUCTO</td>
			<td>CATEGORIA</td>
		</tr>
		<s:iterator value="inventarios">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="producto" /></td>
				<td><s:property value="categoria" /></td>
				<td><s:url id="editURL" action="editar">
						<s:param name="id" value="%{id}" />
					</s:url> <s:a href="%{editURL}">EDITAR</s:a></td>
				<td><s:url id="deleteURL" action="baja">
						<s:param name="id" value="%{id}" />
					</s:url> <s:a href="%{deleteURL}">BORRAR</s:a></td>
			</tr>

		</s:iterator>
	</table>

</body>
</html>