import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Component, ElementRef, HostBinding, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Mrn } from '../pojo/mrn';
import { Po } from '../pojo/po';
import { User } from '../pojo/user';
import { MaterialsReceivedNoteService } from '../services/materials-received-note.service';

@Component({
  selector: 'app-view-mrn',
  templateUrl: './view-mrn.component.html',
  styleUrls: ['./view-mrn.component.css']
})
export class ViewMRNComponent implements OnInit {
  allMRNs: Mrn[] = [];
  user : User = new User();
  po: Po = new Po();
  sessionData: any;
  email: string = "";

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
    this.reloadData();
  }

  reloadData(){
    this.materialsReceivedNote.getMRNs().subscribe(
      data=>{
        this.allMRNs = data;
        console.log(data);
      }
    )
  }

  removeMRN(mrn_number: number){
    this.materialsReceivedNote.remMRN(mrn_number).subscribe(
      data =>{
        console.log(data);
      }
    )
  }

  sendMRN(po_number: number){
    this.sessionData = sessionStorage.getItem('user')
    console.log(this.sessionData);

    this.po.po_number = po_number;
    this.user.email_id = this.sessionData.email_id;

    this.materialsReceivedNote.sendMRN(this.user, this.po).subscribe(
      data =>{     
        console.log(data);
      }
    );
    this.router.navigate(['/home']);
  }

}
