<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//on recupere l'url et le nom de la radio à ajouter
$latitude = $_POST['latitude'];
$longitude = $_POST['longitude'];


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

//escaping
$latitude = mysqli_real_escape_string($conn, $latitude);
$longitude = mysqli_real_escape_string($conn, $longitude);

$query = "insert into track (latitude, longitude) values ($latitude,$longitude)";


//execution requete
if (!$result = mysqli_query($conn, $query)) {
    die("erreur execution requete $query");
}

echo 'SUCCESS';
