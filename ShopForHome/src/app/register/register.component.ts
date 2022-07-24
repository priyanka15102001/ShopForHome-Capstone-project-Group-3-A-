import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  name: string | undefined;
  password: string | undefined;
  reg: boolean = true;
  message: string | undefined;
  type: boolean | undefined;
  alert_reg: boolean = false;

  constructor(private router: Router) {}

  ngOnInit(): void {}
  Register = async () => {
    this.name = (<HTMLInputElement>document.getElementById('username')).value;
    console.log(this.name);
    this.password = (<HTMLInputElement>document.getElementById('pwd')).value;
    console.log(this.password);
    this.type = (<HTMLInputElement>document.getElementById('usertype')).checked;
    console.log(this.type);
    this.alert_reg = true;
    let res1 = await fetch('http://localhost:8087/users', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    });
    let users = await res1.json();
    users.forEach((element: any) => {
      if (element.name == this.name) {
        this.message = 'username already exists';
        this.reg = false;
      }
    });
    if (this.reg) {
      const data = {
        name: this.name ,
        type: this.type ? 'admin' : 'user' ,
        password: this.password,
      };
      let res = await fetch('http://localhost:8087/users', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
      });
      if(this.type){
        const data = {
          admin_name: this.name ,
          password: this.password,
        };
        let ad =  await fetch('http://localhost:8087/admin', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(data),
        });
        if(res.status == 200){
          this.message= "successfully Registered as admin";
          setTimeout(() => {
            this.router.navigate(['/login']);
          }, 1000);
        }
      }

      if(res.status == 200){
        this.message= "successfully Registered";
        setTimeout(() => {
          this.router.navigate(['/login']);
        }, 1000);
      }


      
    }
  };
}
