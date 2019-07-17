
//event recuperation d'information sur un sondage
$('#sidebar').on('click', '.mysurvey', function(){
    id_survey = $(this).attr('id');
    getInfoSurvey();	
    getConsol();      
}); 
//event sur click pour voir le sondage
$('#surveyConsol').on('click', '#view', function(){
    getQuestion(); 
});

//event sur click pour voir le sondage
$('#surveyConsol').on('click', '#edit', function(){
    
    getEditConsolType();
    getEditInfoSurvey();
    getEditQuestion();
    
});