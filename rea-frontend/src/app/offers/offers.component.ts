import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {EstateServiceType, FavoriteOperationType, OfferResponse} from '../model/offer.model';
import {OfferService} from '../service/offer.service';
import {Router} from '@angular/router';
import {Filter} from "../common/filter/Filter";
import {FilterParams} from "../common/constants/filter-params";

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit {

  @ViewChild('top') top!: ElementRef;
  offers: OfferResponse[] = [];
  index: number = 0;

  constructor(
    private offerService: OfferService,
    private router: Router,
  ) {
  }

  ngOnInit(): void {
    FilterParams.selectedService = EstateServiceType.SELL;
    this.index = 0;
    this.offerService.getOffers({service: EstateServiceType.SELL}, '0')
      .subscribe(data => {
        this.offers = data;
      });
  }

  likeOffer(offerResponse: OfferResponse) {
    this.offerService.addLikedOffer({
      offerId: offerResponse.id,
      operationType: FavoriteOperationType.ADD
    }).subscribe(value => value);
  }

  onFillter(filter: Filter) {
    this.index = 0;
    this.offerService.getOffers(filter, '0')
      .subscribe(data => {
        this.offers = data;
      });
  }

  getImage(images: string[]) {
    return images[0];
  }

  historicalOffer(offer: OfferResponse) {
    this.router.navigate(['/historical', FilterParams.selectedService, offer.id]);
  }

  nextPage(index: number) {
    const filter = {
      service: FilterParams.selectedService,
      priceTo: FilterParams.priceTo,
      priceFrom: FilterParams.priceFrom,
      metersTo: FilterParams.metersTo,
      metersFrom: FilterParams.metersFrom,
    }
    this.index = index;
    this.offerService.getOffers(filter, index.toString())
      .subscribe(data => {
        this.offers = data;
        this.top.nativeElement.scrollIntoView({behavior: 'smooth'})
      });
  }
}
