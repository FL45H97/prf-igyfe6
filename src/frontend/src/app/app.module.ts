import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProdlistComponent } from './prodlist/prodlist.component';
import { ErrorComponent } from './error/error.component';
import { LoginComponent } from './login/login.component';
import { HttpReqInterceptor } from './utils/http.interceptor';
import { ProductService } from './services/products/product.service';

import { AngularFireModule } from '@angular/fire'
import { environment } from 'src/environments/environment';
import { TransactionService } from './services/transactions/transaction.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
@NgModule({
  declarations: [
    AppComponent,
    ProdlistComponent,
    ErrorComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AngularFireModule.initializeApp(environment.firebase),
    BrowserAnimationsModule,
    MatCardModule, 
    MatInputModule,
    MatFormFieldModule,
    MatToolbarModule,
    MatButtonModule,

  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpReqInterceptor, multi: true },
    ProductService,
    TransactionService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
