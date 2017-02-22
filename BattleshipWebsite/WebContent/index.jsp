<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport"
			  content="width=device-width, 
			  		   initial-scale=1.0">
		<title>Battleship | Home</title>
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="assets/css/base.css" rel="stylesheet" type="text/css">
		<link href="assets/css/index.css" rel="stylesheet" type="text/css">
		
	</head>
	<body>
		<h1>Battleship</h1>
		<div class="container">
			<div id="logoImage">
			</div>
		</div>
		
		<main>
			
			<nav class="navbar navbar-default">
	  			<ul class="nav navbar-nav">
					<li>
						<a href="#">Home</a>
					</li>
					<li>
						<a href="#">About</a>
					</li>
					<li>
						<a href="#">Contact Us</a>
					</li>
				</ul>
			</nav>
		

			<div id="canvasContain">
				<canvas id="gameCanvas">
				
				</canvas>
			</div>
			<div class="row">
				<div class="col-md-4">
					<aside id="playHighScore">
						<h2 id="highScore"></h2>
						
						
						
					</aside>
				</div>
				<div class="col-md-8">
					<div id="userControls">
				
					</div>
				</div>
			</div>
			
			
		</main>
		<script
			  src="https://code.jquery.com/jquery-3.1.1.min.js"
			  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
			  crossorigin="anonymous"></script>
	</body>
</html>