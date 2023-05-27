import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Po } from '../pojo/po';
import { User } from '../pojo/user';

@Injectable({
  providedIn: 'root'
})
export class PurchaseOrderService {

  private baseURL = "http://localhost:8181/po";

  constructor(private http: HttpClient) { }

  addPO(po: Po): Observable<Po>{
    return this.http.post<Po>(`${this.baseURL + '/addPO'}`, po);
  }

  getPOs(): Observable<any>{
    return this.http.get(`${this.baseURL + '/getPOs'}`);
  }

  remPO(po_number: number): Observable<number>{
    return this.http.post<number>(`${this.baseURL + '/remPO'}`, po_number);
  }

  sendPO(user:User, po: Po){
    let params = new HttpParams()
    .set('sender_email', user.email_id)
    .set('po_number', po.po_number)
    .set('receiver_email', po.supplier_email)
    .set('product_name', po.product)
    .set('product_qty', po.product_qty)
    .set('unit_price', po.unit_price)
    .set('total_price', po.total_price)
    return this.http.post(`${this.baseURL + '/sendPO'}`, params);
  }

}
