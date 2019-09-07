package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "wizard_deposits")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Deposit {
    private long id;
    private String firstName;
    private String lastName;
    private String notice;
    private short age;
    private String magicWandCreator;
    private short magicWandSize;
    private String depositGroup;
    private Date depositStartDate;
    private BigDecimal depositAmount;
    private double depositInterest;
    private double depositCharge;
    private Date depositExpirationDate;
    private boolean isDepositExpired;

    public Deposit() {
    }

    public Deposit(long id, String firstName, String lastName, String notice, short age,
                   String magicWandCreator, short magicWandSize,
                   String depositGroup, Date depositStartDate, BigDecimal depositAmount,
                   double depositInterest, double depositCharge, Date depositExpirationDate,
                   boolean isDepositExpired) throws Exception {

        if (firstName.length() <= 50) {
            this.firstName = firstName;
        } else {
            throw new Exception("First name must be up to 50 symbols!");
        }

        if (lastName.length() <= 60) {
            this.lastName = lastName;
        } else {
            throw new Exception("Last name must be up to 60 symbols!");
        }

        if (notice.length() <= 1000) {
            this.notice = notice;
        } else {
            throw new Exception("Notice must be up to 1000 symbols!");
        }

        if (age > 0) {
            this.age = age;
        } else {
            throw new Exception("Age must be positive value!");
        }

        if (magicWandCreator.length() <= 100) {
            this.magicWandCreator = magicWandCreator;
        } else {
            throw new Exception("Text must be up to 100 symbols!");
        }

        if (magicWandSize >= 1) {
            this.magicWandSize = magicWandSize;
        } else {
            throw new Exception(" !");
        }

        if (depositGroup.length() <= 20) {
            this.depositGroup = depositGroup;
        } else {
            throw new Exception("Text must be up to 20 symbols!");
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "notice")
    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Column(name = "age")
    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    @Column(name = "magic_wand_creator")
    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    @Column(name = "magic_wand_size")
    public short getMagicWandSize() {
        return magicWandSize;
    }

    public void setMagicWandSize(short magicWandSize) {
        this.magicWandSize = magicWandSize;
    }

    @Column(name = "deposit_group")
    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    @Column(name = "deposit_start_date")
    public Date getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(Date depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    @Column(name = "deposit_amount")
    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    @Column(name = "deposit_interest")
    public double getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(double depositInterest) {
        this.depositInterest = depositInterest;
    }

    @Column(name = "deposit_charge")
    public double getDepositCharge() {
        return depositCharge;
    }

    public void setDepositCharge(double depositCharge) {
        this.depositCharge = depositCharge;
    }

    @Column(name = "deposit_expiration_date")
    public Date getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public void setDepositExpirationDate(Date depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    @Column(name = "is_deposit_expired")
    public boolean isDepositExpired() {
        return isDepositExpired;
    }

    public void setDepositExpired(boolean depositExpired) {
        isDepositExpired = depositExpired;
    }
}
