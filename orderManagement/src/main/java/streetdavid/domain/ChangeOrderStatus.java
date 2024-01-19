package streetdavid.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import streetdavid.domain.*;
import streetdavid.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ChangeOrderStatus extends AbstractEvent {

    private Long id;
    private Long userId;
    private String status;
    private Date orderDate;

    public ChangeOrderStatus(Order aggregate) {
        super(aggregate);
    }

    public ChangeOrderStatus() {
        super();
    }
}
//>>> DDD / Domain Event
