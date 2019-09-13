package modules;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class Account extends BaseEntity {

    private BigDecimal balance;
    private User user;

    public Account() {
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
