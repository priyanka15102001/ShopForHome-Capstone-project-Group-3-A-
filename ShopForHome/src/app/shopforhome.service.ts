import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class ServiceNameService {

  constructor(private http: HttpClient) {}
}

@Injectable({
  providedIn: 'root',
})
export class ShopforhomeService {
  constructor() {}
}
