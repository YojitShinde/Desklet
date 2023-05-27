import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { User } from '../pojo/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseURL = "http://localhost:8181/users";

  constructor(private http: HttpClient) { }

  loginUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.baseURL + '/login'}`, user);
  }

  addUser(user: User): Observable<User>{
    return this.http.post<User>(`${this.baseURL + '/addUser'}`, user);
  }

  getUsers(): Observable<any>{
    return this.http.get(`${this.baseURL + '/getUsers'}`);
  }

  removeUser(email: string){
    return this.http.post<string>(`${this.baseURL + '/removeUser'}`, email);
  }
}
