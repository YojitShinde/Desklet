import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMRNComponent } from './add-mrn.component';

describe('AddMRNComponent', () => {
  let component: AddMRNComponent;
  let fixture: ComponentFixture<AddMRNComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddMRNComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMRNComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
