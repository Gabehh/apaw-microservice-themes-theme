package es.upm.miw.apaw_microservice_themes_theme.controller;

import es.upm.miw.apaw_microservice_themes_theme.exceptions.BadRequestException;

public class UserCreationDto {

    private String nick;

    private String email;

    private String country;

    private String city;

    private String street;

    public UserCreationDto(String nick, String email, String country, String city, String street) {
        this.nick = nick;
        this.email = email;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void validate() {
        if (this.nick == null || this.nick.isEmpty() || this.email == null || this.email.isEmpty()
                || this.country == null || this.country.isEmpty()) {
            throw new BadRequestException("Incomplete UserCreationDto");
        }
    }

    @Override
    public String toString() {
        return "UserCreationDto{" +
                "nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
