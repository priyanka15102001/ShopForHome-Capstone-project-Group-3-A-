import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-view-wishlist',
  templateUrl: './view-wishlist.component.html',
  styleUrls: ['./view-wishlist.component.css'],
})
export class ViewWishlistComponent implements OnInit {
  Carts: any = [];
  crt: any;
  deleted: boolean = false;
  TotalPrice: number = 0;

  constructor(private httpClient: HttpClient) {}

  ngOnInit(): void {
    fetch(`http://localhost:8087/wishlist`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => res.json())
      .then((data) => {
        data = data.filter((item: any) => {
          return item.username == localStorage.getItem('user');
        });
        this.Carts = data;
      });
  }

  DeleteItem = async (id: number) => {
    let res = await fetch(`http://localhost:8087/wishlist/${id}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
      },
    });
    if (res.status) {
      this.deleted = true;
    } else {
      this.deleted = false;
    }
    setTimeout(() => {
      this.deleted = false;
    }, 3000);

    this.Carts = this.Carts.filter((item: any) => {
      return item.id != id;
    });
    this.TotalPrice = 0;
    this.Carts.forEach((element: any) => {
      this.TotalPrice =
        this.TotalPrice + (element.product_price - element.discount_amt);
    });
  };
}
