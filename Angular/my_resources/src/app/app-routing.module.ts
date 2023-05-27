import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddMRNComponent } from './add-mrn/add-mrn.component';
import { AddPOComponent } from './add-po/add-po.component';
import { AddSOComponent } from './add-so/add-so.component';
import { AddUserComponent } from './add-user/add-user.component';
import { HomeComponent } from './home/home.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { ViewMRNComponent } from './view-mrn/view-mrn.component';
import { ViewPOComponent } from './view-po/view-po.component';
import { ViewSOComponent } from './view-so/view-so.component';
import { ViewUserComponent } from './view-user/view-user.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginPageComponent },
  { path: 'home', component: HomeComponent},
  { path: 'addPO', component: AddPOComponent},
  { path: 'viewPO', component: ViewPOComponent},
  { path: 'addSO', component: AddSOComponent},
  { path: 'viewSO', component: ViewSOComponent},
  { path: 'addMRN', component: AddMRNComponent},
  { path: 'viewMRN', component: ViewMRNComponent },
  { path: 'addUser', component: AddUserComponent },
  { path: 'viewUser', component: ViewUserComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
