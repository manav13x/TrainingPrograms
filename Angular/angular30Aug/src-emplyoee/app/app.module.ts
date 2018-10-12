import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule,Routes} from '@angular/router';
import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';
import { ItemListComponent } from './item-list/item-list.component';
import { ItemFormComponent } from './item-form/item-form.component';
import { ItemViewComponent } from './item-view/item-view.component';
//for ngModule Selector

const routesMap : Routes = [
  {path:'',component:ItemListComponent},
  {path:'if',component:ItemFormComponent},
  {path:'ivc/:id',component:ItemViewComponent},
  {path:'ie/:id',component:ItemFormComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ItemListComponent,
    ItemFormComponent,
    ItemViewComponent,
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
