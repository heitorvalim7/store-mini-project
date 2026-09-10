  import { Injectable } from '@angular/core';
  import { HttpClient } from '@angular/common/http';
  import { Observable } from 'rxjs';
  import { ProductRequest, ProductResponse } from '../models/product.model';

  @Injectable({
    providedIn: 'root',
  })

  export class ProductService {
    private apiUrl = 'http://localhost:8082/products'

    constructor(private http: HttpClient){}

    getProducts(): Observable<ProductResponse[]>{
      return this.http.get<ProductResponse[]>(this.apiUrl);
    }

    createProduct(product: ProductRequest): Observable<ProductResponse>{
      return this.http.post<ProductResponse>(this.apiUrl, product);
    }

  }
