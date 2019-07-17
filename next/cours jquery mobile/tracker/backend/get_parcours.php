<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

if ($_SERVER['HTTP_HOST'] == "localhost"){
    //localhost
    $db_host = "localhost";
    $db_name = "news";
    $db_user = "root";
    $db_password = "";
}
else{
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

$query = "select * from track";

//execution requete
if (!$result = mysqli_query($conn, $query)) {
    die("erreur execution requete $query");
}

//tableau de resultat
$resultat = [];

//parcourir les resultats de la requete
//on mets les resultats de la requete dans un tableau associatif
while ($val = mysqli_fetch_array($result)) {
    $resultat[] = array("id" => $val["id"],
        "longitude" => $val["longitude"],
        "latitude" => $val["latitude"],
        );
}

echo json_encode($resultat);
