/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//definition de constantes
//le mot clé const n'est pas standard
var UP_ARROW = 38;
var DOWN_ARROW = 40;
var LEFT_ARROW = 37;
var RIGHT_ARROW = 39;
var SPACE = 32;

//var globale
var mon_div;

//on attend le chargement du doc complet
window.addEventListener('load', init);

function init(){
    
    //on attend bien que le doc soit chargé avant d'affecter l'element à la var mon_div
    mon_div = document.getElementById('div1');
    
    window.addEventListener('keydown', function(event){
        console.log(event.keyCode);
        switch(event.keyCode){
            case UP_ARROW:
                moveUp();
                break;
            case DOWN_ARROW:
                moveDown();
                break;
            case LEFT_ARROW:
                moveLeft();
                break;
            case RIGHT_ARROW:
                moveRight();
                break;
            case SPACE:
                rotation();
                break;
        }
    });
    
}

function moveRight(){
    //console.log(getComputedStyle(mon_div).getPropertyValue("left"));
    var pos = mon_div.offsetLeft;
    mon_div.style.left = (pos + 10)+'px';
}

function moveLeft(){
    var pos = mon_div.offsetLeft;
    mon_div.style.left = (pos - 10)+'px';
}

function moveUp(){
    var pos = mon_div.offsetTop;
    mon_div.style.top = (pos - 10)+'px';
}

function moveDown(){
    var pos = mon_div.offsetTop;
    mon_div.style.top = (pos + 10)+'px';
}

function rotation(){
    mon_div.style.transform = 'rotate(360deg)';
    mon_div.style.transition = '0.5s';
}



