import { Component, OnInit } from '@angular/core';
import { Job } from '../models/Job';
import { JobService } from '../service/job.service';
import { SearchService } from '../service/search.service';

@Component({
  selector: 'app-job-details',
  templateUrl: './job-details.component.html',
  styleUrls: ['./job-details.component.css']
})
export class JobDetailsComponent implements OnInit {
  job!: Job;
  success!:boolean;
  constructor(private jobService: JobService, private searchService: SearchService) { }

  ngOnInit(): void {
    this.job = this.jobService.currentJob;
  }

  addJobToList() {
    console.log(this.job);
    this.searchService.addJob(this.job).subscribe(
      (data) => 
      console.log(data)
    );
  }

}
