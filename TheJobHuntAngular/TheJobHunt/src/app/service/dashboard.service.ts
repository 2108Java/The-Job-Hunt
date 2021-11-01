import { Injectable } from '@angular/core';
import { SearchService } from './search.service';
import { JobService } from './job.service';
import { Router } from '@angular/router';
import { Job } from '../models/Job';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { DataService } from './data.service';
import { SavedJob } from '../models/SavedJob';


@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private dataService: DataService, private router: Router, private httpClient: HttpClient) { }

  searchForJob() {
    this.router.navigate(['/search']);
  }
  getSavedJobs() {
    return this.httpClient.get<SavedJob[]>("http://localhost:8000/jobs/getAllJobs",
      { withCredentials: true, observe: 'response' as 'response' }
    );
  }
  deleteJob(job: SavedJob) {
    let options = {
      withCredentials: true,
      observe: 'response' as 'response',
      body: {
        "Users": job.Users,
        "AppliedFor": job.AppliedFor,
        "Id"!: job.Id,
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
}
