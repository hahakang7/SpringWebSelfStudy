package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController를 사용하면 원래 일반 컨트롤러는 view이름으로 반환하는데 이건 http body에 그대로 넣을수 있다.
//Controller로 돌리면 writable error
@RestController
@Slf4j
public class LogTestController {

    //private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {

        String name = "Spring";

        System.out.println("name = " + name);
        //모두 다 보는 용도
        log.trace(" trace log={}", name);
        //디버그할때 보는용도
        log.debug(" debug log={}", name);
        //운영시스템에서 봐야할 정보
        log.info(" info log={}", name);
        //경고야
        log.warn(" warn log={}", name);
        //에러야
        log.error(" error log={}", name);
        return "OK";
    }


}
