
package com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.general;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@type",
    "itemOffered",
    "url",
    "availability",
    "priceCurrency",
    "price"
})
@Generated("jsonschema2pojo")
public class ItemListElement {

    @JsonProperty("@type")
    private String type;
    @JsonProperty("itemOffered")
    private ItemOffered itemOffered;
    @JsonProperty("url")
    private String url;
    @JsonProperty("availability")
    private String availability;
    @JsonProperty("priceCurrency")
    private String priceCurrency;
    @JsonProperty("price")
    private Integer price;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("@type")
    public String getType() {
        return type;
    }

    @JsonProperty("@type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("itemOffered")
    public ItemOffered getItemOffered() {
        return itemOffered;
    }

    @JsonProperty("itemOffered")
    public void setItemOffered(ItemOffered itemOffered) {
        this.itemOffered = itemOffered;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("availability")
    public String getAvailability() {
        return availability;
    }

    @JsonProperty("availability")
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @JsonProperty("priceCurrency")
    public String getPriceCurrency() {
        return priceCurrency;
    }

    @JsonProperty("priceCurrency")
    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
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
