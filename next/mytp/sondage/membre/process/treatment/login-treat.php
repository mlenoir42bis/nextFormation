<?php require_once $_SERVER['DOCUMENT_ROOT']."/backend/includes/autoload.php"; ?>
<?php
$email=isset($_POST['email'])?$_POST['email']:null;
$password=isset($_POST['password'])?$_POST['password']:null;

$sessionManager = new manager\Session_manager();
$redirect = new library\HTTPResponse();
$usersManager = new manager\Users_manager();

//test sur les champs
$errorMsg = array();

    if(!isset($email) || $email==""){
        $errorMsg[] = "Enter your email";
    }

    if(!isset($password) || $password==""){
        $errorMsg[] = "Enter your password";
    }

//si il y a des erreurs redirection
if(count($errorMsg)>0){
    $msg = implode("<br />", $errorMsg);
    $sessionManager->errorMessage = $msg;
    $redirect->redirect('/public/login.php');
}

if($usersManager->validation($email, $password)){
    $redirect->redirect('/membre/home.php');
    
}else{
    $sessionManager->errorMessage = "Error recognition";
    $redirect->redirect('/public/login.php');
}

?>