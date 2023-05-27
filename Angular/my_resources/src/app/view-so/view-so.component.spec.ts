import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewSOComponent } from './view-so.component';

describe('ViewSOComponent', () => {
  let component: ViewSOComponent;
  let fixture: ComponentFixture<ViewSOComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewSOComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewSOComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
