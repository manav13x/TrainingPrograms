// This file has extension .ts
/*function show(name){
//    return "Hello "+name;
    return 12.5;
}
*/
function show(name) {
    //syntax of declaraling a variable and its return type in typescript
    return "Hello " + name;
    // return 0;
}
var a;
var names = "Vamsy";
var age = 20;
var basic = 12.44;
var isAdmin = true;
//let nArray:string[]=["manav","is","cool"];//finxed
var nArray = ["manav", "is", "cool"]; //generic
//also gets converted into fixed 
/*
enum Role{
    //EMPLOYEE-3 to associate it with index 3
    EMPLOYEE=3,
    MANAGER,
    ADMIN
};*/
var Role;
(function (Role) {
    //EMPLOYEE-3 to associate it with index 3
    Role[Role["EMPLOYEE"] = 0] = "EMPLOYEE";
    Role[Role["MANAGER"] = 3] = "MANAGER";
    Role[Role["ADMIN"] = 4] = "ADMIN";
})(Role || (Role = {}));
;
//enumerated data types to provide names to number
var userRole = Role.EMPLOYEE;
//enumerated datatype : used to provide name to number
console.log("Roles :", Role[2], "|", Role[4]);
var x = "hello";
x = 50;
x = [1, 2, 3, 4];
// All work with variable x because it is of type any
function fun(name) {
    console.log("heloio");
}
fun("dum");
var Employee = /** @class */ (function () {
    function Employee() {
        this.name = "manav";
        this.age = 23;
        this.basic = 6000.90;
        this.depertment = ['It', 'CSE', 'SALES'];
    }
    //methods
    Employee.prototype.show_default = function () {
        console.log("Function within class");
        console.log(this.name + "|" + this.basic + "| " + this.age);
        this.depertment.forEach(function (dept) { return console.log(dept); });
    };
    return Employee;
}());
var emp; //Does not create an object its a reference
//that will point to object when created
emp = new Employee();
var emp_pro = new Employee();
emp.show_default();
console.log(emp);
var Product = /** @class */ (function () {
    /*
            item_code:number;
            name:string;
    
        constructor(item_code,name){
                this.item_code=item_code;
                this.name=name;
        }*/
    /*
        constructor(public item_code:number,public name:string){
    
            no need of this here for assigment
        }*/
    function Product(item_code, name) {
        this.item_code = item_code;
        this.name = name;
    }
    return Product;
}());
var prod = new Product(1234, "C++");
console.log(prod);
