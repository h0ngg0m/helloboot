package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {
    @Autowired
    HelloRepository helloRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    void findHelloFailed() {
        assertThat(helloRepository.findHello("Spring")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("Spring")).isEqualTo(0);

        helloRepository.increaseCount("Spring");
        assertThat(helloRepository.countOf("Spring")).isEqualTo(1);

        helloRepository.increaseCount("Spring");
        assertThat(helloRepository.countOf("Spring")).isEqualTo(2);
    }
}
