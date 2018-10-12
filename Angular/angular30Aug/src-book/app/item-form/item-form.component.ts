import { Component, OnInit } from '@angular/core';
import { Book } from '../model/Book';
import { InventoryService } from '../service/inventory.service.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-Book-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})
export class BookFormComponent implements OnInit {

  book : Book;
  isEdit : boolean;
  constructor(private inv : InventoryService,
  private router:Router,
  private activatedRoute : ActivatedRoute
  ) { }

  ngOnInit() {
    //this.Book =  new Book();
    this.activatedRoute.params.subscribe(
      data =>{
        let BookId = data['id'];
        if(BookId){
          this.book = this.inv.getBookByid(BookId);
          this.isEdit=true;
        }
        else{
          this.book =  new Book();
          this.isEdit=false;
        }
      }
   );
  }

  save(){
    if(this.isEdit){
      this.inv.update(this.book);
    }
      else
    {
   this.inv.add(this.book);
    }
    //this.inv.add(this.Book);
    this.router.navigateByUrl("")
  }
  cancel(){
    this.router.navigateByUrl("");
  }
 // deleteBook()

}
