package com.visualnuts.exercice02;

import com.visualnuts.exceptions.VisualNutsException;
import com.visualnuts.exercice02.dto.CountryDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Exercice02Test {

    @Test
    public void doTest01() {
        List<CountryDTO> countries = Exercice02.getCountries();
        Assert.assertNotNull(countries);
        Assert.assertEquals(countries.isEmpty(), false);
        Assert.assertNotNull(countries.get(0));
    }

    @Test
    public void doTest02() {
        List<CountryDTO> countries = Exercice02.getCountries();
        Exercice02.verifyListCountriesEmpty(countries);
    }

    @Test(expected = VisualNutsException.class)
    public void doTest03() {
        Exercice02.verifyListCountriesEmpty(new ArrayList<>());
    }

    @Test(expected = VisualNutsException.class)
    public void doTest04() {
        Exercice02.verifyListCountriesEmpty(null);
    }

    @Test
    public void doTest05() {
        List<CountryDTO> countries = Exercice02.getCountries();
        Integer result = Exercice02.getNumberOfCountries(countries);
        Assert.assertNotNull(result);
    }

    @Test
    public void doTest06() {
        List<CountryDTO> countries = Exercice02.getCountries();
        CountryDTO result = Exercice02.getCountryByLanguage("de", countries);
        Assert.assertNotNull(result);
    }

    @Test(expected = VisualNutsException.class)
    public void doTest07() {
        List<CountryDTO> countries = Exercice02.getCountries();
        CountryDTO result = Exercice02.getCountryByLanguage("TESTE", countries);
        Assert.assertNotNull(result);
    }

    @Test
    public void doTest08() {
        List<CountryDTO> countries = Exercice02.getCountries();
        Map<String, Integer> result = Exercice02.countlanguagesCountries(countries);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.isEmpty(), false);
    }

    @Test
    public void doTest09() {
        List<CountryDTO> countries = Exercice02.getCountries();
        String result = Exercice02.getCountryByMoreLanguages(countries);
        Assert.assertNotNull(result);
    }

    @Test
    public void doTest10() {
        List<CountryDTO> countries = Exercice02.getCountries();
        Map<String, Integer> result = Exercice02.countLanguagesByCountries(countries);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.isEmpty(), false);
    }
}
