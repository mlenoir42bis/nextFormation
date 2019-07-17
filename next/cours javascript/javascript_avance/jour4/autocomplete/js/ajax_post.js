/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('load', init);

function init() {

    //ajoute une evenement de click sur le lien
    document.getElementById('link').addEventListener('click', function (event) {
        event.preventDefault();

        //recupere la valeur du champ texte mon_prenom
        var mon_prenom = document.getElementById('mon_prenom').value;

        //Creation d'un XMLHttpRequest
        var xhr = new XMLHttpRequest();

        //definit la methode, l'url et async
        xhr.open('POST', 'server/post.php', true);


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
        //on changer l'entete http et on precise que ce sont des data type form
        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhr.send('prenom=' + mon_prenom + "&nom=white"); //on envoit les datas

    });

}


function callBack(text) {
    alert(text);
}