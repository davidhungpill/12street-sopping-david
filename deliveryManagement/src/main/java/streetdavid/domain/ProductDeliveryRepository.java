package streetdavid.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import streetdavid.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "productDeliveries",
    path = "productDeliveries"
)
public interface ProductDeliveryRepository
    extends PagingAndSortingRepository<ProductDelivery, Long> {}
