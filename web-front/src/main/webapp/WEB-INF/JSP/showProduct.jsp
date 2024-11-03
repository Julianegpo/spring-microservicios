<%@page import="es.minsait.models.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Producto encontrado</h1>
	
	<jsp:useBean id="foundProduct" class="es.minsait.models.Product" scope="request"></jsp:useBean>
	
	<ul>
		<li>ID: <jsp:getProperty property="ID" name="foundProduct"></li>
		<li>Descripcion: <jsp:getProperty property="description" name="foundProduct"></li>
		<li>Precio: <jsp:getProperty property="price" name="foundProduct"></li>
	</ul>
	
</body>
</html>