/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//var globale
var overlay;

//on attend que le doc soit chargé
window.addEventListener('load', init);

function init() {

    //recuperation de la liste des liens avec attribut rel = lightbox
    var lightboxLinks = document.querySelectorAll('a[rel=lightbox]');

    //parcours de la liste et ajout evenement de click
    for (var i = 0; i < lightboxLinks.length; i++) {

        //afficher l'overlay

        //recuperer l'image descendante de l'element a
        var image = lightboxLinks[i].querySelector('img');

        console.log(image.src);
        //recupere la taille d'origine
        console.log(image.naturalWidth); //naturalWidth => dans les navigateurs recents
        console.log(image.naturalHeight);//naturalHeight => dans les navigateurs recents
    }


    buildOverlay();
}

function buildOverlay() {

    overlay = document.createElement('div');
    overlay.id = "overlay";
    overlay.style.width = document.body.clientWidth + 'px';
    overlay.style.height = getDocumentHeight() + 'px';

    document.body.appendChild(overlay);
}

//recupere la hauteur du document
function getDocumentHeight() {
    var body = document.body;
    var html = document.documentElement;

    var height = Math.max(body.scrollHeight, body.offsetHeight,
            html.clientHeight, html.scrollHeight, html.offsetHeight);

    return height;
}