const Joi=require('joi');
const express=require('express');
const app=express();
const router=express.Router();

const genres = [
    { id: 1, name: 'Naveen' },  
    { id: 2, name: 'Raju' },  
    { id: 3, name: 'Ram' },  
  ];


router.get('/api/genres', (req, res) => {
    res.send(genres);
  });
  
  router.get('/api/genres/:id', (req, res) => {
    const genre = genres.find(c => c.id === parseInt(req.params.id));
    if (!genre) 
      return res.status(404).send('The genre with the given ID was not found.');
    res.send(genre);
  });
  
router.post('/api/genres',(req,res,next)=>{
  const { error } = validateGenre(req.body); 
  if (error)
   return res.status(400).send(error.details[0].message);
    const genre={
        id: genres.length+1,
        name:req.body.name
    };
    genres.push(genre);
    res.status(200).send(genre);

});
router.put('/api/genres/:id', (req, res) => {
  const genre = genres.find(c => c.id === parseInt(req.params.id));
  if (!genre)
     return res.status(404).send('The genre with the given ID was not found.');

  const { error } = validateGenre(req.body); 
  if (error) 
    return res.status(400).send(error.details[0].message);
  
  genre.name = req.body.name; 
  res.send(genre);
});

router.delete('/api/genres/:id', (req, res) => {
  const genre = genres.find(c => c.id === parseInt(req.params.id));
  if (!genre) 
    return res.status(404).send('The genre with the given ID was not found.');

  const index = genres.indexOf(genre);
  genres.splice(index, 1);

  res.send(genre);
});

function validateGenre(genre)
{
  const schema=
  {
    name:Joi.string().min(3).required()
  };
  return Joi.validate(genre,schema);
}


module.exports=router;