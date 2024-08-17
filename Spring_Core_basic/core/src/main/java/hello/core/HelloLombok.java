package hello.core;

import lombok.Getter;
import lombok.Setter;

public class HelloLombok {

    @Getter
    @Setter
    private  String name;
    private  int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("sadsa");

        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
