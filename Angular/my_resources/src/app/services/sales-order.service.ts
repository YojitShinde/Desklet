import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { So } from '../pojo/so';
import { User } from '../pojo/user';

@Injectable({
  providedIn: 'root'
})
export class SalesOrderService {

  private baseURL = "http://localhost:8181/so";

  constructor(private http: HttpClient) { }

  addSO(so: So): Observable<So>{
    return this.http.post<So>(`${this.baseURL + '/addSO'}`, so);
  }

  getSOs(): Observable<any>{
    return this.http.get(`${this.baseURL + '/getSOs'}`);
  }

  remSO(so_number: number): Observable<number>{
    return this.http.post<number>(`${this.baseURL + '/remSO'}`, so_number);
  }

  sendSO(user:User, so: So){
    let params = new HttpParams()
    .set('sender_email', user.email_id)
    .set('so_number', so.so_number)
    .set('receiver_email', so.customer_email)
    .set('product_name', so.product)
    .set('product_qty', so.product_qty)
    .set('unit_price', so.unit_price)
    .set('total_price', so.total_price)
    .set('customer_add', so.customer_address)
    return this.http.post(`${this.baseURL + '/sendSO'}`, params);
  }

}
