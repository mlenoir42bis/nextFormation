<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//recuperation la commune passée en GET
$commune = $_GET["commune"];

//connexion à une base de données
$db_host = "localhost";
$db_name = "ajax";
$db_user = "root";
$db_password = "";

//on utilise mysqli

if (!$conn = mysqli_connect($db_host, $db_user, $db_password, $db_name)) {
    die('erreur connexion bdd');
}

//escaping
$commune = mysqli_real_escape_string($conn, $commune);

$query = "select * from villes_france where ville_nom like '$commune%' limit 0,10";

//execution requete
if (!$result = mysqli_query($conn, $query)) {
    die("erreur execution requete $query");
}

//tableau de resultat
$resultat = [];

//parcourir les resultats de la requete
//on mets les resultats de la requete dans un tableau associatif
while ($val = mysqli_fetch_array($result)) {
    $resultat[] = array("code_postal" => $val["ville_code_postal"],
        "nom" => $val["ville_nom"]);
}

echo json_encode($resultat);
