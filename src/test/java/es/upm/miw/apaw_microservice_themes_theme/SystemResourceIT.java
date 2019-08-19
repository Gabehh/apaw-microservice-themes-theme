package es.upm.miw.apaw_microservice_themes_theme;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ApiTestConfig
class SystemResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadVersion() {
        VersionDto versionDto = this.webTestClient
                .get().uri(SystemResource.SYSTEM + SystemResource.VERSION)
                .exchange()
                .expectStatus().isOk()
                .expectBody(VersionDto.class)
                .returnResult().getResponseBody();
        assertNotNull(versionDto.getVersion());
    }
}
