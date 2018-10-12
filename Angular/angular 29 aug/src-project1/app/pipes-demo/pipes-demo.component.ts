import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes-demo',
  templateUrl: './pipes-demo.component.html',
  styleUrls: ['./pipes-demo.component.css']
})
export class PipesDemoComponent implements OnInit {

  //create data on which pipes will eb applied
  strData:string;
  numData:number;
  dateDate:Date;
  array : number[];
  constructor() {
    this.strData="This is a Demo String";
    this.numData=7990.56566;
    this.dateDate=new Date;
    this.array=[10,11,12,13,14,15,16,171,8,19,20,21,22,23,24,25];
   }

  ngOnInit() {
  }

}
