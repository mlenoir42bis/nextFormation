/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//variables globales
var clicState = false; //variable pour determiner si on est en train de cliquer ou pas
var mon_ecran;
var taille= '1px';
var couleur = 'black';

//on attend que le doc soit chargé
window.addEventListener('load', init);

function init() {
    mon_ecran = document.getElementById('ecran');

    //ajouter un evenement mousedown sur la fenetre
    window.addEventListener('mousedown', function () {
        clicState = true;
    });

    //ajouter un evenement mouseup sur la fenetre
    window.addEventListener('mouseup', function () {
        clicState = false;
    });

    //ajouter un evenement mousemove sur la fenetre
    mon_ecran.addEventListener('mousemove', function (event) {
        if(clicState){
            draw(event.clientX , event.clientY);
        }
    });

    //ajouter un evenement sur la select taille
    document.getElementById('taille').addEventListener('change', function(){
        //this fait reference à l'element qui a déclenché l'evenement
        taille = this.options[this.selectedIndex].value; //recupere la valeur de l'option selectionnée
    });
    
    //ajouter un evenement change sur l'input de type color
    document.getElementById('couleur').addEventListener('change', function(){
        couleur= this.value;
    });
    
    //ajoute un evenement de clic sur le lien refresh
    //on passe en parametre une fonction qui s'appelle recharger
    document.getElementById('refresh').addEventListener('click', recharger);
    
}

function draw(x,y){
    
    var mon_div = document.createElement('div');
    with (mon_div.style){
        width = taille;
        height = taille;
        backgroundColor = couleur;
        position = 'absolute';
        left = x+'px';
        top = y+'px';
    }
    mon_ecran.appendChild(mon_div);
}


//event est implicitement transmis par addEventListener
function recharger(event){
    event.preventDefault();
    window.location.reload(); //recharge la page
}