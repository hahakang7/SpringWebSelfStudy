package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class IpPortToStringConverter implements Converter<IpPort, String> {

    public String convert(IpPort source) {
        log.info("convert source: {}", source);
        //IpPort객체 -> 127.0.0.1:8080
        return source.getIp()+":"+source.getPort();
    }
}
