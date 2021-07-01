const path=require('path');
const express=require('express');
const app=express();
const router=express.Router();
const bodyParser=require('body-parser');
app.use(bodyParser.urlencoded({extended: false}));
router.get('/add-league',(req,res,next)=>{
 
    res.sendFile(path.join(__dirname,'../','views','add-league.html'));

});
router.post('/add-league',(req,res,next)=>{
    console.log(req.body);
    res.redirect('/');
});

module.exports=router;