
package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "items",
    "isPriceHidden",
    "pagination",
    "facets",
    "__typename"
})
@Generated("jsonschema2pojo")
public class PaginatedUnits {

    @JsonProperty("items")
    private Object items;
    @JsonProperty("isPriceHidden")
    private Object isPriceHidden;
    @JsonProperty("pagination")
    private Object pagination;
    @JsonProperty("facets")
    private Object facets;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("items")
    public Object getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(Object items) {
        this.items = items;
    }

    @JsonProperty("isPriceHidden")
    public Object getIsPriceHidden() {
        return isPriceHidden;
    }

    @JsonProperty("isPriceHidden")
    public void setIsPriceHidden(Object isPriceHidden) {
        this.isPriceHidden = isPriceHidden;
    }

    @JsonProperty("pagination")
    public Object getPagination() {
        return pagination;
    }

    @JsonProperty("pagination")
    public void setPagination(Object pagination) {
        this.pagination = pagination;
    }

    @JsonProperty("facets")
    public Object getFacets() {
        return facets;
    }

    @JsonProperty("facets")
    public void setFacets(Object facets) {
        this.facets = facets;
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
