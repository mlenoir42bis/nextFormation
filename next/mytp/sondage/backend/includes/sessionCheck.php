<?php
require_once $_SERVER['DOCUMENT_ROOT']."/backend/includes/autoload.php";

$sessionManager = new manager\Session_manager();

if(!$sessionManager->Z45THYIOPOK67){
    $sessionManager->errorMessage= "You loose ! Error session";
    header("Location: /index.php");
    die();
}
?>