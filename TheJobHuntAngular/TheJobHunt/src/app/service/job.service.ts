import { Injectable } from '@angular/core';
import { Job } from '../models/Job';
import { SavedJob } from '../models/SavedJob';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  currentJob!: Job;
  currentSearchString!: string;

}
