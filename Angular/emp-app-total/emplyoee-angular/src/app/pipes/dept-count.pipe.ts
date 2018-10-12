import { Pipe, PipeTransform } from '@angular/core';
import { Emplyoee } from '../models/emplyoee';

@Pipe({
  name: 'deptCount'
})
export class TypeCountPipe implements PipeTransform {

  transform(emplyoees: Emplyoee[], dept?:string): number {
    return emplyoees.filter((b)=>b.dept==dept).length;;
  }

}
