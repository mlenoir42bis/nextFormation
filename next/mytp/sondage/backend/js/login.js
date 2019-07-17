

$(window).on('load', getRegister);


function getRegister(){
    
    $('#register').hide();
    
    $('#getRegister').on('click', function(){
        
        $('#register').show();
        
    });
}


