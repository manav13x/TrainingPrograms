import { Component, OnInit } from '@angular/core';
import {BookService} from '../../services/book.service'
import { Book } from '../../models/book';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  books: Book[];
  bookIcon : string;
  cdIcon : string;
  constructor(private bookService:BookService,
  private router:Router) { 
    this.bookIcon="/assets/book.jpg";
    this.cdIcon="/assets/cd.jpg";
  }

  ngOnInit() {
      this.bookService.getAllBooks().subscribe(
        data=>this.books=data
      );

  }
  showBook(bcode){
    //alert(bcode);
    this.router.navigateByUrl("/view/"+bcode);

  }

}
