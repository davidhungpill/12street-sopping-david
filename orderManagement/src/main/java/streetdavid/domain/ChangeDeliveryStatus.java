package streetdavid.domain;

import java.util.*;
import lombok.*;
import streetdavid.domain.*;
import streetdavid.infra.AbstractEvent;

@Data
@ToString
public class ChangeDeliveryStatus extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String productName;
    private Long productId;
    private Integer qty;
    private String status;
    private Date deliveryDt;
}
