<!doctype html>
<html id="html">
	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="<?php echo get_template_directory_uri(); ?>/style.css" />
		<?php wp_head(); ?>

		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
		<title><?php bloginfo('name'); ?></title>
	</head>

<body>

	<div class="container-fluid">
			<header class="container my_header">
					<div class="row" >
						<nav class="navbar navbar-default" >
						  <div class="container-fluid">
							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header">
							  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							  </button>
							  <a class="navbar-brand" href="<?php echo esc_url(home_url( '/' ));?>"><?php bloginfo('name'); ?></a>
							</div>

							<!-- Collect the nav links, forms, and other content for toggling -->
							<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							  <ul class="nav navbar-nav">
								
								<?php 
								
								$menu_name = getMenuName('primary');
								
								$menu_items = wp_get_nav_menu_items($menu_name, $options['menu_choice'] );
								//on reconstruit un tableau avec hierarchie
								$tab_res = array();
								foreach ( (array) $menu_items as $key => $menu_item ) {
									$id = $menu_item->ID;
									$title = $menu_item->title;
									$url = $menu_item->url;
									$parent = $menu_item->menu_item_parent;
									
									if($parent==0){
										$tab_res[$id][]= array('title' => $title, 'url' => $url);
									}else{
										$tab_res[$parent][] = array('title' => $title, 'url' => $url);
									}
									
								}
								
								//on fabrique les liens
								$html='';
								foreach($tab_res as $menu){
								
									if(count($menu)==1){
										$html.='<li><a href="'.$menu[0]['url'].'">'.$menu[0]['title'].'</a></li>';
									}else{
										$html.='<li class="dropdown">';
										$html.='<a href="'.$menu[0]['url'].'" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">'.$menu[0]['title'].'<span class="caret"></span></a>';
										
										$html.='<ul class="dropdown-menu" role="menu">';
										for($i=1;$i<count($menu);$i++){
											$html.='<li><a href="'.$menu[$i]['url'].'">'.$menu[$i]['title'].'</a></li>';
										}
										$html.='</ul>';
										$html.='</li>';
									}
								}
								
								echo $html;
								
								?>
								
							  </ul>
							  
							  
							</div><!-- /.navbar-collapse -->
						  </div><!-- /.container-fluid -->
						</nav>
					</div>
			</header>
