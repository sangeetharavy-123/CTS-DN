package com.cognizant.spring_learn;

public class Country {

    private String code;
    private String name;

    // Default constructor
    public Country() {
    }

    // Parameterized constructor (optional but useful)
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getter and Setter for code
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}