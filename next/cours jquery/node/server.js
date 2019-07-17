
	var express = require('express');
	var app = express();
	var http = require('http').Server(app);
	var io = require('socket.io')(http);

	app.get('/', function(req, res){
		res.sendFile(__dirname + "/chat.html");
	});

	var users = [];

	//sur connexion d'un user
	io.on('connection', function(socket){
		console.log("nouvelle connexion utilisateur !");

		users.push(socket.id);

		//
		io.emit("users_list", users);

		//sur déconnexion
		socket.on('disconnect', function(){

			var index = users.indexOf(socket.id);
			users.splice(index, 1);
			//
			io.emit("users_list", users);

			console.log("Bye bye user !");
		});

		socket.on('new_message', function(mess){
			var mess_obj = {
				mess: mess,
				socket_id: socket.id
			};
			io.emit('new_message', mess_obj);
		});

	});


	http.listen('3000');
	console.log('Port 3000 sur écoute');