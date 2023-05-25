<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todos los Dojos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>

<h1> Bienvenido al Dojo ${dojosyninjas.nombre}</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Edad  </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ dojosyninjas.ninjas}" var="n">
				<tr>
					<td>${ n.nombre}</td>
					<td>${ n.apellido }</td>
					<td>${ n.edad }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>