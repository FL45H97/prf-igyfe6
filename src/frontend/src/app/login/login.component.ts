import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login/login.service';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginGroup: FormGroup;
  email = new FormControl('', [Validators.required, Validators.email]);
  password = new FormControl('', [Validators.required]);

  constructor(private loginService: LoginService, private router: Router, private fb: FormBuilder) {
    this.loginGroup = fb.group({
      email : this.email,
      password: this.password,
    });
  }

  login() {
    if (this.email.value != '' && this.password.value != '') {
      this.loginService.login(this.email.value, this.password.value).then((res: any) => {        
        localStorage.setItem('user', res.user!.uid);
        this.router.navigate(['/products']);
      }).catch((error: any) => {
        console.error('Sikertelen bejelentkezés!', error);
      })
    }
  }

  ngOnInit(): void {
    if(localStorage.getItem('user')) {
      localStorage.removeItem('user');
      this.loginService.logout().then(() => {
        console.log('Sikeres kijelentkezés!');
      }).catch((error:any) => {
        console.error('Sikertelen kijelentkezés!', error);
      })
    }
  }

}
