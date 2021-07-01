const express=require('express');
const app=express();
const router=express.Router();

const genres = [
    { id: 1, name: 'Action' },  
    { id: 2, name: 'Horror' },  
    { id: 3, name: 'Romance' },  
  ];


router.get('/api/genres', (req, res) => {
    res.send(genres);
  });
module.exports=router;