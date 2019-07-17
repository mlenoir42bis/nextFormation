<?php require_once $_SERVER['DOCUMENT_ROOT']."/membre/includes/header.php"; ?>


<h1>I probe you</h1>

<p>
here, if you want.<br/> 
You created surveys and send them online
</p>


<form id="survey_form" role="form" action="process/treatment/create-treat.php" method="POST">    
    
    <div id="generateSurvey" class="well">
        <fieldset>
        <legend>Title And Description Survey</legend>

            <div class="form-group">
                <label for="title">Title</label>
                <br/>
                <input type="text" name="title" class="form-control" id="title">
                <p class='help-block'></p>
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <br/>
                <textarea rows="10" cols="45" name="description"  id="description"></textarea>
                <p class='help-block'></p>
            </div>

        <p class="btn btn-primary btn-small pull-right" id="create">Create</p>
        <input type="submit" value="Save" id="submitProb" class="btn btn-primary pull-right">
        </fieldset>
    </div>
    
    <div>
        <div id="contentType" class="well">
            <h3>add a question :</h3>
            <p id='simpletext'>Simple text</p>
            <p id='number'>Number</p>
            <p id='qcm'>Qcm</p>
        </div>
        <div id="contentQuestion">  
        </div>
    </div>
    
    </form>
    

<?php require_once $_SERVER['DOCUMENT_ROOT']."/membre/includes/footer.php"; ?>