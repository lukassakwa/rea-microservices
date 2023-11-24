export class OfferResponse {
  id?: string;
  publicId?: string;
  images?: string[];
  title?: string;
  description?: string;
  price?: number;
  pricePerMeter?: number;
  meters?: number;
  roomNumber?: string;
  floor?: string;
  fullAddress?: string;
  latitiude?: string;
  longtitiude?: string;
  modifiedAt?: string;
  contactPhone?: string;
  href?: string;
}

export enum FavoriteOperationType {
    ADD = "ADD",
    REMOVE = "REMOVE"
}

export class LikedOfferRequest {
  offerId?: string;
  operationType?: FavoriteOperationType
}

export enum EstateServiceType {
  RENT = "RENT",
  SELL = "SELL"
}
