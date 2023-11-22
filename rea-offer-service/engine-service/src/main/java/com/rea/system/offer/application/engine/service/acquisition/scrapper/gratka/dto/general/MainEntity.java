
package com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.general;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@type",
    "name",
    "itemListElement"
})
@Generated("jsonschema2pojo")
public class MainEntity {

    @JsonProperty("@type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("itemListElement")
    private List<ItemListElement> itemListElement = null;
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

    @JsonProperty("itemListElement")
    public List<ItemListElement> getItemListElement() {
        return itemListElement;
    }

    @JsonProperty("itemListElement")
    public void setItemListElement(List<ItemListElement> itemListElement) {
        this.itemListElement = itemListElement;
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
