/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//dom ready
$(function () {

    var ma_carte;

    //calculer la taille de la carte
    var largeur = ($(document).innerWidth()) - 40; //j'enleve 10px pour ne pas coller aux bords
    var hauteur = ($(document).innerHeight()) - 150; //j'enleve 10px pour ne pas coller aux bords

    //on affecte la taille au div #ma_carte
    $('#ma_carte').width(largeur);
    $('#ma_carte').height(hauteur);

    //encapsulation dans evenement pagechange pour affichage correct de la carte
    $(document).bind('pagechange', function () {
        //initialisation de la map
        ma_carte = new google.maps.Map(document.getElementById("ma_carte"), {
            zoom: 15,
            center: new google.maps.LatLng(48.858565, 2.347198),
            mapTypeId: google.maps.MapTypeId.ROADMAP
        });


        //récupération du parcours
        $.ajax({
            type: 'GET',
            url: 'backend/get_parcours.php',
            dataType: 'json',
            success: function (data) {
                afficheParcours(data);
            }

        });


    });

    function afficheParcours(data) {

        var parcours = []; //tableau de coordonnées 

        $.each(data, function (index, point) {

            var icon;
            var info;

            if (index == 0) {
                //centre la carte sur le premier point
                ma_carte.setCenter(new google.maps.LatLng(point.latitude, point.longitude));
                icon = 'img/start.png'; //on change l'icone
                info = '<p>Départ</p>';
            } else if (index == (data.length - 1)) {
                //si dernier point, on change l'icone
                icon = 'img/finish.png';
                info = '<p>Arrivée</p>';
            } else {
                //sinon icone standard
                icon = '';
                info = '<p>Etape #' + index + '</p>';
            }

            var marqueur = new google.maps.Marker({
                position: new google.maps.LatLng(point.latitude, point.longitude),
                map: ma_carte,
                icon: icon,
                animation: google.maps.Animation.DROP
            });

            var infowindow = new google.maps.InfoWindow({
                content: info
            });

            google.maps.event.addListener(marqueur, 'click', function () {
                infowindow.open(ma_carte, marqueur);
            });


            //on ajoute le point au parcours
            parcours.push(new google.maps.LatLng(point.latitude, point.longitude));
        });

        //on trace le parcours
        var parcoursPath = new google.maps.Polyline({
            path: parcours,
            geodesic: true,
            strokeColor: '#FF0000',
            strokeOpacity: 1.0,
            strokeWeight: 2
        });

        parcoursPath.setMap(ma_carte);


    }

});
