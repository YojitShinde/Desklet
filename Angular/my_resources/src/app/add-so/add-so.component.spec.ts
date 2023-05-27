import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSOComponent } from './add-so.component';

describe('AddSOComponent', () => {
  let component: AddSOComponent;
  let fixture: ComponentFixture<AddSOComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddSOComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSOComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
