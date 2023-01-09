package com.visualnuts.exercice02.dto;

import java.io.Serializable;
import java.util.List;

public class CountryDTO implements Serializable {

    private String country;
    private List<String> languages;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}
