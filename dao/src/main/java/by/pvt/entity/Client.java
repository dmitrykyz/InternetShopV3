package by.pvt.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Dmitry on 11/19/2016.
 */
@Entity
@Table(name = "T_CLIENT")
@AttributeOverrides({
        @AttributeOverride(name = "idUser", column = @Column(name = "idUser")),
        @AttributeOverride(name = "login", column = @Column(name = "login_Client")),
        @AttributeOverride(name = "password", column = @Column(name = "password_Client")),
        @AttributeOverride(name = "firstName", column = @Column(name = "firstName_Client")),
        @AttributeOverride(name = "lastName", column = @Column(name = "lastName_Client")),
        @AttributeOverride(name = "userType", column = @Column(name = "userType"))
})
public class Client extends User {

    @Column(name = "inBlackList")
    private Integer inBlackList = 0;                //0 - not in blackList; 1 - in blackList
    @Column(name = "summOnCreditCard")
    private Double summOnCreditCard = 100000.0;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Order> orderListInbBasket;         //Basket with product

    public Client() {
    }

    public Integer getInBlackList() {
        return inBlackList;
    }

    public void setInBlackList(Integer inBlackList) {
        this.inBlackList = inBlackList;
    }

    public Double getSummOnCreditCard() {
        return summOnCreditCard;
    }

    public void setSummOnCreditCard(Double summOnCreditCard) {
        this.summOnCreditCard = summOnCreditCard;
    }

    public List<Order> getOrderListInbBasket() {
        return orderListInbBasket;
    }

    public void setOrderListInbBasket(List<Order> orderListInbBasket) {
        this.orderListInbBasket = orderListInbBasket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(inBlackList, client.inBlackList)
                .append(summOnCreditCard, client.summOnCreditCard)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(inBlackList)
                .append(summOnCreditCard)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Client{" +
                "inBlackList=" + inBlackList +
                ", summOnCreditCard=" + summOnCreditCard +
                "} " + super.toString();
    }
}
