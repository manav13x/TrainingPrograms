import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'toWords'
})
export class ToWordsPipe implements PipeTransform {

  words : string[]=['ZERO','ONE','TWO',
                           'THREE','FOUR','FIVE',
                          'SIZ','SEVEN','EIGHT','NINE'
];
  transform(value: number, args?: any): string {
   let result  : string= "";
   let input : string  = value + "";
   for( let i=0;i<input.length;i++){
     
      let digit = parseInt(input.charAt(i));
      let w = this.words[digit];
      if(w  == undefined)
      result += input.charAt(i)+ " ";
      else
    result += w+ " ";
  }
    return result;
  }

}
