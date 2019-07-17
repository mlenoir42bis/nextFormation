/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//var globale
var ma_canvas;


window.addEventListener('load', init);


function init() {
    //recupere l'elt canvas
    ma_canvas = document.getElementById('ma_canvas');

    var context = ma_canvas.getContext('2d'); //determine le contexte 2d ou 3d
    context.fillStyle = '#000000'; //choisir couleur de remplissage
    context.fillRect(0, 0, 150, 50); //dessine un rectangle plein

    //recupere l'elt image
    var vaisseau = document.getElementById('vaisseau');
    context.drawImage(vaisseau, 300, 200); //ajoute l'image dans le canvas

    ma_canvas.addEventListener('mousemove', drawPixel);


}

function drawPixel(event) {
    console.log(event.clientX + ' ' + event.clientY);
}


