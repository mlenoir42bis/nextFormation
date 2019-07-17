/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//var globales
var slider;
var bandeau_controls;
var bandeau_photos;
var bandeau_puces;
var photo_list;
var slider_width;
var slider_height;
var currentPhoto = 0; //initialise à 0
var direction = 'left';
var mon_timer;

//on attend le chargement complet du doc
window.addEventListener('load', init);

//init
function init() {
    //on recupere le div slider
    slider = document.getElementById('slider');

    //on recupere la liste des images
    photo_list = document.querySelectorAll('#slider img');

    //si pas de photo on arrete
    if (photo_list.length == 0) {
        return;
    }

    //déterminer les dimensions du slider à partir de la première photo
    slider_width = photo_list[0].width;
    slider_height = photo_list[0].height;

    //on dimensionne le div slider
    slider.style.width = slider_width + 'px';
    slider.style.height = slider_height + 'px';

    //construit le bandeau photo
    buildBandeauPhotos();

    //construit le bandeau controls
    buildBandeauControls();

    //construit le bandeau puces
    buildBandeauPuces();

    //on vide le contenu html du div slider
    slider.innerHTML = '';

    //on ajoute le bandeau_photos au slider
    slider.appendChild(bandeau_photos);

    //on ajoute le bandeau de controls au slider
    slider.appendChild(bandeau_controls);

    //on ajoute le bandeau de puces
    slider.appendChild(bandeau_puces);

    //ajout evenement mouseover et mouseout sur le slider pour afficher le bandeau controls etle bandeau puces
    slider.addEventListener('mouseover', function () {
        bandeau_controls.style.opacity = '1';
        bandeau_controls.style.transition = '1s';
        bandeau_puces.style.opacity = '1';
        bandeau_puces.style.transition = '1s';
    });

    slider.addEventListener('mouseout', function () {
        bandeau_controls.style.opacity = '0';
        bandeau_controls.style.transition = '1s';
        bandeau_puces.style.opacity = '0';
        bandeau_puces.style.transition = '1s';
    });

    //on ajoute les controls sur les liens
    addControlLinks();


    //on va gere les liens de clic sur les puces
    var pucesLinkList = document.querySelectorAll('.puce_link');

    //parcours de la liste et ajout d'un listener sur chaque element
    for (var i = 0; i < pucesLinkList.length; i++) {
        pucesLinkList[i].addEventListener('click', function (event) {
            event.preventDefault();
            currentPhoto = this.getAttribute('num_photo'); //recupere la valeur de l'attribut
            displayPhoto();
        });
    }


    setActivePuce(currentPhoto); //pour le premier chargement
} //fin du init

//affiche une photo avec une transition
function displayPhoto() {
    setActivePuce(currentPhoto); //active la puce
    bandeau_photos.style.transform = 'translate(-' + (currentPhoto * slider_width) + 'px, 0px)';
    bandeau_photos.style.transition = '1s';
}

//parametre les liens de controls
function addControlLinks() {

    //ajout evenement de click sur lien next
    document.getElementById('next_photo').addEventListener('click', function (event) {
        event.preventDefault();
        currentPhoto++;

        if (currentPhoto < photo_list.length) {
            displayPhoto();
        } else {
            currentPhoto = photo_list.length - 1;
        }

    });

    //ajout evenement de click sur lien previous
    document.getElementById('previous_photo').addEventListener('click', function (event) {
        event.preventDefault();
        currentPhoto--;
        if (currentPhoto >= 0) {
            displayPhoto();
        } else {
            currentPhoto = 0;
        }
    });

    //ajout evenement click sur les liens play et pause
    //play
    document.getElementById('play_photo').addEventListener('click', function (event) {
        event.preventDefault();
        clearInterval(mon_timer);
        mon_timer = setInterval(function () {

            if (direction == 'left') {
                currentPhoto++;
            } else {
                currentPhoto--;
            }

            if (currentPhoto == photo_list.length - 1) {
                direction = 'right';
            }

            if (currentPhoto == 0) {
                direction = 'left';
            }

            if (currentPhoto >= 0 && currentPhoto < photo_list.length) {
                displayPhoto();
            }
        }, 2000);
    });

    //pause
    document.getElementById('pause_photo').addEventListener('click', function (event) {
        event.preventDefault();
        clearInterval(mon_timer); //kill le timer
    });

}

//construction d'un bandeau de controls
function buildBandeauControls() {

    bandeau_controls = document.createElement('div');
    bandeau_controls.id = 'bandeau_controls';

    bandeau_controls.innerHTML = '<a href="#" id="previous_photo"><img src="img/prev.png" /></a>\n\
                                    &nbsp;<a href="#" id="pause_photo"><img src="img/pause.png" /></a>\n\
                                    &nbsp;<a href="#" id="play_photo"><img src="img/play.png" /></a>\n\
                                    &nbsp;<a href="#" id="next_photo"><img src="img/next.png" /></a>';
}

//créer un div bandeau photo
function buildBandeauPhotos() {

    bandeau_photos = document.createElement('div');
    bandeau_photos.id = "bandeau_photos";
    bandeau_photos.style.width = (photo_list.length * slider_width) + 'px'; //nb de photo x slider width
    bandeau_photos.style.height = slider_height + 'px';

    //ajout de toutes les images dans le bandeau photos
    for (var i = 0; i < photo_list.length; i++) {
        bandeau_photos.appendChild(photo_list[i]); //on ajoute les images les unes à la suite des autres
    }
}


//construction d'un bandeau de puces
function buildBandeauPuces() {

    bandeau_puces = document.createElement('div');
    bandeau_puces.id = 'bandeau_puces';

    //on fabrique le contenu html du bandeau puces
    var html = '';
    //on parcours la liste des photos
    for (var i = 0; i < photo_list.length; i++) {
        html += '<a href="#" class="puce_link" num_photo="' + i + '" ><img src="img/puce.png" /></a>';
    }

    bandeau_puces.innerHTML = html;
}

function setActivePuce(num) {

    var imgList = document.querySelectorAll('.puce_link img');
    for (var i = 0; i < imgList.length; i++) {
        imgList[i].src = "img/puce.png";
    }
    
    imgList[num].src ="img/puce_active.png";

}