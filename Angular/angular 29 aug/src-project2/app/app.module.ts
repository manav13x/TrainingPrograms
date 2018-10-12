import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { StaasComponent } from './staas/staas.component';
import { SaasComponent } from './saas/saas.component';
import { IaasComponent } from './iaas/iaas.component';
import {RouterModule,Routes} from '@angular/router';

const routeMap : Routes = [
  {path:'',component:HomeComponent},
  {path:'saas',component:SaasComponent},
  {path:'iaas',component:IaasComponent},
  {path:'staas',component:StaasComponent}
  ];
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    StaasComponent,
    SaasComponent,
    IaasComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routeMap)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
