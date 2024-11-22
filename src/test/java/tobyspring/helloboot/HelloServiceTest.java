package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

    @Test
    void simpleHelloService() {
        HelloService helloService = new SimpleHelloService();

        String result = helloService.sayHello("Spring");

        Assertions.assertThat(result).isEqualTo("Hello Spring");
    }

    @Test
    void helloDecorator() {
        HelloService helloService = new HelloDecorator(name -> name);

        String result = helloService.sayHello("Spring");

        Assertions.assertThat(result).isEqualTo("*Spring*");
    }
}
