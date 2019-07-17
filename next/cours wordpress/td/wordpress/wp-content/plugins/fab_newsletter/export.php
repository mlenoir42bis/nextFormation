<?php
require_once('../../../wp-load.php'); //necessaire pour utiliser l'api wordpress

global $wpdb;

$table_name = $wpdb->prefix . "fab_newsletter";
	
$sql = "SELECT * FROM $table_name";
$result = $wpdb->get_results($sql);

$str = "id;email\n"; // entete du fichier csv

foreach($result as $row){
	$str.= $row->id.";".$row->email."\n";
}

//on set les headers
header("Content-Type: application/csv") ;
header("Content-Disposition: attachment; filename=export.csv"); //force le téléchargement

echo $str;


