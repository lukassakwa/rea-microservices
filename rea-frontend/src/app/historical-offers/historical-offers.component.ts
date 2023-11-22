import { Component, OnInit } from '@angular/core';
import { OfferService } from '../service/offer.service';
import { ActivatedRoute } from '@angular/router';
import { DatePipe } from "@angular/common";

@Component({
  selector: 'app-historical-offers',
  templateUrl: './historical-offers.component.html',
  styleUrls: ['./historical-offers.component.css'],
  providers: [DatePipe]
})
export class HistoricalOffersComponent implements OnInit {

  publicId: string = "";
  service: string = "";
  offers: any[] = [];

  constructor(
    private offerService: OfferService,
    private activeRoute: ActivatedRoute,
    private datePipe: DatePipe
  ) { }

  ngOnInit(): void {
    this.publicId = this.activeRoute!.snapshot!.paramMap!.get('offerId')!;
    this.service = this.activeRoute!.snapshot!.paramMap!.get('estateServiceType')!;
    this.offerService.getHistoricalOffers(this.service, this.publicId).subscribe((value) => {
      this.offers = value;
    });
  }

  getImage(images: string[]) {
    return images[0];
  }

  getDate(date: string) : string {
    console.log(date)
    return this.datePipe.transform(date, 'medium')!;
  }

}
