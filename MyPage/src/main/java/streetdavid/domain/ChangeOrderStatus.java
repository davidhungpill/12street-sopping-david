package streetdavid.domain;

import java.util.*;
import lombok.*;
import streetdavid.domain.*;
import streetdavid.infra.AbstractEvent;

@Data
@ToString
public class ChangeOrderStatus extends AbstractEvent {

    private Long id;
    private Long userId;
    private String status;
    private Date orderDate;
}
