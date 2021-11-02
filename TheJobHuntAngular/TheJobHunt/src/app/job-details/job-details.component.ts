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
  success!: boolean;
  message!: string | null;
  constructor(private jobService: JobService, private searchService: SearchService) { }

  ngOnInit(): void {
    this.message = null;
    this.job = this.jobService.currentJob;
  }

  addJobToList() {
    this.searchService.addJob(this.job).subscribe((data) => {
      if (data.status == 200) {
        this.message = "Successfully added job to your list!"
      }
    });
  }

}
