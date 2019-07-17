
function getInfoSurvey(){
    $.ajax({
	url: "/membre/process/request/GetSurvey.php",                      
        data: "id="+id_survey
	})
	.done(function(response){
            
            $("#survey").html('');
            $("#surveyInfo").html('');
            $("#surveyInfo").append("<h2>" + response[0].title + "</h2>");
            $("#surveyInfo").append("<p>" + response[0].description + "</p>");
	});
}


function getQuestion(){
    $.ajax({
	url: "/membre/process/request/GetQuestion.php",                      
        data: "id="+id_survey  
	})
	.done(function(response){
    
            for (var i = 0; i < response.length; i++) {
                var newDiv = $("<div id='question"+response[i]['id_question']+"' class='well'>");
        
                newDiv.append('<p>' + response[i]['libel'] + ' ?' + '</p>');  
                if(response[i]['type_question'] === 'qcm'){
                    getAnswerQcm(response[i]['id_question']);
                }
                else{
                    newDiv.append(createInput(response[i]['type_question'], 'answer'+response[i]['id_question'], 'Your answer ...'));
                }
                                
            $("#survey").append(newDiv);
            }
	});
}

function getAnswerQcm(id_question){
    $.ajax({
	url: "/membre/process/request/GetAnswerQcm.php",                      
        data: "id="+id_question  
	})
	.done(function(response){

        var newBlocAnswer = $("<div class='BlocAnswer'>");
        
            for (var i = 0; i < response.length; i++) {
                var newAnswer = $("<div class='answer'>");  
                
                newAnswer.append(response[i]['libel']);

                newAnswer.append("<input type='radio' name='question" + id_question + "answer' value='" + response[i]['id_qcm'] + "'>");
                newBlocAnswer.append(newAnswer);
            }
        
        $('#question'+id_question).append(newBlocAnswer);
    });      
}

function getConsol(){
    $("#surveyConsol").html('');
    $("#surveyConsol").append("<p class='btn btn-danger btn-small' id='delete'>delete</p>");
    $("#surveyConsol").append("<p class='btn btn-primary btn-small' id='view'>view</p>");   
    $("#surveyConsol").append("<span class='clearfix'></span>");   
    $("#surveyConsol").append("<p class='btn btn-warning btn-small' id='edit'>edit</p>");   
}

function getConsolTypeQuestion(){
    $("#survey").html('');
    newDivType = $('</div>');
    newDivType.append("<div id='contentType' class='well'>");
    newDivType.append("<h3>add a question :</h3>");
    newDivType.append("<p id='simpletext'>Simple text</p>");
    newDivType.append("<p id='number'>Number</p>");
    newDivType.append("<p id='qcm'>Qcm</p>");
    
    newContent = $("</div id='contentQuestion'>");
    newDivType.append(newContent);
    
$("#survey").append(newDivType);
}