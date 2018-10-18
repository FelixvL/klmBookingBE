package yc.klm.booking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yc.klm.booking.domain.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
