import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import { EstateServiceType } from '../../model/offer.model';
import {Filter} from "./Filter";
import {FilterParams} from "../constants/filter-params";

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {

  @Input() showPrice: boolean = false;
  @Input() showMeters: boolean = false;
  @Output() clicked = new EventEmitter<Filter>();

  selectedEstate: string = FilterParams.selectedEstate;
  selectedService: string = FilterParams.selectedService;
  priceFrom: string = FilterParams.priceFrom;
  priceTo: string = FilterParams.priceTo;
  metersFrom: string = FilterParams.metersFrom;
  metersTo: string = FilterParams.metersTo;
  estates: string[] = [FilterParams.selectedEstate];
  services: string[] = [EstateServiceType.RENT, EstateServiceType.SELL];

  constructor() { }

  ngOnInit(): void {
    this.selectedService = FilterParams.selectedService;
    this.clicked.emit({
      service: FilterParams.selectedService
    });
  }

  onFillter() {
    FilterParams.selectedService = this.selectedService;
    FilterParams.priceFrom = this.priceFrom;
    FilterParams.priceTo = this.priceTo;
    FilterParams.metersFrom = this.metersFrom;
    FilterParams.metersTo = this.metersTo;
    this.clicked.emit({
      service: FilterParams.selectedService,
      priceFrom: FilterParams.priceFrom,
      priceTo: FilterParams.priceTo,
      metersTo: FilterParams.metersTo,
      metersFrom: FilterParams.metersFrom
    });
  }

  getTranslation(service: string) {
    if (service === 'RENT') {
      return 'WYNAJEM';
    }
    return 'NA SPRZEDAZ';
  }

  getTranslationEstate(estate: string) {
    if (estate === 'HOME') {
      return 'DOM'
    }
    return 'MIESZKANIE'
  }
}
