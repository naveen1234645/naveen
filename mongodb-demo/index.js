const mongoose=require('mongoose');
mongoose.connect('mongodb://localhost/employee',()=>{
    console.log('connection successful');
});
 

  const employeeSchema=new mongoose.Schema({
      firstName:String,
      lastName: String,
      email:String
  });
  const Employee=mongoose.model('Employee',employeeSchema)
 
  async function getEmployees()
  {
      return await Employee.find();
  }

 
async function run() {
  
    const employees=await getEmployees();
    console.log(employees);
  }
  
  run();