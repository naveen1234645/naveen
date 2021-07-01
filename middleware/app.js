const path=require('path');
const bodyParser=require('body-parser');;
const express=require('express');
const app=express();
app.use(bodyParser.urlencoded({extended: false}))
app.get('/add-product',(req,res,next)=>{
    res.sendFile(path.join(__dirname,'views','add-product.html'));
  

});
app.post('/add-product',(req,res,next)=>{
    console.log(req.body);
    res.redirect('/');

});

app.get('/',(req,res,next)=>{

    res.sendFile(path.join(__dirname,'views','shop.html'));
});

app.use((req,res,next)=>{
res.status(400).send('<h1> page not found</h1>');

})



app.listen(3000);