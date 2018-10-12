import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { HttpModule } from "@angular/http";
import {RouterModule,Routes} from '@angular/router'
import { AppComponent } from './app.component';
import { EmplyoeeListComponent } from './components/emplyoee-list/emplyoee-list.component';
import { EmplyoeeFormComponent } from './components/emplyoee-form/emplyoee-form.component';
import { EmplyoeeViewComponent } from './components/emplyoee-view/emplyoee-view.component';
import { TypeCountPipe } from './pipes/dept-count.pipe';


const paths : Routes = [
  {path:'',component:EmplyoeeListComponent},
  {path:'add',component:EmplyoeeFormComponent},
  {path:'view/:empid',component:EmplyoeeViewComponent},
  {path:'edit/:empid',component:EmplyoeeFormComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    EmplyoeeListComponent,
    EmplyoeeFormComponent,
    EmplyoeeViewComponent,
    TypeCountPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(paths)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
