import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Component, ElementRef, HostBinding, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../pojo/user';
import { LoginService } from '../services/login-page.service';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css']
})
export class ViewUserComponent implements OnInit {
  allUsers: User[] = [];

  @HostBinding('class.pc') pcMode = false;

  constructor(private loginService: LoginService, private router: Router, private element: ElementRef, private breakPointObserver: BreakpointObserver) {
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
    this.loginService.getUsers().subscribe(
      data=>{
        this.allUsers = data;
        // console.log(data);
      }
    )
  }

  removeUser(email: string){
    this.loginService.removeUser(email).subscribe(
      data =>{
        console.log(data);
      }
    )
  }

}
