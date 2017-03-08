$(function() {
	
	// Clicks on enemy board
	$('table#enemyBoard > tbody > tr > td').click(function() {
		
		var gridPosition = $(this).attr("class");
		
		alert(gridPosition);
		
	});
	
	// Clicks on ship images
	//$('').click() {
		
	//}
	
	// Clicks on user board
	//$('').click() {
		
	//}
	
});