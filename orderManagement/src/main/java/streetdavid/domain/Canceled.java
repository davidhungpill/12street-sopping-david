package streetdavid.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import streetdavid.domain.*;
import streetdavid.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long id;
    private Long userId;
    private String productName;
    private Long productId;
    private Integer qty;
    private String status;
    private Date orderDate;

    public Canceled(Order aggregate) {
        super(aggregate);
    }

    public Canceled() {
        super();
    }
}
//>>> DDD / Domain Event
