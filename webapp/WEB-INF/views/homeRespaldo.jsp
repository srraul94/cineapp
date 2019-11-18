<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a CineApp</title>

<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet" href="${ urlPublic}/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<%--
	<h1>Lista de Películas</h1>

	<ul>
		<c:forEach items="${peliculas}" var="pelicula">
			<li>${pelicula}</li>
		</c:forEach>
	</ul>
	 --%>

	<div class="panel">
		<div class="panel-heading">Lista de Películas</div>
		<div class="panel-body">

			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Título</th>
						<th>Duración</th>
						<th>Clasificación</th>
						<th>Género</th>
						<th>Imagen</th>
						<th>Fecha Estreno</th>
						<th>Estatus</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${peliculas}" var="pelicula">
						<tr>
							<td>${pelicula.id}</td>
							<td>${pelicula.titulo}</td>
							<td>${pelicula.duracion}min</td>
							<td>${pelicula.clasificacion}</td>
							<td>${pelicula.genero}</td>
							<td><img src="${urlPublic}/images/${pelicula.imagen}" width="80" height="100"></td>
							<td><fmt:formatDate value="${pelicula.fechaEstreno}" pattern="dd-MM-yyyy"/> </td>
							<td>
								
								<c:choose>
									<c:when test="${pelicula.estatus == 'Activa' }">
										<span class="label label-success" >ACTIVA</span>
									</c:when>
									
									<c:otherwise>
										<span class="label label-danger">INACTIVA</span>
									</c:otherwise>
								
								
								</c:choose>
							
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>