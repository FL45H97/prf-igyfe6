import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Transaction } from '../../model/transaction/transaction';
import {config} from '../../config/config';
import { fromPromise } from 'rxjs/internal-compatibility';

@Injectable()
export class TransactionService {

  private transactionUrl: string;

  constructor(private http: HttpClient) {
    this.transactionUrl = config.transactionServiceUrl;
  }
  
  public registerTransaction(id: number, price: number): void {
    this.http.post<Transaction>(this.transactionUrl, new Transaction(0,id, price)).subscribe();
  }
}
