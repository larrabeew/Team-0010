$(function() {
	
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
		
	    // RIGHT and DOWN will be the
		// only possible values
		dir: "DOWN",
			
		get direction() {
			return this._dir
		},
		set direction(dir) {
			this._dir = dir;
		}
	
	}
	
	var $shipImages = $("div#shipDock > div#shipDockImages > img");
	
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
			
			selectedDirection.dir = "RIGHT";
			
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
		
	});
	
	$("table#userBoard td").droppable({
		accept: "img"
	});
	
	// Get the "Go to Game" button and use it to close the start page
	var $gameBtn = $(".startBtn");
	
	var $startPage = $("div.startPage");
	
	$gameBtn.on("click", function(){
		$startPage.css("display", "none");
	});
	
	var $musicBtn = $(".musicBtn");
	
	var $audio = $("#player");
	
	$musicBtn.on("click", function(){
		
		$audio.trigger("pause");
		
	});
	

});