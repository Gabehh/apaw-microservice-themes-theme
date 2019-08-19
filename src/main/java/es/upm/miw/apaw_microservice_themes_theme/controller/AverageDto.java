package es.upm.miw.apaw_microservice_themes_theme.controller;

public class AverageDto {

    private Double average;

    public AverageDto() {
        // empty for framework
    }

    public AverageDto(Double average) {
        this.average = average;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "AverageDto{" +
                "average=" + average +
                '}';
    }
}
