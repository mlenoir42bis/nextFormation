<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//definit un tableau
$tableau = [];

//comme push, ajoute un element à la fin du tableau
$tableau[] = array("nom" => "bouvier", "prenom" => "fabien"); //tableau associatif
$tableau[] = array("nom" => "white", "prenom" => "walter"); //tableau associatif
$tableau[] = array("nom" => "goodman", "prenom" => "saul"); //tableau associatif

//pour recuperer les infos
//$tableau[0]['nom'] => le nom de la premiere personne
//$tableau[1]['prenom'] =>le prenom de la deuxieme personne

//encode le tableau en json, et on l'affiche
echo json_encode($tableau);
        