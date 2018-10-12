import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule,Routes} from '@angular/router';
import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';

import { BookListComponent } from './item-list/item-list.component';
import { BookFormComponent } from './item-form/item-form.component';
import { BookViewComponent } from './item-view/item-view.component';
//for ngModule Selector

const routesMap : Routes = [
  {path:'',component:BookListComponent},
  {path:'if',component:BookFormComponent},
  {path:'ivc/:id',component:BookViewComponent},
  {path:'ie/:id',component:BookFormComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    BookFormComponent,
    BookViewComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routesMap),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
