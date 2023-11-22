
package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Area",
    "AreaRange",
    "Build_year",
    "Building_floors_num",
    "Building_material",
    "Building_ownership",
    "Building_type",
    "City",
    "City_id",
    "Construction_status",
    "Country",
    "Extras_types",
    "Floor_no",
    "Heating",
    "Id",
    "MarketType",
    "Media_types",
    "ObidoAdvert",
    "OfferType",
    "Photo",
    "Price",
    "PriceRange",
    "Price_per_m",
    "ProperType",
    "Province",
    "RegularUser",
    "Rooms_num",
    "Security_types",
    "Subregion",
    "Title",
    "Windows_type",
    "categoryId",
    "env",
    "hidePrice",
    "seller_id",
    "user_type"
})
@Generated("jsonschema2pojo")
public class Target {

    @JsonProperty("Area")
    private String area;
    @JsonProperty("AreaRange")
    private List<Object> areaRange = null;
    @JsonProperty("Build_year")
    private String buildYear;
    @JsonProperty("Building_floors_num")
    private String buildingFloorsNum;
    @JsonProperty("Building_material")
    private List<String> buildingMaterial = null;
    @JsonProperty("Building_ownership")
    private List<String> buildingOwnership = null;
    @JsonProperty("Building_type")
    private List<String> buildingType = null;
    @JsonProperty("City")
    private String city;
    @JsonProperty("City_id")
    private String cityId;
    @JsonProperty("Construction_status")
    private List<String> constructionStatus = null;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("Extras_types")
    private List<String> extrasTypes = null;
    @JsonProperty("Floor_no")
    private List<String> floorNo = null;
    @JsonProperty("Heating")
    private List<String> heating = null;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("MarketType")
    private String marketType;
    @JsonProperty("Media_types")
    private List<String> mediaTypes = null;
    @JsonProperty("ObidoAdvert")
    private String obidoAdvert;
    @JsonProperty("OfferType")
    private String offerType;
    @JsonProperty("Photo")
    private String photo;
    @JsonProperty("Price")
    private Integer price;
    @JsonProperty("PriceRange")
    private List<String> priceRange = null;
    @JsonProperty("Price_per_m")
    private Double pricePerM;
    @JsonProperty("ProperType")
    private String properType;
    @JsonProperty("Province")
    private String province;
    @JsonProperty("RegularUser")
    private String regularUser;
    @JsonProperty("Rooms_num")
    private List<String> roomsNum = null;
    @JsonProperty("Security_types")
    private List<String> securityTypes = null;
    @JsonProperty("Subregion")
    private String subregion;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Windows_type")
    private List<String> windowsType = null;
    @JsonProperty("categoryId")
    private String categoryId;
    @JsonProperty("env")
    private String env;
    @JsonProperty("hidePrice")
    private String hidePrice;
    @JsonProperty("seller_id")
    private String sellerId;
    @JsonProperty("user_type")
    private String userType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Area")
    public String getArea() {
        return area;
    }

    @JsonProperty("Area")
    public void setArea(String area) {
        this.area = area;
    }

    @JsonProperty("AreaRange")
    public List<Object> getAreaRange() {
        return areaRange;
    }

    @JsonProperty("AreaRange")
    public void setAreaRange(List<Object> areaRange) {
        this.areaRange = areaRange;
    }

    @JsonProperty("Build_year")
    public String getBuildYear() {
        return buildYear;
    }

