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
  selectedJob!: SavedJob | null;
  userInfo!: UserInformation;
  message!: string|null;

  constructor(private dataService: DataService,
    private dashboardService: DashboardService,
    private jobService: JobService,
    private router: Router,
    private formBuilder: FormBuilder) {
    this.getCurrentUserInfo();
    this.getCurrentUsersJobList();
  }

  dashboardSearch = this.formBuilder.group({
    dashboardSearchString: this.jobService.currentSearchString
  });

  ngOnInit() {
    this.getCurrentUserInfo();
    this.getCurrentUsersJobList();
    this.message=null;
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
          this.user = data.body[0].Users;
          this.dataService.currentSavedJobs = data.body;
          this.dataService.currentUser = data.body[0].Users;
        }
      }
    );
  }

  public getCurrentUserInfo() {
    this.dashboardService.getCurrentUserInfo().subscribe(
      (data) => {
        if (data.body != null) {
          this.userInfo = data.body;
          this.dataService.userInfo = data.body;
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
        if(data.status == 200){
          this.getCurrentUsersJobList();
          this.message="Successfully deleted job from list!";
          this.selectedJob = null;
        }
      }
    );
    this.getCurrentUsersJobList();
  }
  updateAppliedFor(job: SavedJob) {
    this.dashboardService.updateSavedJob(job).subscribe(
      (data)=>{
        console.log(data);
        if(data.status == 200){
          this.message="Successfully updated job's applied for status!";
        }
      }
    );
  }
}
