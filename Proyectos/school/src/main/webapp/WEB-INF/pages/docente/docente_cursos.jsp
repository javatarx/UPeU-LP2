<%@include file="/common/taglibs.jsp"%>
<h1>Cursos de ${docente.nombre}</h1>
<c:choose>
	<c:when test="${not empty docente.cursos}">
		<table class="tabla-cebra">
			<tr>
				<td colspan="5"><a href="#"
					onclick="upeu.cargarUrl('docentes/');">[Atras]</a>&nbsp;&nbsp;&nbsp;<span
					onclick="upeu.cargarUrl('docentes/${docente.id}/cursos/editar')"
					class="icon-pen icon-verde"></span></td>
			</tr>
			<tr>
				<th>#</th>
				<th>Nombre</th>
				<th>Opc</th>
			</tr>
			<c:forEach items="${docente.cursos}" var="c" varStatus="cs">
				<tr>
					<td>${cs.count}</td>
					<td>${c.nombre}</td>
					<td><span
						onclick="upeu.cargarUrl('docentes/${docente.id}/cursos/${c.id}/eliminar')"
						class="icon-minus-alt icon-verde"></span></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<p>
			<span
				onclick="upeu.cargarUrl('docentes/${docente.id}/cursos/editar')"
				class="icon-pen icon-verde"> </span>
		</p>
		<div class="aviso">No se encontraron cursos</div>
	</c:otherwise>
</c:choose>