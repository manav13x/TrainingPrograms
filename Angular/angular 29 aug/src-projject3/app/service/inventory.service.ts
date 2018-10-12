import { Injectable } from '@angular/core';
import { Item } from '../model/item';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {
 items :Item[];
  constructor() {
    this.items = [];
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
}
