<?php
   $surveyManager = new manager\Survey_manager();
$questionManager = new manager\Question_manager();
$qcmManager = new manager\Qcm_manager();

//$id_user = $sessionManager->id;

$id_survey = isset($_GET['id']) ? $_GET['id'] : null;

$posts = $surveyManager->selectOneById($id_survey);   
$posts[1] = $questionManager->selectAllBySurvey($id_survey);

if($posts){
    foreach ($posts[0] as $key => $value){
        echo $key . ' : = : ' . $value . '</br>';
        }
    
    echo '</br>';
    
    for( $i = 0; $i < count($posts[1]); $i++){
        echo '</br>';
        
        foreach ($posts[1][$i] as $key => $value){
        
            echo $key . ' : = : ' . $value . '</br>';
            
            if($key === 'id_question'){
                $id_question = $value;
            }
            if(($key === 'type_question') && ($value === 'qcm')){
                $posts[2] = $qcmManager->selectAllByQuestion($id_question);
            }
        }  
    }
    
    echo '</br>';
    
    for( $i = 0; $i < count($posts[2]); $i++){
        echo '</br>';
        
        foreach ($posts[2][$i] as $key => $value) {
        
            echo $key . ' : = : ' . $value . '</br>';
           
        }
    }
    
//    echo $posts[0]['title'];
}
else{
    echo 'zubbbb';
}             
?>

id_survey : = : 52
id_user : = : 1
title : = : zdznqdzknqdiq
description : = : nuzindqidnzqi


id_survey : = : 52
id_question : = : 33
type_question : = : text
libel : = : zdqdqd
order_question : = : 1

id_survey : = : 52
id_question : = : 34
type_question : = : number
libel : = : dzqdzqdq
order_question : = : 2

id_survey : = : 52
id_question : = : 35
type_question : = : qcm
libel : = : dzqdqdzqd
order_question : = : 3

id_survey : = : 52
id_question : = : 36
type_question : = : qcm
libel : = : zdzqdzqdzqq
order_question : = : 4


id_qcm : = : 38
id_question : = : 36
libel : = : dzqdqzdqd

id_qcm : = : 39
id_question : = : 36
libel : = : zdqdzqdzqdzq