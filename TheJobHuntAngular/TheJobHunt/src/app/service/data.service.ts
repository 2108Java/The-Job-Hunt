import { Injectable } from '@angular/core';
import { SavedJob } from '../models/SavedJob';
import { User } from '../models/User';


@Injectable()
export class DataService {
  
  constructor() { }
currentUser!: User;
currentSavedJobs!: SavedJob;

}