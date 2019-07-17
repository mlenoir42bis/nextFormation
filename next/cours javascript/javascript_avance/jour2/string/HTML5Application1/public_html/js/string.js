/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var ma_chaine = "Je suis une chaine de caracteres";

//finalement, une chaine est un tableau de caracteres
var taille = ma_chaine.length;
console.log(taille);

console.log(ma_chaine[0]);
console.log(ma_chaine[1]);

console.log(ma_chaine.toUpperCase()); //majuscule
console.log(ma_chaine.toLowerCase()); //minuscule

//concatenation de chaines
console.log(ma_chaine + ' yop');

ma_chaine = '     yop yop       ';

console.log(ma_chaine.trim()); //supprime les espaces à gauche et à droite

//chercher une chaine de caractere dans une autre
var phrase = "Salut je vais bien, je suis en forme";
var search = "je";

console.log(phrase.indexOf(search)); //renvoit la position de la premiere occurence
console.log(phrase.lastIndexOf(search)); //renvoit la position de la dernière occurence
console.log(phrase.indexOf('truc')); //renvoit -1 si ca ne le trouve pas


var ma_var = "1,2,3,56,49,20,11";
var tab = ma_var.split(","); // transforme la chaine de caracteres en tableau avec un separateur
console.log(tab);

var truc = tab.join(';'); //contraire de split, transforme un tableau en string
console.log(truc);

console.log(phrase.slice(0, 6)); //renvoit une tranche de la chaine
console.log(phrase.slice(0, phrase.indexOf(','))); //renvoit du début jusqu'à bien
//on aurait pu utiliser substr ou substring


var tableau1 = [1, 2, 3, 4];
var tableau2 = ['a', 'b', 'c', 'd'];
var tableau3 = new Array(5, 6, 7, 8);

console.log(tableau1.toString()); //convertit le tableau en caracteres

var todo_list = [];

//ajout des trucs à faire => push
todo_list.push('sortir le chien');
todo_list.push('faire la vaisselle');
todo_list.push('ranger la chambre');
console.log(todo_list);

//j'ai terminé les trucs à faire
console.log(todo_list.pop('ranger la chambre')); //pop => retrourne l'element et le sort du tableau
console.log(todo_list);

console.log(tableau3);
tableau3.reverse(); //inverse l'ordre du tableau
console.log(tableau3);


var tableau4 = [5, 8, 35, 12, 3, 98, 42];
var tableau5 = ['koala', 'chien', 'mouton', 'chevre', 'cheval', 'autruche'];
console.log(tableau4);
tableau4.sort(); //tri le tableau par ordre alphabetique
tableau5.sort(); //tri le tableau par ordre alphabetique
console.log(tableau4);
console.log(tableau5);

console.log(tableau4.concat(tableau5)); //concatene 2 tableaux
