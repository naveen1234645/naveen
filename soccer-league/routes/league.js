const path=require('path');
const express=require('express');
const app=express();
const router=express.Router();
router.get('/',(req,res,next)=>{
    res.sendFile(path.join(__dirname,'../','views','soccer-league.html'));    

});
module.exports=router;