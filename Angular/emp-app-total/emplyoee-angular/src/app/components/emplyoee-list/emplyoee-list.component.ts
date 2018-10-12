import { Component, OnInit } from '@angular/core';
import {EmplyoeeService} from '../../services/emplyoee.service'
import { Emplyoee } from '../../models/emplyoee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-emplyoee-list',
  templateUrl: './emplyoee-list.component.html',
  styleUrls: ['./emplyoee-list.component.css']
})
export class EmplyoeeListComponent implements OnInit {
  emplyoees: Emplyoee[];
 cloudIcon : string;
 itIcon : string;
 supportIcon:string;
 testIcon:string;
  constructor(private emplyoeeService:EmplyoeeService,
  private router:Router) { 
    this.itIcon="/assets/it.jpg";
    this.cloudIcon="/assets/cloud.jpg";
    this.supportIcon="/assets/support.jpg";
    this.testIcon="/assets/testing.png";
  }

  ngOnInit() {
      this.emplyoeeService.getAllEmplyoees().subscribe(
        data=>this.emplyoees=data
      );

  }
  showEmplyoee(empid){
    //alert(empid);
    this.router.navigateByUrl("/view/"+empid);

  }

}
