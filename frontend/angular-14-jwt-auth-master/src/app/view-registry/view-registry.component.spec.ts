import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRegistryComponent } from './view-registry.component';

describe('ViewRegistryComponent', () => {
  let component: ViewRegistryComponent;
  let fixture: ComponentFixture<ViewRegistryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewRegistryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewRegistryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
