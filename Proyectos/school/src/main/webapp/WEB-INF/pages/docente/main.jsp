<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty lp}">
		<table class="tabla-cebra">
			<caption>Lista de Docentes</caption>
			<tr>
				<td colspan="5"><a href="#"
					onclick="upeu.cargarUrl('docentes/nuevo')">+ Nuevo</a></td>
			</tr>
			<tr>
				<th>#</th>
				<th>Paterno</th>
				<th>Materno</th>
				<th>Nombre</th>
				<th>Opc</th>
			</tr>
			<c:forEach items="${lp}" var="p" varStatus="ps">
				<tr>
					<td>${ps.count}</td>
					<td>${p.apePat}</td>
					<td>${p.apeMat}</td>
					<td>${p.nombre}</td>
					<td><span title="Clic para editar"
						onclick="upeu.cargarUrl('docentes/${p.id}')"
						class="icon-pen icon-verde"></span>&nbsp;&nbsp;<span
						title="Clic para ver cursos"
						onclick="upeu.cargarUrl('docentes/${p.id}/cursos')"
						class="icon-book-alt2 icon-verde"></span></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<p>
			<a href="#" onclick="upeu.cargarUrl('docentes/nuevo')">+ Nuevo</a>
		</p>
		<div class="aviso">No se encontraron docentes</div>
	</c:otherwise>
</c:choose>