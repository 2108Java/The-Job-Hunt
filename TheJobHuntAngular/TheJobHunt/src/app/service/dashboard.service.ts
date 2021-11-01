import { Injectable } from '@angular/core';
import { SearchService } from './search.service';
import { JobService } from './job.service';
import { Router } from '@angular/router';
import { Job } from '../models/Job';
import { UserInformation } from '../models/UserInformation';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private httpClient: HttpClient, private searchService:SearchService,private jobService:JobService,private router:Router) { }

  public searchForJob(searchString:string) {
    // this.jobService.currentSearchList= this.searchService.getSearch(searchString);
    this.router.navigate(['/search']);
  }

  public getCurrentUserInfo() {
    return this.httpClient.get<UserInformation>("http://localhost:8000/info/myInfo",
      { withCredentials: true, observe: 'response' as 'response' }
    );
  }
  }


