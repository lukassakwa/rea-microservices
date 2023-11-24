
package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "licenseNumber",
    "type",
    "phones",
    "address",
    "imageUrl",
    "url",
    "leaderYear",
    "brandingVisible",
    "enabledFeatures",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Agency {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("licenseNumber")
    private String licenseNumber;
    @JsonProperty("type")
    private String type;
    @JsonProperty("phones")
    private List<String> phones = null;
    @JsonProperty("address")
    private String address;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("url")
    private String url;
    @JsonProperty("leaderYear")
    private String leaderYear;
    @JsonProperty("brandingVisible")
    private Boolean brandingVisible;
    @JsonProperty("enabledFeatures")
    private List<String> enabledFeatures = null;
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

    @JsonProperty("licenseNumber")
    public String getLicenseNumber() {
        return licenseNumber;
    }

    @JsonProperty("licenseNumber")
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("phones")
    public List<String> getPhones() {
        return phones;
    }

    @JsonProperty("phones")
    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("leaderYear")
    public String getLeaderYear() {
        return leaderYear;
    }

    @JsonProperty("leaderYear")
    public void setLeaderYear(String leaderYear) {
        this.leaderYear = leaderYear;
    }

    @JsonProperty("brandingVisible")
    public Boolean getBrandingVisible() {
        return brandingVisible;
    }

    @JsonProperty("brandingVisible")
    public void setBrandingVisible(Boolean brandingVisible) {
        this.brandingVisible = brandingVisible;
    }

    @JsonProperty("enabledFeatures")
    public List<String> getEnabledFeatures() {
        return enabledFeatures;
    }

    @JsonProperty("enabledFeatures")
    public void setEnabledFeatures(List<String> enabledFeatures) {
        this.enabledFeatures = enabledFeatures;
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
