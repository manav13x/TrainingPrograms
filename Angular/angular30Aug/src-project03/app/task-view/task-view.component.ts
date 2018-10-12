import { Component, OnInit, Input, Output ,EventEmitter} from '@angular/core';
import { Task } from '../model/task';

@Component({
  selector: 'app-task-view',
  templateUrl: './task-view.component.html',
  styleUrls: ['./task-view.component.css']
})
export class TaskViewComponent implements OnInit {

@Input() task :Task;
@Output() completed : EventEmitter<boolean> = new EventEmitter<boolean>();
isEdit : boolean;
taskName:string;
  constructor() { }

  ngOnInit() {
    //this.completed = new EventEmitter<boolean>();
    this.isEdit =false;
    this.taskName = "";
  }
  markCompleted(status:boolean){
    this.task.isCompleted=status;
    this.completed.emit(status);
  }

}
