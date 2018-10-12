import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AboutUsComponent } from '../about-us/about-us.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
//dependency injection of router in constructor so that its provided 
//by angular
  constructor(private router: Router) { }

  ngOnInit() {
  }

  showAboutUs(){

    //this.router.navigate(AboutUsComponent);
    this.router.navigateByUrl("/abt");
  }
  showContactUs(){
    this.router.navigateByUrl("/cont");
  }
}
