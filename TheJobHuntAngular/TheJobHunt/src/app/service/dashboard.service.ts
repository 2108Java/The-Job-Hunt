import { Injectable } from '@angular/core';
import { SearchService } from './search.service';
import { JobService } from './job.service';
import { Router } from '@angular/router';
import { Job } from '../models/Job';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private searchService:SearchService,private jobService:JobService,private router:Router) { }

  public searchForJob(searchString:string) {
    // this.jobService.currentSearchList= this.searchService.getSearch(searchString);
    this.router.navigate(['/search']);
  }
}
