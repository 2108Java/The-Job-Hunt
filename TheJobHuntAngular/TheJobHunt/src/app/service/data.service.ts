import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Job } from '../models/Job';
import { SavedJob } from '../models/SavedJob';
import { User } from '../models/User';
import { UserInformation } from '../models/UserInformation';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  userInfo!: UserInformation;
  job!: Job;
  currentUser!: User;
  currentSavedJobs!: SavedJob[];


  constructor() { }

}