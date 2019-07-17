var counter = '0';
var end = false;
var invalid = false;
var gameWin = false;

$("td").on("click", function(){
invalid = false;
    
    if($(this).hasClass("blue") || $(this).hasClass("red")){
        alert("Check invalid");
        return;
    }
    
    counter++;
    
    if((end===false)){
        if (counter%2){
            $(this).css( "background-color", "blue" );
            $(this).addClass("blue");
            gameWin = win("Gamer1", "blue");
        }
        else{
            $(this).css( "background-color", "red" );
            $(this).addClass("red");
            gameWin = win("Gamer2", "red");
        }
    }

    if(gameWin){
        end = true;
    }
    else{
        end = End();
    }
});


$("#restart").on("click", function(){
    counter = '0';
    $("td").removeClass("red");
    $("td").removeClass("blue");
    $("td").css("background-color","");
});


function End(){
    if(counter === 9){
        alert("Partie Null");
        end = true;
    }
return end;
}

function win(gamer, Color){
    
    for (i=1; i<=3; i++){
        if ((($("#L"+ i +" ." + Color)).length) === 3 ) {
        alert(gamer + " win ! horizontal");
        gameWin=true;
        }
    }
    
    for (i=1; i<=3; i++){
       if ((($(".C" + i + "." + Color)).length) === 3 ){
        alert(gamer + " win ! vertical");
        gameWin=true;
        } 
    }
    
    if((($("#L1 .C1" + "." + Color)).hasClass(Color)) && (($("#L2 .C2" + "." + Color)).hasClass(Color)) && (($("#L3 .C3" + "." + Color)).hasClass(Color))){
        alert(gamer + " win ! diagonal");
        gameWin=true;
    }
    
    if((($("#L1 .C3" + "." + Color)).hasClass(Color)) && (($("#L2 .C2" + "." + Color)).hasClass(Color)) && (($("#L3 .C1" + "." + Color)).hasClass(Color))){
        alert(gamer + " win ! diagonal");
        gameWin=true;
    }
    
    if(gameWin){
        $('#'+gamer).html();
    }
    
return gameWin;    
}