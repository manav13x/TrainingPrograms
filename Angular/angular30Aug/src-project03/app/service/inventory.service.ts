import { Injectable } from '@angular/core';
import { Item } from '../model/item';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {
 items :Item[];
  constructor() {
    this.items = [
      {id:101,name:'Apples',rate:45,qty:10,price:450},
      {id:102,name:'Mangoes',rate:40,qty:10,price:400},
      {id:103,name:'Oranges',rate:50,qty:10,price:500}
    ];
   }
   getAllItems()
  {
    return this.items;
  }
  add(item : Item){
    //item.price = 300;
     item.price = (item.rate)*(item.qty);
    this.items.push(item);
  }
  getItemByid(idInput:number):Item{
    let item : Item = null;
    item = this.items.find(
      (i)=>(i.id==idInput)//if not working change variable name 
    );
    return item;
  }

  deleteItemById(idInp:number)
  {
    let indexToDel = this.items.findIndex(
      (i)=>(i.id == idInp)
    );
    this.items.splice(indexToDel,1);
  }

    update(item : Item){
    //item.price = 300;
    let indexToUpd = this.items.findIndex(
      (i)=>(i.id == item.id)
    );
    item.price = (item.rate)*(item.qty);
    this.items[indexToUpd]=item;
  }

}
