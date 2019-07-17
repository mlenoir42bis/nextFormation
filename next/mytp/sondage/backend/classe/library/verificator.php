<?php

namespace library;

/**
 * Description of FormVerif
 *
 * @author marceau
 */
class verificator {
    
    function checkString($tab){
        $string = false;
        foreach ($tab as $k => $v){
            if (is_string($v)){
                continue;
            }   
            else{
                $string = true;
            }
        }
    return $string;
    }
    
    function checkNumeric($tab){
        $numeric = false;
        foreach ($tab as $k => $v){
            if (is_numeric($v)){
                continue;
            }
            else{
                $numeric = true;
            }
        }
    return $numeric;
    }
    
    function checkEmail($email) {
        
        $is_valid = false;
        if(preg_match("/^([a-zA-Z0-9])+([a-zA-Z0-9\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\._-]+)+$/",$email))
        {
          $tab_email = explode('@',$email);
          list($username,$domain)=$tab_email;
          
          if(checkdnsrr($domain,'MX')) 
          {
            $is_valid = true;
          }
        }
        
    return $is_valid;
    }
    
    //Verifie tous les valeurs d'un tableau $post
    //si une valeur est null return false
    function checkPost($post){
        $is_valid = false;
        
        foreach ($post as $k => $v) {
            if($v == null) {
                $is_valid = true;
            }
        }
    return $is_valid;
    }
    
    function checkElemArray($seekVal,$val){
        $found = false;
            if(preg_match('/'.$seekVal.'/', $val)) {
                $found = true;
            }
    return $found;
    }
    
}