import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item';
import { InventoryService } from '../service/inventory.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  items : Item[];
  constructor(private inv : InventoryService ) { }

  ngOnInit() {
    this.items = this.inv.getAllItems();
  }
deleteItem(id:number)
  {
      if(confirm("Are u sure u want to delete item#"+id))
      {
      this.inv.deleteItemById(id);
      this.items=this.inv.getAllItems();        
      }
  }    
}
