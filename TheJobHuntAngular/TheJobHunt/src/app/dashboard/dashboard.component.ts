import { Component, OnInit } from '@angular/core';
import { SearchService } from '../service/search.service';
import { Router } from '@angular/router';
import { JobService } from '../service/job.service';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {

  constructor(private searchService: SearchService, private jobService: JobService, private router: Router, private formBuilder: FormBuilder) { }
  ngOnInit() {
  }
  dashboardSearch = this.formBuilder.group({
    dashboardSearchString: ""
  });
  public searchForJob() {
    this.jobService.currentSearchList = this.searchService.getSearch(this.dashboardSearch.get("dashboardSearchString")!.value);
    this.router.navigate(['/search']);
  }

}
