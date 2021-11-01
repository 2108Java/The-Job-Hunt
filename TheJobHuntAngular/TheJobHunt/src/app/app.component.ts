import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'TheJobHunt';
  logout(){
    sessionStorage.setItem('isLoggedIn', 'false');
    sessionStorage.removeItem('token');
  }
}
