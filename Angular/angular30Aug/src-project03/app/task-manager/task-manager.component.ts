import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';

@Component({
  selector: 'app-task-manager',
  templateUrl: './task-manager.component.html',
  styleUrls: ['./task-manager.component.css']
})
export class TaskManagerComponent implements OnInit {
  tasks:Task[];
  completedCount:number;

  constructor() { 
    //this.tasks = [];
    this.completedCount = 0;
  }

  ngOnInit() {
    this.tasks=[
      {taskId:101,name:"Buy 1 Kg of sugar",isCompleted:false},
      {taskId:102,name:"Collect collect cloths from laundry",isCompleted:false},
      {taskId:103,name:"Buy gift for marirage",isCompleted:false},
      {taskId:104,name:"Buy 1 Kg of Potatoes",isCompleted:false},
    ];
  }
  handleCompleted(isComplete:boolean){
    if(isComplete){
      this.completedCount++;
    }
    else{
      this.completedCount--;
    }
  }


  handleAdd(taskName:string)
  {
    let task = new Task();
    task.name = taskName;
    task.taskId = this.tasks[this.tasks.length-1].taskId+1 ;
    this.tasks.push(task);
 }
}
