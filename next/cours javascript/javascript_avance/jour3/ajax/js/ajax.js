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
        xhr.open("GET", "server/first.php", true);


        //definir le traitement en cas de succes
        xhr.onreadystatechange = function () {
            //readyState =4 => request finished and response is ready
            //status =200 => OK
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    //tout est ok
                    var text = xhr.responseText;
                    alert(text);
                } else {
                    //pas ok
                    alert(xhr.status);
                }
            }

        };

        xhr.send(); //envoit la requete
    });

}
