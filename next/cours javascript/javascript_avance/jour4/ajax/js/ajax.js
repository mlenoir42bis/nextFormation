/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('load', init);

function init() {


    document.getElementById('link').addEventListener('click', function (event) {
        console.log('click');
        event.preventDefault();

        var xhr = new XMLHttpRequest(); //Creation d'un objet XMLHttpRequest

        //open
        //1er param => type de methode
        //2em param => url
        //3em param => async true or false
        xhr.open("GET", "server/first.php?prenom=fabien", true);


        //definir le traitement en cas de succes
        xhr.onreadystatechange = function () {
            //readyState =4 => request finished and response is ready
            //status =200 => OK
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    //tout est ok
                    var text = xhr.responseText;
                    callBack(text); //appelle cette fonction en cas de succes
                } else {
                    //pas ok
                    alert(xhr.status);
                }
            }

        };

        xhr.send(); //envoit la requete
    });


    document.getElementById('json_link').addEventListener('click', function (event) {
        console.log('click');
        event.preventDefault();

        var xhr = new XMLHttpRequest(); //Creation d'un objet XMLHttpRequest

        //open
        //1er param => type de methode
        //2em param => url
        //3em param => async true or false
        xhr.open("GET", "server/second.php", true);


        //definir le traitement en cas de succes
        xhr.onreadystatechange = function () {
            //readyState =4 => request finished and response is ready
            //status =200 => OK
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    //tout est ok
                    var text = xhr.responseText;
                    callBackJson(text); //appelle cette fonction en cas de succes
                } else {
                    //pas ok
                    alert(xhr.status);
                }
            }

        };

        xhr.send(); //envoit la requete
    });

}


//fonction qui sera appelée si tout est ok
function callBack(text) {
    alert(text);
}

//fonction qui est appelée si tout est ok lorsque l'on clique sur le lien json_link
function callBackJson(text) {
    console.log(text);
    var json = JSON.parse(text); //=>tranforme une chaine de caractere en json
    console.log(json);
    displayPersonnes(json); //on appelle une fonction pour afficher le resultat
}

//fonctions qui va afficher une liste de personnes
function displayPersonnes(data) {

    var html = '';
    for (var i = 0; i < data.length; i++) {
        html += data[i].prenom + ' ' + data[i].nom + '<br />';
    }

    document.getElementById('liste_personne').innerHTML = html;
}