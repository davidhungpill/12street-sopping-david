package streetdavid.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import streetdavid.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "searchOrders",
    path = "searchOrders"
)
public interface SearchOrderRepository
    extends PagingAndSortingRepository<SearchOrder, Long> {}
