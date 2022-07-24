import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit {
  products: any = [];
  added: boolean = false;
  wishadded: boolean = false;
  category: any;
  allcat: any = [];

  

  uniq(a: any) {
    return a.sort().filter(function (item: any, pos: number, ary: any) {
      return !pos || item != ary[pos - 1];
    });
  }

  constructor(private httpClient: HttpClient, private route: ActivatedRoute) {}

  ngOnInit() {
    // let response = this.httpClient.get('http://localhost:8087/products');
    // response.subscribe((data) => (this.products = data));
    // console.log(this.route.snapshot.paramMap.get('category'));
    // this.products = this.products.filter((item: any) => {
    //   console.log(item.product_type)
    //   return item.product_type === this.route.snapshot.paramMap.get('category');
    // });
    // this.products = Array.of(this.products);

    fetch(`http://localhost:8087/products`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => res.json())
      .then((data) => {
        data.forEach((element: any) => {
          this.allcat.push(element.product_type);
        });
        this.allcat = this.uniq(this.allcat);
        if (this.route.snapshot.paramMap.get('category')) {
          this.category = this.route.snapshot.paramMap.get('category');
          data = data.filter((item: any) => {
            return (
              item.product_type === this.route.snapshot.paramMap.get('category')
            );
          });
        }
        this.products = data;
      });
  }

  searched = async () => {
    let SW = (<HTMLInputElement>document.getElementById('searchword')).value;

    await fetch(`http://localhost:8087/products`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => res.json())
      .then((data) => {
        if(SW.length >= 0){
          data = data.filter((item: any) => {
            return item.product_name.includes(SW);
          });
        }
        this.products = data;
      });
  }



  filterandsort = async () => {
    let cat = (<HTMLInputElement>document.getElementById('product-type')).value;
    let sorts = (<HTMLInputElement>document.getElementById('sort')).value;
    console.log(cat, sorts);
    await fetch(`http://localhost:8087/products`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((res) => res.json())
      .then((data) => {
        if (cat != '0') {
          data = data.filter((item: any) => {
            return item.product_type === cat;
          });
          data = data.sort();
        }
        if (sorts != 'all') {
          if (sorts === 'LH') {
            data.sort((a: any, b: any) => {
              return a.product_price - b.product_price;
            });
          }

          if (sorts === 'HL') {
            data.sort((a: any, b: any) => {
              return b.product_price - a.product_price;
            });
          }
        }
        this.products = data;
      });
  }

  AddToCart = async (
    product_id: number,
    item_name: string,
    quantity: number,
    product_price: number,
    discount_amt: number,
    img_url: string
  ) => {
    const data = {
      product_id,
      item_name,
      quantity,
      product_price,
      discount_amt,
      img_url,
      username: localStorage.getItem('user'),
    };

    let res = await fetch('http://localhost:8087/cart', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    });
    if (res.status) {
      this.added = true;
    } else {
      this.added = false;
    }
    setTimeout(() => {
      this.added = false;
    }, 3000);
  };

  AddToWish = async (
    name: string,
    quantity: number,
    product_price: number,
    total_amt: number,
    img_url: string
  ) => {
    const data = {
      name,
      product_price,
      quantity,
      total_amt,
      img_url,
      username: localStorage.getItem('user'),
    };

    let res = await fetch('http://localhost:8087/wishlist', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    });
    if (res.status) {
      this.wishadded = true;
    } else {
      this.wishadded = false;
    }
    setTimeout(() => {
      this.wishadded = false;
    }, 3000);
  };
}
