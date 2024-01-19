package streetdavid.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import streetdavid.domain.*;
import streetdavid.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InventoryDecreased extends AbstractEvent {

    private Long id;
    private Long productId;
    private String productName;
    private Integer qty;

    public InventoryDecreased(InventoryManagement aggregate) {
        super(aggregate);
    }

    public InventoryDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
