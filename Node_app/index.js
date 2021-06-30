let os = require('os');
let http=require('http');
//var file = require('file');
//console.log(os.userInfo());
//console.log(os.version());
 //console.log(os.homedir());
 const server=http.createServer( function(request,response){
     if(request.url=='/')
     {
        response.write('<b>hello world</b>');
     response.end();
     }
     
     if(request.url==='/customers')
     {
         response.write('<b>i am within /customer</b>');
         response.end();
     }
})
 server.listen(3000,function()
 {
    console.log('server started and listening tom port number : 3000');
 });