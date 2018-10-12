import { Component, OnInit } from '@angular/core';
import { Emplyoee } from '../../model/emplyoee';
import { EmplyoeeService } from '../../service/emplyoee.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-emplyoee-list',
  templateUrl: './emplyoee-list.component.html',
  styleUrls: ['./emplyoee-list.component.css']
})
export class EmplyoeeListComponent implements OnInit {

  emplyoees:Emplyoee[];
  
  ladyLogo:string;
  gentLogo:string;

  constructor(
    private emplyoeeService:EmplyoeeService
, private activatedRoute : ActivatedRoute  ) {
    this.ladyLogo="/assets/images/fem.jpg";
    this.gentLogo="/assets/images/male.png";
   }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe(
      (params) =>{
        let field = params['field'];
        let srchValue = params['srchValue'];

        console.log(field +":"+srchValue);

        if(field && srchValue){
          this.emplyoeeService.searchEmplyoees(field,srchValue).subscribe(
            (data) => this.emplyoees=data,
            (err)=>{this.emplyoees=undefined}
          );
        }else{
          this.emplyoeeService.getAllEmplyoees().subscribe(
            (data) => this.emplyoees=data,
            (err)=> {this.emplyoees=undefined}
          );
        }
      },
      (err)=>this.emplyoees=undefined
    );
    
  }

}
