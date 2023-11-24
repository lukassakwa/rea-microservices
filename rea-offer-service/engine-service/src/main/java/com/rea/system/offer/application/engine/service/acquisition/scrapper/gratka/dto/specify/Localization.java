package com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka.dto.specify;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lokalizacja_ulica",
        "lokalizacja_szerokosc-geograficzna-y",
        "lokalizacja_region",
        "lokalizacja_powiat",
        "lokalizacja_miejscowosc",
        "lokalizacja_kraj",
        "lokalizacja_gmina",
        "lokalizacja_dzielnica",
        "lokalizacja_dlugosc-geograficzna-x"
})
@Generated("jsonschema2pojo")
public class Localization {

    @JsonProperty("lokalizacja_ulica")
    private String lokalizacjaUlica;
    @JsonProperty("lokalizacja_szerokosc-geograficzna-y")
    private Double lokalizacjaSzerokoscGeograficznaY;
    @JsonProperty("lokalizacja_region")
    private String lokalizacjaRegion;
    @JsonProperty("lokalizacja_powiat")
    private String lokalizacjaPowiat;
    @JsonProperty("lokalizacja_miejscowosc")
    private String lokalizacjaMiejscowosc;
    @JsonProperty("lokalizacja_kraj")
    private String lokalizacjaKraj;
    @JsonProperty("lokalizacja_gmina")
    private String lokalizacjaGmina;
    @JsonProperty("lokalizacja_dzielnica")
    private String lokalizacjaDzielnica;
    @JsonProperty("lokalizacja_dlugosc-geograficzna-x")
    private Double lokalizacjaDlugoscGeograficznaX;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("lokalizacja_ulica")
    public String getLokalizacjaUlica() {
        return lokalizacjaUlica;
    }

    @JsonProperty("lokalizacja_ulica")
    public void setLokalizacjaUlica(String lokalizacjaUlica) {
        this.lokalizacjaUlica = lokalizacjaUlica;
    }

    @JsonProperty("lokalizacja_szerokosc-geograficzna-y")
    public Double getLokalizacjaSzerokoscGeograficznaY() {
        return lokalizacjaSzerokoscGeograficznaY;
    }

    @JsonProperty("lokalizacja_szerokosc-geograficzna-y")
    public void setLokalizacjaSzerokoscGeograficznaY(Double lokalizacjaSzerokoscGeograficznaY) {
        this.lokalizacjaSzerokoscGeograficznaY = lokalizacjaSzerokoscGeograficznaY;
    }

    @JsonProperty("lokalizacja_region")
    public String getLokalizacjaRegion() {
        return lokalizacjaRegion;
    }

    @JsonProperty("lokalizacja_region")
    public void setLokalizacjaRegion(String lokalizacjaRegion) {
        this.lokalizacjaRegion = lokalizacjaRegion;
    }

    @JsonProperty("lokalizacja_powiat")
    public String getLokalizacjaPowiat() {
        return lokalizacjaPowiat;
    }

    @JsonProperty("lokalizacja_powiat")
    public void setLokalizacjaPowiat(String lokalizacjaPowiat) {
        this.lokalizacjaPowiat = lokalizacjaPowiat;
    }

    @JsonProperty("lokalizacja_miejscowosc")
    public String getLokalizacjaMiejscowosc() {
        return lokalizacjaMiejscowosc;
    }

    @JsonProperty("lokalizacja_miejscowosc")
    public void setLokalizacjaMiejscowosc(String lokalizacjaMiejscowosc) {
        this.lokalizacjaMiejscowosc = lokalizacjaMiejscowosc;
    }

    @JsonProperty("lokalizacja_kraj")
    public String getLokalizacjaKraj() {
        return lokalizacjaKraj;
    }

    @JsonProperty("lokalizacja_kraj")
    public void setLokalizacjaKraj(String lokalizacjaKraj) {
        this.lokalizacjaKraj = lokalizacjaKraj;
    }

    @JsonProperty("lokalizacja_gmina")
    public String getLokalizacjaGmina() {
        return lokalizacjaGmina;
    }

    @JsonProperty("lokalizacja_gmina")
    public void setLokalizacjaGmina(String lokalizacjaGmina) {
        this.lokalizacjaGmina = lokalizacjaGmina;
    }

    @JsonProperty("lokalizacja_dzielnica")
    public String getLokalizacjaDzielnica() {
        return lokalizacjaDzielnica;
    }

    @JsonProperty("lokalizacja_dzielnica")
    public void setLokalizacjaDzielnica(String lokalizacjaDzielnica) {
        this.lokalizacjaDzielnica = lokalizacjaDzielnica;
    }

    @JsonProperty("lokalizacja_dlugosc-geograficzna-x")
    public Double getLokalizacjaDlugoscGeograficznaX() {
        return lokalizacjaDlugoscGeograficznaX;
    }

    @JsonProperty("lokalizacja_dlugosc-geograficzna-x")
    public void setLokalizacjaDlugoscGeograficznaX(Double lokalizacjaDlugoscGeograficznaX) {
        this.lokalizacjaDlugoscGeograficznaX = lokalizacjaDlugoscGeograficznaX;
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
