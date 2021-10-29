import { Injectable } from '@angular/core';
import { Job } from '../models/Job';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  public currentJob!: Job;
  currentSearchString!: string;
}
