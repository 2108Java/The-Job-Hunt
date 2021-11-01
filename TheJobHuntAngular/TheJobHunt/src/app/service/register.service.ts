import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserInformation } from '../models/UserInformation';
import { Observable } from 'rxjs';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {


  public userInfo!: UserInformation;

  private endpointForUserInfo: string = 'http://localhost:8000/info/myInfo';
  private endpointForUser: string = 'http://localhost:8000/user/createUser'
  constructor(private httpClient: HttpClient) { }

  
  registerNewUser(user:string): Observable<HttpResponse<User>> {
    console.log(user);
    return this.httpClient.post<User>(this.endpointForUser, {
      "userEmail": user
  }, {withCredentials: true, observe: 'response' as 'response'} );
  }


  registerInfoNewUser(userInfo: any): Observable<HttpResponse<UserInformation>> {
    
    return this.httpClient.post<UserInformation>(this.endpointForUserInfo, {
      "firstName": userInfo.firstName,
      "lastName": userInfo.lastName,
      "street": userInfo.street,
      "city": userInfo.city,
      "state": userInfo.state,
      "zip": userInfo.zip
    }, {withCredentials: true, observe: 'response' as 'response'}
    );
  }


}
