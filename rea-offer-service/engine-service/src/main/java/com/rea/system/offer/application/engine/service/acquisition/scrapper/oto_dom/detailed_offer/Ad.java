
package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom.detailed_offer;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "publicId",
    "slug",
    "advertiserType",
    "advertType",
    "createdAt",
    "modifiedAt",
    "description",
    "developmentId",
    "developmentTitle",
    "developmentUrl",
    "exclusiveOffer",
    "externalId",
    "features",
    "featuresByCategory",
    "featuresWithoutCategory",
    "openDay",
    "referenceId",
    "target",
    "title",
    "topInformation",
    "additionalInformation",
    "url",
    "status",
    "category",
    "characteristics",
    "images",
    "links",
    "location",
    "statistics",
    "owner",
    "agency",
    "seo",
    "breadcrumbs",
    "userAdverts",
    "paginatedUnits",
    "specialOffer",
    "__typename",
    "contactDetails"
})
@Generated("jsonschema2pojo")
public class Ad {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("publicId")
    private String publicId;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("advertiserType")
    private String advertiserType;
    @JsonProperty("advertType")
    private String advertType;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("modifiedAt")
    private String modifiedAt;
    @JsonProperty("description")
    private String description;
    @JsonProperty("developmentId")
    private Integer developmentId;
    @JsonProperty("developmentTitle")
    private String developmentTitle;
    @JsonProperty("developmentUrl")
    private String developmentUrl;
    @JsonProperty("exclusiveOffer")
    private Boolean exclusiveOffer;
    @JsonProperty("externalId")
    private String externalId;
    @JsonProperty("features")
    private List<String> features = null;
    @JsonProperty("featuresByCategory")
    private List<FeaturesByCategory> featuresByCategory = null;
    @JsonProperty("featuresWithoutCategory")
    private List<Object> featuresWithoutCategory = null;
    @JsonProperty("openDay")
    private OpenDay openDay;
    @JsonProperty("referenceId")
    private String referenceId;
    @JsonProperty("target")
    private Target target;
    @JsonProperty("title")
    private String title;
    @JsonProperty("topInformation")
    private List<TopInformation> topInformation = null;
    @JsonProperty("additionalInformation")
    private List<AdditionalInformation> additionalInformation = null;
    @JsonProperty("url")
    private String url;
    @JsonProperty("status")
    private String status;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("characteristics")
    private List<Characteristic> characteristics = null;
    @JsonProperty("images")
    private List<Image> images = null;
    @JsonProperty("links")
    private Links links;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("statistics")
    private Statistics statistics;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("agency")
    private Agency agency;
    @JsonProperty("seo")
    private Seo seo;
    @JsonProperty("breadcrumbs")
    private List<Breadcrumb> breadcrumbs = null;
    @JsonProperty("userAdverts")
    private List<UserAdvert> userAdverts = null;
    @JsonProperty("paginatedUnits")
    private PaginatedUnits paginatedUnits;
    @JsonProperty("specialOffer")
    private Object specialOffer;
    @JsonProperty("__typename")
    private String typename;
    @JsonProperty("contactDetails")
    private ContactDetails contactDetails;
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

    @JsonProperty("publicId")
    public String getPublicId() {
        return publicId;
    }

    @JsonProperty("publicId")
    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("advertiserType")
    public String getAdvertiserType() {
        return advertiserType;
    }

    @JsonProperty("advertiserType")
    public void setAdvertiserType(String advertiserType) {
        this.advertiserType = advertiserType;
    }

    @JsonProperty("advertType")
    public String getAdvertType() {
        return advertType;
    }

