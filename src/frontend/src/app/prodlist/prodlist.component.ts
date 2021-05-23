import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Subscription } from 'rxjs';
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

  constructor(private afs: AngularFirestore, private ps: ProductService, private ts: TransactionService) {
    console.log(environment);
    this.cloudElements = [];
  }

  cloudId = '';
  value = '';
  cloudElements: any[];

  dataObserver: Subscription | null = null;

  refreshDb() {
    this.cloudElements = [];
    this.afs.collection('Examples-023', ref => ref.where('id', '==', 'valami').orderBy('value', 'desc')).get().subscribe(res => {
      res.docs.forEach(doc => {
        const data = doc.data() as any;
        this.cloudElements.push('Id: ' + data.id + ', Value: ' + data.value);
      })
    })
  }

  ngOnInit(): void {
    this.ps.findAll().subscribe((data: any) => {
      this.products = data;
    });
  }

  registerTransaction(id: number, price: number) {
    this.ts.registerTransaction(id, price);
  }

}
