import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {

  loggedin: boolean = false;
  admin: boolean = false;

  
  constructor(private router: Router) {
    if (localStorage.getItem('user')) {
      this.loggedin = true;
    }
    if (localStorage.getItem("auth")) {
      this.admin = true;
    }

  }

  LogOut(): any {
    localStorage.removeItem('user');
    localStorage.removeItem('auth');
    this.loggedin = false;
    this.admin = false;
    this.router.navigate(['/']);
  }

  ngOnInit(): void {
  }

  refresh(): void {
    window.location.reload();
}

}
