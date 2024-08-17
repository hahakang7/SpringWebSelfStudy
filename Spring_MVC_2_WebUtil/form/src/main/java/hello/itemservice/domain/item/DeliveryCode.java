package hello.itemservice.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
    FAST:빠른배속
    NORMAL:보통배송
    SLOW:느린배송
     */

@Data
@AllArgsConstructor
public class DeliveryCode {
    private String code;
    private String displayName;

}
