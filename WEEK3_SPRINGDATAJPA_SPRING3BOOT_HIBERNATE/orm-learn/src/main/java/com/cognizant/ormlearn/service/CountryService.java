package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country with code " + countryCode + " not found");
        }
        return result.get();
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {
        Optional<Country> optionalCountry = countryRepository.findById(code);
        if (!optionalCountry.isPresent()) {
            throw new CountryNotFoundException("Country with code " + code + " not found");
        }
        Country country = optionalCountry.get();
        country.setName(name);
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) throws CountryNotFoundException {
        Optional<Country> optionalCountry = countryRepository.findById(code);
        if (!optionalCountry.isPresent()) {
            throw new CountryNotFoundException("Country with code " + code + " not found");
        }
        countryRepository.deleteById(code);
    }

    public List<Country> searchCountriesByPartialName(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }
}
