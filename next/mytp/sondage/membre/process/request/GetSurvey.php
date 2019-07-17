<?php
require_once $_SERVER['DOCUMENT_ROOT']."/backend/includes/autoload.php"; 


$id = isset($_GET['id']) ? $_GET['id'] : null;


if($id !== null)
{   
    $surveyManager = new manager\Survey_manager();
    
    $posts = $surveyManager->selectOneById($id);    
    
	header("Content-Type: application/json");
	echo json_encode($posts);
	die();
   
}
else
{
    echo("<p>Error</p>");
}

?>