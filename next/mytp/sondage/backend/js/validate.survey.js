var registerFormIsValid = true;

$("#survey_form").on("submit", validFormSurvey);

//ajout d'un message d'erreur sur une balise (selector)
function addError(selector, message){
	registerFormIsValid = false; //on a au moins une erreur, donc il ne faudra pas soumettre
	$(selector).siblings(".help-block").html(message);
	$(selector).parent()
		.addClass("has-error")
		.removeClass("has-success");
}

//enlève les messages d'erreur
function addSuccess(selector){
	$(selector).siblings(".help-block").html("");
	$(selector).parent()
		.addClass("has-success")
		.removeClass("has-error");
}

function validNewsSurvey(){
    registerFormIsValid = true;
    
    var title = $("#title").val();
      
	if (title === ""){
		addError("#title", "Please enter a title for the survey !");
	}
	else {
		addSuccess("#title");
	}
    var description = $("#description").val();
      
	if (description === ""){
		addError("#description", "Please enter a description for the survey !");
	}
	else {
		addSuccess("#description");
	}
}

//input[type=text]

//gère la soumission du formulaire
function validFormSurvey(e){
    e.preventDefault();
    var error = [];
    
        validNewsSurvey();
        
        console.log($("#contentQuestion input[type=text]").attr('name'));
        
            $("#contentQuestion input[type=text]").each(function(k, v){
                var elem = $(v).val();

                if (elem === ""){
                    addError($(v), "Please fill in this field!");
                    error.push('\n' + $(v).attr('name'));
                }
                else {
                    addSuccess($(v));
                }
            });
       
    //seulement si le form est valide....
    if( registerFormIsValid ){
            //enlève la mise sous écoute
            //sinon le formulaire sera revalidé à l'infini !
            $("#survey_form").off("submit");

            //déclenche la soumission du formulaire
            $("#survey_form").submit();
    }
    else{
        alert('Please check the question :' + error);
    }
}