/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//definit une classe
function Personne() {

    //propriétés
    var nom;
    var prenom;

    //methodes
    this.setPrenom = function (str) {
        prenom = str;
    };

    this.getPrenom = function () {
        return prenom;
    };

    this.jeMappelle = function () {
        alert("Je m'appelle " + prenom);
    }

}

var homme = new Personne();
homme.setPrenom('Vincent');
//homme.jeMappelle();

console.log(homme.prenom); 



