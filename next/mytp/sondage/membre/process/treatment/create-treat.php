<?php require_once $_SERVER['DOCUMENT_ROOT']."/backend/includes/autoload.php"; ?>
<?php
$verificator = new library\verificator();
$queryPrepared = new library\queryPrepared();
$HTTPResponse = new library\HTTPResponse();
$surveyManager = new manager\Survey_manager();
$questionManager = new manager\Question_manager();
$qcmManager = new manager\Qcm_manager();

$linkReturn = "/membre/create.php";

//Verifie que tous les champs du formulaire sont remplie
$checkPost = $verificator->checkPost($_POST);
if($checkPost){
    $sessionManager->errorMessage = 'All fields are blank';
    $HTTPResponse->redirect($linkReturn);
die();
}

//recuperation des donne de creation du sondage 'titre' + 'description'
$dataSurvey = array();
foreach ($_POST as $key => $value) {
    if($key === 'title'){
        $dataSurvey[$key]=$value;
        unset($_POST[$key]);
    }
    if($key === 'description'){
        $dataSurvey[$key]=$value;
        unset($_POST[$key]);       
    }
}

//verification recuperation des données // si ok insertion et recuperation id sondage
if(isset($title) && isset($description)){
    $sessionManager->errorMessage = 'error during data transfer (name and description survey)';
    $HTTPResponse->redirect($linkReturn);
die();
}
else{
//ajout de l'id user du createur du sondage************************************************************************
    $dataSurvey['id_user']=1;
//preparation des données pour l'insertion
    $queryKey = $queryPrepared->preKey($dataSurvey, true);
    $queryVal = $queryPrepared->preVal($dataSurvey, true);
//insertion et recuperation id sondage
    $id_survey = $surveyManager->insert($queryKey, $queryVal);
}

//trie de la variable $post, creation d'un tabeau de tableau trié par question
$dataQuestion = array();
for($i=0; $i<=count($_POST); $i++){
    foreach ($_POST as $key => $value){
        $questionFound = $verificator->checkElemArray('question'.$i, $key);
        if($questionFound){
            $dataQuestion[$i][$key] = $value;
        }
    }
}

//traitement insertion question
$queryKey = 'libel,type_question,id_survey,order_question';
$queryKeyAnswer = 'id_question,libel';
//boucle sur toute la longeur du tableau de tableau de question
for($i=1; $i<=count($dataQuestion); $i++){
    //sur chaque tableau de question
    foreach ($dataQuestion[$i] as $key => $value){
        //recuperation du type de la question
        $typeFound = $verificator->checkElemArray('type', $key);
            //si type trouvé
            if($typeFound){
                
                    //ajout de l'id du sondage
                    $dataQuestion[$i]['id_survey'] = $id_survey;
                    $dataQuestion[$i]['order_question'] = $i;
                    
                //si qcm
                if($value==='qcm'){
                    
                    $dataAnswer = array();
                    //boucle sur le tableau de la question de type qcm
                    foreach ($dataQuestion[$i] as $k => $v){
                        
                        //recuperation des reponses possible
                        $answerFound = $verificator->checkElemArray('answer', $k);
                            //si des reponse trouve separation des donnes de la question, des reponses possible
                            if($answerFound){
                                $dataAnswer[]=$v;
                                unset($dataQuestion[$i][$k]);
                            }
                        
                    }
                    
                    //mise en forme
                    $queryVal = $queryPrepared->preVal($dataQuestion[$i], true);
                    //insertion des donnes de la question, recuperation id
                    $id_question = $questionManager->insert($queryKey, $queryVal);                
                    //insertion des reponse
                    foreach ($dataAnswer as $k => $v){
                        $qcmManager->insert($queryKeyAnswer, $id_question.',\''.$v.'\'');
                    }
                }
                else{
                    
                    //recuperation de la chaine de valeur a inserer
                    $queryVal = $queryPrepared->preVal($dataQuestion[$i], true);
                    echo $queryVal.'<br>';
                    //insertion, recuperation de l'id question
                    $questionManager->insert($queryKey, $queryVal);
                } 
			}
    }
}

$sessionManager->infoMessage = 'successful registration';
$HTTPResponse->redirect('/membre/home.php');
