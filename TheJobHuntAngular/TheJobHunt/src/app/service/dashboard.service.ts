import { Injectable } from '@angular/core';
import { SearchService } from './search.service';
import { JobService } from './job.service';
import { Router } from '@angular/router';
import { Job } from '../models/Job';

import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { DataService } from './data.service';
import { SavedJob } from '../models/SavedJob';

import { UserInformation } from '../models/UserInformation';



@Injectable({
  providedIn: 'root'
})
export class DashboardService {


  constructor(private httpClient: HttpClient,
    private searchService: SearchService,
    private jobService: JobService,
    private router: Router) { }


  searchForJob() {
    this.router.navigate(['/search']);
  }
  getSavedJobs() {
    return this.httpClient.get<SavedJob[]>("http://localhost:8000/jobs/getAllJobs",
      { withCredentials: true, observe: 'response' as 'response' }
    );
  }
  updateSavedJob(job: SavedJob) {
    let options = {
      withCredentials: true,
      observe: 'response' as 'response',
      body: {
        "Users": job.Users,
        "AppliedFor": job.AppliedFor,
        "Id": job.Id,
        "OrganizationName": job.OrganizationName,
        "MatchedObjectId": job.MatchedObjectId,
        "PositionTitle": job.PositionTitle,
        "PositionLocationDisplay": job.PositionLocationDisplay,
        "AgencyMarketingStatement": job.AgencyMarketingStatement,
        "Evaluations": job.Evaluations,
        "JobSummary": job.JobSummary,
        "OtherInformation": job.OtherInformation,
        "Requirements": job.Requirements
      },
    };
    return this.httpClient.post<SavedJob>("http://localhost:8000/jobs/updateJob", options);
  }
  deleteJob(job: SavedJob) {
    let options = {
      withCredentials: true,
      observe: 'response' as 'response',
      body: {
        "Users": job.Users,
        "AppliedFor": job.AppliedFor,
        "Id": job.Id,
        "OrganizationName": job.OrganizationName,
        "MatchedObjectId": job.MatchedObjectId,
        "PositionTitle": job.PositionTitle,
        "PositionLocationDisplay": job.PositionLocationDisplay,
        "AgencyMarketingStatement": job.AgencyMarketingStatement,
        "Evaluations": job.Evaluations,
        "JobSummary": job.JobSummary,
        "OtherInformation": job.OtherInformation,
        "Requirements": job.Requirements
      },
    };
    return this.httpClient.delete<SavedJob>("http://localhost:8000/jobs/deleteJob", options);
  }


  public getCurrentUserInfo() {
    return this.httpClient.get<UserInformation>("http://localhost:8000/info/myInfo",
      { withCredentials: true, observe: 'response' as 'response' }
    );
  }
}


