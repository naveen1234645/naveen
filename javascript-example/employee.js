
class Employee
{
    //  _firstName;
     //_lastName;
     //_employeeId;
     //_email;   

     constructor(_firstName,_lastName,_employeeId,_email)
     {
         this._firstName = _firstName;
         this._lastName = _lastName;
         this._employeeId = _employeeId;
         this._email = _email;
     }

getDetails()
{
    return 'Employee ID: '+this._employeeId+' First Name: '+this._firstName+' Last Name: '+this._lastName+' Email: '+this._email;
}

}
class Permanent_E extends Employee{
    _Per_Employee
    constructor(_Per_Employee)
    {
        super('swa','rat',11,'swa@email.com');
        this._Per_Employee=_Per_Employee;
        console.log('Permanent employee Details');
    }
}
class Temporary_E extends Employee{
    _Temp_Employee
    constructor(_Temp_Employee)
    {
        super('lohi','rar',11,'lohi@email.com');
        this._Temp_Employee=_Temp_Employee;
        console.log(' Temporary Employee Details');

    }
}
let employee1=new Employee('John','Doe',100,'john@email.com');
console.log(employee1.getDetails());
let employee2=new Employee('Marry','Public',200,'marry@email.com');
console.log(employee2.getDetails());
let employee3=new Employee('honey','well',5000,'honey@email.com');
console.log(employee3.getDetails());
let employee4 =new Permanent_E();
console.log(employee4.getDetails());
let employee5 =new Temporary_E();
console.log(employee5.getDetails());