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

    constructor(
        private offerService: OfferService,
        private router: Router,
    ) {
    }

    ngOnInit(): void {
        FilterParams.selectedService = EstateServiceType.SELL;
        this.offerService.getOffers({service: EstateServiceType.SELL})
            .subscribe(data => {
                this.offers = data;
            });
    }

    likeOffer(offerResponse: OfferResponse) {
        console.log(offerResponse.id);
        this.offerService.addLikedOffer({
            offerId: offerResponse.id,
            operationType: FavoriteOperationType.ADD
        }).subscribe(value => value);
    }

    onFillter(filter: Filter) {
        this.offerService.getOffers(filter)
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
}
