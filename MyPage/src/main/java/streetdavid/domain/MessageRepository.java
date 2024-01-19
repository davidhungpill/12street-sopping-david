package streetdavid.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import streetdavid.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "messages", path = "messages")
public interface MessageRepository
    extends PagingAndSortingRepository<Message, Long> {}
