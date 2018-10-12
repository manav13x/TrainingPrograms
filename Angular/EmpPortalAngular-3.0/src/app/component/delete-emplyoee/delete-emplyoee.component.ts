import { Component, OnInit } from '@angular/core';
import { Emplyoee } from '../../model/emplyoee';
import { ActivatedRoute, Router } from '@angular/router';
import { EmplyoeeService } from '../../service/emplyoee.service';

@Component({
  selector: 'app-delete-emplyoee',
  templateUrl: './delete-emplyoee.component.html',
  styleUrls: ['./delete-emplyoee.component.css']
})
export class DeleteEmplyoeeComponent implements OnInit {

  emplyoee: Emplyoee;
  ladyLogo: string;
  gentLogo: string;
  constructor(private emplyoeeService: EmplyoeeService,
    private activatedRoute: ActivatedRoute,
    private router : Router
  ) {
  this.ladyLogo = "/assets/images/fem.jpg";
    this.gentLogo = "/assets/images/male.png";
  }

  ngOnInit() {
    this.activatedRoute.params.subscribe(
      (params) => {
        let emplyoeeId = params['id'];
        if (emplyoeeId) {
          this.emplyoeeService.getEmplyoeeById(emplyoeeId).subscribe(
            (data) => this.emplyoee = data
          );
        }
      }
    );
  }

  doDelete(isConfirmed:boolean){
    if(isConfirmed){
      this.emplyoeeService.deleteEmplyoeeById(this.emplyoee.empId).subscribe(
        (resp) =>{
          if(resp.ok){
            this.router.navigateByUrl("/?opt=d&id="+this.emplyoee.empId);
          }
        }
      );
    }else{
      this.router.navigateByUrl("/");
    }
  }
}
