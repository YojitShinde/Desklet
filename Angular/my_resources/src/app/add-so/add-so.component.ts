import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Component, ElementRef, HostBinding, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { So } from '../pojo/so';
import { SalesOrderService } from '../services/sales-order.service';

@Component({
  selector: 'app-add-so',
  templateUrl: './add-so.component.html',
  styleUrls: ['./add-so.component.css']
})
export class AddSOComponent implements OnInit {
  sessionData: any;
  so: So = new So();
  submitted: boolean = false;

  @HostBinding('class.pc') pcMode = false;

  constructor(private salesorder: SalesOrderService, private router: Router, private element: ElementRef, private breakPointObserver: BreakpointObserver) {
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
    this.salesorder.addSO(this.so).subscribe(
      data =>{
        this.so = data;
        console.log(data);
      }
    );

    this.router.navigate(['/home']);
   }

}
