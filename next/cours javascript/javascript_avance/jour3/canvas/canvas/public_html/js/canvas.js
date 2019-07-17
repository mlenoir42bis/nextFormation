/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//var globale
var ma_canvas;
var draw = false;
var context;
var couleur;

window.addEventListener('load', init);


function init() {

    //par defaut
    if (localStorage.getItem('couleur') !== null) {
        couleur = localStorage.getItem('couleur');
    } else {
        couleur = "#CCCCCC";
    }

    document.getElementById('couleur').value = couleur;

    //recupere l'elt canvas
    ma_canvas = document.getElementById('ma_canvas');

    context = ma_canvas.getContext('2d'); //determine le contexte 2d ou 3d
    context.fillStyle = '#000000'; //choisir couleur de remplissage
    context.fillRect(0, 0, 150, 50); //dessine un rectangle plein

    //recupere l'elt image
    var vaisseau = document.getElementById('vaisseau');
    context.drawImage(vaisseau, 300, 200); //ajoute l'image dans le canvas

    ma_canvas.addEventListener('mousemove', drawPixel);

    window.addEventListener('mousedown', function () {
        draw = true;
    });

    window.addEventListener('mouseup', function () {
        draw = false;
    });

    //ajout de evenement change sur l'input couleur
    document.getElementById('couleur').addEventListener('change', function () {
        couleur = this.value; //value => valeur du champ input
        localStorage.setItem('couleur', couleur); //enregistre la valeur de la couleur
    });
}

function drawPixel(event) {

    var x = event.clientX - ma_canvas.getBoundingClientRect().left;
    var y = event.clientY - ma_canvas.getBoundingClientRect().top;

    if (draw) {
        context.fillStyle = couleur;
        context.fillRect(x, y, 10, 10);
    }
}


