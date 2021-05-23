import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Product } from '../../model/product/product';
import { Observable } from 'rxjs/Observable';
import { config } from '../../config/config';

@Injectable()
export class ProductService {

  private productUrl: string;

  constructor(private http: HttpClient) {
    this.productUrl = config.productServiceUrl;
  }

  public findAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productUrl);
  }

}
