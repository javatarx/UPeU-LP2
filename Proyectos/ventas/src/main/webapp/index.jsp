<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Home</title>
<link href="resources/css/normalize.css" rel="stylesheet">
<link href="resources/css/estilo.css" rel="stylesheet">
</head>
<body>
	<form action="login" method="post">
		<div id="contenedorLogin">
			<p>
				<img alt="Universidad Peruana Union" src="resources/img/logo.png">
			</p>
			<p>
				<label for="username">Usuario:</label> <input type="text"
					name="username" id="username" required autofocus
					placeholder="Ingrese su usuario">
			</p>
			<p>
				<label for="password">Contrase�a:</label> <input type="password"
					name="password" id="password" required
					placeholder="Ingrese su contrase�a">
			</p>
			<p>
				<input type="submit" value="Ingresar">
			</p>
		</div>
	</form>
</body>
</html>