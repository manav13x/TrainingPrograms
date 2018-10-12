import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title : string;
  logoUrl: string;
  field:string="emailId";
  srchValue:string="";
  constructor(
    private router:Router
  ){
    this.title="Emplyoee portal 3.0";
    this.logoUrl="/assets/images/emplogo.jpg";
  }

  doSearch(){
    this.router.navigate(["/listEmplyoees"],{queryParams:{field:this.field,srchValue:this.srchValue}});
  }

  doChangeField(field,ele){
    this.field=field;
    this.srchValue="";
    switch(field){
      case 'mobileNumber': ele.placeholder="Mobile Number";ele.type="text"; break;
      case 'emailId': ele.placeholder="Email Id"; ele.type="email";break;
      case 'lastName': ele.placeholder="Last Name"; ele.type="text";break;
      case 'dept': ele.placeholder="Department"; ele.type="text";break;
    }
  }
}
