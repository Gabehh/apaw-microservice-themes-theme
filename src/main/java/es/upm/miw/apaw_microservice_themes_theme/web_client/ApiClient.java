package es.upm.miw.apaw_microservice_themes_theme.web_client;

import es.upm.miw.apaw_microservice_themes_theme.exceptions.BadGatewayException;
import es.upm.miw.apaw_microservice_themes_theme.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiClient {

    private WebClient.Builder webClientBuilder;

    @Autowired
    public ApiClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public void validateUserIdAssured(String userId) {
        webClientBuilder.build()
                .get()
                .uri("https://apaw-microservice-themes-user.herokuapp.com/users/" + userId + "/nick")
                .exchange()
                .onErrorResume(exception ->
                        Mono.error(new BadGatewayException("Unexpected error: Users API. " + exception.getMessage())))
                .flatMap(response -> {
                    if (HttpStatus.NOT_FOUND.equals(response.statusCode())) {
                        return Mono.error(new NotFoundException("User id: " + userId));
                    } else if (response.statusCode().isError()) {
                        return Mono.error(new BadGatewayException("Unexpected error: Users API."));
                    } else {
                        return response.bodyToMono(Object.class);
                    }
                })
                .block();
    }
}
