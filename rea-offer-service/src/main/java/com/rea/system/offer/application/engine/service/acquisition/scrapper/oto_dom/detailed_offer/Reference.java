
package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "geoLevel",
    "areaPrice",
    "areaPriceUnit",
    "price",
    "priceUnit",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Reference {

    @JsonProperty("geoLevel")
    private GeoLevel geoLevel;
    @JsonProperty("areaPrice")
    private String areaPrice;
    @JsonProperty("areaPriceUnit")
    private String areaPriceUnit;
    @JsonProperty("price")
    private String price;
    @JsonProperty("priceUnit")
    private String priceUnit;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("geoLevel")
    public GeoLevel getGeoLevel() {
        return geoLevel;
    }

    @JsonProperty("geoLevel")
    public void setGeoLevel(GeoLevel geoLevel) {
        this.geoLevel = geoLevel;
    }

    @JsonProperty("areaPrice")
    public String getAreaPrice() {
        return areaPrice;
    }

    @JsonProperty("areaPrice")
    public void setAreaPrice(String areaPrice) {
        this.areaPrice = areaPrice;
    }

    @JsonProperty("areaPriceUnit")
    public String getAreaPriceUnit() {
        return areaPriceUnit;
    }

    @JsonProperty("areaPriceUnit")
    public void setAreaPriceUnit(String areaPriceUnit) {
        this.areaPriceUnit = areaPriceUnit;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("priceUnit")
    public String getPriceUnit() {
        return priceUnit;
    }

    @JsonProperty("priceUnit")
    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
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
