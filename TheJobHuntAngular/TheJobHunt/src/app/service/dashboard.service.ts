import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { HttpClient } from '@angular/common/http';
import { SavedJob } from '../models/SavedJob';

import { UserInformation } from '../models/UserInformation';



@Injectable({
  providedIn: 'root'
})
export class DashboardService {


  constructor(private httpClient: HttpClient,
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
    return this.httpClient.put<SavedJob>("http://localhost:8000/jobs/updateJob", {
      "AppliedFor": job.AppliedFor,
      "Id": job.Id,
    }, { withCredentials: true, observe: 'response' as 'response'
   });
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


