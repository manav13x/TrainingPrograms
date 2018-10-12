import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StaasComponent } from './staas.component';

describe('StaasComponent', () => {
  let component: StaasComponent;
  let fixture: ComponentFixture<StaasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StaasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StaasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
