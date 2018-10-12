import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule,Routes} from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { EmplyoeeListComponent } from './component/emplyoee-list/emplyoee-list.component';
import { EmplyoeeDetailsComponent } from './component/emplyoee-details/emplyoee-details.component';
import { EmplyoeeFormComponent } from './component/emplyoee-form/emplyoee-form.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { GenderCountPipe } from './pipe/gender-count.pipe';
import { FullNamePipe } from './pipe/full-name.pipe';
import { AdjustLengthPipe } from './pipe/adjust-length.pipe';
import { BornTodayPipe } from './pipe/born-today.pipe';
import { DeptCountPipe } from './pipe/dept-count.pipe';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { DeleteEmplyoeeComponent } from './component/delete-emplyoee/delete-emplyoee.component';

const paths : Routes =[
  {path:'',component:DashboardComponent},
  {path:'listEmplyoees',component:EmplyoeeListComponent},
  {path:'addEmplyoee',component:EmplyoeeFormComponent},
  {path:'editEmplyoee/:id',component:EmplyoeeFormComponent},
  {path:'viewEmplyoee/:id',component:EmplyoeeDetailsComponent},
  {path:'delEmplyoee/:id',component:DeleteEmplyoeeComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    EmplyoeeListComponent,
    EmplyoeeDetailsComponent,
    EmplyoeeFormComponent,
    DashboardComponent,
    GenderCountPipe,
    FullNamePipe,
    DeptCountPipe,
    AdjustLengthPipe,
    BornTodayPipe,
    DeleteEmplyoeeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AngularFontAwesomeModule,
    RouterModule.forRoot(paths)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
