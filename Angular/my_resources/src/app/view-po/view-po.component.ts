import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Component, ElementRef, HostBinding, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Po } from '../pojo/po';
import { User } from '../pojo/user';
import { PurchaseOrderService } from '../services/purchase-order.service';

@Component({
  selector: 'app-view-po',
  templateUrl: './view-po.component.html',
  styleUrls: ['./view-po.component.css']
})
export class ViewPOComponent implements OnInit {
  allPOs: Po[] = [];
  user : User = new User();
  sessionData: any;

  @HostBinding('class.pc') pcMode = false;

  constructor(private pruchaseOrderService: PurchaseOrderService, private router: Router, private element: ElementRef, private breakPointObserver: BreakpointObserver) {
    console.log("directive working!")
    this.breakPointObserver.observe([Breakpoints.HandsetPortrait, Breakpoints.WebLandscape]).subscribe({
      next: (value: any) => {
        for(let breakpoint of Object.keys(value.breakpoints)){
          if(value.breakpoints[breakpoint]){
            console.log("working properly!")
            if(breakpoint == Breakpoints.HandsetPortrait){
              this.element.nativeElement.classList.remove('pc');
              console.log("mobile")
              this.pcMode = false;
            }
            if(breakpoint == Breakpoints.WebLandscape){
              this.element.nativeElement.classList.add('pc');
              console.log("pc")
              this.pcMode = true;
            }
          }
        }
      }
    })
   }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(){
    this.pruchaseOrderService.getPOs().subscribe(
      data=>{
        this.allPOs = data;
        console.log(data);
      }
    )
  }

  removePO(po_number: number){
    this.pruchaseOrderService.remPO(po_number).subscribe(
      data =>{
        console.log(data);
      }
    )
  }

  sendPO(po: Po){
    this.sessionData = sessionStorage.getItem('user')
    console.log(this.sessionData);

    this.user.email_id = this.sessionData.email_id;
    this.user.name = this.sessionData.name;
    this.user.password = this.sessionData.password;
    this.user.phone = this.sessionData.phone;

    this.pruchaseOrderService.sendPO(this.user, po).subscribe(
      data =>{     
        console.log(data);
      }
    );
    this.router.navigate(['/home']);
  }

}
