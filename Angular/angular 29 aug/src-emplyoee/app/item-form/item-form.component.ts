import { Component, OnInit } from '@angular/core';
import { Emplyoee } from '../model/emplyoee';
import { EmpdataService } from '../service/empdata.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})
export class ItemFormComponent implements OnInit {

  empl : Emplyoee;
  constructor(private enc : EmpdataService,private router:Router) { }

  ngOnInit() {
    this.empl = new Emplyoee();
  }

  save(){
    this.empl.hra=this.empl.hra/100;
    this.enc.add(this.empl);
    this.router.navigateByUrl("/ilc");
  }
  cancel(){
    this.router.navigateByUrl("/ilc");
  }
}
