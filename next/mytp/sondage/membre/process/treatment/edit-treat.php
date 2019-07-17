<?php require_once $_SERVER['DOCUMENT_ROOT']."/backend/includes/autoload.php"; ?>
<?php
$verificator = new library\verificator();
$queryPrepared = new library\queryPrepared();
$HTTPResponse = new library\HTTPResponse();
$surveyManager = new manager\Survey_manager();
$questionManager = new manager\Question_manager();
$qcmManager = new manager\Qcm_manager();
$sessionManager = new manager\Session_manager();

$linkReturn = "/membre/home.php";

echo $sessionManager->id;

////Verifie que tous les champs du formulaire sont remplie
//$checkPost = $verificator->checkPost($_POST);
//if($checkPost){
//    $sessionManager->errorMessage = 'All fields are blank';
//    $HTTPResponse->redirect($linkReturn);
//die();
//}
//
////recuperation des donne de creation du sondage 'titre' + 'description'
//$dataSurvey = array();
//foreach ($_POST as $key => $value) {
//    if($key === 'title'){
//        $dataSurvey[$key]=$value;
//        unset($_POST[$key]);
//    }
//    if($key === 'description'){
//        $dataSurvey[$key]=$value;
//        unset($_POST[$key]);       
//    }
//}
//
////verification recuperation des données // si ok insertion et recuperation id sondage
//if(isset($title) && isset($description)){
//    $sessionManager->errorMessage = 'error during data transfer (name and description survey)';
//    $HTTPResponse->redirect($linkReturn);
//die();
//}
//else{
////ajout de l'id user du createur du sondage************************************************************************
//    $dataSurvey['id_user']=1;
////preparation des données pour l'insertion
//    $queryKey = $queryPrepared->preKey($dataSurvey, true);
//    $queryVal = $queryPrepared->preVal($dataSurvey, true);
////insertion et recuperation id sondage
//    $id_survey = $surveyManager->insert($queryKey, $queryVal);
//}

?>