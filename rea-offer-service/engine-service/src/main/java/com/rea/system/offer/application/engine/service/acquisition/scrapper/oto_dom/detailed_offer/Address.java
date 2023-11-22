
package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "street",
    "subdistrict",
    "district",
    "city",
    "municipality",
    "county",
    "province",
    "postalCode",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Address {

    @JsonProperty("street")
    private Street street;
    @JsonProperty("subdistrict")
    private Object subdistrict;
    @JsonProperty("district")
    private District district;
    @JsonProperty("city")
    private City city;
    @JsonProperty("municipality")
    private Object municipality;
    @JsonProperty("county")
    private County county;
    @JsonProperty("province")
    private Province province;
    @JsonProperty("postalCode")
    private Object postalCode;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("street")
    public Street getStreet() {
        return street;
    }

    @JsonProperty("street")
    public void setStreet(Street street) {
        this.street = street;
    }

    @JsonProperty("subdistrict")
    public Object getSubdistrict() {
        return subdistrict;
    }

    @JsonProperty("subdistrict")
    public void setSubdistrict(Object subdistrict) {
        this.subdistrict = subdistrict;
    }

    @JsonProperty("district")
    public District getDistrict() {
        return district;
    }

    @JsonProperty("district")
    public void setDistrict(District district) {
        this.district = district;
    }

    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }

    @JsonProperty("municipality")
    public Object getMunicipality() {
        return municipality;
    }

    @JsonProperty("municipality")
    public void setMunicipality(Object municipality) {
        this.municipality = municipality;
    }

    @JsonProperty("county")
    public County getCounty() {
        return county;
    }

    @JsonProperty("county")
    public void setCounty(County county) {
        this.county = county;
    }

    @JsonProperty("province")
    public Province getProvince() {
        return province;
    }

    @JsonProperty("province")
    public void setProvince(Province province) {
        this.province = province;
    }

    @JsonProperty("postalCode")
    public Object getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postalCode")
    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
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
