import { TestBed } from '@angular/core/testing';

import { ShopforhomeService } from './shopforhome.service';

describe('ShopforhomeService', () => {
  let service: ShopforhomeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShopforhomeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
