import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { ResponsiveDirective } from './responsive.directive';
import { HomeComponent } from './home/home.component';
import { AddMRNComponent } from './add-mrn/add-mrn.component';
import { AddPOComponent } from './add-po/add-po.component';
import { AddSOComponent } from './add-so/add-so.component';
import { AddUserComponent } from './add-user/add-user.component';
import { ViewMRNComponent } from './view-mrn/view-mrn.component';
import { ViewPOComponent } from './view-po/view-po.component';
import { ViewSOComponent } from './view-so/view-so.component';
import { ViewUserComponent } from './view-user/view-user.component';
import { RouterModule } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ResponsiveDirective,
    HomeComponent,
    AddMRNComponent,
    AddPOComponent,
    AddSOComponent,
    AddUserComponent,
    ViewMRNComponent,
    ViewPOComponent,
    ViewSOComponent,
    ViewUserComponent,
    LoginPageComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    RouterModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
