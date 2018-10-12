import { Pipe, PipeTransform } from '@angular/core';
import { Emplyoee } from '../model/emplyoee';

@Pipe({
  name: 'fullName'
})
export class FullNamePipe implements PipeTransform {

  transform(emplyoee: Emplyoee): string {
    let result =emplyoee.firstName+" "+emplyoee.lastName;
    return result;
  }

}
