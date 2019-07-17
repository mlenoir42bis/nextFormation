<?php

/**
 * Description of Survey_manager
 *
 * @author lnoiro
 */

namespace manager;

class Survey_manager {
    
    protected $pdo;
    
    public function __construct(){
        $dbManager = new \manager\Db_manager();
        $this->pdo = $dbManager->getConnection();
    }
    
    public function insert($key, $val){
        $query ="INSERT INTO survey ($key) values ($val)";
        $this->pdo->query($query);
        
        $id = $this->pdo->lastInsertId();
    return $id;
    }
    
    public function selectAllbyUser($id){    
        if(!isset($id) || $id ==""){
        return false;
        }
        
            $query ="select * from survey where id_user=$id";
            $result = $this->pdo->query($query);
        
            $tab = array();
            
            foreach($result as $row){
                $survey = new \entity\Survey();
                $survey->setId_survey($row['id_survey']);
                $survey->setId_user($row['id_user']);
                $survey->setTitle($row['title']);
                $survey->setDescription($row['description']);
            $tab[] = $survey;
            }
            
    return $tab;
    }
    
    public function selectOneById($id){
        if(!isset($id) || $id ==""){
        return false;
        } 
            $query ="select * from survey where id_survey=$id";
            $result = $this->pdo->query($query);
        
            $tab = array();
            $survey = array();

            foreach($result as $row){
                $survey['id_survey'] = $row['id_survey'];
                $survey['id_user'] = $row['id_user'];
                $survey['title'] = $row['title'];
                $survey['description'] = $row['description'];  
            $tab[] = $survey;
            }
            
    return $tab;
    }
}
