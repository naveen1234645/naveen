const mongoose=require('mongoose');
mongoose.connect('mongodb://localhost/couse',()=>{
    console.log('connection successful');
});
 
const courseSchema = new mongoose.Schema({
    name: String,
    author: String, 
    tags: [ String ],
    date: Date, 
    isPublished: Boolean,
    price: Number
  });
  const Course = mongoose.model('Course', courseSchema);
 
async function getCourses() {
  return await Course
  .find();
}
 
async function run() {
    const courses = await getCourses();
    console.log(courses);
}

run();