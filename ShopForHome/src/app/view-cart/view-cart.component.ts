import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-view-cart',
  templateUrl: './view-cart.component.html',
  styleUrls: ['./view-cart.component.css'],
})
export class ViewCartComponent implements OnInit {
  Carts: any = [];
  crt: any;
  deleted: boolean = false;
  TotalPrice: number = 0;
  sold: any = [];
  message: string | undefined;
  products: any = [];
  clearcart: boolean = false;
  
  constructor(private httpClient: HttpClient) {}

  ngOnInit(): void {
    fetch(`http://localhost:8087/cart`, {
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
        data.forEach((element: any) => {
          this.TotalPrice =
            this.TotalPrice + (element.product_price - element.discount_amt);
        });
      });
  }

  DeleteItem = async (id: number) => {
    let res = await fetch(`http://localhost:8087/cart/${id}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
      },
    });
    if (res.status) {
      this.deleted = true;
      this.message = 'Your Item has been deleted from cart';
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

  CheckOut = async () => {
    await fetch(`http://localhost:8087/cart`, {
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
        this.sold = data;
      });

    await fetch(`http://localhost:8087/products`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => res.json())
      .then((data) => {
        this.products = data;
      });

    for (let i = 0; i < this.sold.length; i++) {
      this.products.forEach(async (pd: any) => {
        if (pd.id == this.sold[i].product_id) {
          const data = {
            id: pd.id,

            product_name: pd.product_name,
            product_type: pd.product_type,
            product_price: pd.product_price,
            product_desc: pd.product_desc,
            stocks: pd.stocks - this.sold[i].quantity,
            img_url: pd.img_url,
          };

          let res = await fetch(`http://localhost:8087/products/${pd.id}`, {
            method: 'PUT',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
          });
          await fetch(`http://localhost:8087/cart/${this.sold[i].id}`, {
            method: 'DELETE',
            headers: {
              'Content-Type': 'application/json',
            },
          });
          this.Carts = [];
          this.TotalPrice = 0;
          this.deleted = true;
          this.message = 'your Order has been placed';
          const d = new Date();
          const salelog = {
            
            product_name: pd.product_name,
            product_price: pd.product_price,
            quantity: this.sold[i].quantity,
            date: `${d.getDate()}/${d.getMonth()}/${d.getFullYear()}-${d.getHours()}:${d.getMinutes()}:${d.getSeconds()}`,
          };
          await fetch(`http://localhost:8087/sales-log`, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(salelog),
          });
        }
      });
    }
    setTimeout(() => {
      this.deleted = false;
    }, 3000);
  };
}
