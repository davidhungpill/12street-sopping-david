package streetdavid.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import streetdavid.domain.*;
import streetdavid.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InventoryIncreases extends AbstractEvent {

    private Long id;
    private Long productId;
    private String productName;
    private Integer qty;

    public InventoryIncreases(InventoryManagement aggregate) {
        super(aggregate);
    }

    public InventoryIncreases() {
        super();
    }
}
//>>> DDD / Domain Event
