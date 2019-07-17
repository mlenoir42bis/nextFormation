/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//vars globales
var mon_timer;

//on attend le chargement du doc
window.addEventListener('load', init);

function init() {

    //ajout evenement de click sur le lien #start_link
    document.getElementById('start_link').addEventListener('click', function (event) {
        event.preventDefault(); //annule le comportement standard du lien
        startClock();
    });


    //ajout evenement de click sur le lien #stop_link
    document.getElementById('stop_link').addEventListener('click', function (event) {
        event.preventDefault(); //annule le comportement standard du lien
        stopClock();
    });

}


function startClock() {

    //autre maniere d'utiliser un timer
    //on definit une interval, et tout les intervals on appel une fonction
    mon_timer = setInterval(function () {
        //ici je recupere la date et l'heure du systeme
        var systemDate = new Date(); //Date objet js qui renvoit une date et une heure

        //je recupere les heures, minutes et secondes
        var currentSeconds = systemDate.getSeconds();
        var currentMinutes = systemDate.getMinutes();
        var currentHours = systemDate.getHours();

        displayAiguilles(currentSeconds, 'secondes');
        displayAiguilles(currentMinutes, 'minutes');
        displayAiguilles(currentHours, 'heures');
    }, 1000);

}

function stopClock() {
    clearInterval(mon_timer); //kill l'interval
}

function displayAiguilles(nb, id) {
    var angle = nb * 6; //360 / 60 => 6deg
    var div = document.getElementById(id);
    div.style.transform = 'rotate(' + angle + 'deg)';
}
