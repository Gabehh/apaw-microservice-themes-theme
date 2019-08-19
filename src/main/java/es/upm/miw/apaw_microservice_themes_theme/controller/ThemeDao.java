package es.upm.miw.apaw_microservice_themes_theme.controller;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ThemeDao extends MongoRepository<Theme, String> {
}
