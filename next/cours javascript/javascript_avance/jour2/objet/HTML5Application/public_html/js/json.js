/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//obj json
//cle : valeur
var obj = {'nom': 'bouvier',
    'prenom': 'fabien',
    'age': 43};

console.log(obj);
console.log(obj.nom);
console.log(obj.prenom);

//cle:valeur
//{} => objet
//[] => tableau

var personne = {'nom': 'bouvier',
    'prenom': 'fabien',
    'age': 43,
    'enfants': [
        {'prenom': 'félix'},
        {'prenom': 'edgar'},
        {'prenom': 'emile'}
    ]};

console.log(personne);
console.log(personne.enfants[0].prenom);

var liste_commune = [
    {'cp': '92000', 'ville': 'nanterre'},
    {'cp': '91000', 'ville': 'evry'},
    {'cp': '74000', 'ville': 'annecy'},
    {'cp': '33000', 'ville': 'bordeaux'},
    {'cp': '31000', 'ville': 'toulouse'},
    {'cp': '75000', 'ville': 'paris'},
    {'cp': '34000', 'ville': 'montpellier'},
    {'cp': '38000', 'ville': 'grenoble'},
    {'cp': '59000', 'ville': 'lille'}
];

//parcours de la liste
for (var i = 0; i < liste_commune.length; i++) {
    var commune = liste_commune[i].cp + ' ' + liste_commune[i].ville;
    console.log(commune);
}




