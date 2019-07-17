/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.addEventListener('load',init);

function init(){
    
    //ajout evement de clic sur le bouton submit
    var btn = document.querySelector('input[type=submit]');
    
    //ajout evenement de clic sur boutons radio
    var radios = document.querySelectorAll('input[name=sexe]');

    for(var i=0; i<radios.length;i++){
        radios[i].addEventListener('click',function(){
            //console.log(this.value);
            if(this.value=='autre'){
                document.querySelector('[name=sexe_autre]').style.display = "block";
            }else{
                document.querySelector('[name=sexe_autre]').style.display = "none";
            }
        });
    }
    
    
    btn.addEventListener('click', function(event){
        event.preventDefault();//annule l'envoi du formulaire
        
        var errorMsg = [];
        
        //verifie si le champ nom est rempli
        if(!checkRequired('nom')){
            errorMsg.push('saisir un nom');
        }
        
        //verifie si le champ adresse est rempli
        if(!checkRequired('adresse')){
            errorMsg.push('saisir une adresse');
        }
        
        //verifie si le champ cp est valide
        if(!checkCP('cp')){
            errorMsg.push('saisir un code postal valide');
        }
        
        if(errorMsg.length>0){
            //on a des erreurs
            displayMessage(errorMsg.join('<br />'));
        }else{
            //pas d'erreur on soumet le formulaire
            
        }
        
        
        
        
    });
    
    
}

//fonction qui va verifier que le champ saisi est non vide
function checkRequired(inputName){
    if(inputName=='' || inputName==null){
        return false;
    }
    
    var elt = document.querySelector('[name='+inputName+']');
    
    if(elt.value!=''){
        return true;
    }
    
    return false;
    
}

//fonction qui va afficher un message
function displayMessage(str){
    var elt = document.getElementById('message');
    elt.innerHTML = '<p>'+str+'</p>'; //modifie le code html de l'element
    elt.className = "error"; //ajoute une classe à l'element
}

//fonction qui verifie le format du cp
function checkCP(inputName){
    if(inputName=='' || inputName==null){
        return false;
    }
    
    var elt = document.querySelector('[name='+inputName+']');
    
    //si c'est vide on renvoie true dans notre cas de figure car cp n'est pas obligatoire
    if(elt.value.length==0){
        return true;
    } 
    //si different de 5 (sup ou inf) on renvoie false
    if(elt.value.length!=5){
        return false;
    }
    //si ce sont des entiers ok
    if(parseInt(elt.value)==elt.value){
        return true;
    }
    
    return false;
    
    
    
}