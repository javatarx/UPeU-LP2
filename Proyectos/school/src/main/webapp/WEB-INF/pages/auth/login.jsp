<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width" />
<title>Ingreso al sistema - Universidad Peruana Uni&oacute;n</title>
<link href="static/css/normalize.css" rel="stylesheet">
<link href="static/css/estiloLogin.css" rel="stylesheet">
</head>
<body>

	<section>
		<article id="contenedorLogin">
			<form name="f" action="j_spring_security_check" method="post">
				<p>
					<input id="username" name="j_username" type="text"
						placeholder="Nombre de Usuario" autofocus="autofocus">
				</p>
				<p>
					<input id="password" name="j_password" type="password"
						placeholder="Contrase&ntilde;a">
				</p>
				<p>
					<input name="submit" type="submit" value="Ingresar" />
					<c:if test="${error}">
						<div>
							<p class="msg-error">${error}</p>
						</div>
					</c:if>
				</p>
			</form>
		</article>
	</section>
</body>
</html>