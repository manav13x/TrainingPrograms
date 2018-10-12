import { Component, OnInit } from '@angular/core';
import { Emplyoee } from '../../models/emplyoee';
import { EmplyoeeService } from '../../services/emplyoee.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-emplyoee-form',
  templateUrl: './emplyoee-form.component.html',
  styleUrls: ['./emplyoee-form.component.css']
})
export class EmplyoeeFormComponent implements OnInit {
  emplyoee:Emplyoee;
  isEdit:boolean;
  constructor(
    private emplyoeeService:EmplyoeeService,
    private router:Router,
    private activatedRoute:ActivatedRoute
  ) { }

  ngOnInit() {

    this.emplyoee = new Emplyoee();
    this.isEdit = false;
    //check for adding and editing check path parameter

    this.activatedRoute.params.subscribe(
      (params)=>{
        let empid = params['empid'];
        if(empid){
          this.isEdit=true;
          this.emplyoeeService.getEmplyoee(empid).subscribe(
            (data)=>this.emplyoee=data
          );
        }
      }
    );
  }


  saveEmplyoee(){
    if(this.isEdit){
      this.emplyoeeService.updateEmplyoee(this.emplyoee).subscribe(
        (data) => this.router.navigateByUrl("/")
      );
    }
    else{
      this.emplyoeeService.addEmplyoee(this.emplyoee).subscribe(
        (data) => this.router.navigateByUrl("/")
      );
    }
  }

}
