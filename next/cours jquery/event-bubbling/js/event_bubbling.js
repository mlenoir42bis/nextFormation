/*
**pour mettre sous écoute des éléments qui ont été créés dynamiquement**

live(): à ne pas utiliser pour la performance

LE PROBLÈME : 
ne fonctionnera pas sur les div créées dynamiquement en JS
mais fonctionnera sur celles présentes au chargement de la page, en HTML
*/
$("div").on("click", function(){
	console.log("div cliquée");
});

/*
LA SOLUTION
grâce au concept d'event bubbling...
on met sous écoute non pas les éléments qui nous intéresse, mais un parent.
Ce parent doit être présent au chargement de la page. 
(Au pire, body est toujours présent.)
on essaie d'utiliser le parent commun le plus proche des éléments qui nous intéressent. 
*/
$("#wrapper").on("click", "div", function(){
	console.log("div cliquée");
});

var newDiv = $("<div>");
$("#wrapper").append(newDiv);