package es.upm.miw.apaw_microservice_themes_theme.controller;

import es.upm.miw.apaw_microservice_themes_theme.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ThemeResource.THEMES)
public class ThemeResource {

    static final String THEMES = "/themes";
    static final String ID_ID = "/{id}";
    static final String VOTES = "/votes";
    static final String AVERAGE = "/overage";
    static final String SEARCH = "/search";

    private ThemeBusinessController themeBusinessController;

    @Autowired
    public ThemeResource(ThemeBusinessController themeBusinessController) {
        this.themeBusinessController = themeBusinessController;
    }

    @PostMapping
    public ThemeBasicDto create(@RequestBody ThemeCreationDto themeCreationDto) {
        themeCreationDto.validate();
        return this.themeBusinessController.create(themeCreationDto);
    }

    @PostMapping(value = ID_ID + VOTES)
    public void createVote(@PathVariable String id, @RequestBody VoteDto voteDto) {
        voteDto.validate();
        this.themeBusinessController.createVote(id, voteDto.getVote());
    }

    @GetMapping(value = ID_ID + AVERAGE)
    public AverageDto readAverage(@PathVariable String id) {
        return this.themeBusinessController.processAverage(id);
    }

    @GetMapping(value = SEARCH)
    public List<ThemeBasicDto> find(@RequestParam String q) {
        if (!"average".equals(q.split(":>=")[0])) {
            throw new BadRequestException("query param q is incorrect, missing 'average:>='");
        }
        return this.themeBusinessController.findByAverageGreaterThanEqual(Double.valueOf(q.split(":>=")[1]));
    }
}
