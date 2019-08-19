package es.upm.miw.apaw_microservice_themes_theme.exceptions;

public class ConflictException extends RuntimeException {
    private static final String DESCRIPTION = "Conflict Exception (409)";

    public ConflictException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
