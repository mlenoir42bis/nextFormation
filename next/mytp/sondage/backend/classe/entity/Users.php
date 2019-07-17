<?php

/**
 * Description of Users
 *
 * @author lnoiro
 */
class Users {
    
    protected $id_user;
    protected $name;
    protected $firstname;
    protected $email;
    protected $password;
    
        
    function getId_user() {
        return $this->id_user;
    }

    function getName() {
        return $this->name;
    }

    function getFirstname() {
        return $this->firstname;
    }
    
    function getEmail() {
        return $this->email;
    }

    function getPassword() {
        return $this->password;
    }

    function setId_user($id_user) {
        $this->id_user = $id_user;
    }
    
    function setName($name) {
        $this->name = $name;
    }

    function setFirstname($firstname) {
        $this->firstname = $firstname;
    }

    function setEmail($email) {
        $this->email = $email;
    }

    function setPassword($password) {
        $this->password = $password;
    }

}
