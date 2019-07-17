<?php require_once $_SERVER['DOCUMENT_ROOT']."/backend/includes/autoload.php"; ?>
<?php require_once $_SERVER['DOCUMENT_ROOT']."/backend/includes/sessionCheck.php"; ?>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Sondage</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="<?php $_SERVER['DOCUMENT_ROOT'] ?>/backend/css/bootstrap.min.css" />
        <link rel="stylesheet" href="<?php $_SERVER['DOCUMENT_ROOT'] ?>/backend/css/style.css" />
    </head>
    
    <body>  
        <div id="wrapper">
            
            
           <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="container">
                    
                    <div class="navbar-header">
                        <a class="navbar-brand" href="<?php $_SERVER['DOCUMENT_ROOT'] ?>/membre/home.php">Home</a>
                        <a class="navbar-brand" href="<?php $_SERVER['DOCUMENT_ROOT'] ?>/membre/create.php">Create</a>
                    </div>
                    
                    <ul class="nav navbar-nav navbar-right">
                    
                    <?php 
                    $sessionManager = new manager\Session_manager();
                    $redirect = new library\HTTPResponse();
                    $is_loged = $sessionManager->is_loged;
                    ?>

                    <?php if ($is_loged == true) :?>
                    <li><a class="btn btn-small btn-danger" href="<?php $_SERVER['DOCUMENT_ROOT'] ?>/membre/process/treatment/logout-treat.php">Log out</a></li>
                    <?php else : ?>
                    <?php $redirect->redirect('/index.php'); ?>
                    <?php endif; ?>
                    </ul>  
                    
                </div>
            </div>
            
            <div id="content">
                
            