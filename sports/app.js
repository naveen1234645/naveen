const path = require('path');
const bodyParser=require('body-parser');;
const express = require('express');
const app = express();
app.use(bodyParser.urlencoded({extended: false}))


app.get('/home',(req,res,next)=>{
    res.sendFile(path.join(__dirname,'soccer','home.html'));
  

});

app.get('/add-league',(req,res,next)=>{
    res.sendFile(path.join(__dirname,'soccer','add-league.html'));
  

});

app.post('/add-league',(req,res,next)=>{
    console.log(req.body);
    res.redirect('/home');

});


app.get('/display-league',(req,res,next)=>{
    res.sendFile(path.join(__dirname,'soccer','display-league.html'));
  

});




app.listen(3000);