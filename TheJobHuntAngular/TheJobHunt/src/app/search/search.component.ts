import { ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';
import { Job } from '../models/Job';
import { HttpHeaders } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { SearchService } from '../service/search.service';
import { Router } from '@angular/router';
import { JobService } from '../service/job.service';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  JobList: Job[] | any;




  constructor(private formBuilder: FormBuilder, private searchService: SearchService, private jobService: JobService, private router: Router,private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
    
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
  }

}
