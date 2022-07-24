import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  loggedin: boolean = false;
  message: string | undefined;
  password: string | undefined;
  name: string | undefined;

  constructor(private router: Router) {}

  ngOnInit(): void {}

  LogIn = async () => {
    this.name = (<HTMLInputElement>document.getElementById('username')).value;
    console.log(this.name);
    this.password = (<HTMLInputElement>document.getElementById('pwd')).value;
    console.log(this.password);
    let res = await fetch('http://localhost:8087/users', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    });
    console.log(this.name, this.password);
    let data = await res.json();
    data.forEach((element: any) => {
      if (element.name === this.name) {
        this.loggedin = true;
        if (element.password === this.password) {
          if (element.type === 'admin') {
            localStorage.setItem('auth', element.type);
          }
          localStorage.setItem('user', element.name);
          this.message = 'Successfully Logged in';
          setTimeout(() => {
            this.router.navigate(['/']);
          }, 1000);

          setTimeout(() => {
            window.location.reload();
          }, 1170);
        } else {
          this.message = 'Invalid Credentials ';
        }
      }
    });
    if (!this.loggedin) {
      this.loggedin = true;
      this.message = 'User not Found!';
    }
  };
}
