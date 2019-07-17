/*
	//crée un objet
	var movies = {
		"movies": [
			{
				title : "Forrest Gump",
				rating: 8.5,
				poster: "http://imdb.com/img/blabla.jpg"	
			}, 
			{
				title : "Batman",
				rating: 7.5,
				poster: "http://imdb.com/img/batman.jpg"	
			},
			{
				title : "Yo",
				rating: 8.7,
				poster: "http://imdb.com/img/pouf.jpg"	
			}
		]
	};

	//convertit en chaîne
	var movies_json = JSON.stringify(movies, null, 4);

	//affiche le résultat
	$("body").html('<pre>' + movies_json + '</pre>');

	//reconvertit en objet
	var re_movies = JSON.parse( movies_json );

	//ajoute un autre film dans re_movies
	var newMovie = {
		title: "Indiana Jones",
		rating:"7.2",
		poster:"http/...."
	};
	re_movies.movies.push( newMovie );

	console.log( re_movies );
*/



//crée l'objet principal "movies"
//l'objet contient un array vide pour l'instant
var movies = {
	movies: []
};

$.ajax({
	url: "proxy.php"
})
.done(function(response){

	//boucle sur tous les éléments .list_item
	$(response).find(".list .list_item").each(function(){

		//crée un nouvel objet 
		var movie = {};

		//affecte une valeur à la clef title
		//le titre se trouve dans un <a> qui est dans <b> qui est dans un <div class="info">
		movie.title = $(this).find(".info > b > a").html();

		//affecte une valeur à la clef poster
		var poster_img = $(this).find("img.zero-z-index");

		movie.poster = poster_img.attr("src");
		//si l'image est chargée tardivement, on utilise plutôt la valeur de loadlate
		if ( poster_img.hasClass("loadlate") ){
			movie.poster = poster_img.attr("loadlate");
		}

		//affecte une valeur à la clef rating
		movie.rating = $(this).find(".rating-rating .value").html();

		//ajoute l'objet dans l'array de movies
		movies.movies.push(movie);

	});

	console.log( movies );

	//encode l'objet en JSON
	var movies_json = JSON.stringify( movies, null, 4 );

	//puis l'affiche
	//$("body").html( "<pre>" + movies_json + "</pre>" );
});



