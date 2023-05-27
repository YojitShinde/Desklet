import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Mrn } from '../pojo/mrn';
import { User } from '../pojo/user';
import { Po } from '../pojo/po';

@Injectable({
  providedIn: 'root'
})
export class MaterialsReceivedNoteService {

  private baseURL = "http://localhost:8181/mrn";

  constructor(private http: HttpClient) { }

  addMRN(mrn: Mrn): Observable<Mrn>{
    return this.http.post<Mrn>(`${this.baseURL + '/addMRN'}`, mrn);
  }

  getMRNs(): Observable<any>{
    return this.http.get(`${this.baseURL + '/getMRNs'}`);
  }

  remMRN(mrn_number: number): Observable<number>{
    return this.http.post<number>(`${this.baseURL + '/remMRN'}`, mrn_number);
  }

  sendMRN(user:User, po: Po){
    let params = new HttpParams()
    .set('sender_email', user.email_id)
    .set('po_number', po.po_number)
    return this.http.post(`${this.baseURL + '/sendMRN'}`, params);
  }

}
