var carrierShip = "";
var carrierShipDirection = "DOWN";

var battleShip = "";
var battleShipDirection = "DOWN";

var destroyerShip = "";
var destroyerShipDirection = "DOWN";

var subShip = "";
var subShipDirection = "DOWN";

var pbShip = "";
var pbShipDirection = "DOWN";

var game_id = null;

var turn = null;


$(function() {
	
	// Clicks on enemy board
	$('table#enemyBoard > tbody > tr > td').click(function() {
		
		var gridPosition = $(this).attr("class");
		
		var value = getShotValue(user_id, opponent_id, game_id, gridPosition);
		
		alert(value);
		
		if(opponent_id == "Computer"){
			
			var value = getShotValue(opponent_id, user_id, game_id, gridPosition);
			
			alert(value);
			
		}
		
		
	});
	
	// Clicks on ship images
	$('img').draggable({
		stop: function(event, ui){
			
			var ship = this.id;
			
			//get the offset position of the ship when finished
			var topPosition = $(this).offset().top;
			
			var leftPosition = $(this).offset().left;
			
			var table = document.getElementById("userBoard");
			
			var location = "";
			
			var coord = "";
			
			var rowLength = table.rows.length;
			
			rowLength -= 2;
			//loop thorugh each cell to determine where the ship is the closest to.  Also grabbing the cell diganally to the current cell as a reference point.
			for (var i = 0; i <= rowLength; i++) {
				
				var row = table.rows[i];
				
				var breakForLoop = false;
				
				var colLength = row.cells.length;
				
				colLength -= 2;
				
			   for (var j = 0; j <= colLength; j++) {
				   	
				   var cell = table.rows[i].cells[j];
				   
				   var nextCell = table.rows[i].cells[j];
					   
				   nextCell = table.rows[i + 1].cells[j + 1];
				   	
			       var cellID =  cell.className;
			       
			       cellID = "." + cellID; 
			       
			       var nextCellID =  nextCell.className;
			       
			       nextCellID = "." + nextCellID;
			       
			       var cellPosition;
			       
			       var cellNextPosition;
			       
			       if(cellID != "." && nextCellID != "."){
			    	   
			    	   cellPosition = $(cellID).offset();

				       cellNextPosition = $(nextCellID).offset();
			    	   
			       }
			       //Check if cell IDs are undefined
			       if(cellPosition != undefined  && cellNextPosition != undefined ){			    	   

			    	   if(cellPosition.left < leftPosition && cellPosition.top < topPosition && cellNextPosition.left > leftPosition && cellNextPosition.top > topPosition){
			    		   
			    		   //set the location to the cell ID and break loops
			    		   location = cellID;
			    		   
			    		   coord = i + "~" + j;
			    	   
			    		   breakForLoop = true;
			    	   
			    		   break;

			    	   }
			       }
			         
			   }
			   
			   if(breakForLoop){
				   break;
			   }
			   
			}
			
			//set the location for the ship to fit exactly on the spaces.
			var setlocationOffest = $(location).offset();
			
			//remove the . from the className to get the cell name
			location = location.replace(".", "");
			
			if(setlocationOffest != undefined){
				$(this).offset({ top: setlocationOffest.top, left: setlocationOffest.left })
			}
			
			//set the location for the ship that was moved.
			if(ship == "PBShip"){
				
				pbShip = coord; 
				
			}else if(ship == "CarrierShip"){
				
				carrierShip = coord;
				
			}else if(ship == "Battleship"){
				
				battleShip = coord;
				
			}else if(ship == "DestroyerShip"){
				
				destroyerShip = coord;
				
			}else if(ship == "SubShip"){
				
				subShip = coord;
				
			}

		}
	});
	
	//when the rotate btn is click rotate selected ship
	$(document).on("click", "#btnRotate", function(){
		
		var ship = $("#rotateShip").val();
		
		if(ship == "pb"){
			
			$("#PBShip").rotate(90);
			
			if(pbShipDirection == "DOWN"){
				
				pbShipDirection = "RIGHT";
				
			}else{
				
				pbShipDirection = "DOWN";
				
			}
			
		}else if(ship == "carrier"){
			
			$("#CarrierShip").rotate(90);
			
			if(carrierShipDirection == "DOWN"){
				
				carrierShipDirection = "RIGHT";
				
			}else{
				
				carrierShipDirection = "DOWN";
				
			}
			
		}else if(ship == "battleship"){
			
			$("#Battleship").rotate(90);
			
			if(battleShipDirection == "DOWN"){
				
				battleShipDirection = "RIGHT";
				
			}else{
				
				battleShipDirection = "DOWN";
				
			}
			
		}else if(ship == "destroyer"){
			
			$("#DestroyerShip").rotate(90);
			
			if(destroyerShipDirection == "DOWN"){
				
				destroyerShipDirection = "RIGHT";
				
			}else{
				
				destroyerShipDirection = "DOWN";
				
			}
			
		}else if(ship == "sub"){
			
			$("#SubShip").rotate(90);
			
			if(subShipDirection == "DOWN"){
				
				subShipDirection = "RIGHT";
				
			}else{
				
				subShipDirection = "DOWN";
				
			}
			
		}
	});
	
	//when the rotate btn is click rotate selected ship
	$(document).on("click", "#btnStart", function(){
		user_id = "Wes";
		opponent_id = "Computer";
		var shipsSet = false;
		if(game_id === null){
			
			game_id = startGame(user_id, opponent_id);
			
			if(carrierShip != "" && battleShip != "" && destroyerShip != "" && subShip != "" && pbShip != ""){
				  
				  var carrierShipString = carrierShipDirection + "~" + carrierShip;
				  var pbShipString = pbShipDirection + "~" + pbShip;
				  var battleShipString = battleShipDirection + "~" + battleShip;
				  var destroyerShipString = destroyerShipDirection + "~" + destroyerShip;
				  var subShipString = subShipDirection + "~" + subShip;
				  
				  shipsSet = setShips(user_id, game_id, carrierShipString, battleShipString, destroyerShipString, subShipString, pbShipString);
			}
			
		}else{
			
			if(carrierShip != "" && battleShip != "" && destroyerShip != "" && subShip != "" && pbShip != ""){
				  
				  var carrierShipString = carrierShipDirection + "~" + carrierShip;
				  var pbShipString = pbShipDirection + "~" + pbShip;
				  var battleShipString = battleShipDirection + "~" + battleShip;
				  var destroyerShipString = destroyerShipDirection + "~" + destroyerShip;
				  var subShipString = subShipDirection + "~" + subShip;
				  
				  shipsSet = setShips(user_id, game_id, carrierShipString, battleShipString, destroyerShipString, subShipString, pbShipString);
			}
			
		}
		
		if(shipsSet){
			
			alert("Ships are set");
			
		}else{
			
			alert("Error when setting ships");
			
		}
		
		
	});
	
});

