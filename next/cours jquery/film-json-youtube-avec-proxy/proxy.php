<?php

	$content = file_get_contents("http://www.imdb.com/list/ls057163321/?start=1&view=detail&sort=release_date_us:desc&defaults=1");
	echo $content;