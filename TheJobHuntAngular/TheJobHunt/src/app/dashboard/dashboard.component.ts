import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JobService } from '../service/job.service';
import { FormBuilder } from '@angular/forms';
import { UserInformation } from '../models/UserInformation';
import { DashboardService } from '../service/dashboard.service';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {

  userInfo!: UserInformation;

  constructor(private dataService: DataService, private dashboardService: DashboardService, private jobService: JobService, private router: Router, private formBuilder: FormBuilder) {   this.getCurrentUserInfo(); }
  ngOnInit() {
    this.getCurrentUserInfo();
  }

  dashboardSearch = this.formBuilder.group({
    dashboardSearchString: ""
  });
  public searchForJob() {
    this.jobService.currentSearchString = this.dashboardSearch.get("dashboardSearchString")!.value;
    this.router.navigate(['/search']);
  }

  public getCurrentUserInfo() {
    this.dashboardService.getCurrentUserInfo().subscribe(
      (data) => {
        if (data.body != null) {
          this.userInfo = data.body;
          this.dataService.userInfo = this.userInfo;
          console.log(this.userInfo);
        }
      }
    );
  }
}
