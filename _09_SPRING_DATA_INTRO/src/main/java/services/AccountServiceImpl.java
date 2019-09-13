package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import repositories.AccountRepository;
import java.math.BigDecimal;

@Service
@Primary
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountrepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountrepository) {
        this.accountrepository = accountrepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) { }

    @Override
    public void transferMoney(BigDecimal money, Long id) { }
}
