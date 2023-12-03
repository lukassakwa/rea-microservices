import { Injectable } from '@angular/core';
import { LikedOfferRequest, OfferResponse} from '../model/offer.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import {Filter} from "../common/filter/Filter";

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  private offerUrl = 'http://localhost:8082/api/offer';
  private likedOfferUrl = 'http://localhost:8082/api/favorite';
  private historicalOfferUrl = 'http://localhost:8082/api/offer/monitor';

  constructor(private http: HttpClient) {

  }

  getOffers(filter: Filter) : Observable<any> {
    let params = new HttpParams()
      .set("estateServiceType", filter.service!)
    params = filter.priceFrom ? params.set('priceFrom', filter.priceFrom) : params;
    params = filter.priceTo ? params.set('priceTo', filter.priceTo) : params;
    params = filter.metersFrom ? params.set('metersFrom', filter.metersFrom) : params;
    params = filter.metersTo ? params.set('metersTo', filter.metersTo) : params;
    return this.http.get<any>(`${this.offerUrl}`, {params: params});
  }

  addLikedOffer(likedOffer: any) {
    return this.http.put(`${this.likedOfferUrl}`, JSON.stringify(likedOffer));
  }

  getLikedOffers(filter: Filter) {
    let params = new HttpParams()
      .set("estateServiceType", filter.service!)
    params = filter.priceFrom ? params.set('priceFrom', filter.priceFrom) : params;
    params = filter.priceTo ? params.set('priceTo', filter.priceTo) : params;
    params = filter.metersFrom ? params.set('metersFrom', filter.metersFrom) : params;
    params = filter.metersTo ? params.set('metersTo', filter.metersTo) : params;
    return this.http.get<any>(`${this.likedOfferUrl}`, {params: params});
  }

  getHistoricalOffers(service: string, offerId: string) {
    return this.http.get<OfferResponse[]>(`${this.historicalOfferUrl}/${service}/${offerId}`);
  }

}
