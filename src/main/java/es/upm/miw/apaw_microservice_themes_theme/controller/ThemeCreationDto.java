package es.upm.miw.apaw_microservice_themes_theme.controller;

import es.upm.miw.apaw_microservice_themes_theme.exceptions.BadRequestException;

public class ThemeCreationDto {

    private String reference;

    private String userId;

    public ThemeCreationDto() {
        // Empty for framework
    }

    public ThemeCreationDto(String reference, String userId) {
        this.reference = reference;
        this.userId = userId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void validate() {
        if (this.reference == null || this.reference.isEmpty() || this.userId == null || this.userId.isEmpty()) {
            throw new BadRequestException("Incomplete ThemeCreationDto");
        }
    }

    @Override
    public String toString() {
        return "ThemeCreationDto{" +
                "reference='" + reference + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

}
