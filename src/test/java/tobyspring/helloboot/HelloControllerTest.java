package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {

    @Test
    void helloController() {
        HelloController controller = new HelloController(name -> name);

        String result = controller.hello("Spring");

        Assertions.assertThat(result).isEqualTo("Spring");
    }

    @Test
    void failsHelloController() {
        HelloController controller = new HelloController(name -> name);

        Assertions.assertThatThrownBy(() -> {
            controller.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            controller.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
