/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {

    //ajout evenement de click sur bouton pour sauvegarder la position
    $('#add_link').click(function (event) {
        event.preventDefault();

        //si on a la geoloc
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(savePosition); //savePosition => callback, une fonction qui est appelée quand le navigateur s'est localisé
        }


    });

    function savePosition(pos) {

        var longitude = pos.coords.longitude;
        var latitude = pos.coords.latitude;

        //appel ajax pour sauvegarde des coords en base
        $.ajax({
            type: 'POST',
            url: 'backend/save_position.php',
            data: {latitude: latitude, longitude: longitude},
            dataType: 'text',
            success: function (data) {
                $('#loading').hide();
                if (data == 'SUCCESS') {
                    $('#message').html('<p>Position sauvegardée</p>');
                } else {
                    alert('Erreur');
                }
            },
            beforeSend:function(){
                $('#message').html('');
                $('#loading').show();
            }
        });

    }

    $('#delete_link').click(function(event){
        event.preventDefault();
        
        $.ajax({
            type:'GET',
            url:'backend/reinit_position.php',
            dataType:'text',
            success:function(data){
                $('#loading').hide();
                if(data=='SUCCESS'){
                    $('#message').html('<p>Parcours rénitialisé</p>');
                    setTimeout(function(){
                        $('#message').html('');
                    },1500);
                }else{
                    alert('Erreur');
                }
            },
            beforeSend:function(){
                $('#message').html('');
                $('#loading').show();
            }
        });
        
        
        
    });

});

