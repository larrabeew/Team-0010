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
	
	user_id = 1;
	opponent_id = "Computer";
	
	game_id = startGame(user_id, opponent_id);
	
	
	// Clicks on enemy board
	$('table#enemyBoard > tbody > tr > td').click(function() {
		
		var gridPosition = $(this).attr("class");
		var value = null;
		value = getShotValue(user_id, opponent_id, game_id, gridPosition);

		var valueOpp = ""
		//if(opponent_id == "Computer"){
			//valueOpp = getShotValue(opponent_id, user_id, game_id, gridPosition);			
		//}
		
		
	});
	
	var $shipImages = $("div#shipDock > img");
	
	// Clicks on ship images
	$shipImages.draggable({
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
	$shipImages.dblclick(function(){
		
		var ship = $(this);
		
		var direction = "DOWN";
		
		//set the location for the ship that was moved.
		if(ship == "PBShip"){
			
			if(pbShipDirection == "DOWN") {
				
				$(this).css({
					'transform':          'rotate(0deg)',
					'-ms-transform':      'rotate(0deg)',
					'-moz-transform':     'rotate(0deg)',
					'-webkit-transform':  'rotate(0deg)',
					'-o-transform':       'rotate(0deg)'
				});
				
				direction = "RIGHT";
			} else {
				
				$(this).css({
					'transform':          'rotate(90deg)',
					'-ms-transform':      'rotate(90deg)',
					'-moz-transform':     'rotate(90deg)',
					'-webkit-transform':  'rotate(90deg)',
					'-o-transform':       'rotate(90deg)'
				});
				
				direction = "DOWN";
				
			}
			
			pbShipDirection = direction; 
			
		}else if(ship == "CarrierShip"){
			
			if(carrierShipDirection == "DOWN") {
				
				$(this).css({
					'transform':          'rotate(0deg)',
					'-ms-transform':      'rotate(0deg)',
					'-moz-transform':     'rotate(0deg)',
					'-webkit-transform':  'rotate(0deg)',
					'-o-transform':       'rotate(0deg)'
				});
				
				direction = "RIGHT";
			} else {
				
				$(this).css({
					'transform':          'rotate(90deg)',
					'-ms-transform':      'rotate(90deg)',
					'-moz-transform':     'rotate(90deg)',
					'-webkit-transform':  'rotate(90deg)',
					'-o-transform':       'rotate(90deg)'
				});
				
				direction = "DOWN";
				
			}
			
			carrierShipDirection = direction;
			
		}else if(ship == "Battleship"){
			
			if(battleShipDirection == "DOWN") {
				
				$(this).css({
					'transform':          'rotate(0deg)',
					'-ms-transform':      'rotate(0deg)',
					'-moz-transform':     'rotate(0deg)',
					'-webkit-transform':  'rotate(0deg)',
					'-o-transform':       'rotate(0deg)'
				});
				
				direction = "RIGHT";
			} else {
				
				$(this).css({
					'transform':          'rotate(90deg)',
					'-ms-transform':      'rotate(90deg)',
					'-moz-transform':     'rotate(90deg)',
					'-webkit-transform':  'rotate(90deg)',
					'-o-transform':       'rotate(90deg)'
				});
				
				direction = "DOWN";
				
			}
			
			battleShipDirection = direction;
			
		}else if(ship == "DestroyerShip"){
			
			if(destroyerShipDirection == "DOWN") {
				
				$(this).css({
					'transform':          'rotate(0deg)',
					'-ms-transform':      'rotate(0deg)',
					'-moz-transform':     'rotate(0deg)',
					'-webkit-transform':  'rotate(0deg)',
					'-o-transform':       'rotate(0deg)'
				});
				
				direction = "RIGHT";
			} else {
				
				$(this).css({
					'transform':          'rotate(90deg)',
					'-ms-transform':      'rotate(90deg)',
					'-moz-transform':     'rotate(90deg)',
					'-webkit-transform':  'rotate(90deg)',
					'-o-transform':       'rotate(90deg)'
				});
				
				direction = "DOWN";
				
			}
			
			destroyerShipDirection = direction;
			
		}else if(ship == "SubShip"){
			
			if(destroyerShipDirection == "DOWN") {
				
				$(this).css({
					'transform':          'rotate(0deg)',
					'-ms-transform':      'rotate(0deg)',
					'-moz-transform':     'rotate(0deg)',
					'-webkit-transform':  'rotate(0deg)',
					'-o-transform':       'rotate(0deg)'
				});
				
				direction = "RIGHT";
			} else {
				
				$(this).css({
					'transform':          'rotate(90deg)',
					'-ms-transform':      'rotate(90deg)',
					'-moz-transform':     'rotate(90deg)',
					'-webkit-transform':  'rotate(90deg)',
					'-o-transform':       'rotate(90deg)'
				});
				
				direction = "DOWN";
				
			}
			
			subShipDirection = direction;
			
		}
	});
	
	//when the start btn is click intiate game ship
	$(document).on("click", "#btnStart", function(){
		
		var shipsSet = false;
			
			if(carrierShip != "" && battleShip != "" && destroyerShip != "" && subShip != "" && pbShip != ""){
				  
				  var carrierShipString = carrierShipDirection + "~" + carrierShip;
				  var pbShipString = pbShipDirection + "~" + pbShip;
				  var battleShipString = battleShipDirection + "~" + battleShip;
				  var destroyerShipString = destroyerShipDirection + "~" + destroyerShip;
				  var subShipString = subShipDirection + "~" + subShip;
				  shipsSet = setShips(user_id, game_id, carrierShipString, battleShipString, destroyerShipString, subShipString, pbShipString);
			}else{
				alert("Please set ships");
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
			  alert("Game started");
			  return game_id;
			  
		});
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
		  			alert("Error when setting ships");
		  			return returnVar;
		  		}else{
		  			returnVar = true;
		  			alert("Ships are set");
		  			return returnVar;
		  		}
		  });
	
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
				  returnVar = "miss";
			  }else if(value.indexOf("win") != -1){
				  returnVar = value;
			  }else{
				  returnVar = "hit";
			  }
			  alert(user_id + " shot was " + returnVar);
			  
			  if(opponent_id == "Computer" || opponent_id == "0"){
				  
				  $.ajax({
					  method: "POST",
					  url: "CheckShot",
					  data: { player: opponent_id, opponent_id: user_id, game: game_id, coord: gridPosition }
					})
					  .done(function(data) {
						  var value = $(data).find("#response").text();
						  value = value.trim();
						  if(value == ""){
							  returnVar = "miss";
						  }else if(value.indexOf("win") != -1){
							  returnVar = value;
						  }else{
							  returnVar = "hit";
						  }
						  alert("Computer shot was " + returnVar);
					});
			  }
		});
	
	
}