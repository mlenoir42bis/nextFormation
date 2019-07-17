/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//on attend le chargement de la page
window.addEventListener('load', function () {

    //recupere l'element select
    var mon_select = document.getElementById('zap');

    //recupre l'ecran
    var ecran = document.getElementById('ecran');

    //on ajoute une evenement change sur la select
    mon_select.addEventListener('change', function () {
        //console.log('change');
        //console.log(this); //=> this fait reference ici au select
        //console.log(mon_select.selectedIndex); //recupere l'indice de l'option selectionnée
        var idx_selected = mon_select.selectedIndex;
        var url = mon_select.options[idx_selected].value;

        console.log(url);

        var html = '<iframe src="' + url + '" ></iframe>';

        ecran.innerHTML = html;

    });


});

