
package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "date",
    "timeFrom",
    "timeTo",
    "__typename"
})
@Generated("jsonschema2pojo")
public class OpenDay {

    @JsonProperty("date")
    private Object date;
    @JsonProperty("timeFrom")
    private Object timeFrom;
    @JsonProperty("timeTo")
    private Object timeTo;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public Object getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(Object date) {
        this.date = date;
    }

    @JsonProperty("timeFrom")
    public Object getTimeFrom() {
        return timeFrom;
    }

    @JsonProperty("timeFrom")
    public void setTimeFrom(Object timeFrom) {
        this.timeFrom = timeFrom;
    }

    @JsonProperty("timeTo")
    public Object getTimeTo() {
        return timeTo;
    }

    @JsonProperty("timeTo")
    public void setTimeTo(Object timeTo) {
        this.timeTo = timeTo;
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
