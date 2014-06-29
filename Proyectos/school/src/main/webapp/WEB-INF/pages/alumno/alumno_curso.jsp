<%@include file="/common/taglibs.jsp"%>
<h1>Cursos de ${alumno.nombre}</h1>
<c:choose>
	<c:when test="${not empty alumno.cursos}">
		<table class="tabla-cebra">
			<tr>
				<td colspan="5"><a href="#"
					onclick="upeu.cargarUrl('alumnos');">[Atras]</a>&nbsp;&nbsp;&nbsp;<a
					href="#"
					onclick="upeu.cargarUrl('alumnos/curso/editar?id=${alumno.id}')">Editar
						Cursos</a></td>
			</tr>
			<tr>
				<th>#</th>
				<th>Nombre</th>
				<th>Horas</th>
				<th>Creditos</th>
				<th>Opc</th>
			</tr>
			<c:forEach items="${alumno.cursos}" var="c" varStatus="cs">
				<tr>
					<td>${cs.count}</td>
					<td>${c.nombre}</td>
					<td>${c.nroHoras}</td>
					<td>${c.nroCreditos}</td>
					<td><a href="#"
						onclick="upeu.cargarUrl('alumnos/curso/eliminar?id_alumno=${alumno.id}&id_curso=${c.id}')">[Elim]</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<p>
			<a href="#" onclick="upeu.cargarUrl('alumnos/curso/nuevo')">+
				Nuevo</a>
		</p>
		<div class="aviso">No se encontraron alumnos</div>
	</c:otherwise>
</c:choose>