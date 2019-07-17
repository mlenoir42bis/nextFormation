<?php

if ($_SERVER['HTTP_HOST'] == "localhost") {
    //localhost
    $db_host = "localhost";
    $db_name = "news";
    $db_user = "root";
    $db_password = "";
} else {
    //olympe
    $db_host = "sql2.olympe.in";
    $db_name = "yf8j6z13";
    $db_user = "yf8j6z13";
    $db_password = "skate31";
}

//on utilise mysqli
if (!$conn = mysqli_connect($db_host, $db_user, $db_password, $db_name)) {
    die('erreur connexion bdd');
}

$query = "delete from track";

//execution requete
if (!$result = mysqli_query($conn, $query)) {
    die("erreur execution requete $query");
}

echo 'SUCCESS';
