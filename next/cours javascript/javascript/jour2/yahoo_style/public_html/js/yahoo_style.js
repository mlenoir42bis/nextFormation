/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//on attend que la page soit entierement chargée
window.addEventListener('load',ma_fonction);

function ma_fonction(){
    
    var big_image= document.getElementById('big_image');
    
    //recupere la liste des images
    var imgList = document.querySelectorAll('ul li img'); //selecteurs css
    console.log(imgList);
    
    //parcours de la liste des images
    for(var i=0;i < imgList.length;i++){
        console.log(imgList[i].src); //recupere l'url
        console.log(imgList[i].title); //recupere le title
        
        imgList[i].addEventListener('mouseover',function(){
            var url = this.src;
            var title= this.title;
            
            var html = '<img src="'+url+'" />';
            big_image.innerHTML = html;
            
            //creer un nouvel element
            var bandeau = document.createElement('div');
            bandeau.id = 'bandeau';
            
            //styling
            bandeau.style.position = 'absolute';
            bandeau.style.left = '0px';
            bandeau.style.bottom = '0px';
            bandeau.style.height = '50px';
            bandeau.style.width = '100%';
            bandeau.style.backgroundColor = 'rgba(255,255,255,0.3)';
            
            //innerHTML
            bandeau.innerHTML = '<p>'+title+'</p>';
            
            //ajoute le nouvel element à big_image
            big_image.appendChild(bandeau);
            
        });
    }
    
}