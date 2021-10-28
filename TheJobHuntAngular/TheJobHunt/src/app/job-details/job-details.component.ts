import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Job } from '../models/Job';
import { JobService } from '../service/job.service';

@Component({
  selector: 'app-job-details',
  templateUrl: './job-details.component.html',
  styleUrls: ['./job-details.component.css']
})
export class JobDetailsComponent implements OnInit {
job:Job|any;
  constructor(private route: ActivatedRoute,private jobService:JobService) { }

  ngOnInit(): void {
    this.job = this.jobService.currentJob;
    console.log(this.job);
  }

}
