<?php

//ajoute la fonctionnalité image à la une
add_theme_support( 'post-thumbnails' ); 

//definit une zone de menu pour le theme
//=>apparaitre la page menu dans l'admin apparene/menu
register_nav_menus( array(
	'primary'   => __( 'Navbar bootstrap', 'fab_theme' ),
) );

//recupere le nom du menu en fonction d'une location
function getMenuName($location){
	if(!isset($location) || $location==""){
		return;
	}
	
	$theme_locations = get_nav_menu_locations();
	if(!isset($theme_locations[$location])){
		return;
	}
	
	$menu_obj = get_term( $theme_locations[$location], 'nav_menu' );
	$menu_name = $menu_obj->name;
	
	return $menu_name;
}

//ajout d'une widget area
function myfooter_widgets_init() {

	register_sidebar( array(
		'name' => 'Mon Footer',
		'id' => 'footer_1',
		'description'   => 'Mon super footer qui est cool',
		'before_widget' => '<div class="col-lg-4">',
		'after_widget' => '</div>',
		'before_title' => '<h4>',
		'after_title' => '</h4>',
	) );
}
add_action( 'widgets_init', 'myfooter_widgets_init' );


function carousel($nb){

	if(!isset($nb) || $nb==""){
		$nb=3;
	}
	
	$html='<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">';
	
	//indicators
	$html.='<ol class="carousel-indicators">';
	for($i=0;$i<$nb;$i++){
		//class active pour le premier
		if($i==0){
			$class='class="active"';
		}else{
			$class='';
		}
		$html.='<li data-target="#carousel-example-generic" data-slide-to="'.$i.'" '.$class.'></li>';
	}
	$html.='</ol>';
	
	//wrapper for slides
	$html.='<div class="carousel-inner" role="listbox">';
	
	$recentPosts = getRecentPosts($nb);
	
	$cpt=0;
	foreach($recentPosts as $article){
		if($cpt==0){
			$class='active';
		}else{
			$class='';
		}
		$html.='<div class="item '.$class.'">';
		$html.= get_the_post_thumbnail($article['ID'],'large');
		$html.='<div class="carousel-caption">';
		$html.='<h3>'.$article["post_title"].'</h3>';
		$html.='</div>';
		$html.='</div>';
		$cpt++;
	}
	
	$html.='</div>';
	
	
	//controls
	$html.=' <!-- Controls -->
		  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		  </a>';
	
	$html.='</div>';//fin div carousel
	
	return $html;

}

function getRecentPosts($nb){

	$args = array(
		'numberposts' => $nb,
		'orderby' => 'post_date',
		'order' => 'DESC',
		'post_type' => 'post');

	return wp_get_recent_posts($args);	
	
}
/*
function select_template($template){
global $post;

if($post->post_type=='page'){
	if(is_front_page()){
		$template = dirname( __FILE__ ) . '/page.php';
	}else{
		$template = dirname( __FILE__ ) . '/page.php';
	}
}

return $template;
}

add_filter( "page_template", "select_template" );

*/