function getEditInfoSurvey(){
    $.ajax({
	url: "/membre/process/request/GetSurvey.php",                      
        data: "id="+id_survey
	})
	.done(function(response){
           
            newForm = $("<form role='form' action='process/treatment/edit-treat.php' method='POST'>");
            
            newDivInfo = $("<div class='well'>");
            
            newGroup = $("<div class='form-group'>");
            newGroup.append("<label for='title'>Title :</label>");
            newGroup.append("<input type='text' name='title' value='"+response[0].title+"' id='title' class='form-control'>");
            newGroup.append("<p class='help-block'></p>");
            
            newGroup2 = $("<div class='form-group'>");
            newGroup2.append("<label for='description'>Description :</label>");
            newGroup2.append("<textarea rows='10' cols='45' name='description' id='description' class='form-control'>"+response[0].description+"</textarea>");
            newGroup2.append("<p class='help-block'></p>");
            
            newDivInfo.append(newGroup, newGroup2);
            newForm.append(newDivInfo);
            newForm.append("<input type='submit 'value='Save' id='submitEdit' class='btn btn-primary pull-right'>");
            $("#survey").append(newForm);
            
            
	});
}

//$("p").before( $("b") );

function getEditQuestion(){
    $.ajax({
	url: "/membre/process/request/GetQuestion.php",                      
        data: "id="+id_survey  
	})
	.done(function(response){
    
            for (var i = 0; i < response.length; i++) {
                  
                    var newDiv = $("<div class='well question' id='question"+response[i]['id_question']+"' data-id='"+response[i]['id_question']+"'>");
                    newDiv.append('<img class="removeQuestion" src="../backend/img/remove.jpg">');  
                
                newDiv.append("<label for='question"+response[i]['id_question']+"'>Question Type : "+response[i]['type_question']+"</label>");
                newDiv.append("<input type='text' name='question"+response[i]['id_question']+"' value='"+response[i]['libel']+"' class='form-control'>");
                newDiv.append("<input type='hidden' name='Typequestion"+response[i]['id_question']+"' value='"+response[i]['type_question']+"'>");
                newDiv.append("<p class='help-block'></p>");
                
                if(response[i]['type_question'] === 'qcm'){
                    newConsol = $("<div class='consol'>");
                    newConsol.append("<img class='less' src='../backend/img/less.jpg'>");
                    newConsol.append("<img class='more' src='../backend/img/add.jpg'>");
                    newDiv.append(newConsol);
                    getEditAnswerQcm(response[i]['id_question']);
                }
                                
            $("#submitEdit").before(newDiv);
            }
	});
}

function getEditAnswerQcm(id_question){
    $.ajax({
	url: "/membre/process/request/GetAnswerQcm.php",                      
        data: "id="+id_question  
	})
	.done(function(response){

        var newBlocAnswer = $("<div class='blockAnswerQcm'>");
        
            for (var i = 0; i < response.length; i++) {
                
                var newAnswer = $("<div class='answerQcm' data-id='"+response[i]['id_qcm']+"'>");  
                newAnswer.append("<img class='remove' src='../backend/img/remove.jpg'>");
                newAnswer.append("<input type='text' name='question" + id_question + "answer" + response[i]['id_qcm'] + "' value='" + response[i]['libel'] + "' class='form-control qcm'>");
                newAnswer.append("<p class='help-block'></p>");
                newBlocAnswer.append(newAnswer);
                
            }
        
        $('#question'+id_question).append(newBlocAnswer);
    });      
}

function getEditConsolType(){
              
    $("#survey").html('');
    $("#surveyInfo").html('');
    $("#surveyConsol").html('');
            
    newDivType = $("<div id='contentType' class='well'>");
    newDivType.append("<h3>add a question by type:</h3>");
    newDivType.append("<p id='simpletext'>Simple text</p>");
    newDivType.append("<p id='number'>Number</p>");
    newDivType.append("<p id='qcm'>Qcm</p>");
    
$("#surveyInfo").append(newDivType);              
    $("#survey").html('');
    $("#surveyInfo").html('');
    $("#surveyConsol").html('');
            
    newDivType = $("<div id='contentType' class='well'>");
    newDivType.append("<h3>add a question by type:</h3>");
    newDivType.append("<p id='simpletext'>Simple text</p>");
    newDivType.append("<p id='number'>Number</p>");
    newDivType.append("<p id='qcm'>Qcm</p>");
    
$("#surveyInfo").append(newDivType);
}

//event creation de question par type
$("#surveyInfo").on('click', '#contentType p', function(){
    counterQuestion++;
    var type = this;
    console.log(type.id);
    $("#survey form").append(switchTypeQuestion(type.id)); 
    countNbQuestion();
});

//event supression d'une reponse specifique d'un qcm
$("#survey").on('click', '.remove', function(){
    elemAnswer = $(this).closest('.blockAnswerQcm');
    $(this).parent().remove();
});

var elem = "";
    //event supression de question
    $("#survey").on('click', '.removeQuestion', function(){
        elem = "";
        elem = $(this).parent().data('id');
        
        if(elem){
            $.ajax({
            url: "/membre/process/request/DeleteQuestion.php",                      
            data: "id="+elem 
            })
            .success(function(response){
            });
        }
            
        $(this).parent().remove();
        counterQuestion = counterQuestion - 1;
        countNbQuestion();
    
    });
    //event suprression d'une reponse a un qcm
    $("#survey").on('click', '.remove', function(){
        elem = "";
        elem = $(this).parent().data('id');
        
        if(elem){
            $.ajax({
            url: "/membre/process/request/DeleteQcm.php",                      
            data: "id="+elem 
            })
            .success(function(response){
            });
        }
            
        $(this).parent().remove();
        counterQuestion = counterQuestion - 1;
        countNbQuestion();
    
    });
    