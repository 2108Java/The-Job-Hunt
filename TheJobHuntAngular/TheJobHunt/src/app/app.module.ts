// Module Imports
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
// Component Imports
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SearchComponent } from './search/search.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AccountComponent } from './account/account.component';
import { JobDetailsComponent } from './job-details/job-details.component';
//  Service Imports
import { DataService } from './service/data.service';
import { JobService } from './service/job.service';
import { AuthService } from './service/auth.service';
import { LoginService } from './service/login.service';
import { SearchService } from './service/search.service';
import { DashboardService } from './service/dashboard.service';
import { RegisterService } from './service/register.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    SearchComponent,
    DashboardComponent,
    AccountComponent,
    JobDetailsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    DataService,
    JobService,
    AuthService,
    LoginService,
    SearchService,
    DashboardService,
    RegisterService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
