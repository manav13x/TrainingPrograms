import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule,Routes} from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {FormsModule} from '@angular/forms';
import { VisitorComponent } from './visitor/visitor.component';
import { ItemListComponent } from './item-list/item-list.component';
import { ItemFormComponent } from './item-form/item-form.component';
import { ItemViewComponent } from './item-view/item-view.component';
import { TaskViewComponent } from './task-view/task-view.component';
import { TaskManagerComponent } from './task-manager/task-manager.component';
import { NewTaskComponent } from './new-task/new-task.component';
//for ngModule Selector

const routesMap : Routes = [
  {path:'',component:HomeComponent},
  {path:'vc',component:VisitorComponent},
  {path:'ilc',component:ItemListComponent},
  {path:'if',component:ItemFormComponent},
  {path:'ivc/:id',component:ItemViewComponent},
  {path:'ie/:id',component:ItemFormComponent},
  {path:'tmc',component:TaskManagerComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    VisitorComponent,
    ItemListComponent,
    ItemFormComponent,
    ItemViewComponent,
    TaskViewComponent,
    TaskManagerComponent,
    NewTaskComponent
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
