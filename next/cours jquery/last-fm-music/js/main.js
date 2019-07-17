
	var guill_api_key 	= "746422493f9490fae032af34641611f1";
	var last_fm_api_url	= "http://ws.audioscrobbler.com/2.0/";
	var prev_content 	= "";
	var artists_page 	= 1;


	function handleAjaxError(response){
		$("#main_section").html("<p>Un problème est survenu. Erreur #buqovd93.</p>");
	}

	//requête exécutée dès le chargement de la page
	//récupère les 30 meilleurs artistes du moment, en France
	function getArtists(e){
		$.ajax({
			url: last_fm_api_url, 
			data: {
				method: 	"geo.gettopartists",
				country: 	"france",
				limit: 		30,
				page: 		artists_page,
				format: 	"json",
				api_key: 	guill_api_key
			}
		})
		//sur réception des résultats
		.done(showArtists)
		//en cas d'erreur
		.fail(handleAjaxError);
	}


	function getAlbums(e){

		e.preventDefault();

		//récupére le mbid de l'artiste cliqué
		var mbid = $(this).attr("data-mbid");

		//fait une nouvelle requête ajax à last.fm pour récupérer ses meilleurs albums
		$.ajax({
			url: last_fm_api_url, 
			data: {
				method: 	"artist.gettopalbums",
				mbid: 		mbid,	//on passe le mbid OU le nom de l'artiste
				format: 	"json",
				api_key: 	guill_api_key
			}
		})
		.done(showAlbums)
		//en cas d'erreur
		.fail(handleAjaxError);
	}



	function showArtists(response){
		$("#img_ul").empty();

		//on boucle sur les artistes pour les afficher un à un
		for(i in response.topartists.artist){

			var li = $("<li>"); //crée un li

			var a = $("<a>"); //crée un a
			//avec des attributs (pour la prochaine requête ajax, ce sera utile)
			a.attr("data-name", response.topartists.artist[i]['name']);
			a.attr("data-mbid", response.topartists.artist[i]['mbid']);
			a.attr("href", "#"+response.topartists.artist[i]['mbid']);

			var img = $("<img>"); //crée l'image
			img.attr("src", response.topartists.artist[i].image[2]['#text'] );

			//crée la balise qui sera animée au survol (cachée par défaut)
			var p = $("<p>");
			p.addClass("artist-name");
			p.html(response.topartists.artist[i]['name']);

			//imbrique tout ça
			a.html(img);
			li.html(a);
			li.append(p);

			//injecte dans le dom
			$("#img_ul").append(li);
		}
	}

	function showAlbums(response){

		prev_content = $("#img_ul").html();
		$("#img_ul").empty();

		//on boucle sur les albums pour les afficher un à un
		for(i in response.topalbums.album){

			var li = $("<li>"); //crée un li

			var a = $("<a>"); //crée un a
			//avec des attributs (pour la prochaine requête ajax, ce sera utile)
			a.attr("data-name", response.topalbums.album[i]['name']);
			a.attr("data-mbid", response.topalbums.album[i]['mbid']);
			a.attr("href", "#" +response.topalbums.album[i]['mbid']);

			var img = $("<img>"); //crée l'image
			img.attr("src", response.topalbums.album[i].image[2]['#text'] );

			//crée la balise qui sera animée au survol (cachée par défaut)
			var p = $("<p>");
			p.addClass("album-name");
			p.html(response.topalbums.album[i]['name']);

			//imbrique tout ça
			a.html(img);
			li.html(a);
			li.append(p);

			//injecte dans le dom
			$("#img_ul").append(li);
		}
	}

	//event listeners de pagination
	$("#next_btn").on("click", function(e){
		artists_page++;
		getArtists();
	});
	$("#prev_btn").on("click", function(e){
		artists_page--;
		getArtists();
	});
	
	//affiche une div portant le nom de l'artiste
	$("#img_ul").on("mouseenter", "li", function(){
		$(this).find("p").animate({"height":0});
	});

	//fait disparaitre la div du nom sur événement "mouseleave"
	$("#img_ul").on("mouseleave", "li", function(){
		$(this).find("p").stop(true).animate({"height":126});
	});

	//sur clic des artistes...
	$("#img_ul").on("click", "a", getAlbums);


	$("#back_btn").on("click", function(){
		$("#img_ul").html(prev_content);
	})


	getArtists();