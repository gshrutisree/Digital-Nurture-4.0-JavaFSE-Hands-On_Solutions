package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);

        testGetAllCountries();
        testAddCountry();
        testFindCountryByCode("ZZ");
        testUpdateCountry();
        testSearchCountriesByName("land");
        testDeleteCountry();
        testFindCountryByCodeIndia(); 
        testAddCountryNew(); 
        testUpdateCountryNew(); 
        testDeleteAddedCountry();



    }

    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("All countries: {}", countries);
        LOGGER.info("End");
    }

    private static void testFindCountryByCode(String code) {
        try {
            Country country = countryService.findCountryByCode(code);
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
    }

    private static void testAddCountry() {
        Country newCountry = new Country();
        newCountry.setCode("ZZ");
        newCountry.setName("Testland");
        countryService.addCountry(newCountry);
        LOGGER.info("Country added: {}", newCountry);
    }

    private static void testUpdateCountry() {
        try {
            countryService.updateCountry("ZZ", "Updated Testland");
            LOGGER.info("Country updated.");
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error updating country: {}", e.getMessage());
        }
    }

    private static void testDeleteCountry() {
        try {
            countryService.deleteCountry("ZZ");
            LOGGER.info("Country deleted.");
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error deleting country: {}", e.getMessage());
        }
    }

    private static void testSearchCountriesByName(String keyword) {
        List<Country> results = countryService.searchCountriesByPartialName(keyword);
        LOGGER.debug("Search results for '{}': {}", keyword, results);
    }

    private static void testFindCountryByCodeIndia() {
        try {
            LOGGER.info("Start");
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
            LOGGER.info("End");
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
    }
    private static void testAddCountryNew() {
    Country newCountry = new Country();
    newCountry.setCode("XY");
    newCountry.setName("NewTestCountry");

    countryService.addCountry(newCountry);
    LOGGER.info(" New Country added: {}", newCountry);

    try {
        Country foundCountry = countryService.findCountryByCode("XY");
        LOGGER.info("Found added Country: {}", foundCountry);
    } catch (CountryNotFoundException e) {
        LOGGER.error(" Country not found after add: {}", e.getMessage());
    }
}

private static void testDeleteAddedCountry() {
    try {
        LOGGER.info(" Deleting test country 'XY'...");
        countryService.deleteCountry("XY");
        LOGGER.info(" Country 'XY' deleted.");

        
        try {
            countryService.findCountryByCode("XY");
        } catch (CountryNotFoundException e) {
            LOGGER.info(" Confirmed: Country 'XY' no longer exists.");
        }

    } catch (CountryNotFoundException e) {
        LOGGER.error(" Error deleting country: {}", e.getMessage());
    }
}

private static void testUpdateCountryNew() {
    try {
        LOGGER.info(" Starting update test...");
        countryService.updateCountry("IN", "Bharat");
        LOGGER.info(" Country updated to new name.");

        Country updated = countryService.findCountryByCode("IN");
        LOGGER.info(" Fetched after update: {}", updated);

    } catch (CountryNotFoundException e) {
        LOGGER.error("Error updating country: {}", e.getMessage());
    }
}


}
