<?php
//ajout d'un custom type

//hook init
add_action( 'init', 'create_post_type' );

function create_post_type() {
  register_post_type( 'next_product',
    array(
      'labels' => array(
        'name' => __( 'Produits' ),
        'singular_name' => __( 'Produit' )
      ),
	  'menu_position' => 2,
	  'menu_icon' => get_template_directory_uri().'-child/img/product.png',
	  'public' => true,
      'has_archive' => true,
    )
  );
}


//ajout d'une widget area
function myfooter_widgets_init() {

	register_sidebar( array(
		'name' => 'Mon Footer',
		'id' => 'footer_1',
		'description'   => 'Mon super footer qui est cool',
		'before_widget' => '<div class="mycolumn">',
		'after_widget' => '</div>',
		'before_title' => '<h2>',
		'after_title' => '</h2>',
	) );
}
add_action( 'widgets_init', 'myfooter_widgets_init' );