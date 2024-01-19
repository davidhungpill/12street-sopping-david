package streetdavid.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import streetdavid.domain.*;
import streetdavid.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryCollectionProcessing extends AbstractEvent {

    private Long id;

    public DeliveryCollectionProcessing(ProductDelivery aggregate) {
        super(aggregate);
    }

    public DeliveryCollectionProcessing() {
        super();
    }
}
//>>> DDD / Domain Event
