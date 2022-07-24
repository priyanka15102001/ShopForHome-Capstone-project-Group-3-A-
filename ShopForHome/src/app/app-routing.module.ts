import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProductsComponent } from './products/products.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ViewCartComponent } from './view-cart/view-cart.component';
import { ViewWishlistComponent } from './view-wishlist/view-wishlist.component';
import { AdminComponent } from './admin/admin.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'products', component: ProductsComponent },
  { path: 'products/:category', component: ProductsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'viewcart', component: ViewCartComponent },
  { path: 'viewwishlist', component: ViewWishlistComponent },
  { path: 'admin', component: AdminComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
