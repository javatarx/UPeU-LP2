<%@include file="/common/taglibs.jsp"%>
<h1>Cursos de ${docente.nombre}</h1>
<c:choose>
	<c:when test="${not empty docente.cursos}">
		<table class="tabla-cebra">
			<tr>
				<td colspan="5"><a href="#"
					onclick="upeu.cargarUrl('docentes');">[Atras]</a>&nbsp;&nbsp;&nbsp;<a
					href="#"
					onclick="upeu.cargarUrl('docentes/curso/editar?id=${docente.id}')">Editar
						Cursos</a></td>
			</tr>
			<tr>
				<th>#</th>
				<th>Nombre</th>
				<th>Horas</th>
				<th>Creditos</th>
				<th>Opc</th>
			</tr>
			<c:forEach items="${docente.cursos}" var="c" varStatus="cs">
				<tr>
					<td>${cs.count}</td>
					<td>${c.nombre}</td>
					<td>${c.nroHoras}</td>
					<td>${c.nroCreditos}</td>
					<td><a href="#"
						onclick="upeu.cargarUrl('docentes/curso/eliminar?id_docente=${docente.id}&id_curso=${c.id}')">[Elim]</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<p>
			<a href="#" onclick="upeu.cargarUrl('docentes/curso/nuevo')">+
				Nuevo</a>
		</p>
		<div class="aviso">No se encontraron cursos</div>
	</c:otherwise>
</c:choose>