import { Pipe, PipeTransform } from '@angular/core';
import { Emplyoee } from '../model/emplyoee';

@Pipe({
  name: 'bornToday'
})
export class BornTodayPipe implements PipeTransform {

  transform(emplyoees: Emplyoee[]):Emplyoee[] {
    let today=new Date();
    return emplyoees.filter(c => {
      let dob = new Date(c.dateOfBirth);
      return dob.getDate()==today.getDate() &&
            dob.getMonth()==today.getMonth();
    });
  }

}
