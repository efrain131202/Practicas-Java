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
<title>CRUD</title>
</head>
<s:head />
<sx:head />
<body>

	<sx:tabbedpanel id="formulario">
		<sx:div label="FORMULARIO CRUD - EMPLEADO">
			<s:form action="alta.action" method="post">
				<s:push value="empleado">
					<s:hidden key="id" />
					<s:textfield key="nombre" label="NOMBRE" />
					<s:radio name="genero" label="GENERO"
						list="#{'Femenino':'FEMENINO', 'Masculino':'MASCULINO'}" />
					<s:select name="ciudad" label="CIUDAD"
						list="#{'PUE':'PUEBLA','Tlax':'TLAXCALA','Mor':'MORELOS','Ver':'VERACRUZ'}"
						headerKey="1" headerValue="Selecciona Ciudad" />
					<s:textarea key="descripcion" label="DESCRIPCION" />
					<s:checkbox name="desarrollador"
						label="TIENE EXPERIENCIA EN DJANGO" />
					<s:submit value="Aceptar" />
					<s:reset value="Limpiar" />
				</s:push>
			</s:form>
		</sx:div>
	</sx:tabbedpanel>

	<table class="table table-dark table-striped-columns">
		<tr>
			<td>ID</td>
			<td>NOMBRE</td>
			<td>GENERO</td>
			<td>CIUDAD</td>
			<td>DESCRIPCION</td>
			<td>DESARROLLADOR</td>
			<td>EDITAR</td>
			<td>ELIMINAR</td>
		</tr>
		<s:iterator value="empleados">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="nombre" /></td>
				<td><s:property value="genero" /></td>
				<td><s:property value="ciudad" /></td>
				<td><s:property value="descripcion" /></td>
				<td><s:property value="desarrollador" /></td>
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