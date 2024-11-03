<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<sf:form action="search" method="POST" modelAttribute="product">
		<sf:label path="ID">Introduce ID:</sf:label>
		<sf:input path="ID" />
		<br />
		<input type="submit" value="Buscar producto" />
	</sf:form>
</body>
</html>