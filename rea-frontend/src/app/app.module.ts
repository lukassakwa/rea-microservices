import {APP_INITIALIZER, LOCALE_ID, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {OffersComponent} from './offers/offers.component';
import {AppRoutingModule} from './app-routing.module';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FilterComponent} from './common/filter/filter.component';
import {BaseInterceptor} from './interceptor/base-interceptor';
import {FavoriteOffersComponent} from './favorite-offers/favorite-offers.component';
import {HistoricalOffersComponent} from './historical-offers/historical-offers.component';
import {UserComponent} from './user/user.component';
import {MatPaginatorModule} from "@angular/material/paginator";
import {CommonModule, registerLocaleData} from "@angular/common";
import localePl from '@angular/common/locales/pl';
import Keycloak from "keycloak-js";
import {AuthHttpInterceptor} from "./interceptor/auth-interceptor";

registerLocaleData(localePl)

export let KEYCLOAK_INITIALIZER: any

function initializeKeycloak() {
  const keycloak = new Keycloak({
    url: '',
    realm: 'rea-keycloak',
    clientId: 'rea-app'
  });
  return () => keycloak.init({
    onLoad: "login-required"
  }).then(value => {
    if (value) {
      KEYCLOAK_INITIALIZER = keycloak;
    }
  })
}

@NgModule({
    declarations: [
        AppComponent,
        OffersComponent,
        FilterComponent,
        FavoriteOffersComponent,
        HistoricalOffersComponent,
        UserComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        CommonModule,
        HttpClientModule,
        NgbModule,
        MatFormFieldModule,
        ReactiveFormsModule,
        MatInputModule,
        MatInputModule,
        MatPaginatorModule
    ],
    providers: [
        {
            provide: APP_INITIALIZER,
            useFactory: initializeKeycloak,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthHttpInterceptor,
            multi: true,
        },
        {provide: LOCALE_ID, useValue: "pl"},
        {
            provide: HTTP_INTERCEPTORS,
            useClass: BaseInterceptor,
            multi: true,
        },
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
