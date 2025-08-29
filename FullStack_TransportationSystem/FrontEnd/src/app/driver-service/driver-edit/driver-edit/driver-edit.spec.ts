import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DriverEdit } from './driver-edit';

describe('DriverEdit', () => {
  let component: DriverEdit;
  let fixture: ComponentFixture<DriverEdit>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DriverEdit]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DriverEdit);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
