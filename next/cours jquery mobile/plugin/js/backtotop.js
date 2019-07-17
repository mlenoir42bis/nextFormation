/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//mode plugin
//ajouter des methodes à l'objet jQuery
(function ($) {

    $.fn.styleFirstWord = function (options) {

        //on definit des valeurs par defaut
        //ces valeurs par defaut sont "surchargeables"
        //$.extend va fusionner l'obj json options avec les valeurs définies par défaut
        var settings = $.extend({
            color: 'red',
            style: 'normal'
        }, options);

        //cela peut etre une collection, d'objet jQuery
        //pour appliquer notre methode sur chaque element on utilise cette syntaxe
        return this.each(function () {
            //recupere le texte de l'element selectionné
            //console.log(this.text());
            //.trim() => supprime les espaces en debut et en fin de chaine
            var texte = $(this).text().trim(); //$(this) fait reference à l'element en cours dans la boucle each

            //on explose la chaine par rapport au caractère espace et on créé un tableau
            var tableauDeMots = texte.split(' ');

            //on boucle sur le tableau pour reconstruire le contenu de l'element
            if (tableauDeMots.length > 0) {
                //console.log(tableauDeMots[0]);

                var html = ''; //on definit une chaine vide
                //on boucle sur le tableau
                $.each(tableauDeMots, function (index, mot) {
                    if (index == 0) {
                        //si c'est le premier mot
                        html += '<span style="color:'+settings.color+';font-style:'+settings.style+';">' + mot + '</span>'; //ajout de span pour styliser le 1er mot
                    } else {
                        //sinon
                        html += ' ' + mot;
                    }
                });

                //on modifie le contenu de l'element par ce que l'on vient de faire
                $(this).html(html);
            }

        });
    };

}(jQuery));

