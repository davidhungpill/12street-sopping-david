package streetdavid.domain;

import java.util.*;
import lombok.*;
import streetdavid.domain.*;
import streetdavid.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCollectionProcessing extends AbstractEvent {

    private Long id;
}
