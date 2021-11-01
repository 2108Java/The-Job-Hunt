import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JobService } from '../service/job.service';
import { FormBuilder } from '@angular/forms';
import { DataService } from '../service/data.service';
import { User } from '../models/User';
import { SavedJob } from '../models/SavedJob';
import { DashboardService } from '../service/dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {

  constructor(
    private jobService: JobService,
    private router: Router,
    private formBuilder: FormBuilder,
    private dataService: DataService,
    private dashboardService: DashboardService
  ) {
    this.getCurrentUsersJobList();
  }

  user!: User;
  savedJobsList!: SavedJob[];
  selectedJob!: SavedJob;
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
}
