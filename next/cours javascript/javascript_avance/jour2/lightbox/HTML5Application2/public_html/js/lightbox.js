/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//var globale
var overlay;

//on attend que le doc soit chargé
window.addEventListener('load', init);

//event de redimension
window.addEventListener('resize', initResize);

function init() {

    //contruction de l'overlay
    buildOverlay();

    //recuperation de la liste des liens avec attribut rel = lightbox
    var lightboxLinks = document.querySelectorAll('a[rel=lightbox]');

    //parcours de la liste et ajout evenement de click
    for (var i = 0; i < lightboxLinks.length; i++) {
        //ajout evenement de clic sur chaque lien
        lightboxLinks[i].addEventListener('click', addClick);
    }
}

//special pour les redimensions
function initResize() {

    //recuperation de la liste des liens avec attribut rel = lightbox
    var lightboxLinks = document.querySelectorAll('a[rel=lightbox]');

    //parcours de la liste et ajout evenement de click
    for (var i = 0; i < lightboxLinks.length; i++) {
        //ajout evenement de clic sur chaque lien
        lightboxLinks[i].removeEventListener('click', addClick);
    }

    //on enleve l'overlay du body si dans le doc lors du resize
    if (overlay.parentNode == document.body) {
        document.body.removeChild(overlay);
    }

    init();
}


function buildOverlay() {

    overlay = document.createElement('div');
    overlay.id = "overlay";
    overlay.style.width = document.body.clientWidth + 'px';
    overlay.style.height = getDocumentHeight() + 'px';

    //ajouter une evenement de click pour cacher l'overlay
    overlay.addEventListener('click', function () {
        hideImage();
        setTimeout(function () {
            hideOverlay();
        }, 600);

    });

}

//recupere la hauteur du document
function getDocumentHeight() {
    var body = document.body;
    var html = document.documentElement;

    var height = Math.max(body.scrollHeight, body.offsetHeight,
            html.clientHeight, html.scrollHeight, html.offsetHeight);

    return height;
}

//on affiche l'overlay
function showOverlay() {
    overlay.innerHTML = ''; //vide l'overlay
    document.body.appendChild(overlay);
    //ajout d'un time out pour laisser le temps d'ajouter l'overlay avant la transition
    setTimeout(function () {
        overlay.style.opacity = '1';
        overlay.style.transition = '0.5s'; //on ajoute au body
    }, 10);

}

//cacher l'overlay
function hideOverlay() {
    overlay.style.opacity = '0';
    overlay.style.transition = '0.5s';
    //on attend 0.6 seconde avant d'enlever l'overlay du body
    //permet à la transition de s'effectuer
    setTimeout(function () {
        //on ne l'enleve de l'overlay que si il est dans le body
        if (overlay.parentNode == document.body) {
            document.body.removeChild(overlay); //on enleve l'overlay du body
        }
    }, 600);
}

//fonction qui affiche l'image
function showImage(url, width, height) {

    //creation de l'image
    var image = document.createElement('img');
    image.src = url;
    image.style.width = '0px';
    image.style.height = '0px';

    //ajout de l'image dans l'overlay
    overlay.appendChild(image);

    //animation pour affichage, avec delai pour laisser le temps à l'image de se mettre dans le doc
    setTimeout(function () {
        image.style.width = width + 'px';
        image.style.height = height + 'px';
        image.style.transition = '0.5s';
    }, 50);

}

function hideImage() {
    var image = overlay.querySelector('img');
    image.style.width = '0px';
    image.style.height = '0px';
    image.style.transition = '0.5s';
}

function addClick(event) {
    event.preventDefault(); //annule le comportement standard

    //recuperer l'image descendante de l'element courant
    var image = this.querySelector('img');

    showOverlay(); //affiche l'overlay

    //on attend que l'affichage de l'overlay soit complet
    setTimeout(function () {
        //naturalWidth et naturalHeight permettent de recupere la taille originale de l'image
        //marche seulement sur les browsers récents
        showImage(image.src, image.naturalWidth, image.naturalHeight);
    }, 600);

}