package es.upm.miw.apaw_microservice_themes_theme.controller;

import es.upm.miw.apaw_microservice_themes_theme.exceptions.BadRequestException;

public class VoteDto {
    private Integer vote;

    public VoteDto() {
        // Empty for framework
    }

    public VoteDto(Integer vote) {
        this.vote = vote;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public void validate() {
        if (this.vote == null || this.vote < 0 || this.vote > 10) {
            throw new BadRequestException("Incomplete VoteDto or out of range");
        }
    }

    @Override
    public String toString() {
        return "VoteDto{" +
                "vote=" + vote +
                '}';
    }

}
