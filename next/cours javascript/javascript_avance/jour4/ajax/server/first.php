<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//recupere le prenom passé en GET
//les variables en PHP commencent toujours par un $
$prenom = $_GET["prenom"];

echo "Salut ".$prenom; // . => concatenation en PHP

