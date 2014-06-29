<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty lp}">
		<table class="tabla-cebra">
			<caption>Lista de Cursos</caption>
			<tr>
				<td colspan="5"><a href="#"
					onclick="upeu.cargarUrl('cursos/nuevo')">+ Nuevo</a></td>
			</tr>
			<tr>
				<th>#</th>
				<th>Nombre</th>
				<th>Creditos</th>
				<th>Horas</th>
				<th>Opc</th>
			</tr>
			<c:forEach items="${lp}" var="p" varStatus="ps">
				<tr>
					<td>${ps.count}</td>
					<td>${p.nombre}</td>
					<td>${p.nroCreditos}</td>
					<td>${p.nroHoras}</td>
					<td><a href="#"
						onclick="upeu.cargarUrl('cursos/editar?id=${p.id}')">[Edit]</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<p>
			<a href="#" onclick="upeu.cargarUrl('cursos/nuevo')">+ Nuevo</a>
		</p>
		<div class="aviso">No se encontraron cursos</div>
	</c:otherwise>
</c:choose>