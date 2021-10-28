import { Injectable } from '@angular/core';
import { Job } from '../models/Job';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  public currentJob: Job | any;
  public currentSearchList: Job[] | null = null;
  constructor() { }
}
