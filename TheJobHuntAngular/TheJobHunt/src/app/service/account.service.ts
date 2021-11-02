import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DataService } from './data.service';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private httpClient: HttpClient, private dataService: DataService) { }

  updateEmail(newEmail: string) {
    return this.httpClient.put("http://localhost:8000/user/updateUserEmail",
      {
        "id": this.dataService.currentUser.id,
        "userEmail": newEmail,
        "userPassword": this.dataService.currentUser.userPassword
      }, { withCredentials: true, observe: 'response' as 'response' }
    );
  }
  updatePassword(newPassword: string) {
    return this.httpClient.put("http://localhost:8000/user/updateUserPassword",
      {
        "id": this.dataService.currentUser.id,
        "userEmail": this.dataService.currentUser.userEmail,
        "userPassword": newPassword
      }, { withCredentials: true, observe: 'response' as 'response' }
    );
  }
  updateInfo(infoForm: any) {
    return this.httpClient.put("http://localhost:8000/info/myInfo",
      {
        "firstName": infoForm.get("firstname")?.value,
        "lastName": infoForm.get("lastname")?.value,
        "street": infoForm.get("address")?.value,
        "city": infoForm.get("city")?.value,
        "state": infoForm.get("state")?.value,
        "zip": infoForm.get("zip")?.value,
      }, { withCredentials: true, observe: 'response' as 'response' }
    );
  }
}
