import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { EstateServiceType} from "../model/offer.model";
import {FilterParams} from "../common/constants/filter-params";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  userForms!: FormGroup;
  estates: string[] = [FilterParams.selectedEstate];
  services: string[] = [EstateServiceType.RENT, EstateServiceType.SELL];
  emailDelays: string[] = ["2", "4", "6", "8"];

  constructor(private userService: UserService,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.userForms = this.formBuilder.group({
      emailDayDelays: ["1"],
      estate: [{value: FilterParams.selectedEstate, disabled: true}],
      service: undefined,
      priceFrom: undefined,
      priceTo: undefined,
      metersFrom: undefined,
      metersTo: undefined
    });
    this.userService.getSettings()
      .subscribe(value => this.updateForm(value))
  }

  onSubmit() {
    if (this.userForms.invalid) {
      return;
    }

    const userSettings = this.userForms.value;
    this.userService.createSettings(userSettings)
      .subscribe(value => this.userService.getSettings().subscribe(value => this.updateForm(value)));
  }

  private updateForm(value: any) {
    this.userForms.get("emailDayDelays")!.setValue(value.emailDayDelays);
    this.userForms.get("service")!.setValue(value.service);
    this.userForms.get("priceTo")!.setValue(value.priceTo);
    this.userForms.get("priceFrom")!.setValue(value.priceFrom);
    this.userForms.get("metersTo")!.setValue(value.metersTo);
    this.userForms.get("metersFrom")!.setValue(value.metersFrom);
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
