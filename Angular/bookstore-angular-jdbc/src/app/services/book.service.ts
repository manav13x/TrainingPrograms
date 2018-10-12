import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {Book} from '../models/book'
@Injectable({
  providedIn: 'root'
})
//rxjs stands for reactjs
export class BookService {
//angular has to make a call to restful in spring
//a request made from localhost to localhost is called cross-origin
//will not be processed for security
//make spring allow cross origin request
baseUrl:string;
constructor(private http:Http) {
  this.baseUrl="http://localhost:7777/books";
 }

 getAllBooks():Observable<Book[]>{//conversion of data string to json
   return this.http.get(this.baseUrl).pipe(
    map((data)=>data.json())
  );
 }
}
