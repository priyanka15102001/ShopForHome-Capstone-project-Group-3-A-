import { Component, OnInit } from '@angular/core';



@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
})
export class AdminComponent implements OnInit {
  products: any = [];
  message: string | undefined;
  show: boolean = false;
  name: string | undefined;
  price: string | undefined;
  type: string | undefined;
  desc: string | undefined;
  stocks: string | undefined;
  users: any = [];
  img_url: string | undefined;
  salelog: any = [];
  
  constructor() {}

  ngOnInit(): void {
    fetch(`http://localhost:8087/users`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => res.json())
      .then((data) => {
        data = data.filter((item: any) => {
          return item.type != "admin";
        });
        this.users = data;
      });
     

      fetch(`http://localhost:8087/products`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => res.json())
      .then((data) => {
        this.products = data;
      });

      fetch(`http://localhost:8087/sales-log`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => res.json())
      .then((data) => {
        this.salelog = data;
      });

  }

  DeleteItem = async (id: number) => {
    let res = await fetch(`http://localhost:8087/products/${id}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
      },
    });
    if (res.status) {
      this.show = true;
      this.message = 'Product Deleted';
    }
    setTimeout(() => {
      this.show = false;
    }, 3000);

    this.products = this.products.filter((item: any) => {
      return item.id != id;
    });
  };

  AddItem = async () => {
    this.name = (<HTMLInputElement>document.getElementById('name')).value;
    this.price = (<HTMLInputElement>document.getElementById('price')).value;
    this.type = (<HTMLInputElement>document.getElementById('type')).value;
    this.desc = (<HTMLInputElement>document.getElementById('desc')).value;
    this.stocks = (<HTMLInputElement>document.getElementById('stocks')).value;
    this.img_url = (<HTMLInputElement>document.getElementById('img_url')).value;

    const data = {
      product_name: this.name,
      product_type: this.type,
      product_desc: this.desc,
      product_price: this.price,
      stocks: this.stocks,
      img_url: this.img_url,
    };
    let res = await fetch(`http://localhost:8087/products`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    });
    if (res.status) {
      this.show = true;
      this.message = 'Product Added';
    }
    setTimeout(() => {
      this.show = false;
    }, 3000);
    this.products.push(data);
  };

  DeleteUser = async (id: number) => {
    let res = await fetch(`http://localhost:8087/users/${id}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
      },
    });
    if (res.status) {
      this.show = true;
      this.message = 'User Deleted';
    }
    setTimeout(() => {
      this.show = false;
    }, 3000);

    this.users = this.users.filter((item: any) => {
      return item.id != id;
    });
  };
}
