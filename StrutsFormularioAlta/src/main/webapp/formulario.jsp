<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FormularioAlta</title>
</head>
<s:head/>
<sx:head/>

<body>
<sx:tabbedpanel id="formularioAlta">
<sx:div label="FORMULARIO ALTA USERCAP">
<s:form action="alta.action" method="post">
<s:textfield key="nombre" label="NOMBRE" />
<s:password key="password" label="PASSWORD" />
<s:radio name="genero" label="GENERO" list="#{'Masculino':'MASCULINO',
'Femenino':'FEMENINO'}" />
<s:checkboxlist name="idioma" label="IDIOMA" list="#{'Esp':'ESPAÑOL',
'Ing':'INGLES','Por':'PORTUGUES','Ale':'ALEMAN'}" />
<s:select name="ciudad" label="ciudad" list="#{'Pue':'PUEBLA',
'Tlax':'TLAXCALA','Mor':'MORELOS','Oax':'OAXACA'}" headerKey="1" 
headerValue="Selecciona Ciudad" />
<sx:datetimepicker key="fecha" label="FECHA" displayFormat="dd/mm/yyyy" />
<sx:autocompleter name="tipo" label="TIPO" list="#{'User':'USER',
'Root':'ROOT','Admin':'ADMIN'}" />
<s:textarea key="comentario" label="COMENTARIO" />
<s:submit value="Enviar Datos" />
</s:form>
</sx:div>
</sx:tabbedpanel>
</body>
</html>