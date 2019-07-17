/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//evenement qui est lancé quand tout est chargé
window.addEventListener('load',function(){
    
    console.log('chargé');
    
    //ecran
    var ecran = document.getElementById('ecran');
    //var ecran = document.querySelector('#ecran'); //Selecteur css
   
    //recupere la liste des elements qui ont la classe .link
    var linkList =document.querySelectorAll('.link');
    console.log(linkList);
    
    //calcul le nombre de l'element
    var nbElt = linkList.length;
    console.log(nbElt);
    
    //parcours de la liste des element
    for(var i=0; i < nbElt; i++){
        
        //ajoute evenement de clic sur chaque element
        linkList[i].addEventListener('click',function(event){
            event.preventDefault();
            //event.target => recupere l'element qui a déclenché l'event
            if(event.target.id=='='){
                //console.log(ecran.innerHTML);
                //console.log(eval(ecran.innerHTML)); //eval => interprete la chaine de caractere en js
                ecran.innerHTML = eval(ecran.innerHTML);
            }else{
                ecran.innerHTML+= event.target.id; 
            }
        });
    }
});


