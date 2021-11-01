import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JobService } from '../service/job.service';
import { FormBuilder } from '@angular/forms';
import { DataService } from '../service/data.service';
import { User } from '../models/User';
import { SavedJob } from '../models/SavedJob';
import { HttpClient } from '@angular/common/http';
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
  ) { }

  user!: User;
  savedJobsList!: SavedJob[];
  dashboardSearch = this.formBuilder.group({
    dashboardSearchString: this.jobService.currentSearchString
  });

  ngOnInit() {
    this.user = this.dataService.currentUser;
    this.getCurrentUsersJobList();
    console.log(this.savedJobsList);
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
        }
      }
    );
  }

  deleteJob(jobId: number) {
    //todo
  }
}
