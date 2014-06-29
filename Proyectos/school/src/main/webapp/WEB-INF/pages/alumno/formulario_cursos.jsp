<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty cursos}">
		<form action="alumnos/curso/editar" method="post" id="formulario">
			<table class="tabla-cebra">
				<caption>Selecciona los cursos</caption>
				<c:forEach items="${cursos}" var="c" varStatus="cs">
					<tr>
						<td><input name="id_curso" type="checkbox" ${c.checked}
							value="${c.id}"></td>
						<td>${c.nombre}</td>
						<td>${c.nroHoras}</td>
						<td>${c.nroCreditos}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4"><input type="hidden" name="id_alumno"
						value="${id_alumno}"> <input type="submit" value="Guardar">
					</td>
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