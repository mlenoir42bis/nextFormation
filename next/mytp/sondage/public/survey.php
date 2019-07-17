<?php require_once $_SERVER['DOCUMENT_ROOT']."/membre/includes/header.php"; ?>

<?php $id = isset($_GET['id']) ? $_GET['id'] : null; ?>

<h1>The survey :p</h1>

<div id="survey-block-question">
    

    <div id='surveyInfo' class='well'>
    </div>
        <span class="clearfix"></span>
    <form>
        <div id="survey">
        </div>
    </form>
    
</div>

<?php require_once $_SERVER['DOCUMENT_ROOT']."/membre/includes/footer.php"; 