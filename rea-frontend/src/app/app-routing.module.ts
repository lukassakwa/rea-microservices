import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FavoriteOffersComponent} from './favorite-offers/favorite-offers.component';
import {OffersComponent} from './offers/offers.component';
import {HistoricalOffersComponent} from './historical-offers/historical-offers.component';
import {UserComponent} from './user/user.component';

const routes: Routes = [
  { path: '', component: OffersComponent, pathMatch: 'full' },
  { path: 'offers', component: OffersComponent },
  { path: 'favorites', component: FavoriteOffersComponent },
  { path: 'historical/:estateServiceType/:offerId', component: HistoricalOffersComponent },
  { path: 'settings', component: UserComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
