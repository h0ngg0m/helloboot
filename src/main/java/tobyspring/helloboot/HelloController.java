package tobyspring.helloboot;

import java.util.Objects;

public class HelloController {
    public String hello(final String name) {
        SimpleHelloService helloService = new SimpleHelloService();
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
