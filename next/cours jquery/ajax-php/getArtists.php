<?php
require_once('connexion.inc.php');

$requete = "SELECT * FROM `post`,category WHERE category.category_id = post.category_id AND category_name='javascript'";

$resultat = mysqli_query($link, $requete);
$posts = array();
while ($ligne = mysqli_fetch_assoc($resultat)) {
	$posts[] = $ligne;
}
print_r($posts);
mysqli_close($link);

function sendJson($array){
	header("Content-Type: application/json");
	$json_artists = json_encode($array);
	echo $json_artists;
	die();
}

sendJson($posts);
	