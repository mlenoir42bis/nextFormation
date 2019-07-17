<?php
require_once $_SERVER['DOCUMENT_ROOT']."/backend/includes/autoload.php"; 
require_once $_SERVER['DOCUMENT_ROOT']."/backend/includes/sessionCheck.php";

$sessionManager = new manager\Session_manager();
$sessionManager->destroy();
$sessionManager->restart();

$sessionManager->infoMessage = "Session destroy";
header('Location: /index.php');
die();

?>


