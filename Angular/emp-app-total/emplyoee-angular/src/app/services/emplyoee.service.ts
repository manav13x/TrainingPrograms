import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions ,Headers} from '@angular/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {Emplyoee} from '../models/emplyoee'
@Injectable({
  providedIn: 'root'
})
//rxjs stands for reactjs
export class EmplyoeeService {
//angular has to make a call to restful in spring
//a request made from localhost to localhost is called cross-origin
//will not be processed for security
//make spring allow cross origin request
baseUrl:string;
constructor(private http:Http) {
  this.baseUrl="http://localhost:9999/emplyoees";
 }

 getAllEmplyoees():Observable<Emplyoee[]>{//conversion of data string to json
   return this.http.get(this.baseUrl).pipe(
    map((data)=>data.json())
  );
 }
 getIdIncludedBaseUrl(empid):string{
   return this.baseUrl+"/"+empid;
 }
 getEmplyoee(empid):Observable<Emplyoee>{//conversion of data string to json
  return this.http.get(this.getIdIncludedBaseUrl(empid)).pipe(
   map((data)=>data.json())
 );
}
deleteEmplyoee(empid):Observable<Response>{//conversion of data string to json
  return this.http.delete(this.getIdIncludedBaseUrl(empid));
}
//Observable is an asynchronous call
getJsonContentTypeHeader() : RequestOptions{ 
   const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return new RequestOptions({ headers: headers });
  }

addEmplyoee(emplyoee:Emplyoee):Observable<Emplyoee>{
let url = this.baseUrl;
let content = JSON.stringify(emplyoee);
let headers = this.getJsonContentTypeHeader();

return this.http.post(url,content,headers).pipe(
  map(data=>data.json())
);

}

updateEmplyoee(emplyoee:Emplyoee):Observable<Emplyoee>{
  let url = this.baseUrl;
  let content = JSON.stringify(emplyoee);
  let headers = this.getJsonContentTypeHeader();
  
  return this.http.put(url,content,headers).pipe(
    map(data=>data.json())
  );
  
  }
}
