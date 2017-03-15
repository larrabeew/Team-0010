<!DOCTYPE html>
<html>
	<head>
		<%@ include file="includes/head.jsp" %>
		<title>Battleship | Home</title>
		<link href="assets/css/index.css" rel="stylesheet" type="text/css">
	</head>
	
	<body>
		
		<h1>Battleship</h1>
		<div class="container">
			<img id="logo"
				 src="assets/images/Battleship_logo.png"
				 alt="Battleship Logo">
		</div>
		
		<main>
			
			<%@ include file="includes/navigation.jsp" %>
		
			<div id="gameContain">
			
				<div class="col-md-6">
					<h2>User</h2>
					<table id="userBoard" class="shadow">						
						<%@ include file="includes/grid.jsp" %>
					</table>
					<div id="userBoardButtons">
						<button class="btn btn-primary">Start</button>
						<button class="btn btn-primary">Reset Ships</button>
					</div>
				</div>

				<div class="col-md-6">
					<h2>Opponent</h2>
					<table id="enemyBoard" class="shadow">
						<%@ include file="includes/grid.jsp" %>
					</table>
				</div>
				
				<div class="col-md-8">
					<div id="shipDock">
						<h3>Ship Dock</h3>
						<div id="shipDockImages">
							<img id="CarrierShip"
								 src="assets/images/ships/CarrierShip.png"
								 alt="Carrier Image">
								 
							<img id="Battleship"
								 src="assets/images/ships/Battleship.png"
								 alt="Battleship Image">
								 
							<img id="DestroyerShip"
								 src="assets/images/ships/DestroyerShip.png"
								 alt="Destroyer Image">
								 
							<img id="SubShip"
								 src="assets/images/ships/SubShip.png"
								 alt="SubShip Image"> 
							
							<img id="PBShip"
								 src="assets/images/ships/PBShip.png"
								 alt="PBShip Image">
						</div>
					</div>
				</div>
				
				<div class="col-md-4">
				
					<div id="gameOutput">
						<h3 id="console">Console</h3>
						
						<div id="gameOutputText">
							<p id=consoleText>Welcome to Battleship!</p>
							<span id="cursor"></span>
						</div>
					</div>
					
				</div>
				
				<div class="col-md-8">
					<h2 id="controlsHead">Controls &amp; Rules</h2>
					
				
				</div>
				
				<div class="col-md-4">
					<div id="highScoreContain">
						<h2 id="highScore">High Scores</h2>
						<div id="highScoreTextContain">
						
							<p id="topDog">1.Jesus</p>
							<p>2.Ronald McDonald</p>
						
						</div>
						
					</div>
	
				</div>

			</div>

			<%@ include file="includes/footer.jsp" %>
			
		</main>
		
		<%@ include file="includes/scripts.jsp" %>

	</body>
</html>