function startGame(user_id, opponent_id){
	$.ajax({
		  method: "POST",
		  url: "intialization",
		  data: { user_id: user_id, opponent_id: opponent_id, size: "10" }
		}).promise()
		  .done(function(data) {
			  game_id = $(data).find("#response").text();
			  game_id = game_id.trim();
			  
			  turn = user_id;
			  
		});
	
	return game_id;
}

function setShips(user_id, game_id, carrierShipString, battleShipString, destroyerShipString, subShipString, pbShipString){
	
	var returnVar = "";
		  $.ajax({
			  method: "POST",
			  url: "setShips",
			  data: { player: user_id, game: game_id, carriership: carrierShipString, battleship: battleShipString, destroyership: destroyerShipString, subship: subShipString, pbship: pbShipString  }
		  })
		  	.done(function(data) {			  		
		  		var response = $(data).find("#response").text();
		  		if(data.indexOf("Error") != -1){
		  			returnVar = false;
		  		}else{
		  			returnVar = true;
		  		}
		  });
	
	return returnVar;
}

function getShotValue(user_id, opponent_id, game_id, gridPosition){
	
	var returnVar = "";
	
	$.ajax({
		  method: "POST",
		  url: "CheckShot",
		  data: { player: user_id, opponent_id: opponent_id, game: game_id, coord: gridPosition }
		})
		  .done(function(data) {
			  var value = $(data).find("#response").text();
			  value = value.trim();
			  if(value == ""){
				  reutrnVar = "miss";
			  }else if(value.indexOf("win") != -1){
				  reutrnVar = value;
			  }else{
				  reutrnVar = "hit";
			  }
		});
	
	return returnVar;
}