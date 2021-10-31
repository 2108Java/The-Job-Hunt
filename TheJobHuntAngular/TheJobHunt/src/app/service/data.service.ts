import { Injectable } from '@angular/core';
import { User } from '../models/User';


@Injectable()
export class DataService {
  
  constructor() { }
currentUser!: User;

}