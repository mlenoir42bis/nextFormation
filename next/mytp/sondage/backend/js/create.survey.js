var counterQuestion = 0;
    
    //event chargement de page
    $(window).on('load', function(){       
        $("#contentType").hide();
        $("#submitProb").hide();
    });
    //event creation de questionnaire
    $("#create").on('click', function () {
        validNewsSurvey();
        if (registerFormIsValid){
            $("#create").hide();
            $("#contentType").show();  
        }      
    });
    //event creation de question par type
    $("#contentType p").on('click', function(){
        counterQuestion++;
        var type = this;
        $("#contentQuestion").append(switchTypeQuestion(type.id)); 
        countNbQuestion();
    });
    
    
    //event supression de question
    $("contentQuestion").on('click', '.removeQuestion', function(){
        elemQuestion = $(this).parent();
        $(this).parent().remove();
//        renameQuestion();
        counterQuestion = counterQuestion - 1;
        countNbQuestion();
    });
    
    
    //event ajout d'une reponse possible a un qcm
    $("body").on('click', '.more', function(){
        console.log($(this).parent().siblings('.blockAnswerQcm').children('.answerQcm').length);
        var lastAnswer = $(this).parent().siblings('.blockAnswerQcm').children('.answerQcm:last-child').children('.qcm');  
        var nbQuestion = lastAnswer.attr('name').substring(8,9);
        var nbAnswer = $(this).parent().siblings('.blockAnswerQcm').children('.answerQcm').length;
            nbAnswer++;
            
    $(this).parent().siblings('.blockAnswerQcm').append(createInputQcm(nbQuestion, nbAnswer));
    });    
    //event supression de la derniere reponse possible a un qcm
    $("body").on('click', '.less', function(){ 
        $(this).parent().siblings('.blockAnswerQcm').children('.answerQcm:last-child').remove();  
    });
    //event supression d'une reponse specifique d'un qcm
    $("#contentQuestion").on('click', '.remove', function(){
        elemAnswer = $(this).closest('.blockAnswerQcm');
        $(this).parent().remove();
        renameAnswer(elemAnswer);
    });
    

    //evenement sur modification de l'ordre des question par la fonction sortable
    //mise a jour du nom des questions
//        $(function() {
//            $( "#contentQuestion" ).sortable({
//                 update: function( event , ui ) {
//                     renameQuestion();
//                 }
//            });
//        });
    
    
function switchTypeQuestion(type){
    switch(type) {
    case 'simpletext':
        typeQuestion = 'text';
        
        return createQuestion(typeQuestion);
        break;
    case 'number':
        typeQuestion = 'number';
        
        return createQuestion(typeQuestion);
        break;
    case 'qcm':
        typeQuestion = 'qcm';
        
        return createQcm(typeQuestion);
        break;
    default:
        alert('loading error');
    } 
}
//creation d'une question
function createQuestion(typeQuestion){
    newQuestion = $("<div class='well question'>");
    newQuestion.append("<img class='removeQuestion' src='../backend/img/remove.jpg'>");
    newQuestion.append(createLabel('question' + counterQuestion, 'Question type '+ typeQuestion + ' :'));  
    newQuestion.append(createInput('text', 'question' + counterQuestion, 'Your question ...'));
    newQuestion.append(createHidden('typequestion' + counterQuestion, typeQuestion));
    newQuestion.append("<p class='help-block'></p>");
return newQuestion;
}
//creation d'une question de type Qcm
function createQcm(typeQuestion){
    newQcm = createQuestion(typeQuestion);

        newConsol = $("<div class='consol'>");
        newConsol.append("<img class='less' src='../backend/img/less.jpg'>");
        newConsol.append("<img class='more' src='../backend/img/add.jpg'>");
        
    newQcm.append(newConsol);
    newblockAnswerQcm = $("<div class='blockAnswerQcm'>");
    
        counterAnswer = 0;
        for(i = 1; i<=4; i++){
            counterAnswer++;
            newblockAnswerQcm.append(createInputQcm(counterQuestion, counterAnswer));
        }
    
    newQcm.append(newblockAnswerQcm);
    
return newQcm;
}
//creation d'une reponse a un qcm
function createInputQcm(counterQuestion, counterAnswer){
    newAnswerQcm = $("<div class='answerQcm'>");
        inputName = 'question' + counterQuestion + 'answer' + counterAnswer; 
            newAnswerQcm.append("<img class='remove' src='../backend/img/remove.jpg'>");
            newAnswerQcm.append(createInput('text', inputName, 'wording answer' + counterAnswer, 'qcm'));
            newAnswerQcm.append("<p class='help-block'></p>");
return newAnswerQcm;
}
//Modification de la numerotation du nom des question et des label de 1 a n
//function renameQuestion(){
//    var nb = 1;
//    var blockQuestion = $('#contentQuestion .question');
//    
//    blockQuestion.each(function(keys, val){
//        var elemtreatInput = $(val).find('input');
//        var elemtreatLabel = $(val).find('label');
//        
//            elemtreatInput.each(function(k, v){
//                if ($(v).attr('name').length > 13){
//                    $(v).attr('name','question' + nb + $(v).attr('name').substring(9,$(v).attr('name').length));
//                }
//                else{
//                    var lgName = $(v).attr('name').length;
//                    $(v).attr('name', $(v).attr('name').substring(0,lgName-1) + nb);
//                }
//            }); 
//            
//            elemtreatLabel.each(function(a, b){
//                    var lgFor = $(b).attr('for').length;
//                    $(b).attr('for', $(b).attr('for').substring(0,lgFor-1) + nb);
//            });
//    nb++;   
//    });  
//}
//Modification de la numerotation du nom des reponse d'un qcm de 1 a n
function renameAnswer(elemAnswer){
    var nb = 1;
    elemAnswer.children('.answerQcm').each(function(keys, val){
        var block = $(val).children('.qcm');
        block.attr('name', block.attr('name').substring(0,15) + nb);
        block.attr('placeholder', block.attr('placeholder').substring(0,14) + nb);
        nb++;
    });
}
//Recupere le nombre de question du questionnaire
//Si le sondage contient au moins une question affiche le bouton submit
function countNbQuestion(){
    Elem = $('#contentQuestion').children('.question').length;
    if(Elem === 0){
        $("#submitProb").hide();
    }
    else{
        $("#submitProb").show();        
    }
}
//creation d'un champ input
function createInput(Type, Name, placeholder, theclass){
    theclass = theclass || "";
    newInput = $("<input>").attr({
        'type': Type,
        'name': Name,
        'placeholder': placeholder,
        'class': 'form-control '+theclass
    });
return newInput;
}
//creation d'un champ label
function createLabel(labelFor, labelVal){
    newLabel = $("<label>").attr('for', labelFor);
    newLabel.append(labelVal);
return newLabel;
}
//creation d'un champ label
function createHidden(Name, Val){
    newHidden = $("<input>").attr({
        'type': 'hidden',
        'name': Name,
        'value': Val
    });
return newHidden;
}

        