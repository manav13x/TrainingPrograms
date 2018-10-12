import { Injectable } from '@angular/core';
import { Book } from '../model/Book';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {
 books :Book[];
  constructor() {
    this.books = [
      {id:101,name:'Java',rate:45,qty:10,price:450},
      {id:102,name:'C++',rate:40,qty:10,price:400},
      {id:103,name:'Cloud',rate:50,qty:10,price:500}
    ];
   }
   getAllBooks()
  {
    return this.books;
  }
  add(book : Book){
    //Book.price = 300;
     book.price = (book.rate)*(book.qty);
    this.books.push(book);
  }
  getBookByid(idInput:number):Book{
    let book : Book = null;
    book = this.books.find(
      (i)=>(i.id==idInput)//if not working change variable name 
    );
    return book;
  }

  deleteBookById(idInp:number)
  {
    let indexToDel = this.books.findIndex(
      (i)=>(i.id == idInp)
    );
    this.books.splice(indexToDel,1);
  }

    update(book : Book){
    //Book.price = 300;
    let indexToUpd = this.books.findIndex(
      (i)=>(i.id == book.id)
    );
    book.price = (book.rate)*(book.qty);
    this.books[indexToUpd]=book;
  }

}
