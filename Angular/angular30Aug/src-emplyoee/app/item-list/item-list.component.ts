import { Component, OnInit } from '@angular/core';
import { Emplyoee } from '../model/emplyoee';
import { EmpdataService } from '../service/empdata.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  emplist : Emplyoee[];
  constructor(private env : EmpdataService) { }

  ngOnInit() {
    this.emplist = this.env.getAllItems();
  }
  deleteItem(id:number)
  {
      if(confirm("Are u sure u want to delete item#"+id))
      {
      this.env.deleteItemById(id);
      this.emplist=this.env.getAllItems();        
      }
  }    
}

