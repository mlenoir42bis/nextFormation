var step = 800;
var stepDeath = 600;
var stepUp = 0;
var minheight = 1;
var maxheight = 600;
var animDuration = 0;
var minDuration = 1000;
var maxDuration = 2600;       
var positionLeft = -100;
var positionTop = Math.floor(Math.random() * (maxheight + 1) + minheight); 
var stop = false;
var rand = 0;
var humanScore = 0;
var duckScore = 0;

$(document).ready(function(){
    $("#duck").hide(); 
});

$("#play").on('click', function(){
    $("#duck").show();
    startAnim();    
});

$("#pause").on('click', function(){
    stopAnim();
});

$("#duck").on('mousedown', function(){
    deathAnim();
});

function startAnim(){
    
        if(stop===true){
        resetPosition();
        stop=false;
        }
        
        $("#duck").css({
            "left": positionLeft,
            "top": positionTop
        });
        
        $( "#duck img" ).removeAttr('style');
        
    moveRight();
}

function randMove(){
    stepUp = Math.floor(Math.random() * (maxheight + 1) + minheight);
    animDuration = Math.floor(Math.random() * (maxDuration + 1) + minDuration);
}

function moveRight(){
    randMove();
    switchImg("img/duck-right.gif");
    $("#duck").animate({"left" : step, "top": stepUp}, animDuration, "swing", function(){
        duckScore++;
        updateScore();
        randTop();
        moveLeft();
    });  
}

function moveLeft(){
    randMove();
    switchImg("img/duck-left.gif");
    $("#duck").animate({"left" : -100, "top": stepUp}, animDuration, "swing", function(){
        duckScore++;
        updateScore();
        randTop();
        moveRight();
    });
}

function deathAnim(){
    switchImg("img/duck-dead.gif");
    $("#duck").stop().animate({ "top": stepDeath}, 1000, "swing", function(){
        humanScore++;
        updateScore();
        resetPosition();
        startAnim(); 
    });
}

function switchImg(name){
    $("#duck img").attr("src", function() {
        return name;
    });
}

function stopAnim(){
    $("#duck").stop();
    stop=true;
    checkPosition();
}

function checkPosition(){
    position = $("#duck").position();
    positionLeft = position.left;
    positionTop = position.top;
}

function resetPosition(){
    positionLeft = -100;
    positionTop = Math.floor(Math.random() * (maxheight + 1) + minheight);
}

function randTop(){
    rand = Math.floor(Math.random() * (maxheight + 1) + minheight);
    $("#duck").css({
            "top": rand
    });
}

function updateScore(){
    $("#humanScore").html(humanScore);
    $("#duckScore").html(duckScore);
}