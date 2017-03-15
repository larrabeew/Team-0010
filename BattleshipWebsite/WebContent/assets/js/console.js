$(function() {
	
	var $cursor = $('span#cursor');
	
	function cursor() {
		
		$cursor.animate({backgroundColor: '#fff'}, 600, 'linear',function(){
			
			$cursor.animate({backgroundColor: '#000'}, 400, 'linear',function() {
				
				//RECURSION!!!!!
				cursor();
				
			});
		});
		
	}
	
	cursor();
	
});