const adminRoute=require('./routes/admin');
const leagueRoute=require('./routes/league');
const publicRoute=require('./routes/public')
const path=require('path');
const express=require('express');
const app=express();
const bodyParser=require('body-parser');
app.use(bodyParser.urlencoded({extended: false}));
app.use('/admin',adminRoute);
app.use(leagueRoute);
app.use('/display',publicRoute);

app.listen(3000,()=>{
    console.log('server started');
});
