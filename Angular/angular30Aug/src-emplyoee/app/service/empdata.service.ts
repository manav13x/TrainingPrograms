import { Injectable } from '@angular/core';
import { Emplyoee } from '../model/emplyoee';

@Injectable({
  providedIn: 'root'
})
export class EmpdataService {
emplist: Emplyoee[];
  constructor() { 
    this.emplist = [];
  }
  getAllItems()
  {
    return this.emplist;
  }
  add(empl : Emplyoee)
  {
    this.emplist.push(empl);
  }
  getItemByid(idInput:number):Emplyoee{
    let item : Emplyoee = null;
   // console.log("this "+this.emplist.length);
    item = this.emplist.find(
      (i) => (i.empid==idInput)//if not working change variable name 
    );
   // console.log(item.empid);
    return item;
  }

  deleteItemById(idInp:number)
  {
    let indexToDel = this.emplist.findIndex(
      (i)=>(i.empid == idInp)
    );
    this.emplist.splice(indexToDel,1);
  }

    update(item : Emplyoee){
    //item.price = 300;
    let indexToUpd = this.emplist.findIndex(
      (i)=>(i.empid == item.empid)
    );
    //item.price = (item.rate)*(item.qty);
    this.emplist[indexToUpd]=item;
  }
}
