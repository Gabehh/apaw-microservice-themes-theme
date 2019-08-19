package es.upm.miw.apaw_microservice_themes_theme.exceptions;

public class BadGatewayException extends RuntimeException {
    private static final String DESCRIPTION = "Bad Gateway Exception (502)";

    public BadGatewayException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
