<!DOCTYPE html>
<html>
	<head>
	    <%@ include file="includes/head.jsp" %>
	    <title>Battleship | Instructions</title>
			<link href="assets/css/index.css" rel="stylesheet" type="text/css">
			<link href="assets/css/instructions.css" rel="stylesheet" type="text/css">
		</head>
	<body>
		<div class="container">
				<div id="logoImage">
				</div>
		</div>
		
		<main>
	
		<%@ include file="includes/navigation.jsp" %>
		
		<div id="instText">	
			<h2 id="inst">Object of the Game</h2>
			<p>Be the first to sink all 5 of your opponent's ships.</p>
			
			<h2 id="inst">Prepare For Battle</h2>
			<p>You and your opponent sit so neither of you can see the others ocean grid.</p>
			<p>Secretly place your fleet of 5 ships on your ocean grid. Your opponent does the same</p>
			<p>Rules for placing ships:</p>
			<ul>
				<li>Place each ship in any horizontal or vertical position, but not diagonally.</li>
				<li>Do not place your ship so that any part of it overlaps letters, number, the edges of the grid or another ship.</li>
				<li>Do not change the position of any of the ships once the game has begun.</li>
			</ul>
			
			<h2 id="inst">How To Play</h2>
			<p>Decide who will go first. You and your opponent will alternate turns, calling out one shot per turn
			to try to hit the each other's ships.</p>
			
			<h3>Call Your Shot</h3>
			<p>On your turn, pick a target hole on your target grid and call out its location by letter and number.
			Each target hole has a letter-number coordinate that corresponds to the same coordinate on your opponents 
			ocean grid. To determine each coordinate find its corresponding letter on the left side of the target grid 
			and its number on the top of the grid</p>
			<p>When you call a shot your opponent must tell you whether your shot was a hit for a miss.</p>
			
			<h3>Its a Hit!</h3>
			<p>If you call out a shot location that is occupied by a ship on your opponents ocean grid, your shot is a hit!
			Your opponent tells you which ship you have it (cruiser, submarine, etc.). Record your hit by placing a red mark in 
			the corresponding target hole on your target grid. Your opponent place a red mark in the corresponding hole of the 
			ship that you have it on his or her ocean grid.</p>
			
			<h3>Its a Miss!</h3>
			<p>If you call out a shot location that is not occupied by a ship on your opponents ocean grid, your shot is a miss!
			Record your miss by placing a white mark in the corresponding target hole on your target grid so you wont call this shot again.
			It is not necessary for players to record each other's miss with white marks on there ocean grid.</p>
			<p>Play continues in this manner, with you and your opponent calling one shot per turn.</p>
			
			<h2 id="inst">Sinking a Ship</h2>
			<p>Once all the holes of a ship are filled with red marks, it has been sunk. 
			The owner of the ship must announce which ship was sunk.</p>
			
			<h2 id="inst">Winning the Game</h2>
			<p>If you are the first player to sink your opponent's entire fleet of 5 ships, you win the game.</p>
			
		</div>
		</main>
	</body>
</html>