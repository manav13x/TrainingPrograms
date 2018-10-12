import { Component, OnInit } from '@angular/core';
import { Emplyoee } from '../model/emplyoee';
import { EmpdataService } from '../service/empdata.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})
export class ItemFormComponent implements OnInit {

  empl : Emplyoee;
  isEdit : boolean;
  constructor(private enc : EmpdataService,private router:Router, private activatedRoute : ActivatedRoute) { }

  ngOnInit() {
    //this.empl = new Emplyoee();
    this.activatedRoute.params.subscribe(
      data =>{
        let itemId = data['id'];
        if(itemId){
          this.empl = this.enc.getItemByid(itemId);
          this.isEdit=true;
        }
        else{
          this.empl =  new Emplyoee();
          this.isEdit=false;
        }
      }
   );
  }

  save(){
    if(this.isEdit){
      this.empl.hra=this.empl.hra/100;
      this.enc.update(this.empl);
    }
      else
    {
      this.empl.hra=this.empl.hra/100;
   this.enc.add(this.empl);
    }
    //this.inv.add(this.item);
    this.router.navigateByUrl("")
  }
  cancel(){
    this.router.navigateByUrl("");
  }
}
