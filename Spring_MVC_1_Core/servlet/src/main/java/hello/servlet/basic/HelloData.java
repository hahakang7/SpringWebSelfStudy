package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StreamUtils;

@Getter @Setter
public class HelloData {
    private String username;
    private int age;
}
