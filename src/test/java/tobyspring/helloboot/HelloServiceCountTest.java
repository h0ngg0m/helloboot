package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

@HellobootTest
public class HelloServiceCountTest {

    @Autowired
    HelloService helloService;

    @Autowired
    HelloRepository helloRepository;

    @Test
    void sayHelloIncrementsCount() {
        IntStream.rangeClosed(1, 10).forEach(
                count -> {
                    helloService.sayHello("Spring");
                    Assertions.assertThat(helloRepository.countOf("Spring")).isEqualTo(count);
                }
        );
    }
}
