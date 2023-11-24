
package com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.general;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@type",
    "addressCountry",
    "addressLocality",
    "addressRegion",
    "streetAddress"
})
@Generated("jsonschema2pojo")
public class Address {

    @JsonProperty("@type")
    private String type;
    @JsonProperty("addressCountry")
    private String addressCountry;
    @JsonProperty("addressLocality")
    private String addressLocality;
    @JsonProperty("addressRegion")
    private String addressRegion;
    @JsonProperty("streetAddress")
    private String streetAddress;
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

    @JsonProperty("addressCountry")
    public String getAddressCountry() {
        return addressCountry;
    }

    @JsonProperty("addressCountry")
    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    @JsonProperty("addressLocality")
    public String getAddressLocality() {
        return addressLocality;
    }

    @JsonProperty("addressLocality")
    public void setAddressLocality(String addressLocality) {
        this.addressLocality = addressLocality;
    }

    @JsonProperty("addressRegion")
    public String getAddressRegion() {
        return addressRegion;
    }

    @JsonProperty("addressRegion")
    public void setAddressRegion(String addressRegion) {
        this.addressRegion = addressRegion;
    }

    @JsonProperty("streetAddress")
    public String getStreetAddress() {
        return streetAddress;
    }

    @JsonProperty("streetAddress")
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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
