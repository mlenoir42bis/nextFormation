var express = require("express");
var fs = require("fs");
var request = require("request");
var cheerio = require("cheerio");
var app = express();

app.get("/scrape", function(req, res){
    
    url = 'http://www.leboncoin.fr/ventes_immobilieres/offres/ile_de_france/?f=a&th=1';

    request(url, function(error, response, html){
        if(!error){
            var $ = cheerio.load(html);
            $(".list-lbc > a").each(function(){
                var detailUrl = $(this).attr("href");
                request(detailUrl, function(error, response, html){
                    if(!error){
                        var $ = cheerio.load(html);
                        var price = $("span.price").text().replace("€", "").replace(" ", "");
                        console.log(price);
                    }
                });
            });

        }
        res.send("done");
    });
    
});

app.listen('8081');
console.log('Magic happens on port 8081');