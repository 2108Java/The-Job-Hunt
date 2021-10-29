import { Injectable } from '@angular/core';
import { Job } from '../models/Job';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { JobService } from './job.service';
import { fakeJob } from '../search/search.component';
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


  constructor(private httpClient: HttpClient, private jobService:JobService) { }

  searchAPI(searchString: string): Observable<Job[]> {
    let fullSearch: string = this.BASE_SEARCH + searchString;
    // let jobs: Observable<Job[]> = this.httpClient.get<fakeJobList>(fullSearch, {
    //   'headers': this.HEADERS
    // });
    
    // jobs.subscribe(
    //   (data) => {
    //     let obj: any = data;
    //     this.jobService.currentSearchList = obj.SearchResult.SearchResultItems;
    //     this.currentPageTotal = obj.SearchResult.UserArea.NumberOfPages;
        
    //   }
    // );
    // this.currentPage = 1;
    // console.log("OUTSIDE: " + this.jobService.currentSearchList)
    // console.log("OUTSIDE: "+ this.currentPageTotal);
    // return this.jobService.currentSearchList;
return this.httpClient.get<Job[]>(fullSearch, {
  'headers': this.HEADERS
});
  }

  getSearch(searchString: string): Observable<Job[]> {
    this.currentPage = 0;
    this.currentSearch = "Keyword=" + searchString;
    console.log(this.currentSearch);
    if (false /* other search conditions applied */) {
      //do a method to appnd searches
    }

    return this.searchAPI(this.currentSearch);
  }

  getJobByID() {

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
