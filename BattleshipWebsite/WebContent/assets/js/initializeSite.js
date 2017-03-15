
//Get the "Go to Game" button and use it to close the start page
var $gameBtn = $(".startBtn");
var $startPage = $("div.startPage");
var $musicBtn = $("#volume");

var audio = document.getElementById('player');

$(function() {
	
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