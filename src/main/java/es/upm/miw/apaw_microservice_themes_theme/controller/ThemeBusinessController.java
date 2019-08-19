package es.upm.miw.apaw_microservice_themes_theme.controller;

import es.upm.miw.apaw_microservice_themes_theme.exceptions.NotFoundException;
import es.upm.miw.apaw_microservice_themes_theme.web_client.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ThemeBusinessController {

    private ThemeDao themeDao;

    private ApiClient apiClient;

    @Autowired
    public ThemeBusinessController(ThemeDao themeDao, ApiClient apiClient) {
        this.themeDao = themeDao;
        this.apiClient = apiClient;
    }

    public ThemeBasicDto create(ThemeCreationDto themeCreationDto) {
        this.apiClient.validateUserIdAssured(themeCreationDto.getUserId());
        Theme theme = new Theme(themeCreationDto.getReference(), themeCreationDto.getUserId());
        this.themeDao.save(theme);
        return new ThemeBasicDto(theme);
    }

    public void createVote(String id, Integer vote) {
        Theme theme = this.findThemeByIdAssured(id);
        theme.getVotes().add(new Vote(vote));
        this.themeDao.save(theme);
    }

    private Theme findThemeByIdAssured(String id) {
        return this.themeDao.findById(id).orElseThrow(() -> new NotFoundException("Theme id: " + id));
    }


    public AverageDto processAverage(String id) {
        Theme theme = this.findThemeByIdAssured(id);
        return new AverageDto(this.average(theme));
    }

    private Double average(Theme theme) {
        return theme.getVotes().stream().mapToDouble(Vote::getValue).average().orElse(Double.NaN);
    }

    public List<ThemeBasicDto> findByAverageGreaterThanEqual(Double value) {
        return this.themeDao.findAll().stream()
                .filter(theme -> this.average(theme) >= value)
                .map(ThemeBasicDto::new)
                .collect(Collectors.toList());
    }
}
