<?php
/**
 * @package fab_newsletter
 * @version 1.0
 */
/*
Plugin Name: Fab newsletter
Plugin URI: http://fab.com/fab_newsletter
Description: créé un widget newsletter
Author: Fab
Version: 1.0
Author URI: http://fab.com/
*/


//hook déclenché lors de lors de l'activation d'un plugin
register_activation_hook( __FILE__, 'fab_newsletter_activate');

function fab_newsletter_activate(){
global $wpdb; //on va pouvoir utiliser cette variable définie en dehors de notre fonction

$table_name = $wpdb->prefix . "fab_newsletter";

//Attention SQL en MAJ
$sql = "CREATE TABLE IF NOT EXISTS ".$table_name." (
			  id int(11) AUTO_INCREMENT NOT NULL,
			  email varchar(255) NOT NULL,
			  PRIMARY KEY (id));";

//bonne pratique pour les updates	
require_once( ABSPATH . 'wp-admin/includes/upgrade.php' );
dbDelta( $sql );

}

//hook déclenché lorsque que l'on desactive le plugin
//register_deactivation_hook(__FILE__, 'fab_newsletter_deactivate');

function fab_newsletter_deactivate(){
global $wpdb;

$table_name = $wpdb->prefix . "fab_newsletter";

$sql = "DROP TABLE IF EXISTS ".$table_name;

$wpdb->query( $sql );

}



//Creation d'une widget
class Foo_Widget extends WP_Widget {

	/**
	 * Register widget with WordPress.
	 */
	function __construct() {
		parent::__construct(
			'fab_newsletter_widget', // Base ID
			__( 'Fab newsletter widget', 'text_domain' ), // Name
			array( 'description' => __( 'Formulaire d\'inscription pour newsletter', 'text_domain' ), ) // Args
		);
	}

	/**
	 * Front-end display of widget.
	 *
	 * @see WP_Widget::widget()
	 *
	 * @param array $args     Widget arguments.
	 * @param array $instance Saved values from database.
	 */
	public function widget( $args, $instance ) {
		
		$alert="";
		
		//si on a soumis le form
		if(isset($_POST['fab_newsletter_submit']) && isset($_POST['fab_newsletter_email']) && $_POST['fab_newsletter_email']!=""){
			global $wpdb;
			
			$table_name = $wpdb->prefix . "fab_newsletter";
			
			$sql = "INSERT INTO $table_name (email) VALUES (%s)";
			$stmt=$wpdb->prepare($sql, $_POST['fab_newsletter_email']);
			$wpdb->query($stmt);
			$alert= "Inscription prise en compte";
		}
		
		
		$class_css = ! empty( $instance['class_css'] ) ? $instance['class_css'] : '';
		
     	echo $args['before_widget'];
		echo '<div class="'.$class_css.'" >';
		echo '<form action="" method="post" >';
		
		if ( ! empty( $instance['title'] ) ) {
			echo $args['before_title'] . apply_filters( 'widget_title', $instance['title'] ). $args['after_title'];
		}
		
		if($alert!=""){
			echo "<p>$alert</p>";
		}
		
		echo '<input type="text" name="fab_newsletter_email" />';
		echo '<input type="submit" name="fab_newsletter_submit" />';
		echo $args['after_widget'];
		echo '</form>';
		echo "</div>";
		}

	/**
	 * Back-end widget form.
	 *
	 * @see WP_Widget::form()
	 *
	 * @param array $instance Previously saved values from database.
	 */
	public function form( $instance ) {
     	$title = ! empty( $instance['title'] ) ? $instance['title'] : __( 'Saisir un titre', 'text_domain' );
		
		$class_css = ! empty( $instance['class_css'] ) ? $instance['class_css'] : '';
		
		$html = "<p>";
		$html.= '<label for="'.$this->get_field_id( 'title' ).'">Titre</label>';
		$html.= '<input class="widefat" id="'.$this->get_field_id( 'title' ).'" name="'.$this->get_field_name( 'title' ).'" type="text" value="'.esc_attr( $title ).'"/>';
		$html.='</p>';
		
		$html.= "<p>";
		$html.= '<label for="'.$this->get_field_id( 'class_css' ).'">Class css</label>';
		$html.= '<input class="widefat" id="'.$this->get_field_id( 'class_css' ).'" name="'.$this->get_field_name( 'class_css' ).'" type="text" value="'.esc_attr( $class_css ).'"/>';
		$html.='</p>';
		
		echo $html;
	}

	/**
	 * Sanitize widget form values as they are saved.
	 *
	 * @see WP_Widget::update()
	 *
	 * @param array $new_instance Values just sent to be saved.
	 * @param array $old_instance Previously saved values from database.
	 *
	 * @return array Updated safe values to be saved.
	 */
	public function update( $new_instance, $old_instance ) {
		$instance = array();
		$instance['title'] = ( ! empty( $new_instance['title'] ) ) ? strip_tags( $new_instance['title'] ) : '';

		$instance['class_css'] = ( ! empty( $new_instance['class_css'] ) ) ? strip_tags( $new_instance['class_css'] ) : '';
		
		return $instance;
	}

} // class Foo_Widget

// register Foo_Widget widget
function register_foo_widget() {
    register_widget( 'Foo_Widget' );
}
add_action( 'widgets_init', 'register_foo_widget' );


//ajout d'une entrée dans le menu admin
add_action( 'admin_menu', 'register_my_custom_menu_page' );

function register_my_custom_menu_page(){
    add_menu_page( 'Fab newsletter admin page', 'Fab newsletter', 'manage_options', 'fabnewsletter_menu', 'my_custom_menu_page', plugins_url( 'fab_newsletter/icon.png' ), null ); 
}

function my_custom_menu_page(){
	
	global $wpdb;
	
	echo "<div class='wrap' >";
	echo "<h2>Fab newsletter plugin</h2>";
	
	$table_name = $wpdb->prefix . "fab_newsletter";
	
	$sql = "SELECT * FROM $table_name";
	$result = $wpdb->get_results($sql);
	
	$html.='<table class="">';
	
	$html.='<tr><th>Id</th><th>Email</th></tr>';
	
	foreach($result as $row){
		$html.="<tr><td>".$row->id."</td><td>".$row->email."</td></tr>";
	}
	$html.="</table>";

	echo $html;
	
	echo '<br /><a href="'.plugins_url().'/fab_newsletter/export.php" class="button-primary">Export</a>';
	
	echo "</div>";
	
	
	
}
