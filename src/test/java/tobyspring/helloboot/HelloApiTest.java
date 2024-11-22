package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HelloApiTest {

    @Test
    void helloApi() {
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> result = rest.getForEntity("http://localhost:8080/app/hello?name={name}", String.class, "Spring");

        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(result.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).contains("text/plain");
        Assertions.assertThat(result.getBody()).isEqualTo("*Hello Spring*");
    }
}
