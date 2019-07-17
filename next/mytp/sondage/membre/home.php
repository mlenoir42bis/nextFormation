<?php require_once $_SERVER['DOCUMENT_ROOT']."/membre/includes/header.php"; ?>

<?php
$surveyManager = new manager\Survey_manager();
$id_user = $sessionManager->id;
?>

<h1>Home space member</h1>

<div id="homeContent">
    <div >
        <div id='surveyInfo' class='well'>
        </div>
        <div id='surveyConsol'>
        </div>
    </div>
    
    <span class="clearfix"></span>
    
    <div id="survey">
    </div>
</div>

<div id="sidebar" class="well">
        <h2>My poll</h2>

    <?php $tabSurvey = $surveyManager->selectAllbyUser($id_user); ?>
    <?php if (isset($tabSurvey)) : ?>
    <?php foreach ($tabSurvey as $survey) : ?>

            <div class="mysurvey" id="<?php echo $survey->getId_survey(); ?>">
                <p><?php echo $survey->getTitle(); ?></p>
            </div>

    <?php endforeach; ?>
    <?php endif; ?>
</div>

<?php require_once $_SERVER['DOCUMENT_ROOT']."/membre/includes/footer.php"; 