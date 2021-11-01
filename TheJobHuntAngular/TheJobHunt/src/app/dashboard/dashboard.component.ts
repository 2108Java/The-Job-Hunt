import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JobService } from '../service/job.service';
import { FormBuilder } from '@angular/forms';

import { DataService } from '../service/data.service';
import { User } from '../models/User';
import { SavedJob } from '../models/SavedJob';
import { DashboardService } from '../service/dashboard.service';
import { UserInformation } from '../models/UserInformation';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {

  user!: User;
  savedJobsList!: SavedJob[];
  selectedJob!: SavedJob;
  userInfo!: UserInformation;

  constructor(private dataService: DataService,
    private dashboardService: DashboardService,
    private jobService: JobService,
    private router: Router,
    private formBuilder: FormBuilder) {
    this.getCurrentUserInfo();
  }

  dashboardSearch = this.formBuilder.group({
    dashboardSearchString: this.jobService.currentSearchString
  });

  ngOnInit() {
    this.getCurrentUsersJobList();
    this.user = this.dataService.currentUser;
  }

  public searchForJob() {
    this.jobService.currentSearchString = this.dashboardSearch.get("dashboardSearchString")!.value;
    this.router.navigate(['/search']);
  }

  getCurrentUsersJobList() {
    this.dashboardService.getSavedJobs().subscribe(
      (data) => {
        if (data.body != null) {
          this.savedJobsList = data.body;
          this.dataService.currentUser = this.savedJobsList[0].Users;
          this.user = this.savedJobsList[0].Users;
        }
      }
    );
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

  selectJob(job: SavedJob) {
    this.selectedJob = job;
  }
  deleteJob(job: SavedJob) {
    this.dashboardService.deleteJob(job).subscribe(
      (data) => {
        this.getCurrentUsersJobList();
      }
    );
  }
  updateAppliedFor(event: any) {
    console.log(event);
  }
}
