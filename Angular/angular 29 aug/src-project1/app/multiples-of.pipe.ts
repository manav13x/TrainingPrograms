import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'multiplesOf'
})
export class MultiplesOfPipe implements PipeTransform {

  transform(value: number[], multiplier: number): number[] {
    let result : number[]=[];
    for (let n of value)
    {
      if(n%multiplier==0)
      {
        result.push(n);
      }
    } 
  return result;
  }
}
