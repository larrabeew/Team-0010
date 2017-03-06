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


$(function() {
	
	// Clicks on enemy board
	$('table#enemyBoard > tbody > tr > td').click(function() {
		
		var gridPosition = $(this).attr("class");
		
		alert(gridPosition);
		
	});
	
	// Clicks on ship images
	$('img').draggable({
		stop: function(event, ui){
			
			var ship = this.id;

			var topPosition = $(this).offset().top;
			
			var leftPosition = $(this).offset().left;
			
			var table = document.getElementById("userBoard");
			
			var location = "";
			
			var rowLength = table.rows.length;
			
			rowLength -= 2;
			
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
			       
			       if(cellPosition != undefined  && cellNextPosition != undefined ){			    	   

			    	   if(cellPosition.left < leftPosition && cellPosition.top < topPosition && cellNextPosition.left > leftPosition && cellNextPosition.top > topPosition){
			    	   
			    		   location = cellID;
			    	   
			    		   breakForLoop = true;
			    	   
			    		   break;

			    	   }
			       }
			         
			   }
			   
			   if(breakForLoop){
				   break;
			   }
			   
			}
			
			var setlocationOffest = $(location).offset();
			
			location = location.replace(".", "");
			
			if(setlocationOffest != undefined){
				$(this).offset({ top: setlocationOffest.top, left: setlocationOffest.left })
			}
			
			if(ship == "PBShip"){
				
				pbShip = location; 
				
			}else if(ship == "CarrierShip"){
				
				carrierShip = location;
				
			}else if(ship == "Battleship"){
				
				battleShip = location;
				
			}else if(ship == "DestroyerShip"){
				
				destroyerShip = location;
				
			}else if(ship == "SubShip"){
				
				subShip = location;
				
			}

		}
	});
		
	//}
	
	// Clicks on user board
	//$('').click() {
		
	//}
	
});