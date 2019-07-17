/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//expression reguliere
var chaine = "Le koala est un animal sympa";
var pattern = /un/i; //i => case insensitive
console.log(pattern.test(chaine)); //true

pattern = /le/;
console.log(pattern.test(chaine)); //false
//=> renvoit false car on est sensible à la casse pas de i à la fin

pattern = /^Le/;//^ => debut de la chaine
var chaine2 = "salut Le chien";

console.log(pattern.test(chaine));//true
console.log(pattern.test(chaine2));//faux

pattern = /sympa$/; //$ =>fin de la chaine
console.log(pattern.test(chaine));//true
console.log(pattern.test(chaine2));//faux

//code postal
console.log('code postal');

var cp = "75012";
var cp1 = "1524";
var cp2 = "456a";
var cp3 = "j'habite 91360";

pattern = /^[0-9]{5}$/;

console.log(pattern.test(cp)); //true
console.log(pattern.test(cp1)); //false
console.log(pattern.test(cp2)); //false
console.log(pattern.test(cp3)); //false

//telephone
console.log('telephone');
var tel1 = "01-02-03-04-06";
var tel2 = "01 02 03 04 06";
var tel3 = "01 02 03 04";
var tel4 = "+33 1 02 03 04 06";

//var pattern_tel = /^0[0-9]{1}(-| )[0-9]{2}(-| )[0-9]{2}(-| )[0-9]{2}(-| )[0-9]{2}$/;
//var pattern_tel = /^0[0-9]((-| )[0-9]{2}){4}$/;
var pattern_tel = /^(0|\+33 )[0-9]((-| )[0-9]{2}){4}$/;

console.log(pattern_tel.test(tel1));//true
console.log(pattern_tel.test(tel2));//true
console.log(pattern_tel.test(tel3));//false

//match
var content ='<p> bla bla </p> <a href="http://www.googl_e.com">google</a> \n\
                <p> bla bla </p><a href="http://www.yah-oo.com">yahoo</a>\n\
                <p> bla bla </p>';
var pattern_url = /"http:\/\/[a-z0-9A-Z\-_\.]*"/g;

console.log(content.match(pattern_url));

