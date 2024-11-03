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
	<h1>Nuestro catalogo de Products</h1>

	<%
	List<Product> list = (List<Product>) request.getAttribute("productsList");
	%>

	<table border="1" align="center">
		<tr>
			<th>ID</th>
			<th>DESCRIPCION</th>
			<th>PRECIO</th>
			<th>CANTIDAD</th>
			<th>COMPRAR</th>
		</tr>

		<%
		for (Product p : list) {
		%>
		<tr>
			<td><%=p.getID()%></td>
			<td><%=p.getDescription()%></td>
			<td><%=p.getPrice()%></td>
			
			<form action="buy" method="post">
				<input type="hidden" name="id" value="<%=p.getID()%>" />
				<td><input type="number" name="quantity"/></td>
				<td><input type="submit" name="addToCart"/></td>
			</form>
			
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>