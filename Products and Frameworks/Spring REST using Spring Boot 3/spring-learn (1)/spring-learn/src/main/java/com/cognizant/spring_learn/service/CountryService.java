package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    public Country getCountry(String code) {

        // Load Spring XML configuration
        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        // Get country list bean from XML
        List<Country> countries =
                context.getBean("countryList", List.class);

        // Search country (case-insensitive)
        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        return null;
    }
}       