import { ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';
import { Job } from '../models/Job';
import { HttpHeaders } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { SearchService } from '../service/search.service';
import { Router } from '@angular/router';
import { JobService } from '../service/job.service';
import { Observable } from 'rxjs';

export interface fakeJob {
  SearchResult: {
    SearchResultItems: [Job[]]
  }
}
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  JobListObservable!: Observable<Job[]>;
  JobList!: Job[];


  constructor(private formBuilder: FormBuilder, private searchService: SearchService, private jobService: JobService, private router: Router) { }

  ngOnInit(): void {
<<<<<<< HEAD
    
    this.getAllJobs();
    //this.jobService.currentSearchList = this.searchService.getSearch(this.searchTerm);
    

    //if(this.jobService.currentSearchList == null && this.jobService.currentSearchList.length > 0){
    this.JobList = this.jobService.currentSearchList;
    this.jobService.currentSearchList = null;
    ///}
  }
  //searchbar = this.formBuilder.group({
  ///  searchString:""
  //});
  searchTerm ="";

  getAllJobs() {
    this.JobList = this.searchService.getSearch(this.searchTerm);
  }

  public selectJob(job: Job) {
    this.jobService.currentJob=job;
    //this.router.navigate(['/jobDetails']);
=======
    if (this.searchbar.get("searchString")!.value != null) {
      this.getAllJobs();
    }
  }
  searchbar = this.formBuilder.group({
    searchString: this.jobService.currentSearchString
  });

  getAllJobs() {
    this.searchService.getSearch(this.searchbar.get("searchString")!.value).subscribe(
      (data) => {
        let obj: any = data;
        this.JobList = obj.SearchResult.SearchResultItems;
        console.log(this.JobList);
      }
    );

  }

  public selectJob(job: Job) {
    this.jobService.currentJob = job;
    this.router.navigate(['/jobDetails']);
>>>>>>> 340a75bafbb1132169c4b810d0823d381fa5f86a
  }

}
