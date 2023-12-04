import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {EstateServiceType, FavoriteOperationType, OfferResponse} from '../model/offer.model';
import {OfferService} from '../service/offer.service';
import {FilterParams} from "../common/constants/filter-params";
import {Router} from "@angular/router";
import {Filter} from "../common/filter/Filter";

@Component({
  selector: 'app-favorite-offers',
  templateUrl: './favorite-offers.component.html',
  styleUrls: ['./favorite-offers.component.css']
})
export class FavoriteOffersComponent implements OnInit {

  @ViewChild('top') top!: ElementRef;
  offers: OfferResponse[] = [];
  index: number = 0;

  constructor(
    private offersService: OfferService,
    private router: Router,
  ) {
  }

  ngOnInit(): void {
    FilterParams.selectedService = EstateServiceType.SELL;
    this.index = 0;
    this.offersService.getLikedOffers({service: EstateServiceType.SELL}, '0')
      .subscribe(data => {
        this.offers = data;
      });
  }

  getOffers() {
    const filter = {
      service: FilterParams.selectedService
    }
    this.index = 0;
    this.offersService.getLikedOffers(filter, '0')
      .subscribe(data => {
        this.offers = data;
      });
  }

  getImage(images: string[]) {
    return images[0];
  }

  unlikeOffer(offerResponse: OfferResponse) {
    this.offersService.addLikedOffer({
      offerId: offerResponse.id,
      operationType: FavoriteOperationType.REMOVE
    }).subscribe(value => {
      this.getOffers();
    })
  }

  historicalOffer(offerResponse: OfferResponse) {
    this.router.navigate(['/historical', FilterParams.selectedService, offerResponse.id]);
  }

  onFillter($event: Filter) {
    const filter = {
      service: FilterParams.selectedService
    }
    this.index = 0;
    this.offersService.getLikedOffers(filter, '0')
      .subscribe(data => {
        this.offers = data;
      });
  }

  nextPage(index: number) {
    const filter = {
      service: FilterParams.selectedService
    }
    this.index = index;
    this.offersService.getLikedOffers(filter, index.toString())
      .subscribe(data => {
        this.offers = data;
        this.top.nativeElement.scrollIntoView({behavior: 'smooth'})
      });
  }
}
