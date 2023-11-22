
package com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.specify;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "typ_strony",
    "kat_glowna",
    "podkategoria",
    "kat_pelna",
    "miejscowosc",
    "region",
    "typ_oferty",
    "rynek",
    "powierzchnia_m2",
    "id_oferty",
    "cena",
    "pkt_wyr",
    "fdo"
})
@Generated("jsonschema2pojo")
public class GratkaMainOffer {

    @JsonProperty("typ_strony")
    private String typStrony;
    @JsonProperty("kat_glowna")
    private String katGlowna;
    @JsonProperty("podkategoria")
    private String podkategoria;
    @JsonProperty("kat_pelna")
    private String katPelna;
    @JsonProperty("miejscowosc")
    private String miejscowosc;
    @JsonProperty("region")
    private String region;
    @JsonProperty("typ_oferty")
    private String typOferty;
    @JsonProperty("rynek")
    private String rynek;
    @JsonProperty("powierzchnia_m2")
    private String powierzchniaM2;
    @JsonProperty("id_oferty")
    private Integer idOferty;
    @JsonProperty("cena")
    private Integer cena;
    @JsonProperty("pkt_wyr")
    private Integer pktWyr;
    @JsonProperty("fdo")
    private String fdo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("typ_strony")
    public String getTypStrony() {
        return typStrony;
    }

    @JsonProperty("typ_strony")
    public void setTypStrony(String typStrony) {
        this.typStrony = typStrony;
    }

    @JsonProperty("kat_glowna")
    public String getKatGlowna() {
        return katGlowna;
    }

    @JsonProperty("kat_glowna")
    public void setKatGlowna(String katGlowna) {
        this.katGlowna = katGlowna;
    }

    @JsonProperty("podkategoria")
    public String getPodkategoria() {
        return podkategoria;
    }

    @JsonProperty("podkategoria")
    public void setPodkategoria(String podkategoria) {
        this.podkategoria = podkategoria;
    }

    @JsonProperty("kat_pelna")
    public String getKatPelna() {
        return katPelna;
    }

    @JsonProperty("kat_pelna")
    public void setKatPelna(String katPelna) {
        this.katPelna = katPelna;
    }

    @JsonProperty("miejscowosc")
    public String getMiejscowosc() {
        return miejscowosc;
    }

    @JsonProperty("miejscowosc")
    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("typ_oferty")
    public String getTypOferty() {
        return typOferty;
    }

    @JsonProperty("typ_oferty")
    public void setTypOferty(String typOferty) {
        this.typOferty = typOferty;
    }

    @JsonProperty("rynek")
    public String getRynek() {
        return rynek;
    }

    @JsonProperty("rynek")
    public void setRynek(String rynek) {
        this.rynek = rynek;
    }

    @JsonProperty("powierzchnia_m2")
    public String getPowierzchniaM2() {
        return powierzchniaM2;
    }

    @JsonProperty("powierzchnia_m2")
    public void setPowierzchniaM2(String powierzchniaM2) {
        this.powierzchniaM2 = powierzchniaM2;
    }

    @JsonProperty("id_oferty")
    public Integer getIdOferty() {
        return idOferty;
    }

    @JsonProperty("id_oferty")
    public void setIdOferty(Integer idOferty) {
        this.idOferty = idOferty;
    }

    @JsonProperty("cena")
    public Integer getCena() {
        return cena;
    }

    @JsonProperty("cena")
    public void setCena(Integer cena) {
        this.cena = cena;
    }

    @JsonProperty("pkt_wyr")
    public Integer getPktWyr() {
        return pktWyr;
    }

    @JsonProperty("pkt_wyr")
    public void setPktWyr(Integer pktWyr) {
        this.pktWyr = pktWyr;
    }

    @JsonProperty("fdo")
    public String getFdo() {
        return fdo;
    }

    @JsonProperty("fdo")
    public void setFdo(String fdo) {
        this.fdo = fdo;
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