    @JsonProperty("Build_year")
    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear;
    }

    @JsonProperty("Building_floors_num")
    public String getBuildingFloorsNum() {
        return buildingFloorsNum;
    }

    @JsonProperty("Building_floors_num")
    public void setBuildingFloorsNum(String buildingFloorsNum) {
        this.buildingFloorsNum = buildingFloorsNum;
    }

    @JsonProperty("Building_material")
    public List<String> getBuildingMaterial() {
        return buildingMaterial;
    }

    @JsonProperty("Building_material")
    public void setBuildingMaterial(List<String> buildingMaterial) {
        this.buildingMaterial = buildingMaterial;
    }

    @JsonProperty("Building_ownership")
    public List<String> getBuildingOwnership() {
        return buildingOwnership;
    }

    @JsonProperty("Building_ownership")
    public void setBuildingOwnership(List<String> buildingOwnership) {
        this.buildingOwnership = buildingOwnership;
    }

    @JsonProperty("Building_type")
    public List<String> getBuildingType() {
        return buildingType;
    }

    @JsonProperty("Building_type")
    public void setBuildingType(List<String> buildingType) {
        this.buildingType = buildingType;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("City_id")
    public String getCityId() {
        return cityId;
    }

    @JsonProperty("City_id")
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @JsonProperty("Construction_status")
    public List<String> getConstructionStatus() {
        return constructionStatus;
    }

    @JsonProperty("Construction_status")
    public void setConstructionStatus(List<String> constructionStatus) {
        this.constructionStatus = constructionStatus;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("Extras_types")
    public List<String> getExtrasTypes() {
        return extrasTypes;
    }

    @JsonProperty("Extras_types")
    public void setExtrasTypes(List<String> extrasTypes) {
        this.extrasTypes = extrasTypes;
    }

    @JsonProperty("Floor_no")
    public List<String> getFloorNo() {
        return floorNo;
    }

    public String getFloorNum() {
        return Optional.of(getFloorNo()).map(floorNo -> floorNo.get(0)).orElse(null);
    }

    @JsonProperty("Floor_no")
    public void setFloorNo(List<String> floorNo) {
        this.floorNo = floorNo;
    }

    @JsonProperty("Heating")
    public List<String> getHeating() {
        return heating;
    }

    @JsonProperty("Heating")
    public void setHeating(List<String> heating) {
        this.heating = heating;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("MarketType")
    public String getMarketType() {
        return marketType;
    }

    @JsonProperty("MarketType")
    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    @JsonProperty("Media_types")
    public List<String> getMediaTypes() {
        return mediaTypes;
    }

    @JsonProperty("Media_types")
    public void setMediaTypes(List<String> mediaTypes) {
        this.mediaTypes = mediaTypes;
    }

    @JsonProperty("ObidoAdvert")
    public String getObidoAdvert() {
        return obidoAdvert;
    }

    @JsonProperty("ObidoAdvert")
    public void setObidoAdvert(String obidoAdvert) {
        this.obidoAdvert = obidoAdvert;
    }

    @JsonProperty("OfferType")
    public String getOfferType() {
        return offerType;
    }

    @JsonProperty("OfferType")
    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    @JsonProperty("Photo")
    public String getPhoto() {
        return photo;
    }

    @JsonProperty("Photo")
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @JsonProperty("Price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("PriceRange")
    public List<String> getPriceRange() {
        return priceRange;
    }

    @JsonProperty("PriceRange")
    public void setPriceRange(List<String> priceRange) {
        this.priceRange = priceRange;
    }

    @JsonProperty("Price_per_m")
    public Double getPricePerM() {
        return pricePerM;
    }

    @JsonProperty("Price_per_m")
    public void setPricePerM(Double pricePerM) {
        this.pricePerM = pricePerM;
    }

    @JsonProperty("ProperType")
    public String getProperType() {
        return properType;
    }

    @JsonProperty("ProperType")
    public void setProperType(String properType) {
        this.properType = properType;
    }

    @JsonProperty("Province")
    public String getProvince() {
        return province;
    }

    @JsonProperty("Province")
    public void setProvince(String province) {
        this.province = province;
    }

    @JsonProperty("RegularUser")
    public String getRegularUser() {
        return regularUser;
    }

    @JsonProperty("RegularUser")
    public void setRegularUser(String regularUser) {
        this.regularUser = regularUser;
    }

    @JsonProperty("Rooms_num")
    public List<String> getRoomsNum() {
        return roomsNum;
    }

    public String getRoomNum() {
        return Optional.of(getRoomsNum()).map(roomNum -> roomNum.get(0)).orElse(null);
    }

    @JsonProperty("Rooms_num")
    public void setRoomsNum(List<String> roomsNum) {
        this.roomsNum = roomsNum;
    }

    @JsonProperty("Security_types")
    public List<String> getSecurityTypes() {
        return securityTypes;
    }

    @JsonProperty("Security_types")
    public void setSecurityTypes(List<String> securityTypes) {
        this.securityTypes = securityTypes;
    }

    @JsonProperty("Subregion")
    public String getSubregion() {
        return subregion;
    }

    @JsonProperty("Subregion")
    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Windows_type")
    public List<String> getWindowsType() {
        return windowsType;
    }

    @JsonProperty("Windows_type")
    public void setWindowsType(List<String> windowsType) {
        this.windowsType = windowsType;
    }

    @JsonProperty("categoryId")
    public String getCategoryId() {
        return categoryId;
    }

    @JsonProperty("categoryId")
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("env")
    public String getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(String env) {
        this.env = env;
    }

    @JsonProperty("hidePrice")
    public String getHidePrice() {
        return hidePrice;
    }

    @JsonProperty("hidePrice")
    public void setHidePrice(String hidePrice) {
        this.hidePrice = hidePrice;
    }

    @JsonProperty("seller_id")
    public String getSellerId() {
        return sellerId;
    }

    @JsonProperty("seller_id")
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @JsonProperty("user_type")
    public String getUserType() {
        return userType;
    }

    @JsonProperty("user_type")
    public void setUserType(String userType) {
        this.userType = userType;
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
