package streetdavid.domain;

import java.util.*;
import lombok.*;
import streetdavid.domain.*;
import streetdavid.infra.AbstractEvent;

@Data
@ToString
public class Ordered extends AbstractEvent {

    private Long id;
    private Long userId;
    private String productName;
    private Long productId;
    private Integer qty;
    private String status;
    private Date orderDate;
    private String product;
}
