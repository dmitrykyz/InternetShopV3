package by.pvt.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * Created by Dmitry on 11/19/2016.
 */
@Entity
@Table(name = "T_ADMIN")
@AttributeOverrides({
        @AttributeOverride(name = "idUser", column = @Column(name = "idUser")),
        @AttributeOverride(name = "login", column = @Column(name = "login_Admin")),
        @AttributeOverride(name = "password", column = @Column(name = "password_Admin")),
        @AttributeOverride(name = "firstName", column = @Column(name = "firstName_Admin")),
        @AttributeOverride(name = "lastName", column = @Column(name = "lastName_Admin")),
        @AttributeOverride(name = "userType", column = @Column(name = "userType"))
})
public class Admin extends User {

    @Column(name = "bankAccount")
    private Double bankAccount = 0.0;

    public Admin() {
        super();
        setUserType(1);
    }

    public Double getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Double bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(bankAccount, admin.bankAccount)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(bankAccount)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "bankAccount=" + bankAccount +
                '}';
    }
}
