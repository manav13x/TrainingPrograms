import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions ,Headers} from '@angular/http';
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
 getIdIncludedBaseUrl(bcode):string{
   return this.baseUrl+"/"+bcode;
 }
 getBook(bcode):Observable<Book>{//conversion of data string to json
  return this.http.get(this.getIdIncludedBaseUrl(bcode)).pipe(
   map((data)=>data.json())
 );
}
deleteBook(bcode):Observable<Response>{//conversion of data string to json
  return this.http.delete(this.getIdIncludedBaseUrl(bcode));
}
//Observable is an asynchronous call
getJsonContentTypeHeader() : RequestOptions{ 
   const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return new RequestOptions({ headers: headers });
  }

addBook(book:Book):Observable<Book>{
let url = this.baseUrl;
let content = JSON.stringify(book);
let headers = this.getJsonContentTypeHeader();

return this.http.post(url,content,headers).pipe(
  map(data=>data.json())
);

}

updateBook(book:Book):Observable<Book>{
  let url = this.baseUrl;
  let content = JSON.stringify(book);
  let headers = this.getJsonContentTypeHeader();
  
  return this.http.put(url,content,headers).pipe(
    map(data=>data.json())
  );
  
  }
}
