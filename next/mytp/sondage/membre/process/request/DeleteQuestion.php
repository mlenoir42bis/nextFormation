<?php
require_once $_SERVER['DOCUMENT_ROOT']."/backend/includes/autoload.php"; 


$id = isset($_GET['id']) ? $_GET['id'] : null;


if($id !== null)
{   
    $questionManager = new manager\Question_manager();
    $posts = $questionManager->deleteById($id);   
    
}
else
{
    echo("<script>Alert('error')</script>");
}

?>