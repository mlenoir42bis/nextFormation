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
var taille;


window.addEventListener('load', init);


function init() {

    //par defaut
    if (localStorage.getItem('couleur') !== null) {
        couleur = localStorage.getItem('couleur');
    } else {
        couleur = "#CCCCCC";
    }

    if (localStorage.getItem('taille') !== null) {
        taille = localStorage.getItem('taille');
    } else {
        taille = 1;
    }

    if (localStorage.getItem('back') !== null) {
        back = localStorage.getItem('back');
    } else {
        back = "img/bg.jpg";
    }

    //recupere l'elt canvas
    ma_canvas = document.getElementById('ma_canvas');

    document.getElementById('couleur').value = couleur;
    document.getElementById('taille').value = taille;
    document.getElementById('back').value = back;
    ma_canvas.style.backgroundImage = 'url(' + back + ')';




    context = ma_canvas.getContext('2d'); //determine le contexte 2d ou 3d
    context.fillStyle = '#000000'; //choisir couleur de remplissage
    context.fillRect(0, 0, 150, 50); //dessine un rectangle plein

    //recupere l'elt image
    var vaisseau = document.getElementById('vaisseau');
    context.drawImage(vaisseau, 300, 200); //ajoute l'image dans le canvas

    ma_canvas.addEventListener('mousemove', drawPixel);

    window.addEventListener('mousedown', function (event) {
        draw = true;
        context.beginPath(); //demarre un nouveau chemin
        context.moveTo(getRealX(event.clientX), getRealY(event.clientY)); //demarre le chemin au niveau du clic
    });

    window.addEventListener('mouseup', function () {
        draw = false;
    });

    //ajout de evenement change sur l'input couleur
    document.getElementById('couleur').addEventListener('change', function () {
        couleur = this.value; //value => valeur du champ input
        localStorage.setItem('couleur', couleur); //enregistre la valeur de la couleur
    });

    document.getElementById('taille').addEventListener('change', function () {
        taille = this.value; //value => valeur du champ input
        localStorage.setItem('taille', taille); //enregistre la valeur de la couleur
    });


    document.getElementById('reset_butt').addEventListener('click', function () {
        context.clearRect(0, 0, 600, 400);
    });

    document.getElementById('back').addEventListener('change', function () {
        ma_canvas.style.backgroundImage = 'url(' + this.value + ')';
        localStorage.setItem('back', this.value);
    });

}

function drawPixel(event) {
    if (draw) {
        context.lineWidth = taille;
        context.strokeStyle = couleur;
        context.lineTo(getRealX(event.clientX), getRealY(event.clientY)); //definit une droite
        context.stroke();//transforme le tracé en trait
    }
}

function getRealX(num) {
    return num - ma_canvas.getBoundingClientRect().left;
}

function getRealY(num) {
    return num - ma_canvas.getBoundingClientRect().top;
}