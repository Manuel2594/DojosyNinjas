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
<title>Persona</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<h1>Agregar Ninja</h1>
	<form:form action="/ninja/new" method="post" modelAttribute="ninja">

			<div class="form-group">
				<form:select class="form-control" path="dojos">
				<c:forEach items="${dojos}" var="d">
					<form:option value="${d.id}"> ${d.nombre}
					</form:option>
					</c:forEach>
				</form:select>
			</div>

		<div class="form-group">
			<form:label path="nombre">Nombre</form:label>
			<form:errors class="text-danger" path="nombre" />
			<form:input class="form-control" path="nombre" />
		</div>
		<div class="form-group">
			<form:label path="apellido">Apellido</form:label>
			<form:errors class="text-danger" path="apellido" />
			<form:input class="form-control" path="apellido" />
		</div>
		<div class="form-group">
			<form:label path="edad">Edad</form:label>
			<form:errors class="text-danger" path="edad" />
			<form:input class="form-control" path="edad" />
		</div>
		<button>Crear</button>
	</form:form>
	</div>
</body>
</html>