import { Component, OnInit } from '@angular/core';
import { Emplyoee } from '../../model/emplyoee';
import { EmplyoeeService } from '../../service/emplyoee.service';

@Component({
  selector: 'app-emplyoee-list',
  templateUrl: './emplyoee-list.component.html',
  styleUrls: ['./emplyoee-list.component.css']
})
export class EmplyoeeListComponent implements OnInit {
  emplyoees:Emplyoee[];

  ladyLogo:string;
  gentLogo:string;
  cloudIcon : string;
  itIcon : string;
  supportIcon:string;
  testIcon:string;

  constructor(private emplyoeeService:EmplyoeeService) {
    this.ladyLogo="/assets/images/fem.jpg";
    this.gentLogo="/assets/images/male.png";
    this.itIcon="/assets/images/it.jpg";
    this.cloudIcon="/assets/images/cloud.jpg";
    this.supportIcon="/assets/images/support.jpg";
    this.testIcon="/assets/images/testing.png";
   }

  ngOnInit() {
    this.emplyoeeService.getAllEmplyoees().subscribe(
      (data)=>this.emplyoees=data);
  }

}
