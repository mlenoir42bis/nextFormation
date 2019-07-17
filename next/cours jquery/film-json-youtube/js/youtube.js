

	for(i in movies.movies){

		var movie_container = $("<div>").addClass("movie");
		var poster = $("<img>").attr("src", movies.movies[i].poster)
						.attr("alt", movies.movies[i].title);

		movie_container.append( poster );
		movie_container.append( '<h4>'+movies.movies[i].title+'</h4>' );
		movie_container.append( movies.movies[i].rating );

		$("#movies_list").append( movie_container );

	}


	//mise sous écoute d'éléments ajoutés dynamiquement en JS
	$("#movies_list").on("click", "img", function(){

		var clicked_title = $(this).attr("alt");
		
		$.ajax({
			url: "https://www.googleapis.com/youtube/v3/search",
			data: {
				q	: clicked_title + " official trailer",
				part: "snippet", //"id" pour moins de détails
				key : "AIzaSyCGnKO0uiCknVKk1ITzl_8-P5okcUVgRlM"
			}
		})
		.done(function(response){
			var videoId = response.items[0].id.videoId;
			$("#ytplayer").attr("src", 
				"https://www.youtube.com/embed/" + videoId + "?autoplay=1&modestbranding=1");
		});

	});