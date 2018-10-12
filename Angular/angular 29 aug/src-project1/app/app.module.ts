import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TodayComponent } from './today/today.component';
import { HomeComponent } from './home/home.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import {RouterModule,Routes} from '@angular/router';
import { PipesDemoComponent } from './pipes-demo/pipes-demo.component';
import { ToWordsPipe } from './to-words.pipe';
import { MultiplesOfPipe } from './multiples-of.pipe';


const routeMap : Routes = [
{path:'',component:HomeComponent},
{path:'abt',component:AboutUsComponent},
{path:'cont',component:ContactUsComponent},
{path:'pipes',component:PipesDemoComponent}
];
//if url has nothing then home component if abt the about us and similarly
@NgModule({
  declarations: [
    AppComponent,
    TodayComponent,
    HomeComponent,
    AboutUsComponent,
    ContactUsComponent,
    PipesDemoComponent,
    ToWordsPipe,
    MultiplesOfPipe
  ],
  imports: [//add router module here
    BrowserModule,
    RouterModule.forRoot(routeMap)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
