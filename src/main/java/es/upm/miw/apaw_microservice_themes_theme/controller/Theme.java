package es.upm.miw.apaw_microservice_themes_theme.controller;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document
public class Theme {

    @Id
    private String id;

    private String reference;

    private LocalDateTime date;

    private String userId;

    private List<Vote> votes;

    public Theme(String reference, String userId) {
        this.reference = reference;
        this.userId = userId;
        this.date = LocalDateTime.now();
        this.votes = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public String getUserId() {
        return this.userId;
    }

    public List<Vote> getVotes() {
        return this.votes;
    }

}
