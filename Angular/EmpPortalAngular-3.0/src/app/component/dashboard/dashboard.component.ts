import { Component, OnInit } from '@angular/core';
import { Emplyoee } from '../../model/emplyoee';
import { EmplyoeeService } from '../../service/emplyoee.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  title: string;
  logoUrl: string;
  ladyLogo: string;
  gentLogo: string;
  birthLogo:string;
  emplyoees: Emplyoee[];
  msg : string;
  cloudIcon : string;
  itIcon : string;
  supportIcon:string;
  testIcon:string;
  constructor(private emplyoeeService:EmplyoeeService,
    private activatedRoute:ActivatedRoute) {
    this.title = "Emplyoee Portal 3.0";
    this.logoUrl = "/assets/images/emplogo.jpg"; 
    this.ladyLogo = "/assets/images/fem.jpg";
    this.gentLogo = "/assets/images/male.png";
    this.birthLogo = "/assets/images/birthday.png";
    this.itIcon="/assets/images/it.jpg";
    this.cloudIcon="/assets/images/cloud.jpg";
    this.supportIcon="/assets/images/support.jpg";
    this.testIcon="/assets/images/testing.png";
  }

  ngOnInit() {
    this.emplyoeeService.getAllEmplyoees().subscribe(
      (data) => this.emplyoees = data
    );
    this.activatedRoute.queryParams.subscribe(
      (params)=>{
        let emplyoeeId=params['id'];
        let operation=params['opt'];
        if(emplyoeeId && operation){
          this.msg = "Emplyoee # "+emplyoeeId + " is successfully "+
          (operation=='d'?'Deleted':(operation=='a'?'added':'updated'));
          
        }else{
          this.msg=undefined;
        }
      }
    );
  }
}
