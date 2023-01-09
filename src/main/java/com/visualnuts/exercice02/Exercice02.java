package com.visualnuts.exercice02;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.visualnuts.exceptions.VisualNutsException;
import com.visualnuts.exercice02.dto.CountryDTO;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Exercice02 {

    /**
     * Method responsible for execution exercice 2
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Begin execution exercice two...");

        List<CountryDTO> countries = getCountries();

        verifyListCountriesEmpty(countries);

        System.out.println("Number of countriws: " + getNumberOfCountries(countries));

        System.out.println("Country by language 'de': " + getCountryByLanguage("de", countries).getCountry());

        System.out.println("Count countries by language: " + countlanguagesCountries(countries));

        System.out.println("Country with greater number of languages: " + getCountryByMoreLanguages(countries));

        System.out.println("Get languages more commom in all countries: " + countLanguagesByCountries(countries));

        System.out.println("Finish execution exercice two...");
    }

    /**
     * Method responsible for to get json file and extract list of countries
     * @return
     */
    public static List<CountryDTO> getCountries() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        List<CountryDTO> countries = null;

        TypeReference<List<CountryDTO>> typeReference = new TypeReference<List<CountryDTO>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
        try {
            countries = mapper.readValue(inputStream,typeReference);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }

    /**
     * Method responsible for to verify if list is null or empty
     * @param countries
     */
    public static void verifyListCountriesEmpty(List<CountryDTO> countries) {
        if (Objects.isNull(countries) || countries.isEmpty()) {
            throw new VisualNutsException("List of countries empty");
        }
    }

    /**
     * Methos responsible for to return count of countries
     * @param countries
     * @return
     */
    public static int getNumberOfCountries(List<CountryDTO> countries) {
        return countries.size();
    }

    /**
     * Methof responsible for to get a country by language
     * @param language
     * @param countries
     * @return
     */
    public static CountryDTO getCountryByLanguage(String language, List<CountryDTO> countries) {
        return countries
                .stream()
                .filter(country -> country.getLanguages().stream().filter(lang -> lang.equals(language)).count() > 0)
                .findFirst()
                .orElseThrow(() -> new VisualNutsException("Country not found by language " + language));
    }

    /**
     *Method responsible for to count languages by same country
     * @param countries
     * @return
     */
    public static Map<String, Integer> countlanguagesCountries(List<CountryDTO> countries) {
        Map<String, Integer> map = new HashMap<>();
        for (CountryDTO country : countries) {
            map.put(country.getCountry(), country.getLanguages().size());
        }
        return map;
    }

    /**
     * Method responsible for to return the country with more official languages
     * @param countries
     * @return
     */
    public static String getCountryByMoreLanguages(List<CountryDTO> countries) {
        Map<String, Integer> map = countlanguagesCountries(countries);
        int max = 0;
        String name = "";
        for (String key : map.keySet()) {
            if (map.get(key).intValue() > max) {
                name = key;
                max = map.get(key).intValue();
            }
        }
        return name;
    }

    /**
     * Mthod responsible for to return the count languages of same country
     * @param countries
     * @return
     */
    public static Map<String, Integer> countLanguagesByCountries(List<CountryDTO> countries) {
        Map<String, Integer> map = new HashMap<>();
        for (CountryDTO country : countries) {
            for (String lang : country.getLanguages()) {
                if (map.containsKey(lang)) {
                    map.replace(lang, map.get(lang).intValue() + 1);
                } else {
                    map.put(lang, 1);
                }
            }
        }

        return map;
    }
}
