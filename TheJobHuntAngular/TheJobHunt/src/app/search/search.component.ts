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

  }

}
