package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;

public class ConversionServiceTest {

    private static final Logger log = LoggerFactory.getLogger(ConversionServiceTest.class);

    @Test
    void conversionServiceTest() {
        //등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());

        //사용
        Integer result = conversionService.convert("10", Integer.class);
        assertThat(result).isEqualTo(10);

        IpPort convert = conversionService.convert("127.0.0.1:800", IpPort.class);
        assertThat(convert).isEqualTo(new IpPort("127.0.0.1", 800));

    }
}
