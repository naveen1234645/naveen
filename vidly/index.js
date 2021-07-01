
const vidlyRouter=require('./routes/admin');
const express = require('express');
const app = express();
app.use(express.json());
app.use('/admin',vidlyRouter);
app.use((req,res,next)=>{
  
  res.status(400).send('<h3>bad request</h3>')
})

app.listen(3000,()=>{

    console.log('server started on port number 3000');
});