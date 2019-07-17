/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//pas besoin de charger le document pour declarer les variables globales
//definition des touches
var KEY_0 = 96;
var KEY_1 = 97;
var KEY_2 = 98;

//var globale pour le son en cours
var currentSound;

//on attend que le doc soit chargé initialiser notre script
window.addEventListener('load', init);

function init() {

    //ajout evenement keydown sur la fenetre du navigateur
    window.addEventListener('keydown', function (event) {

        switch (event.keyCode) {
            case KEY_0:
                playSound('bd');
                break;
            case KEY_1:
                playSound('sd');
                break;
            case KEY_2:
                playSound('hh');
                break;
            default:
                //on arrive si on presse une autre touche que les 3 définies
                break;
        }

    });

}

//fonction qui demarre un son
function playSound(id) {
    var sound = document.getElementById(id);
    currentSound = sound;
    sound.play();
}
