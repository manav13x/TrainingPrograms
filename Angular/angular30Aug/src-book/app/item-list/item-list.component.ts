import { Component, OnInit } from '@angular/core';
import { Book } from '../model/Book';
import { InventoryService } from '../service/inventory.service.service';

@Component({
  selector: 'app-Book-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class BookListComponent implements OnInit {

  books : Book[];
  constructor(private inv : InventoryService ) { }

  ngOnInit() {
    this.books = this.inv.getAllBooks();
  }
deleteBook(id:number)
  {
      if(confirm("Are u sure u want to delete Book#"+id))
      {
      this.inv.deleteBookById(id);
      this.books=this.inv.getAllBooks();        
      }
  }    
}
