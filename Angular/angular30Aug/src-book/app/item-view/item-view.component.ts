import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Book } from '../model/Book';
import { InventoryService } from '../service/inventory.service.service';

@Component({
  selector: 'app-Book-view',
  templateUrl: './item-view.component.html',
  styleUrls: ['./item-view.component.css']
})
export class BookViewComponent implements OnInit {


  book :Book;
  constructor(private activatedRoute : ActivatedRoute,
              private  invService:InventoryService
  ) { }

  ngOnInit() {
    //params is an observable object so we have to subscribe from params
    this.activatedRoute.params.subscribe(
       data =>{
         let BookId = data['id'];
         this.book = this.invService.getBookByid(BookId);
       }
    );
  }

}
