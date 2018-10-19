package yc.klm.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc.klm.booking.domain.Account;
import yc.klm.booking.repositories.AccountRepository;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account a) {
        return accountRepository.save(a);
    }

    public Optional<Account> findById(Long aLong) {
        return accountRepository.findById(aLong);
    }

    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    public void deleteById(Long aLong) {
        accountRepository.deleteById(aLong);
    }
}
