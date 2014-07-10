<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Bienvenido al sistema</title>
<link rel="stylesheet" type="text/css" href="static/css/normalize.css">
<link rel="stylesheet" type="text/css" href="static/css/estilo.css">
<link rel="stylesheet" type="text/css" href="static/css/iconos.css">
<script type="text/javascript" src="static/js/vendor/jquery.js"></script>
<script type="text/javascript" src="static/js/vendor/jquery.form.js"></script>
</head>
<body>
	<div id="contenedor">
		<header>
			<h1>SchoolSystem</h1>
		</header>
		<div id="main">
			<nav>
				<ul>
					<li onclick="upeu.cargarUrl('alumnos/');"><span class="icon-pin">&nbsp;</span>Alumnos</li>
					<li onclick="upeu.cargarUrl('docentes/');"><span class="icon-user">&nbsp;</span>Docentes</li>
					<li onclick="upeu.cargarUrl('cursos/');"><span class="icon-book">&nbsp;</span>Cursos</li>
					<li onclick="location.href='logout'"><span class="icon-bolt">&nbsp;</span>Salir</li>
				</ul>
			</nav>
			<section>
				<article id="contenido">
					<img alt="Universidad Peruana Union" width="250"
						src="static/img/logo.png">
				</article>
			</section>
		</div>
	</div>
	<script type="text/javascript" src="static/js/main.js"></script>
</body>
</html>