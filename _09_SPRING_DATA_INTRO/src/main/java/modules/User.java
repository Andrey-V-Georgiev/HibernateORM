package modules;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Component
public class User extends BaseEntity{

    private String username;
    private Integer age;
    private Set<Account> accounts;

    public User() {
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @OneToMany(
            targetEntity = Account.class,
            mappedBy = "id",
            cascade = CascadeType.ALL
    )
    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
