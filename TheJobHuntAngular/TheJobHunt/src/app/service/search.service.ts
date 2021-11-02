import { Injectable } from '@angular/core';
import { Job } from '../models/Job';
import { Observable } from 'rxjs';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { JobService } from './job.service';
@Injectable({
  providedIn: 'root'
})
export class SearchService {
  BASE_SEARCH: string = "https://data.usajobs.gov/api/search?"
  AUTHKEY: string = 'phGRKckFO5Eo3cnG2VfS5StjJd+UaBYvsCC7CNOHvuI=';
  HEADERS: HttpHeaders = new HttpHeaders().set('Authorization-Key', this.AUTHKEY);


  constructor(private httpClient: HttpClient) { }

  getSearch(searchString: string): Observable<Job[]> {
    let fullSearch: string = this.BASE_SEARCH + "Keyword=" + searchString;
    return this.httpClient.get<Job[]>(fullSearch, {
      'headers': this.HEADERS
    });
  }

  addJob(job:Job) {
    return this.httpClient.post("http://localhost:8000/jobs/addJob",
    {
      "OrganizationName": job.MatchedObjectDescriptor.OrganizationName,
      "MatchedObjectId": job.MatchedObjectId,
      "PositionTitle": job.MatchedObjectDescriptor.PositionTitle,
      "PositionLocationDisplay": job.MatchedObjectDescriptor.PositionLocationDisplay,
      "AgencyMarketingStatement": job.MatchedObjectDescriptor.UserArea.Details.AgencyMarketingStatement,
      "Evaluations": job.MatchedObjectDescriptor.UserArea.Details.Evaluations,
      "JobSummary": job.MatchedObjectDescriptor.UserArea.Details.JobSummary,
      "OtherInformation": job.MatchedObjectDescriptor.UserArea.Details.OtherInformation,
      "Requirements": job.MatchedObjectDescriptor.UserArea.Details.Requirements
    }, {withCredentials: true,observe: 'response' as 'response'}
    );
  }
}
