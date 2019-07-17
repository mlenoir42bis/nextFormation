
$(window).on('load', function(){
   

});

$(document).ready(function(){
    
});

$(function(){
    
});

    $("#test").on('click', function(){
       newDiv = $('<div class="wtf">');
       newDiv.html('texte de wtf');
       $("#test").prepend(newDiv);
       
       console.log($(".wtf").length);
       console.log($(".wtf"));
    });