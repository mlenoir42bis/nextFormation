/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.addEventListener('load', init);

function init() {

    //ajoute une evenement de keyup sur la boite de texte
    document.getElementById('commune').addEventListener('keyup', function (event) {

        //console.log(this.value);
        document.getElementById('loading').style.display = "inline"; //on affiche le loading

        //Creation d'un XMLHttpRequest
        var xhr = new XMLHttpRequest();

        //definit la methode, l'url et async
        xhr.open('GET', 'server/get_commune.php?commune=' + this.value, true);


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

        //on envoit la requete
        xhr.send();
    });


}

//fonction callback appellée en cas de succès
function callBack(text) {
    var json = JSON.parse(text);
    displayCommune(json);
    document.getElementById('loading').style.display = "none"; //cache le loading
}

//fonction qui va gérer l'affichage des communes
function displayCommune(data) {
    var reco = document.getElementById('recommandation'); //on recuperere le div
    reco.innerHTML = ''; //on vide son contenu

    var html = '';

    //on parcours les datas et on construit une chaine html
    for (var i = 0; i < data.length; i++) {
        html += '<a href="#" class="reco_link">' + data[i].code_postal + ' ' + data[i].nom + '</a><br />';
    }

    reco.innerHTML = html; //on ecrit le html dans le div

    //parcours de la liste des liens
    var linkList = document.querySelectorAll('.reco_link'); //selecteur css

    for (var i = 0; i < linkList.length; i++) {
        linkList[i].addEventListener('click', function (event) {

            event.preventDefault();
            document.getElementById('commune').value = this.text; //on affecte le texte du lien dans le input
            reco.innerHTML = '';

        });
    }

}