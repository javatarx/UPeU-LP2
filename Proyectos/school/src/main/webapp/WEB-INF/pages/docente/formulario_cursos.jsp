<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty docente.cursos}">
		<form action="docentes/${docente.id}/cursos/editar" method="post"
			id="formulario">
			<table class="tabla-cebra">
				<caption>Selecciona los cursos</caption>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Horas</th>
					<th>Creditos</th>
				</tr>
				<c:forEach items="${docente.cursos}" var="c" varStatus="cs">
					<tr>
						<td><input name="id_curso" type="checkbox" ${c.checked}
							value="${c.id}"></td>
						<td>${c.nombre}</td>
						<td>${c.nroHoras}</td>
						<td>${c.nroCreditos}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4"><input type="submit" value="Guardar"></td>
				</tr>
			</table>
		</form>
		<script>
			upeu.enviarFormulario({
				id : 'formulario',
				target : 'contenido'
			});
		</script>
	</c:when>
	<c:otherwise>
		<div class="aviso">No se encontraron cursos</div>
	</c:otherwise>
</c:choose>