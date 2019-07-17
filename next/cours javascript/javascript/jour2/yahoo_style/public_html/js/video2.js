
//on attend la page soit entierement chargée
window.addEventListener('load', function () {

    //video en cours
    var currentSource = 0;

    //recupere l'element container
    var mon_container = document.getElementById('container');

    //recupere la liste des sources des videos
    var sourceList = document.querySelectorAll('#container video source'); //selecteurs css

    //definition une liste d'url
    var urlList = [];

    //parcours de la liste des sources pour construire la liste des urls
    for (var i = 0; i < sourceList.length; i++) {
        //console.log(sourceList[i].src);
        urlList.push(sourceList[i].src); //ajoute un element à la fin du tableau
    }

    //si la liste de urls est vide, on arrete
    if (urlList.length == 0) {
        return;
    }

    //vider le contenu du container
    mon_container.innerHTML = '';

    //on redefinit le contenu html du container
    var html = '<video id="ma_video"> <source src="' + urlList[0] + '"> </video>'; //utilise la premiere url
    html += '<div id="bandeau"><a href="#" id="play_link">Play</a>\n\
                &nbsp;<a href="#" id="pause_link">Pause</a>\n\
                &nbsp;<a href="#" id="next_link">Next</a></div>';

    mon_container.innerHTML = html; //on remplace le html du container

    //recupere l'element bandeau
    var bandeau = document.getElementById('bandeau');

    //recupere l'element video
    var ma_video = document.getElementById('ma_video');

    //gestion des evenements pour afficher/cacher les controls
    //affiche le bandeau
    mon_container.addEventListener('mouseover', function () {
        bandeau.style.opacity = '1'; //on change la propriété css opacity, le bandeau est visible
        bandeau.style.transition = '0.5s'; //ajout transition pour animation 
    });

    //cache le bandeau
    mon_container.addEventListener('mouseout', function () {
        bandeau.style.opacity = '0'; //on change la propriété css opacity, le bandeau est invisible
        bandeau.style.transition = '0.5s'; //ajout transition pour animation 
    });

    //gestion des evenements liés aux controls
    var play_link = document.getElementById('play_link');
    var pause_link = document.getElementById('pause_link');
    var next_link = document.getElementById('next_link');
    
    //play
    play_link.addEventListener('click',function(event){
        event.preventDefault();
        ma_video.play(); //lance la video
    });
    
    //pause
    pause_link.addEventListener('click',function(event){
        event.preventDefault();
        ma_video.pause(); //met la video en pause
    });

    //next
    next_link.addEventListener('click',function(event){
        event.preventDefault();
        nextVideo();
    });

    //ajoute un evenement sur la fin de la video
    ma_video.addEventListener('ended',function(){
        nextVideo();
    });

    //fonction nextVideo
    function nextVideo(){
        currentSource++;//increment la source en cours
        //si on depasse le nombre de source, on remet à zéro
        if(currentSource == urlList.length){
            currentSource =0;
        }
        
        //on change la video
        ma_video.src= urlList[currentSource];
        ma_video.play();
        
    }

});

