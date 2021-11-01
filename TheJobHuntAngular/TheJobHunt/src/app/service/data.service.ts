import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Job } from '../models/Job';
import { SavedJob } from '../models/SavedJob';
import { User } from '../models/User';
import { UserInformation } from '../models/UserInformation';
//import all the models

@Injectable({
  providedIn: 'root'
})
export class DataService {
  
  private user!: User;
  private userInfo!: UserInformation;
  private job!: Job;
  private savedJob!: SavedJob;

  private endpointForUserInfo: string = 'http://localhost:8000/info/myInfo';
  private endpointGetTheUser!: string;
  private endpointGetTheJob!: string;

  constructor( private httpClient: HttpClient ) { }

  //USER INFO methods
  getInfoForUser(): Observable<UserInformation> {
    return this.httpClient.get<UserInformation>(this.endpointForUserInfo, { //headers? user session?
    });
  }

  registerInfoNewUser(user: User, userInfo: UserInformation): Observable<UserInformation> {
    return this.httpClient.post<UserInformation>(this.endpointForUserInfo, {
    });
  }

  updateSomeInfo(userInfo: UserInformation): Observable<UserInformation> {
    return this.httpClient.post<UserInformation>(this.endpointForUserInfo, {
    });
  }


  //MIGHT BE USEFUL, BUT ARE INCOMPLETE
  getUserForUser(): Observable<User> {
    return this.httpClient.get<User>(this.endpointGetTheUser, { 
    });
  }

  getJob(): Observable<Job>{
    return this.httpClient.get<Job>(this.endpointGetTheJob, { //headers? user session?
    });
  }

  getSavedJob(): SavedJob{
    return this.savedJob;
  }

  
}