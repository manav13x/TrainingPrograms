// This file has extension .ts
/*function show(name){
//    return "Hello "+name;
    return 12.5;
}
*/

function show(name:string): string{
//syntax of declaraling a variable and its return type in typescript
    return "Hello "+name;
   // return 0;
}
let a: any;

let names:string="Vamsy";

let age:number=20;
let basic:number=12.44;
let isAdmin:boolean=true;

//let nArray:string[]=["manav","is","cool"];//finxed

let nArray:Array<string> = ["manav","is","cool"];//generic
//also gets converted into fixed 
/*
enum Role{
    //EMPLOYEE-3 to associate it with index 3
    EMPLOYEE=3,
    MANAGER,
    ADMIN
};*/
enum Role{
    //EMPLOYEE-3 to associate it with index 3
    EMPLOYEE,
    MANAGER=3,
    ADMIN
};
//enumerated data types to provide names to number
let userRole=Role.EMPLOYEE;
//enumerated datatype : used to provide name to number

console.log("Roles :",Role[2],"|",Role[4]);

let x:any = "hello";
x = 50;
x = [1,2,3,4];
// All work with variable x because it is of type any

function fun(name:string):void{
    console.log("heloio");
}

fun("dum");

class Employee{
    //by default access public
    name:string;
    age:number;
    basic:number;
    depertment:string[];
    constructor(){
        this.name="manav";
        this.age=23;
        this.basic=6000.90;
        this.depertment=['It','CSE','SALES']
    }
    //methods

    show_default(){//can use :void too here else return type any
        console.log("Function within class");
        console.log(this.name+"|"+this.basic+"| "+this.age);
        this.depertment.forEach((dept)=>console.log(dept));
    }
}

let emp:Employee//Does not create an object its a reference
//that will point to object when created
emp = new Employee();
let emp_pro:Employee = new Employee();

emp.show_default();
console.log(emp);

class Product{
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
    constructor(private item_code:number,private name:string){

    }
}

let prod:Product = new Product(1234,"C++");

console.log(prod);

