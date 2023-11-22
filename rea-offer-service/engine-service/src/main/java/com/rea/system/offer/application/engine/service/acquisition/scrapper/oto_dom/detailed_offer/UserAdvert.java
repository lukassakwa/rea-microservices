
package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "image",
    "roomsNum",
    "pricePerM",
    "price",
    "netArea",
    "title",
    "__typename"
})
@Generated("jsonschema2pojo")
public class UserAdvert {

    @JsonProperty("url")
    private String url;
    @JsonProperty("image")
    private String image;
    @JsonProperty("roomsNum")
    private String roomsNum;
    @JsonProperty("pricePerM")
    private Integer pricePerM;
    @JsonProperty("price")
    private Price price;
    @JsonProperty("netArea")
    private String netArea;
    @JsonProperty("title")
    private String title;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("roomsNum")
    public String getRoomsNum() {
        return roomsNum;
    }

    @JsonProperty("roomsNum")
    public void setRoomsNum(String roomsNum) {
        this.roomsNum = roomsNum;
    }

    @JsonProperty("pricePerM")
    public Integer getPricePerM() {
        return pricePerM;
    }

    @JsonProperty("pricePerM")
    public void setPricePerM(Integer pricePerM) {
        this.pricePerM = pricePerM;
    }

    @JsonProperty("price")
    public Price getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Price price) {
        this.price = price;
    }

    @JsonProperty("netArea")
    public String getNetArea() {
        return netArea;
    }

    @JsonProperty("netArea")
    public void setNetArea(String netArea) {
        this.netArea = netArea;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
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
