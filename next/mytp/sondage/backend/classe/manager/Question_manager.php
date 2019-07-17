<?php

/**
 * Description of Question_manager
 *
 * @author lnoiro
 */

namespace manager;

class Question_manager {
    
    protected $pdo;
    
    public function __construct(){
        $dbManager = new \manager\Db_manager();
        $this->pdo = $dbManager->getConnection();
    }
    
    public function insert($key, $val){
        $query ="INSERT INTO question ($key) values ($val)";
        $this->pdo->query($query);
        
        $id = $this->pdo->lastInsertId();
    return $id;
    }
    
    
    public function selectAllBySurvey($id){
        if(!isset($id) || $id ==""){
        return false;
        } 
        
            $query ="select * from question where id_survey=$id";
            $result = $this->pdo->query($query);
        
            $tab = array();
            $survey = array();

            foreach($result as $row){
                $survey['id_survey'] = $row['id_survey'];
                $survey['id_question'] = $row['id_question'];
                $survey['type_question'] = $row['type_question'];
                $survey['libel'] = $row['libel'];  
                $survey['order_question'] = $row['order_question'];  
            $tab[] = $survey;
            }
            
    return $tab;
    }
    
    public function deleteById($id){
        if(!isset($id) || $id==""){
            return false;
        }
        
        $query = "delete from question where id_question=:id_question";
        
        $stmt=$this->pdo->prepare($query);
        $stmt->bindParam(':id_question',$id, \PDO::PARAM_INT);
        
        try{
            $stmt->execute();
        }catch (\Exception $e){
            return false;
        }
        
    return true;  
    }
    
    public function checkExist($id){
         if(!isset($id) || $id==""){
            return false;
        }
        
        $query ="select * from question where id_question=:id_question";
            $stmt=$this->pdo->prepare($query);
            $stmt->bindParam(":id_question", $id, \PDO::PARAM_STR);
            $stmt->execute();
        
        if($stmt->rowCount()!=1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
}
