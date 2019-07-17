<!DOCTYPE html>
<html>
    <head>
        <title>Sondage</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="<?php $_SERVER['DOCUMENT_ROOT'] ?>/backend/css/bootstrap.min.css" />
        <link rel="stylesheet" href="<?php $_SERVER['DOCUMENT_ROOT'] ?>/backend/css/style.css" />
        
        <script src="<?php $_SERVER['DOCUMENT_ROOT'] ?>/backend/js/jquery.min.js"></script>
        <script src="<?php $_SERVER['DOCUMENT_ROOT'] ?>/backend/js/login.js"></script>
    </head>
    <body>  
        <div id="wrapper">
            
            <?php require_once $_SERVER['DOCUMENT_ROOT']."/backend/includes/displayMessage.php"; ?>
                <?php 
                echo $message;
                ?>
            
            <div id="indentify" class="well form-login">
                
                <form role="form" action="<?php $_SERVER['DOCUMENT_ROOT'] ?>/membre/process/treatment/login-treat.php" method="POST">                    
                    <fieldset>
                    <legend>Identify</legend>
                    
                        <div class="form-group">
                            <label for="email">Your email</label>
                            <input type="email" name="email" class="form-control" id="email">
                        </div>

                        <div class="form-group">
                            <label for="password">Your password</label>
                            <input type="password" name="password" class="form-control" id="password">
                        </div>

                    <input class="btn btn-primary pull-right" type="submit" value="Validate">
                    </fieldset>
                </form>
                
            </div>
                            
            <a id="getRegister" href="#">Register</a>                 
                            
            <div id="register" class="well form-login">
                
                <form role="form" action="" method="post">
                    <fieldset>
                    <legend>Register</legend>
                    
                        <div class="form-group">
                          <label >Name :</label>
                          <input type="text" name="name" class="form-control" placeholder="Your name">
                        </div>
                        <div class="form-group">
                          <label >First name :</label>
                          <input type="text" name="firstname" class="form-control" placeholder="Your first name">
                        </div>
                        <div class="form-group">
                          <label>Email</label>
                          <input type="email" name="email" class="form-control" placeholder="Your email">
                        </div>
                        <div class="form-group">
                          <label >Password</label>
                          <input type="password" name="password" class="form-control" placeholder="Your password">
                        </div>
                    
                        <input class="btn btn-primary pull-right" type="submit" value="Record">
                    </fieldset>
                </form>
                
            </div>
        </div> 
    </body>
</html>