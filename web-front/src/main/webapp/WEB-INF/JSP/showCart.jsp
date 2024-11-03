<%@page import="es.minsait.models.Order"%>
<%@page import="es.minsait.models.ShoppingCart"%>
<%@page import="es.minsait.models.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Contenido del carrito</h1>

	<%
	ShoppingCart shoppingCart = (ShoppingCart) request.getAttribute("carrito");
	%>

	<h2>
		User:
		<%=shoppingCart.getUser()%></h2>
	<h2>
		Importe:
		<%=shoppingCart.getAmount()%></h2>

	<table border="1" align="center">
		<tr>
			<th>ID</th>
			<th>DESCRIPCION</th>
			<th>PRECIO</th>
			<th>CANTIDAD</th>
			<th>ELIMINAR</th>
		</tr>

		<%
		for (Order p : shoppingCart.getContenido()) {
		%>
		<tr>			
			<td><%=p.getProduct().getID()%></td>
			<td><%=p.getProduct().getDescription()%></td>
			<td><%=p.getProduct().getPrice()%></td>
			<td><%=p.getQuantity()%></td>

			<td>
				<a href="deleteItem?id=<%=p.getProduct().getID()%>">
				Sacar del carrito
				</a>
			</td>

		</tr>
		<% } %>
	</table>
</body>
</html>