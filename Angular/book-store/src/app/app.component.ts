import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title : String;
  logoUrl:string;
  constructor(){
    this.title="Book Store App";
    this.logoUrl = "/assets/book-logo.jpg";
  }
}
