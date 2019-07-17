
	$("#search_form").on("submit", function(e){
		e.preventDefault();

		var kw = $("#search_input").val();

		$.ajax({
			url: "http://api.geonames.org/searchJSON",
			data: {
				q: kw,
				username: "gsylvestre",
				maxRows: 20
			},
			dataType: "json",
			type: "GET",
			beforeSend: function(){
				$("#preloader").show();
			}
		})
		.done(function(response){
			var resultsDiv = $("<div>");
			if (response.totalResultsCount == 0){
				resultsDiv.html("Aucun résultat !");
			}
			else {
				for(i in response.geonames){
					resultsDiv.append(
						'<p>' + response.geonames[i].name + 
						' (' + response.geonames[i].fclName + ')</p>');
				}
			}
			$("#search_results").html(resultsDiv);
		})
		.fail(function(response){
			alert("requête échouée");
		})
		.always(function(response){
			$("#preloader").fadeOut();
		});

	});