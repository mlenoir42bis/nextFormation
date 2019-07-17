<?php

/**
 * Description of Users_manager
 *
 * @author lnoiro
 */

namespace manager;

class Users_manager {
    protected $pdo;
    
    public function __construct(){
        $dbManager = new \manager\Db_manager();
        $this->pdo = $dbManager->getConnection();
    }
    
    public function validation($email, $password){
        
        if(!isset($email) || $email=="" || !isset($password) || $password=="")
        {
            return false;
        }
        
            $query ="select * from users where email=:email and password=:password";
            $stmt=$this->pdo->prepare($query);
            $stmt->bindParam(":email", $email, \PDO::PARAM_STR);
            $stmt->bindParam(":password", $password, \PDO::PARAM_STR);
            $stmt->execute();
        
        if($stmt->rowCount()!=1)
        {
            return false;
        }
        else
        {
            $sessionManager = new Session_manager();
            
            $result = $stmt->fetch();
            
                $id = $result['id_user'];
                $email= $result['email'];

                    $sessionManager->Z45THYIOPOK67 = true; 
                    $sessionManager->is_loged = true;
                    $sessionManager->id = $id;
                    $sessionManager->email = $email;
                
            return true;
        }
    }
}
