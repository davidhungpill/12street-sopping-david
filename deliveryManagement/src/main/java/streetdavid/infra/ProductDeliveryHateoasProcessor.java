package streetdavid.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import streetdavid.domain.*;

@Component
public class ProductDeliveryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ProductDelivery>> {

    @Override
    public EntityModel<ProductDelivery> process(
        EntityModel<ProductDelivery> model
    ) {
        return model;
    }
}
