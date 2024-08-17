package hello.core.singleton;

import hello.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Testconfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //Thread A: A사용자가 10000원 주문
        statefulService1.order("userA", 10000);
        //Thread B: A사용자가 10000원 주문
        statefulService2.order("userB", 20000);

        //Thread A: A사용자 주문금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);
    }

    static class Testconfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}