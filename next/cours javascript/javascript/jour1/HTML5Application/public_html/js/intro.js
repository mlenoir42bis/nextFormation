/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//ecris dans la console
console.log('yo');

var ma_var = "une chaine";
var ma_var_2 = 'une autre chaine';

// un commentaire
/*
 * un bloc de commentaire
 alert(ma_var);
 alert(ma_var_2);
 */

console.log(ma_var);
console.log(ma_var_2);

//concatenation
var ma_var_3 = "toto" + " et moi" + " totu" + " top";
console.log(ma_var_3);

//declaration fonction
function test() {
    console.log('test');
}

//appel d'une fonction
test();

//fonction hello
function hello(langue) {

    if (langue == 'fr') {
        return 'bonjour';
    }

    if (langue == 'en') {
        return 'hello';
    }

    return 'bonjour';
}

var resultat = hello('fr');
console.log('resultat: ' + resultat);

console.log(hello('en'));

console.log(hello('es'));
console.log(hello());

//declaration d'un tableau
var tableau = new Array();
var tableau2 = [];

//ajouter des elements au tableau
tableau[0] = "bonjour";
tableau[1] = "hello";
tableau[2] = "guten tag";

console.log(tableau);

tableau2.push("yop"); //ajoute une element à la fin du tableau
tableau2.push("yip");

console.log(tableau2);

var langues = [];
langues['fr'] = "bonjour";
langues['en'] = "hello";
langues['sp'] = "hola";

console.log(langues);

//recuperation de la langue du navigateur
console.log(navigator); //navigator => objet natif javascript qui correspond au navigator
var ma_langue = navigator.language;
console.log(langues[ma_langue]);

//parcours du premier tableau
var taille = tableau.length;

for (var i = 0; i < taille; i++) {
    console.log(i + ' ' + tableau[i]);
}

//parcours du tableau langue (associatif)
for (var key in langues) {
    console.log(langues[key]);
}


var var1 = 3;

function double(valeur) {
    return valeur * 2;
}

double(var1);

console.log(var1); //affiche 3, car passage de parametre par valeur, var1 n'est pas modifié

var var2 = 2;
var var3 = 3;

function next() {
    console.log(var2);
    var var4 = 4;
}

next();

//console.log(var4);

//DOM
var mon_div = document.getElementById('div1');
console.log(mon_div);
mon_div.style.width = "150px";
mon_div.style.height = "150px";
mon_div.style.backgroundColor = "pink";

mon_div.innerHTML = '<ul><li>yop</li><li>yip</li></ul>';

//ajout evenement de clic sur le div
mon_div.addEventListener('click',function(){
   mon_div.style.width='100px';
   mon_div.style.height='100px';
   mon_div.style.backgroundColor = "yellow";
   mon_div.innerHTML = 'on m\'a cliqué';
});

mon_div.addEventListener('mouseover',function(){
   mon_div.style.backgroundColor = "blue";
   mon_div.innerHTML = 'on est sur moi';
});

mon_div.addEventListener('mouseout',function(){
   mon_div.style.backgroundColor = "pink";
   mon_div.innerHTML = 'on est passé sur moi';
});

var mon_lien = document.getElementById('click_me');
mon_lien.addEventListener('click',function(event){
    event.preventDefault(); //annule le comportement standard du lien

    if(mon_div.style.display=="block" || mon_div.style.display==""){
        mon_div.style.display = "none";
    }else{
        mon_div.style.display = "block";
    }
});