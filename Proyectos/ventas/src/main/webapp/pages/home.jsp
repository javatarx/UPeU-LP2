<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
</head>
<body>
	<table>
		<caption>Lista de Personas</caption>
		<tr>
			<td colspan="4"><a href="nuevaPersona">Nuevo</a></td>
		</tr>
		<tr>
			<th>#</th>
			<th>Paterno</th>
			<th>Materno</th>
			<th>Nombre</th>
		</tr>
		<c:forEach items="${lp}" var="p" varStatus="ps">
			<tr>
				<td><c:out value="${ps.count}"></c:out></td>
				<td><c:out value="${p.apePat}"></c:out></td>
				<td><c:out value="${p.apeMat}"></c:out></td>
				<td><c:out value="${p.nombre}"></c:out></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>