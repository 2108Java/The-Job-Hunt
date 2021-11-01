import { Injectable } from '@angular/core';
import { Job } from '../models/Job';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { JobService } from './job.service';
import { fakeJob } from '../search/search.component';
import { SavedJob } from '../models/SavedJob';
@Injectable({
  providedIn: 'root'
})
export class SearchService {
  BASE_SEARCH: string = "https://data.usajobs.gov/api/search?"
  AUTHKEY: string = 'phGRKckFO5Eo3cnG2VfS5StjJd+UaBYvsCC7CNOHvuI=';
  HEADERS: HttpHeaders = new HttpHeaders().set('Authorization-Key', this.AUTHKEY);
  currentSearch: string = "";
  currentPage: number = 0;
  currentPageTotal: number = 0;


  constructor(private httpClient: HttpClient, private jobService: JobService) { }

  searchAPI(searchString: string): Observable<Job[]> {
    let fullSearch: string = this.BASE_SEARCH + searchString;
    return this.httpClient.get<Job[]>(fullSearch, {
      'headers': this.HEADERS
    });
  }

  getSearch(searchString: string): Observable<Job[]> {
    this.currentPage = 0;
    this.currentSearch = "Keyword=" + searchString;
    console.log(this.currentSearch);
    // if (false /* other search conditions applied */) {
    //   //do a method to appnd searches
    // }

    return this.searchAPI(this.currentSearch);
  }

  addJob(job:Job) {

    if(job.MatchedObjectDescriptor.UserArea.Details.AgencyMarketingStatement.length < 1){
      job.MatchedObjectDescriptor.UserArea.Details.AgencyMarketingStatement = "empty";
    }
    if(job.MatchedObjectDescriptor.UserArea.Details.Evaluations.length < 1){
      job.MatchedObjectDescriptor.UserArea.Details.Evaluations = "empty";
    }
    if(job.MatchedObjectDescriptor.UserArea.Details.JobSummary.length < 1){
      job.MatchedObjectDescriptor.UserArea.Details.JobSummary = "empty";
    }
    if(job.MatchedObjectDescriptor.UserArea.Details.OtherInformation.length < 1){
      job.MatchedObjectDescriptor.UserArea.Details.OtherInformation = "empty";
    }
    if(job.MatchedObjectDescriptor.UserArea.Details.Requirements.length < 1){
      job.MatchedObjectDescriptor.UserArea.Details.Requirements = "empty";
    }
    if(job.MatchedObjectDescriptor.PositionLocationDisplay.length < 1){
      job.MatchedObjectDescriptor.PositionLocationDisplay = "empty";
    }
    if(job.MatchedObjectDescriptor.PositionTitle.length < 1){
      job.MatchedObjectDescriptor.UserArea.Details.AgencyMarketingStatement = "empty";
    }
    if(job.MatchedObjectDescriptor.OrganizationName.length < 1){
      job.MatchedObjectDescriptor.OrganizationName = "empty";
    }
    
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

  // changePage(pageValue: number):Observable<Job[]> {
  //   let newPage: string = "";
  //   this.currentPage += pageValue;
  //   if (this.currentPage > 1) {
  //     newPage = this.currentSearch + "&Page=" + this.currentPage;
  //   } else if (this.currentPage == 1) {
  //     newPage = this.currentSearch;
  //   }
  //   this.searchAPI(newPage);
  //   return this.searchAPI(newPage);
  // }
}
