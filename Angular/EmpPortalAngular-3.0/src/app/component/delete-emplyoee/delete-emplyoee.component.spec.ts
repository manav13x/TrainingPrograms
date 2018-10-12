import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteEmplyoeeComponent } from './delete-emplyoee.component';

describe('DeleteEmplyoeeComponent', () => {
  let component: DeleteEmplyoeeComponent;
  let fixture: ComponentFixture<DeleteEmplyoeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteEmplyoeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteEmplyoeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
