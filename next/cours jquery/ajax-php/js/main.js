
	$.ajax({
		url: "getArtists.php"
	})
	.done(function(response){
		console.log(response);	
	});