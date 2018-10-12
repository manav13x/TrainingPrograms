import { Component, OnInit } from '@angular/core';
import { Emplyoee } from '../../model/emplyoee';
import { EmplyoeeService } from '../../service/emplyoee.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-emplyoee-details',
  templateUrl: './emplyoee-details.component.html',
  styleUrls: ['./emplyoee-details.component.css']
})
export class EmplyoeeDetailsComponent implements OnInit {

  emplyoee: Emplyoee;
  ladyLogo: string;
  gentLogo: string;
  cloudIcon : string;
  itIcon : string;
  supportIcon:string;
  testIcon:string;
  constructor(private emplyoeeService: EmplyoeeService,
    private activatedRoute: ActivatedRoute
  ) {
  this.ladyLogo = "/assets/images/fem.jpg";
    this.gentLogo = "/assets/images/male.png";
    this.itIcon="/assets/images/it.jpg";
    this.cloudIcon="/assets/images/cloud.jpg";
    this.supportIcon="/assets/images/support.jpg";
    this.testIcon="/assets/images/testing.png";
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

}
