
var socket = io();
console.log(socket);

$("#chat_form").on("submit", function(e){
	e.preventDefault();

	var newMess = $("#message_input").val();

	//on envoit un message
	socket.emit("new_message", newMess);
});

//on reçoit des nouveaux messages
socket.on("new_message", function(mess_obj){
	console.log(mess_obj);
	$("#messages").append('<p><b>' + mess_obj.socket_id + "</b> : "+ mess_obj.mess + '</p>');
});

socket.on("users_list", function(users){
	$("#users").empty();
	for(i in users){
		$("#users").append('<p>'+users[i]+'</p>');
	}
});