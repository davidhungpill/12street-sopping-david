package streetdavid.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import streetdavid.domain.*;

@Component
public class InventoryManagementHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<InventoryManagement>> {

    @Override
    public EntityModel<InventoryManagement> process(
        EntityModel<InventoryManagement> model
    ) {
        return model;
    }
}
