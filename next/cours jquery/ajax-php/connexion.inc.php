<?php
$host='localhost';
$user='root';
$pw='';
$db='geek_news';
$link = mysqli_connect($host, $user, $pw, $db);
/*utilisation de la méthode connect_error
qui renvoie un message d'erreur si la connexion échoue
*/
if (mysqli_connect_errno()) {
	printf("Échec de la connexion : %s\n", mysqli_connect_error());
	exit();
	}
?>