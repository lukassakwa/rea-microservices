
package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "reference",
    "priceTrend",
    "areaPriceTrend",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Statistics {

    @JsonProperty("reference")
    private Reference reference;
    @JsonProperty("priceTrend")
    private List<Object> priceTrend = null;
    @JsonProperty("areaPriceTrend")
    private List<Object> areaPriceTrend = null;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("reference")
    public Reference getReference() {
        return reference;
    }

    @JsonProperty("reference")
    public void setReference(Reference reference) {
        this.reference = reference;
    }

    @JsonProperty("priceTrend")
    public List<Object> getPriceTrend() {
        return priceTrend;
    }

    @JsonProperty("priceTrend")
    public void setPriceTrend(List<Object> priceTrend) {
        this.priceTrend = priceTrend;
    }

    @JsonProperty("areaPriceTrend")
    public List<Object> getAreaPriceTrend() {
        return areaPriceTrend;
    }

    @JsonProperty("areaPriceTrend")
    public void setAreaPriceTrend(List<Object> areaPriceTrend) {
        this.areaPriceTrend = areaPriceTrend;
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
