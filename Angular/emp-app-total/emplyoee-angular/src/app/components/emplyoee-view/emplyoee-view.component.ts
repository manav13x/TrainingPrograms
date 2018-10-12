import { Component, OnInit } from '@angular/core';
import { Emplyoee } from '../../models/emplyoee';
import { EmplyoeeService } from '../../services/emplyoee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-emplyoee-view',
  templateUrl: './emplyoee-view.component.html',
  styleUrls: ['./emplyoee-view.component.css']
})
export class EmplyoeeViewComponent implements OnInit {

  emplyoee:Emplyoee
  constructor(private emplyoeeService:EmplyoeeService,
              private activatedRoute:ActivatedRoute,
              private router:Router
  ) {
    this.emplyoee = new Emplyoee();
   }

  ngOnInit() {
    this.activatedRoute.params.subscribe(
      (params)=>{
        let empid = params['empid']
        //console.log(empid+"hello")
        this.emplyoeeService.getEmplyoee(empid).subscribe(
          (data) => this.emplyoee=data
        );
      }
    );
  }

  doEdit(){
    this.router.navigateByUrl("/edit/"+this.emplyoee.empid);
  }

  doDelete(){
    if(confirm("Do You want to delete Emplyoee# "+this.emplyoee.empid+"?")){
      this.emplyoeeService.deleteEmplyoee(this.emplyoee.empid).subscribe(
        (resp)=>{
          if(resp.ok){
              this.router.navigateByUrl("/");
          }
        }
      );
    }
  }
}