    @JsonProperty("advertType")
    public void setAdvertType(String advertType) {
        this.advertType = advertType;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("modifiedAt")
    public String getModifiedAt() {
        return modifiedAt;
    }

    @JsonProperty("modifiedAt")
    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("developmentId")
    public Integer getDevelopmentId() {
        return developmentId;
    }

    @JsonProperty("developmentId")
    public void setDevelopmentId(Integer developmentId) {
        this.developmentId = developmentId;
    }

    @JsonProperty("developmentTitle")
    public String getDevelopmentTitle() {
        return developmentTitle;
    }

    @JsonProperty("developmentTitle")
    public void setDevelopmentTitle(String developmentTitle) {
        this.developmentTitle = developmentTitle;
    }

    @JsonProperty("developmentUrl")
    public String getDevelopmentUrl() {
        return developmentUrl;
    }

    @JsonProperty("developmentUrl")
    public void setDevelopmentUrl(String developmentUrl) {
        this.developmentUrl = developmentUrl;
    }

    @JsonProperty("exclusiveOffer")
    public Boolean getExclusiveOffer() {
        return exclusiveOffer;
    }

    @JsonProperty("exclusiveOffer")
    public void setExclusiveOffer(Boolean exclusiveOffer) {
        this.exclusiveOffer = exclusiveOffer;
    }

    @JsonProperty("externalId")
    public String getExternalId() {
        return externalId;
    }

    @JsonProperty("externalId")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @JsonProperty("features")
    public List<String> getFeatures() {
        return features;
    }

    @JsonProperty("features")
    public void setFeatures(List<String> features) {
        this.features = features;
    }

    @JsonProperty("featuresByCategory")
    public List<FeaturesByCategory> getFeaturesByCategory() {
        return featuresByCategory;
    }

    @JsonProperty("featuresByCategory")
    public void setFeaturesByCategory(List<FeaturesByCategory> featuresByCategory) {
        this.featuresByCategory = featuresByCategory;
    }

    @JsonProperty("featuresWithoutCategory")
    public List<Object> getFeaturesWithoutCategory() {
        return featuresWithoutCategory;
    }

    @JsonProperty("featuresWithoutCategory")
    public void setFeaturesWithoutCategory(List<Object> featuresWithoutCategory) {
        this.featuresWithoutCategory = featuresWithoutCategory;
    }

    @JsonProperty("openDay")
    public OpenDay getOpenDay() {
        return openDay;
    }

    @JsonProperty("openDay")
    public void setOpenDay(OpenDay openDay) {
        this.openDay = openDay;
    }

    @JsonProperty("referenceId")
    public String getReferenceId() {
        return referenceId;
    }

    @JsonProperty("referenceId")
    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    @JsonProperty("target")
    public Target getTarget() {
        return target;
    }

    @JsonProperty("target")
    public void setTarget(Target target) {
        this.target = target;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("topInformation")
    public List<TopInformation> getTopInformation() {
        return topInformation;
    }

    @JsonProperty("topInformation")
    public void setTopInformation(List<TopInformation> topInformation) {
        this.topInformation = topInformation;
    }

    @JsonProperty("additionalInformation")
    public List<AdditionalInformation> getAdditionalInformation() {
        return additionalInformation;
    }

    @JsonProperty("additionalInformation")
    public void setAdditionalInformation(List<AdditionalInformation> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("characteristics")
    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    @JsonProperty("characteristics")
    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    @JsonProperty("links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(Links links) {
        this.links = links;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("statistics")
    public Statistics getStatistics() {
        return statistics;
    }

    @JsonProperty("statistics")
    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @JsonProperty("agency")
    public Agency getAgency() {
        return agency;
    }

    @JsonProperty("agency")
    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @JsonProperty("seo")
    public Seo getSeo() {
        return seo;
    }

    @JsonProperty("seo")
    public void setSeo(Seo seo) {
        this.seo = seo;
    }

    @JsonProperty("breadcrumbs")
    public List<Breadcrumb> getBreadcrumbs() {
        return breadcrumbs;
    }

    @JsonProperty("breadcrumbs")
    public void setBreadcrumbs(List<Breadcrumb> breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
    }

    @JsonProperty("userAdverts")
    public List<UserAdvert> getUserAdverts() {
        return userAdverts;
    }

    @JsonProperty("userAdverts")
    public void setUserAdverts(List<UserAdvert> userAdverts) {
        this.userAdverts = userAdverts;
    }

    @JsonProperty("paginatedUnits")
    public PaginatedUnits getPaginatedUnits() {
        return paginatedUnits;
    }

    @JsonProperty("paginatedUnits")
    public void setPaginatedUnits(PaginatedUnits paginatedUnits) {
        this.paginatedUnits = paginatedUnits;
    }

    @JsonProperty("specialOffer")
    public Object getSpecialOffer() {
        return specialOffer;
    }

    @JsonProperty("specialOffer")
    public void setSpecialOffer(Object specialOffer) {
        this.specialOffer = specialOffer;
    }

    @JsonProperty("__typename")
    public String getTypename() {
        return typename;
    }

    @JsonProperty("__typename")
    public void setTypename(String typename) {
        this.typename = typename;
    }

    @JsonProperty("contactDetails")
    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    @JsonProperty("contactDetails")
    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
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
