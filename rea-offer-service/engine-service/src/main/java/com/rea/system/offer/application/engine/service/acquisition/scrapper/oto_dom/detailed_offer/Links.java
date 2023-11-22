
package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "localPlanUrl",
    "videoUrl",
    "view3dUrl",
    "walkaroundUrl",
    "__typename"
})
@Generated("jsonschema2pojo")
public class Links {

    @JsonProperty("localPlanUrl")
    private String localPlanUrl;
    @JsonProperty("videoUrl")
    private String videoUrl;
    @JsonProperty("view3dUrl")
    private String view3dUrl;
    @JsonProperty("walkaroundUrl")
    private String walkaroundUrl;
    @JsonProperty("__typename")
    private String typename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("localPlanUrl")
    public String getLocalPlanUrl() {
        return localPlanUrl;
    }

    @JsonProperty("localPlanUrl")
    public void setLocalPlanUrl(String localPlanUrl) {
        this.localPlanUrl = localPlanUrl;
    }

    @JsonProperty("videoUrl")
    public String getVideoUrl() {
        return videoUrl;
    }

    @JsonProperty("videoUrl")
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @JsonProperty("view3dUrl")
    public String getView3dUrl() {
        return view3dUrl;
    }

    @JsonProperty("view3dUrl")
    public void setView3dUrl(String view3dUrl) {
        this.view3dUrl = view3dUrl;
    }

    @JsonProperty("walkaroundUrl")
    public String getWalkaroundUrl() {
        return walkaroundUrl;
    }

    @JsonProperty("walkaroundUrl")
    public void setWalkaroundUrl(String walkaroundUrl) {
        this.walkaroundUrl = walkaroundUrl;
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
