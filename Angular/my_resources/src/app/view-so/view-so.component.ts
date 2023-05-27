import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Component, ElementRef, HostBinding, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { So } from '../pojo/so';
import { User } from '../pojo/user';
import { SalesOrderService } from '../services/sales-order.service';

@Component({
  selector: 'app-view-so',
  templateUrl: './view-so.component.html',
  styleUrls: ['./view-so.component.css']
})
export class ViewSOComponent implements OnInit {
  allSOs : So[] = [];
  user : User = new User();
  sessionData: any;

  @HostBinding('class.pc') pcMode = false;

  constructor(private salesOrderService: SalesOrderService, private router: Router, private element: ElementRef, private breakPointObserver: BreakpointObserver) {
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
    this.salesOrderService.getSOs().subscribe(
      data=>{
        this.allSOs = data;
        console.log(data);
      }
    )
  }

  removeSO(so_number: number){
    this.salesOrderService.remSO(so_number).subscribe(
      data =>{
        console.log(data);
      }
    )
  }

  sendSO(so: So){
    this.sessionData = sessionStorage.getItem('user')
    console.log(this.sessionData);

    this.user.email_id = this.sessionData.email_id;
    this.user.name = this.sessionData.name;
    this.user.password = this.sessionData.password;
    this.user.phone = this.sessionData.phone;

    this.salesOrderService.sendSO(this.user, so).subscribe(
      data =>{     
        console.log(data);
      }
    );
    this.router.navigate(['/home']);
  }

}
