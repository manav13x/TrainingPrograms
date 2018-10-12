import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Item } from '../model/item';
import { InventoryService } from '../service/inventory.service';

@Component({
  selector: 'app-item-view',
  templateUrl: './item-view.component.html',
  styleUrls: ['./item-view.component.css']
})
export class ItemViewComponent implements OnInit {


  item :Item;
  constructor(private activatedRoute : ActivatedRoute,
              private  invService:InventoryService
  ) { }

  ngOnInit() {
    //params is an observable object so we have to subscribe from params
    this.activatedRoute.params.subscribe(
       data =>{
         let itemId = data['id'];
         this.item = this.invService.getItemByid(itemId);
       }
    );
  }

}
