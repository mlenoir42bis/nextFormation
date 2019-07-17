/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//vars globales
var mon_timer;
var mon_horloge;

//on attend le chargement du doc
window.addEventListener('load', init);

function init() {

    //recupere l'elt #horloge
    mon_horloge = document.getElementById('horloge');

    //setTimeout declenche l'appel de la fonction dans 5 seconds
    //en milliseconds => 1s = 1000 ms
    /*setTimeout(function(){
     alert('yo');
     }, 5000);
     */

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


function getCurrentTime() {
    //ici je recupere la date et l'heure du systeme
    var systemDate = new Date(); //Date objet js qui renvoit une date et une heure

    //je recupere les heures, minutes et secondes
    var seconds = systemDate.getSeconds();
    var minutes = systemDate.getMinutes();
    var hours = systemDate.getHours();


    //on ajoute un 0 devant les heures, minutes, secondes si sur 1 chiffre
    //toString() => transforme une variable en une chaine de caractere
    if (seconds.toString().length == 1) {
        seconds = '0' + seconds;
    }

    if (minutes.toString().length == 1) {
        minutes = '0' + minutes;
    }

    if (hours.toString().length == 1) {
        hours = '0' + hours;
    }


    //je fabrique une chaine de caracteres avec heure:minute:seconde
    var systemTimeStr = hours + ':' + minutes + ':' + seconds;

    return systemTimeStr;
}

function startClock() {
    mon_horloge.innerHTML = '<p>' + getCurrentTime() + '</p>';
    
    //autre maniere d'utiliser un timer
    //on definit une interval, et tout les intervals on appel une fonction
    mon_timer = setInterval(function () {
        mon_horloge.innerHTML = '<p>' + getCurrentTime() + '</p>';
    }, 1000);

}

function stopClock(){
    clearInterval(mon_timer); //kill l'interval
}