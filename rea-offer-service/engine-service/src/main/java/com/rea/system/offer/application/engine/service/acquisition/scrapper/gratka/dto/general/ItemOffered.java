
package com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.general;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@type",
    "name",
    "image",
    "address",
    "url",
    "geo",
    "numberOfRooms",
    "floorLevel",
    "floorSize",
    "description",
    "yearBuilt"
})
@Generated("jsonschema2pojo")
public class ItemOffered {

    @JsonProperty("@type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image")
    private String image;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("url")
    private String url;
    @JsonProperty("geo")
    private Geo geo;
    @JsonProperty("numberOfRooms")
    private Integer numberOfRooms;
    @JsonProperty("floorLevel")
    private Integer floorLevel;
    @JsonProperty("floorSize")
    private FloorSize floorSize;
    @JsonProperty("description")
    private String description;
    @JsonProperty("yearBuilt")
    private Integer yearBuilt;
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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("geo")
    public Geo getGeo() {
        return geo;
    }

    @JsonProperty("geo")
    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    @JsonProperty("numberOfRooms")
    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    @JsonProperty("numberOfRooms")
    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @JsonProperty("floorLevel")
    public Integer getFloorLevel() {
        return floorLevel;
    }

    @JsonProperty("floorLevel")
    public void setFloorLevel(Integer floorLevel) {
        this.floorLevel = floorLevel;
    }

    @JsonProperty("floorSize")
    public FloorSize getFloorSize() {
        return floorSize;
    }

    @JsonProperty("floorSize")
    public void setFloorSize(FloorSize floorSize) {
        this.floorSize = floorSize;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("yearBuilt")
    public Integer getYearBuilt() {
        return yearBuilt;
    }

    @JsonProperty("yearBuilt")
    public void setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
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
