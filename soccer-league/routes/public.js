const path=require('path');
const express=require('express');
const app=express();
const router=express.Router();
router.get('/display-league',(req,res,next)=>{

    res.sendFile(path.join(__dirname,'../','views','display-league.html'));

});
router.get('/register-league',(req,res,next)=>{
    res.sendFile(path.join(__dirname,'../','views','register-league.html'));
})
module.exports=router;