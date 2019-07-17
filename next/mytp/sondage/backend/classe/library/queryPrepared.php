<?php

namespace library;

/**
 * Description of PrepareReq
 *
 * @author marceau
 */
class queryPrepared {
    
    //Recuperation des cle d'un tableau $datapost 
    //cretion d'un chaine de caractere de type keys1,keys2,...
    function preKey($datapost, $implode = false) {
        $datakey = array_keys($datapost);
    return implode(',', $datakey);
    }
    
    //Recuperation des cle d'un tableau $datapost 
    //si implode=true cretion d'un chaine de caractere de type val1,val2 si numeric et 'val1','val2' si string
    // si implode=false recuperation des valeur de $datapost dans un tableau
    function preVal($datapost, $implode = false) {
        $dataval = array_values($datapost);
    
        foreach ($dataval as $k => $v) {
            if(is_numeric($v)){
                $data[] = $v;
                continue;
            }
            else{
                $data[] = '\''.$v.'\'';
                continue;
            }
        }
         
        if($implode==true){
            return implode(',', $data);
        }
        
    return $data;
    }
    
    //mise en forme des donnes du tableau datapost au format $key=$val,...
    function preUpdate($datapost){

    $dataval =  $this->preVal($datapost);
    $datakey =  array_keys($datapost);
    $nb_element = count($dataval);
    $var = array();
    
        for ($i = 0; $i <= $nb_element; $i++) {   
        $string='';
            foreach ($datakey as $a => $b) {   
                if ($a === $i) {
                    $string.= $b."=";
                }
            }
            foreach ($dataval as $c => $d) {
                if ($c === $i){
                    $string.= $d;
                }
            }
        $var[] = $string;
        }
        
        $var = implode(',', $var);
        
    return rtrim($var, ',');
    }
    
}