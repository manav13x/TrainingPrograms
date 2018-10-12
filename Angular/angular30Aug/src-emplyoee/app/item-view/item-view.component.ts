import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Emplyoee } from '../model/emplyoee';
import { EmpdataService } from '../service/empdata.service';

@Component({
  selector: 'app-item-view',
  templateUrl: './item-view.component.html',
  styleUrls: ['./item-view.component.css']
})
export class ItemViewComponent implements OnInit {


  item :Emplyoee;
  constructor(private activatedRoute : ActivatedRoute,
              private  invService:EmpdataService
  ) { }

  ngOnInit() {
    //params is an observable object so we have to subscribe from params
    this.activatedRoute.params.subscribe(
       data =>{
         let itemId = data['id'];
        console.log(itemId);
         this.item = this.invService.getItemByid(itemId);
         //console.log(this.item.empid);
       }
    );
  }

}
