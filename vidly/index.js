
const express = require('express');
const app = express();
app.use(express.json());
const genres = [
    { id: 1, name: 'Action' },  
    { id: 2, name: 'Horror' },  
    { id: 3, name: 'Romance' },  
  ];
const employees=[
    {id:100, firstName: 'John', lastName: 'Doe'},
    {id:101, firstName: 'Marry', lastName: 'Gold'},
    {id:100, firstName: 'Sachin', lastName: 'Tendulkar'},
    {id:100, firstName: 'Sourav', lastName: 'Ganguly'}
]
app.get('/',(req,res)=>{

    res.send('hello world');
});
app.get('/api/genres', (req, res) => {
    res.send(genres);
  });

  app.get('/api/employees',(req,res)=>{

    res.send(employees);
  });

app.listen(3000,()=>{

    console.log('server started on port number 3000');
})