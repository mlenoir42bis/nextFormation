/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('load', init);

function init() {

    //recupere la liste des boutons radios
    var radioList = document.querySelectorAll('input[type=radio]');
    
    for (var i = 0; i < radioList.length; i++) {
        var parent = radioList[i].parentNode; //recupere le pere, ici c'est body

        //console.log(radioList[i].name);

        //creation d'un span
        var elt = document.createElement('span');
        elt.className = 'custom_radio ' + radioList[i].name + ' off';
        elt.id = i;

        //inserer le span avant le label
        //nextSibling => renvoie l'element qui suit
        //insertBefore => 1 param : elt à inserer, 2eme param: elt qui suit l'insertion
        parent.insertBefore(elt, radioList[i].nextSibling);

        //on cache les boutons radio
        radioList[i].style.display = 'none';
        //on force le uncheck, car bug au demarrage
        uncheckAllRadio(radioList[i].name);

        //ajouter un evenement de clic sur le span custom
        elt.addEventListener('click', function () {
            
            //le bouton radio qui nous interesse est l'element precedant l'elt custom
            var radio = this.previousSibling;
             
            //on verifie si le bouton radio est décoché
            if (!radio.checked) {
                uncheckAllRadio(radio.name); //decoche les radio cachés
                uncheckAllSpan(radio.name); //decoche les spans
                //coche celui en cours
                radio.checked = true; 
                this.className = "custom_radio "+radio.name+" on";
            }
        });

    }



}

//fonction qui change le background de tous les span custom_radio à off 
function uncheckAllSpan(nom){
    var eltList = document.querySelectorAll('.custom_radio.'+nom);
    for(var i=0;i<eltList.length;i++){
        eltList[i].className = "custom_radio "+nom+" off";
    }
}

//fonction qui decoche tous les boutons radio hidden
function uncheckAllRadio(nom){
    var eltList = document.querySelectorAll('input[name='+nom+']');
    for(var i=0;i<eltList.length;i++){
        eltList[i].checked = false;
    }
}