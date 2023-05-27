import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Component, ElementRef, HostBinding, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Po } from '../pojo/po';
import { PurchaseOrderService } from '../services/purchase-order.service';

@Component({
  selector: 'app-add-po',
  templateUrl: './add-po.component.html',
  styleUrls: ['./add-po.component.css']
})
export class AddPOComponent implements OnInit {
  sessionData: any;
  po: Po = new Po();
  submitted: boolean = false;

  @HostBinding('class.pc') pcMode = false;

  constructor(private purchaseorder: PurchaseOrderService, private router: Router, private element: ElementRef, private breakPointObserver: BreakpointObserver) {
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
  }

  onSubmit(){
    this.purchaseorder.addPO(this.po).subscribe(
      data => {
        this.po = data;
        console.log(data);
      }
    );

    this.router.navigate(['/home']);
  }

}
