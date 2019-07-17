/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('load', function () {

    //recupere le container
    var container = document.getElementById('container');

    //recupere l'element video
    var ma_video = document.getElementById('ma_video');

    //creation d'un div
    var bandeau = document.createElement('div');
    bandeau.id = 'bandeau';
    bandeau.innerHTML = '<p><a href="#" id="play_link">Play</a>\n\
                        &nbsp;<a href="#" id="pause_link">Pause</a>\n\
                        &nbsp;<a href="#" id="full_link">Full screen</a>\n\
                        &nbsp;<a href="#" id="next_link">Next</a></p>';
    container.appendChild(bandeau);

    //ajoute un evenement on mouseover
    container.addEventListener('mouseover', function () {
        bandeau.style.opacity = '1';
        bandeau.style.transition = "0.5s";
    });

    container.addEventListener('mouseout', function () {
        bandeau.style.opacity = '0';
        bandeau.style.transition = "0.5s";
    });

    //recupere les liens
    var play_link = document.getElementById('play_link');
    var pause_link = document.getElementById('pause_link');
    var full_link = document.getElementById('full_link');
    var next_link = document.getElementById('next_link');

    play_link.addEventListener('click', function (event) {
        event.preventDefault();
        ma_video.play();
    });

    pause_link.addEventListener('click', function (event) {
        event.preventDefault();
        ma_video.pause();
    });

    full_link.addEventListener('click', function (event) {
        event.preventDefault();
        var largeur = window.innerWidth;
        var hauteur = window.innerHeight;
        container.style.width = largeur+'px';
        container.style.height= hauteur+'px';
        container.style.transition = '0.5s';
    });

    next_link.addEventListener('click', function (event) {
        event.preventDefault();
        ma_video.src="video/video2.mp4";
        ma_video.play();
    });

});

