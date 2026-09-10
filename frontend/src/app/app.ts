import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProductRequest } from './models/product.model';
import { ProductResponse } from './models/product.model';
import { ProductService } from './services/product';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit{
  protected readonly title = signal('frontend');
  
  // variable that will save the product list from the backend
  products : ProductResponse[] = [];

  constructor(private productService : ProductService){}

  ngOnInit(): void {
    this.productService.getProducts().subscribe(APIdata =>{
        this.products = APIdata;
    })
  }
}
