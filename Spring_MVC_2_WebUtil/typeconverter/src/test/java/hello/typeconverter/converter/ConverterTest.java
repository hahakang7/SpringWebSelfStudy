package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {

    @Test
    void StringToIntegerTest() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("13");
        assertThat(result).isEqualTo(13);
    }

    @Test
    void IntegerToStringTest() {
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String convert = converter.convert(34);
        assertThat(convert).isEqualTo("34");
    }

    @Test
    void IpPortToString() {
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort ipPort = new IpPort("127.0.0.1", 8080);
        String convert = converter.convert(ipPort);
        assertThat(convert).isEqualTo("127.0.0.1:8080");

    }

    @Test
    void StringToIpPortTest() {
        StringToIpPortConverter converter = new StringToIpPortConverter();
        IpPort convert = converter.convert("127.0.0.1:8080");
        assertThat(convert).isEqualTo(new IpPort("127.0.0.1", 8080));
    }
}
