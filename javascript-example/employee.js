class Employee
{
   


    constructor(_firstName,_lastName,_employeeId,_email)
    {
        this._firstName=_firstName;
        this._lastName=_lastName;
        this._employeeId=_employeeId;
        this._email=_email;
        console.log('within parameterized constructor');
    }

      getDetails()
     {
         return 'Employee ID: '+this._employeeId+' First Name: '+this._firstName+' Last Name: '+this._lastName+' Email: '+this._email;
     }

}


let employee1=new Employee('John','Doe',100,'john@email.com');
console.log(employee1.getDetails());
let employee2=new Employee('Marry','Public',200,'marry@email.com');
console.log(employee2.getDetails());