import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AngularFirestore } from '@angular/fire/firestore';
import { Product } from '../model/product/product';
import { ProductService } from '../services/products/product.service';
import { TransactionService } from '../services/transactions/transaction.service';

@Component({
  selector: 'app-prodlist',
  templateUrl: './prodlist.component.html',
  styleUrls: ['./prodlist.component.css']
})
export class ProdlistComponent implements OnInit {

  products: Product[] = [];
  hidden = true;
  constructor(private afs: AngularFirestore, private ps: ProductService, private ts: TransactionService) {
    console.log(environment);
  }

  value = '';


  refreshList(): void {
    this.hidden = true;
    this.ps.findAll().subscribe((data: any) => {
      this.products = data;
      this.hidden = false;
    });
  }

  ngOnInit(): void {
    this.refreshList();
  }


  registerTransaction(id: number, price: number) {
    this.ts.registerTransaction(id, price).subscribe((res)=> {
      this.refreshList();
    },(err)=> {
      this.refreshList();
    });

  }


}
