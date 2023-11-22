
package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.simpleOffer;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "imageUrl",
    "type",
    "brandingVisible",
    "highlightedAds",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Agency {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("type")
    private String type;
    @JsonProperty("brandingVisible")
    private Boolean brandingVisible;
    @JsonProperty("highlightedAds")
    private Boolean highlightedAds;
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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("brandingVisible")
    public Boolean getBrandingVisible() {
        return brandingVisible;
    }

    @JsonProperty("brandingVisible")
    public void setBrandingVisible(Boolean brandingVisible) {
        this.brandingVisible = brandingVisible;
    }

    @JsonProperty("highlightedAds")
    public Boolean getHighlightedAds() {
        return highlightedAds;
    }

    @JsonProperty("highlightedAds")
    public void setHighlightedAds(Boolean highlightedAds) {
        this.highlightedAds = highlightedAds;
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
