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
        
        //creation d'un span
        var elt = document.createElement('span');
        elt.className= 'custom_radio off';
        elt.id = i;
        
        //inserer le span avant le label
        //nextSibling => renvoie l'element qui suit
        //insertBefore => 1 param : elt à inserer, 2eme param: elt qui suit l'insertion
        parent.insertBefore(elt, radioList[i].nextSibling);
        
        //on cache les boutons radio
        radioList[i].style.display = 'none';
        
        //ajouter un evenement de clic sur le span custom
        elt.addEventListener('click',function(){
            
            //le bouton radio qui nous interesse est l'element precedant l'elt custom
            var radio = this.previousSibling;

            //on verifie si le bouton radio est coché
            if(radio.checked){
                radio.checked = false;
                this.className="custom_radio off";
            }else{
                radio.checked = true;
                this.className="custom_radio on";
            }
        });
        
    }



}
