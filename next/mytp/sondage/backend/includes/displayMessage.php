<?php

require_once $_SERVER['DOCUMENT_ROOT']."/backend/includes/autoload.php";

$sessionManager = new manager\Session_manager();

$message ="";

if($sessionManager->errorMessage!=""){
    $message = '<div class="alert alert-danger error_info_message">'.$sessionManager->errorMessage.'</div>';
    $sessionManager->errorMessage = null;
}

if($sessionManager->infoMessage!=""){
    $message = '<div class="alert alert-success error_info_message">'.$sessionManager->infoMessage.'</div>';
    $sessionManager->infoMessage = null;
}

?>