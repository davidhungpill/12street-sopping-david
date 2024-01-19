package streetdavid.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import streetdavid.domain.*;
import streetdavid.infra.AbstractEvent;

//<<< DDD / Domain Event
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

    public ChangeDeliveryStatus(ProductDelivery aggregate) {
        super(aggregate);
    }

    public ChangeDeliveryStatus() {
        super();
    }
}
//>>> DDD / Domain Event
