
package com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.general;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@context",
    "@type",
    "url",
    "mainEntity"
})
@Generated("jsonschema2pojo")
public class GratkaSimpleOffer {

    @JsonProperty("@context")
    private String context;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("url")
    private String url;
    @JsonProperty("mainEntity")
    private MainEntity mainEntity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("@context")
    public String getContext() {
        return context;
    }

    @JsonProperty("@context")
    public void setContext(String context) {
        this.context = context;
    }

    @JsonProperty("@type")
    public String getType() {
        return type;
    }

    @JsonProperty("@type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("mainEntity")
    public MainEntity getMainEntity() {
        return mainEntity;
    }

    @JsonProperty("mainEntity")
    public void setMainEntity(MainEntity mainEntity) {
        this.mainEntity = mainEntity;
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
