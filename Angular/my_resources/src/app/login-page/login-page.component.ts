import { Component, HostBinding, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../pojo/user';
import { LoginService } from '../services/login-page.service';
import { ElementRef } from '@angular/core';
import { BreakpointObserver, Breakpoints} from '@angular/cdk/layout';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css'],
})
export class LoginPageComponent implements OnInit {
  sessionData: any;
  user: User = new User();
  submitted: boolean = false;
  hide:boolean = true;

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
  }

  onSubmit(){
    this.loginService.loginUser(this.user).subscribe(
      data =>{
        // this.user = data;
        sessionStorage.setItem('user',JSON.stringify(data));
        console.log(data);

        if(data != null){
          this.router.navigate(['/home']);
        }
        else{
          this.hide = false;
        }
      });
    }

}
