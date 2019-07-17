/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//dom ready
$(function () {

    //initialisation de la carte
    var ma_carte = new google.maps.Map(document.getElementById("ma_carte"), {
        zoom: 15,
        center: new google.maps.LatLng(48.858565, 2.347198),
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    //panel sera utilisé pour afficher le détail
    var panel = document.getElementById('panel');

    //evet de clic sur le bouton calculer
    $('#go').click(function () {
        $('#panel').html(''); //vide le panel
        var from = $('#from').val();
        var to = $('#to').val();
        var travel_mode = $('#travel_mode').val();
        var travel = 'DRIVING';

        if (travel_mode == 2) {
            travel = 'BICYCLING';
        }

        //on declare l'utilisation de l'api pour les directions
        var directionsService = new google.maps.DirectionsService();

        //options que l'on va donner au service
        var directionsRequest = {
            origin: from,
            destination: to,
            travelMode: google.maps.DirectionsTravelMode[travel],
            unitSystem: google.maps.UnitSystem.METRIC
        };

        //calcule l'itineraire
        directionsService.route(
                directionsRequest,
                function (response, status)
                {
                    if (status == google.maps.DirectionsStatus.OK)
                    {
                        new google.maps.DirectionsRenderer({
                            map: ma_carte,
                            directions: response,
                            panel: panel
                        });
                    }
                    else
                        $("#error").append("Unable to retrieve your route<br />");
                }
        );

    });


});
