var id_survey = "";

$(window).on('load', function(){
    id_survey = "";
    var loc = $(location).attr('href');
    
if((loc.substring(0, 36) === "http://sondage.com/public/survey.php" ) && (loc.length > 39)){
    id_survey = loc.substring(loc.lastIndexOf("=")+1);
}
if(id_survey !== ""){
    getInfoSurvey();
    getQuestion();
}
});

