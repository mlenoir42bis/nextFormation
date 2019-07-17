<?php
/**
 * @package fab_plugin
 * @version 1.0
 */
/*
Plugin Name: Fab plugin
Plugin URI: http://fab.com/fab_plugin
Description: c'est un super plugin
Author: Fab
Version: 1.0
Author URI: http://fab.com
*/

//filter => hook lié au contenu
//déclenché avant d'afficher le titre
add_filter('the_title','titreRouge');

function titreRouge($title){
	global $post; // recupérer le post en cours
	
	//si c'est un produit
	if($post->post_type=="next_product"){
		$title.= " $$";
	}
	
	return "<span style='color:red;'>".$title."</span>";
}








