import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMRNComponent } from './view-mrn.component';

describe('ViewMRNComponent', () => {
  let component: ViewMRNComponent;
  let fixture: ComponentFixture<ViewMRNComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewMRNComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewMRNComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
