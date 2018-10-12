import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item';
import { InventoryService } from '../service/inventory.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})
export class ItemFormComponent implements OnInit {

  item : Item;
  constructor(private inv : InventoryService,
  private router:Router
  ) { }

  ngOnInit() {
    this.item =  new Item();
  }

  save(){
    this.inv.add(this.item);
    this.router.navigateByUrl("/ilc")
  }
  cancel(){
    this.router.navigateByUrl("/ilc");
  }
  

}
