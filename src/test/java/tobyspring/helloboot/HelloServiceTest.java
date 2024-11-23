package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Test
@interface UnitTest {
}

public class HelloServiceTest {

    @FastUnitTest
    void simpleHelloService() {
        HelloService helloService = new SimpleHelloService(helloRepository);

        String result = helloService.sayHello("Spring");

        Assertions.assertThat(result).isEqualTo("Hello Spring");
    }

    @Test
    void helloDecorator() {
        HelloService helloService = new HelloDecorator(name -> name);

        String result = helloService.sayHello("Spring");

        Assertions.assertThat(result).isEqualTo("*Spring*");
    }

    private static HelloRepository helloRepository = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {
        }

    };
}
