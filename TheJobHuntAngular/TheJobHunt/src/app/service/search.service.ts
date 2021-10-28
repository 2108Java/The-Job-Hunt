import { Injectable } from '@angular/core';
import { Job } from '../models/Job';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class SearchService {
  BASE_SEARCH: string = "https://data.usajobs.gov/api/search?"
  AUTHKEY: string = 'phGRKckFO5Eo3cnG2VfS5StjJd+UaBYvsCC7CNOHvuI=';
  HEADERS: HttpHeaders = new HttpHeaders().set('Authorization-Key', this.AUTHKEY);
  currentSearch: string = "";
  currentPage: number = 0;
  searchArray: Job[] = [];


  constructor(private httpClient: HttpClient) { }

  searchAPI(searchString: string): Job[] {
    let fullSearch: string = this.BASE_SEARCH + searchString;
    let jobs: Observable<Job[]> = this.httpClient.get<Job[]>(fullSearch, {
      'headers': this.HEADERS
    });

    jobs.subscribe(
      (data) => {
        console.log(data);
        let obj: any = data;
        this.searchArray = obj.SearchResult.SearchResultItems;
      }
    );
    this.currentPage = 1;
    return this.searchArray;

  }

  getSearch(searchString: string): Job[] {
    this.currentPage = 0;
    this.currentSearch = "Keyword=" + searchString;
    console.log(this.currentSearch);
    if (false /* other search conditions applied */) {
      //do a method to appnd searches
    }

    return this.searchAPI(this.currentSearch);
  }

  getJobByID(){
    
  }

  changePage(pageValue: number): Job[] {
    let newPage: string = "";
    this.currentPage += pageValue;
    if (this.currentPage > 1) {
      newPage = this.currentSearch + "&Page=" + this.currentPage;
    } else if (this.currentPage == 1) {
      newPage = this.currentSearch;
    }
    return this.searchAPI(newPage);
  }
}
