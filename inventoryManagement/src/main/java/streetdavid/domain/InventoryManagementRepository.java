package streetdavid.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import streetdavid.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "inventoryManagements",
    path = "inventoryManagements"
)
public interface InventoryManagementRepository
    extends PagingAndSortingRepository<InventoryManagement, Long> {}
