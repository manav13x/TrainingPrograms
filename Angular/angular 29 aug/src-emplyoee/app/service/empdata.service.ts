import { Injectable } from '@angular/core';
import { Emplyoee } from '../model/emplyoee';

@Injectable({
  providedIn: 'root'
})
export class EmpdataService {
emplist: Emplyoee[];
  constructor() { 
    this.emplist = [];
  }
  getAllItems()
  {
    return this.emplist;
  }
  add(empl : Emplyoee)
  {
    this.emplist.push(empl);
  }
}
