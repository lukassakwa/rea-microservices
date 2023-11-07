
package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.simpleOffer;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "title",
    "slug",
    "estate",
    "transaction",
    "locationLabel",
    "images",
    "isExclusiveOffer",
    "isPrivateOwner",
    "isPromoted",
    "agency",
    "openDays",
    "totalPrice",
    "rentPrice",
    "priceFromPerSquareMeter",
    "pricePerSquareMeter",
    "areaInSquareMeters",
    "terrainAreaInSquareMeters",
    "roomsNumber",
    "hidePrice",
    "investmentState",
    "investmentUnitsAreaInSquareMeters",
    "peoplePerRoom",
    "dateCreated",
    "investmentUnitsNumber",
    "investmentUnitsRoomsNumber",
    "investmentEstimatedDelivery",
    "pushedUpAt",
    "specialOffer",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Item {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("estate")
    private String estate;
    @JsonProperty("transaction")
    private String transaction;
    @JsonProperty("locationLabel")
    private LocationLabel locationLabel;
    @JsonProperty("images")
    private List<Image> images = null;
    @JsonProperty("isExclusiveOffer")
    private Boolean isExclusiveOffer;
    @JsonProperty("isPrivateOwner")
    private Boolean isPrivateOwner;
    @JsonProperty("isPromoted")
    private Boolean isPromoted;
    @JsonProperty("agency")
    private Agency agency;
    @JsonProperty("openDays")
    private String openDays;
    @JsonProperty("totalPrice")
    private TotalPrice totalPrice;
    @JsonProperty("rentPrice")
    private RentPrice rentPrice;
    @JsonProperty("priceFromPerSquareMeter")
    private Object priceFromPerSquareMeter;
    @JsonProperty("pricePerSquareMeter")
    private PricePerSquareMeter pricePerSquareMeter;
    @JsonProperty("areaInSquareMeters")
    private Float areaInSquareMeters;
    @JsonProperty("terrainAreaInSquareMeters")
    private Object terrainAreaInSquareMeters;
    @JsonProperty("roomsNumber")
    private String roomsNumber;
    @JsonProperty("hidePrice")
    private Boolean hidePrice;
    @JsonProperty("investmentState")
    private Object investmentState;
    @JsonProperty("investmentUnitsAreaInSquareMeters")
    private Object investmentUnitsAreaInSquareMeters;
    @JsonProperty("peoplePerRoom")
    private Object peoplePerRoom;
    @JsonProperty("dateCreated")
    private String dateCreated;
    @JsonProperty("investmentUnitsNumber")
    private Object investmentUnitsNumber;
    @JsonProperty("investmentUnitsRoomsNumber")
    private Object investmentUnitsRoomsNumber;
    @JsonProperty("investmentEstimatedDelivery")
    private Object investmentEstimatedDelivery;
    @JsonProperty("pushedUpAt")
    private ZonedDateTime pushedUpAt;
    @JsonProperty("specialOffer")
    private Object specialOffer;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("estate")
    public String getEstate() {
        return estate;
    }

    @JsonProperty("estate")
    public void setEstate(String estate) {
        this.estate = estate;
    }

    @JsonProperty("transaction")
    public String getTransaction() {
        return transaction;
    }

    @JsonProperty("transaction")
    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    @JsonProperty("locationLabel")
    public LocationLabel getLocationLabel() {
        return locationLabel;
    }

    @JsonProperty("locationLabel")
    public void setLocationLabel(LocationLabel locationLabel) {
        this.locationLabel = locationLabel;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    @JsonProperty("isExclusiveOffer")
    public Boolean getIsExclusiveOffer() {
        return isExclusiveOffer;
    }

    @JsonProperty("isExclusiveOffer")
    public void setIsExclusiveOffer(Boolean isExclusiveOffer) {
        this.isExclusiveOffer = isExclusiveOffer;
    }

    @JsonProperty("isPrivateOwner")
    public Boolean getIsPrivateOwner() {
        return isPrivateOwner;
    }

    @JsonProperty("isPrivateOwner")
    public void setIsPrivateOwner(Boolean isPrivateOwner) {
        this.isPrivateOwner = isPrivateOwner;
    }

    @JsonProperty("isPromoted")
    public Boolean getIsPromoted() {
        return isPromoted;
    }

    @JsonProperty("isPromoted")
    public void setIsPromoted(Boolean isPromoted) {
        this.isPromoted = isPromoted;
    }

    @JsonProperty("agency")
    public Agency getAgency() {
        return agency;
    }

    @JsonProperty("agency")
    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @JsonProperty("openDays")
    public String getOpenDays() {
        return openDays;
    }

    @JsonProperty("openDays")
    public void setOpenDays(String openDays) {
        this.openDays = openDays;
    }

    @JsonProperty("totalPrice")
    public TotalPrice getTotalPrice() {
        return totalPrice;
    }

    @JsonProperty("totalPrice")
    public void setTotalPrice(TotalPrice totalPrice) {
        this.totalPrice = totalPrice;
    }

    @JsonProperty("rentPrice")
    public RentPrice getRentPrice() {
        return rentPrice;
    }

    @JsonProperty("rentPrice")
    public void setRentPrice(RentPrice rentPrice) {
        this.rentPrice = rentPrice;
    }

    @JsonProperty("priceFromPerSquareMeter")
    public Object getPriceFromPerSquareMeter() {
        return priceFromPerSquareMeter;
    }

    @JsonProperty("priceFromPerSquareMeter")
    public void setPriceFromPerSquareMeter(Object priceFromPerSquareMeter) {
        this.priceFromPerSquareMeter = priceFromPerSquareMeter;
    }

    @JsonProperty("pricePerSquareMeter")
    public PricePerSquareMeter getPricePerSquareMeter() {
        return pricePerSquareMeter;
    }

    @JsonProperty("pricePerSquareMeter")
    public void setPricePerSquareMeter(PricePerSquareMeter pricePerSquareMeter) {
        this.pricePerSquareMeter = pricePerSquareMeter;
    }

    @JsonProperty("areaInSquareMeters")
    public Float getAreaInSquareMeters() {
        return areaInSquareMeters;
    }

    @JsonProperty("areaInSquareMeters")
    public void setAreaInSquareMeters(Float areaInSquareMeters) {
        this.areaInSquareMeters = areaInSquareMeters;
    }

    @JsonProperty("terrainAreaInSquareMeters")
    public Object getTerrainAreaInSquareMeters() {
        return terrainAreaInSquareMeters;
    }

    @JsonProperty("terrainAreaInSquareMeters")
    public void setTerrainAreaInSquareMeters(Object terrainAreaInSquareMeters) {
        this.terrainAreaInSquareMeters = terrainAreaInSquareMeters;
    }

    @JsonProperty("roomsNumber")
    public String getRoomsNumber() {
        return roomsNumber;
    }

    @JsonProperty("roomsNumber")
    public void setRoomsNumber(String roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    @JsonProperty("hidePrice")
    public Boolean getHidePrice() {
        return hidePrice;
    }

    @JsonProperty("hidePrice")
    public void setHidePrice(Boolean hidePrice) {
        this.hidePrice = hidePrice;
    }

    @JsonProperty("investmentState")
    public Object getInvestmentState() {
        return investmentState;
    }

    @JsonProperty("investmentState")
    public void setInvestmentState(Object investmentState) {
        this.investmentState = investmentState;
    }

    @JsonProperty("investmentUnitsAreaInSquareMeters")
    public Object getInvestmentUnitsAreaInSquareMeters() {
        return investmentUnitsAreaInSquareMeters;
    }

    @JsonProperty("investmentUnitsAreaInSquareMeters")
    public void setInvestmentUnitsAreaInSquareMeters(Object investmentUnitsAreaInSquareMeters) {
        this.investmentUnitsAreaInSquareMeters = investmentUnitsAreaInSquareMeters;
    }

    @JsonProperty("peoplePerRoom")
    public Object getPeoplePerRoom() {
        return peoplePerRoom;
    }

    @JsonProperty("peoplePerRoom")
    public void setPeoplePerRoom(Object peoplePerRoom) {
        this.peoplePerRoom = peoplePerRoom;
    }

    @JsonProperty("dateCreated")
    public String getDateCreated() {
        return dateCreated;
    }

    @JsonProperty("dateCreated")
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @JsonProperty("investmentUnitsNumber")
    public Object getInvestmentUnitsNumber() {
        return investmentUnitsNumber;
    }

    @JsonProperty("investmentUnitsNumber")
    public void setInvestmentUnitsNumber(Object investmentUnitsNumber) {
        this.investmentUnitsNumber = investmentUnitsNumber;
    }

    @JsonProperty("investmentUnitsRoomsNumber")
    public Object getInvestmentUnitsRoomsNumber() {
        return investmentUnitsRoomsNumber;
    }

    @JsonProperty("investmentUnitsRoomsNumber")
    public void setInvestmentUnitsRoomsNumber(Object investmentUnitsRoomsNumber) {
        this.investmentUnitsRoomsNumber = investmentUnitsRoomsNumber;
    }

    @JsonProperty("investmentEstimatedDelivery")
    public Object getInvestmentEstimatedDelivery() {
        return investmentEstimatedDelivery;
    }

    @JsonProperty("investmentEstimatedDelivery")
    public void setInvestmentEstimatedDelivery(Object investmentEstimatedDelivery) {
        this.investmentEstimatedDelivery = investmentEstimatedDelivery;
    }

    @JsonProperty("pushedUpAt")
    public ZonedDateTime getPushedUpAt() {
        return pushedUpAt;
    }

    @JsonProperty("pushedUpAt")
    public void setPushedUpAt(ZonedDateTime pushedUpAt) {
        this.pushedUpAt = pushedUpAt;
    }

    @JsonProperty("specialOffer")
    public Object getSpecialOffer() {
        return specialOffer;
    }

    @JsonProperty("specialOffer")
    public void setSpecialOffer(Object specialOffer) {
        this.specialOffer = specialOffer;
    }

    @JsonProperty("__typename")
    public String getTypename() {
        return typename;
    }

    @JsonProperty("__typename")
    public void setTypename(String typename) {
        this.typename = typename;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
