$(function() {
	
	var arrayBoard = [];
	
	var ships = [];
	
	//ships.push({name: , length:});
	
	var selectedShip = {
		name: "",
			
		get className() {
			return this._name
		},
		set className(name) {
			this._name = name;
		}
	}
	
	var selectedDirection = {
		
	    // UP and DOWN will be the
		// only possible values
		dir: "UP",
			
		get direction() {
			return this._dir
		},
		set direction(dir) {
			this._dir = dir;
		}
	
	}
	
	var $shipImages = $("div#shipDock > img");
	
	// Clicks on enemy board
	$('table#enemyBoard > tbody > tr > td').click(function() {
		
		var gridPosition = $(this).attr("class");
		
		alert(gridPosition);
		
	});
	
	// Change Ship Orientation
	$shipImages.dblclick(function() {
		
		if(selectedDirection.dir == "DOWN") {
			
			$(this).css({
				'transform':          'rotate(0deg)',
				'-ms-transform':      'rotate(0deg)',
				'-moz-transform':     'rotate(0deg)',
				'-webkit-transform':  'rotate(0deg)',
				'-o-transform':       'rotate(0deg)'
			});
			
			selectedDirection.dir = "UP";
		} else {
			
			$(this).css({
				'transform':          'rotate(90deg)',
				'-ms-transform':      'rotate(90deg)',
				'-moz-transform':     'rotate(90deg)',
				'-webkit-transform':  'rotate(90deg)',
				'-o-transform':       'rotate(90deg)'
			});
			
			selectedDirection.dir = "DOWN";
			
		}
		
	});
	
	// Dragging on ship images
	$shipImages.draggable({
		snap: 'table#userBoard > tbody > tr > td',
		snapTolerance: 35,
		snapMode: "both",
		opacity: 0.35,
		cursorAt: { left: 14.5, top: 3},
		drag: function() {
			selectedShip.name = $(this).attr("id");
		}
	});
	
	$("table#userBoard > tbody > tr > td").droppable({
		accept: "img",
		drop: function() {
			$(this).addClass(selectedShip.name);
		}
	});
	
});