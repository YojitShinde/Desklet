import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Component, ElementRef, HostBinding, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Mrn } from '../pojo/mrn';
import { MaterialsReceivedNoteService } from '../services/materials-received-note.service';

@Component({
  selector: 'app-add-mrn',
  templateUrl: './add-mrn.component.html',
  styleUrls: ['./add-mrn.component.css']
})
export class AddMRNComponent implements OnInit {
  sessionData: any;
  mrn: Mrn = new Mrn();
  submitted: boolean = false;

  @HostBinding('class.pc') pcMode = false;

  constructor(private materialsReceivedNote: MaterialsReceivedNoteService, private router: Router, private element: ElementRef, private breakPointObserver: BreakpointObserver) {
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
    this.materialsReceivedNote.addMRN(this.mrn).subscribe(
      data => {
        this.mrn = data;
        console.log(data);
      }
    );

    this.router.navigate(['/home']);
  }

}
