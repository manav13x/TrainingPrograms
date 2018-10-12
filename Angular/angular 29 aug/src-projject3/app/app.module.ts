import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule,Routes} from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {FormsModule} from '@angular/forms';
import { VisitorComponent } from './visitor/visitor.component';
import { ItemListComponent } from './item-list/item-list.component';
import { ItemFormComponent } from './item-form/item-form.component';
//for ngModule Selector

const routesMap : Routes = [
  {path:'',component:HomeComponent},
  {path:'vc',component:VisitorComponent},
  {path:'ilc',component:ItemListComponent},
  {path:'if',component:ItemFormComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    VisitorComponent,
    ItemListComponent,
    ItemFormComponent
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
