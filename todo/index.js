const mongoose = require('mongoose');
const todos = require('./routes/todos');
const express = require('express');
const app = express();

mongoose.connect('mongodb://localhost/todo')
  .then(() => console.log('Connected to MongoDB...'))
  .catch(err => console.error('Could not connect to MongoDB...'));

  app.use(express.json());
  app.use('/api/todos',todos);
  app.listen(3000);