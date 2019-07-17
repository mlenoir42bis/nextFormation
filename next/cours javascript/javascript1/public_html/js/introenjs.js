console.log('yop');

var ma_var="une chaine";
var ma_var_2="une autre chaine";



//alert(ma_var);
//alert(ma_var_2);
console.log(ma_var);
console.log(ma_var_2);

//concatenation
var ma_var_3 = "toto" + " et moi";
console.log(ma_var_3);

//declaration fonction
function test(){
    console.log('test');
}

//apel une fonction
test();

function hello(langue){
    if(langue=='fr'){
        return 'bonjour';
    }
    if(langue=='en'){
        return 'hello';
    }
    return 'bonjour'
}


var resultat=hello('fr');
console.log('resultat:'+ resultat);
console.log(hello('en'));
console.log(hello('es'));

//declarationdun tableau
var tableau = new Array();
var tableau2 = [];



//ajouter des element
tableau[0] = "bonjour" ;
tableau[1] = "hello" ;
tableau[2] = "gutten tag";

console.log(tableau);

tableau2.push("yop");//ajout d'un element a la fin d'un tableau 
tableau2.push("yip");

console.log(tableau2);


var langues=[];
langues['fr'] = "bonjour";
langues['en'] = "hello";
langues['sp'] = "hola";

console.log(langues);
console.log(navigator);

var ma_langue = navigator.language;

console.log(langues[ma_langue]);


var taille = tableau.length;

for(i=0;i<taille;i++){
    console.log(i + ' '+ tableau[i]);
}


for (var key in langues){
    console.log(langues[key]);

}

var var2=2;
var var3=3;

function next(){
    console.log(var2);
    
   
}
 var var4=4;
next();
console.log(var4);

//dom
var mon_div = document.getElementById('div1');

console.log(mon_div);

mon_div.style.width = "150px";
mon_div.style.height = "150px";
mon_div.style.backgroundColor = "pink";
mon_div.style.color = "white";
mon_div.innerHTML = '<ul><li>yop</li><li>yap</li><li>yip</li></ul>';

//ajouter evenemen

mon_div.addEventListener('click',function(){
    mon_div.style.width = "100px";
mon_div.style.height = "100px";
mon_div.style.backgroundColor = "red";

mon_div.innerHTML = 'on m\'a cliqué';

});





mon_div.addEventListener('mouseover',function(){

mon_div.style.backgroundColor = "blue";



});
mon_div.addEventListener('mouseout',function(){

mon_div.style.backgroundColor = "pink";



});





var mon_lien = document.getElementById('click_me');

mon_lien.addEventListener('click',function(event){
  event.preventDefault();
  if(mon_div.style.display=="block" ||  mon_div.style.display ==""){
      mon_div.style.display = "none";
  }else{
    mon_div.style.display = "block";
}
});



