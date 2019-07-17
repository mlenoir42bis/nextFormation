<?php

/**
 * Description of Qcm_manager
 *
 * @author lnoiro
 */

namespace manager;

class Qcm_manager {
    
    protected $pdo;
    
    public function __construct(){
        $dbManager = new \manager\Db_manager();
        $this->pdo = $dbManager->getConnection();
    }
    
    public function insert($key, $val){
        $query ="INSERT INTO qcm ($key) values ($val)";
        $this->pdo->query($query);
    }
    
    public function selectAllByQuestion($id){
        if(!isset($id) || $id ==""){
        return false;
        } 
        
            $query ="select * from qcm where id_question=$id";
            $result = $this->pdo->query($query);
        
            $tab = array();
            $question = array();

            foreach($result as $row){
                $question['id_qcm'] = $row['id_qcm'];
                $question['id_question'] = $row['id_question'];
                $question['libel'] = $row['libel'];   
            $tab[] = $question;
            }
            
    return $tab;
    }
    
    public function deleteById($id){
        if(!isset($id) || $id==""){
            return false;
        }
        
        $query = "delete from qcm where id_qcm=:id_qcm";
        
        $stmt=$this->pdo->prepare($query);
        $stmt->bindParam(':id_qcm',$id, \PDO::PARAM_INT);
        
        try{
            $stmt->execute();
        }catch (\Exception $e){
            return false;
        }
        
    return true;  
    }
}
