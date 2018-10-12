import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmplyoeeViewComponent } from './emplyoee-view.component';

describe('EmplyoeeViewComponent', () => {
  let component: EmplyoeeViewComponent;
  let fixture: ComponentFixture<EmplyoeeViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmplyoeeViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmplyoeeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
