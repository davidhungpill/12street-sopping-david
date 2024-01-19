package streetdavid.domain;

import java.util.*;
import lombok.*;
import streetdavid.domain.*;
import streetdavid.infra.AbstractEvent;

@Data
@ToString
public class InventoryIncreases extends AbstractEvent {

    private Long id;
    private Long productId;
    private String productName;
    private Integer qty;
}
