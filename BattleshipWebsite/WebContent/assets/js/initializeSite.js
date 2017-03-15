
var $ships = $('div#shipDockImages > img')

//Get the "Go to Game" button and use it to close the start page
var $gameBtn = $(".startBtn");
var $startPage = $("div.startPage");
var $musicBtn = $("#volume");

var audio = document.getElementById('player');

$(function() {
	
	// Reset the ships
	$('button#reset').click(function() {
		
		$ships.each(function() {

			var $this = $(this);
			
			if($this.css('left') != 0 || $this.css('top') != 0) {

				$this.animate({
					left: 0,
					top: 0,
					rotate: 0

				}, 600);
				
			}
			
		});
		
	});
	
	$gameBtn.on("click", function(){
		
		$startPage.css("display", "none");
		
	});
	
	$musicBtn.on("click", function(){
		
		$musicBtn.removeClass();
		
		if(audio.paused) {
			
			audio.play();
			$musicBtn.addClass("musicBtn glyphicon glyphicon-volume-up");
			
		} else {
			
			audio.pause();
			$musicBtn.addClass("musicBtn glyphicon glyphicon-volume-off");
			
		}
		
	});
	
});