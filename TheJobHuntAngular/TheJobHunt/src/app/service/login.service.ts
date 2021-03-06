import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';
import { User } from '../models/User';
import { DataService } from './data.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private myHttpClient: HttpClient,private dataService:DataService) { }

  loginRequestWithPost(email: String, password: String): Observable<HttpResponse<User>>{ //instead of the json, we get the entire response.
    //post request with an empty body
    return this.myHttpClient.post<User>("http://localhost:8000/user/login", //uri
    {
    "userEmail": email,
    "userPassword": password
    }, //body 
    {withCredentials: true,observe: 'response' as 'response'} //http options, key value pairs.
    );
  }
}
