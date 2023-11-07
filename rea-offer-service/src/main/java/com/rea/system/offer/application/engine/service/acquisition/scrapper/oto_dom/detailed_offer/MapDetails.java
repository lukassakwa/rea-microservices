
package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "radius",
    "zoom",
    "__typename"
})
@Generated("jsonschema2pojo")
public class MapDetails {

    @JsonProperty("radius")
    private Integer radius;
    @JsonProperty("zoom")
    private Integer zoom;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("radius")
    public Integer getRadius() {
        return radius;
    }

    @JsonProperty("radius")
    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    @JsonProperty("zoom")
    public Integer getZoom() {
        return zoom;
    }

    @JsonProperty("zoom")
    public void setZoom(Integer zoom) {
        this.zoom = zoom;
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
