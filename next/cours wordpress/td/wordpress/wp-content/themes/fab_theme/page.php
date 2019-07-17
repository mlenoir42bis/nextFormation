<?php get_header();?>
	
	<?php if(is_front_page()): ?>
		<div id="carousel_div">
			<?php echo carousel(3);?>
		</div>
	<?php endif;?>


<?php get_footer();?>