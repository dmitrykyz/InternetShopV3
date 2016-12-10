package by.pvt.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 10/23/2016.
 */
@Entity
@Table(name = "T_ORDER")
public class Order implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "F_ORDER_ID")
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    private Integer idOrder;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "T_ORDER_PRODUCT",
            joinColumns = {@JoinColumn(name = "F_ORDER_ID")},
            inverseJoinColumns = {@JoinColumn (name = "F_PRODUCT_ID")})
    private List<Product> productList;

    @ManyToOne
    @JoinColumn (name = "idUser")
    private Client client;

    @Column(name = "totalPrice")
    private Double totalPrice = 0.0;
    @Column(name = "isRegistryOrder")
    private Integer isRegistryOrder = 0; //1- registry ; 0 - not registry
    @Column(name = "isPaidOrder")
    private Integer isPaidOrder = 0; //1 - paid; 0 - not paid

    public Order() {
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getIsRegistryOrder() {
        return isRegistryOrder;
    }

    public void setIsRegistryOrder(Integer isRegistryOrder) {
        this.isRegistryOrder = isRegistryOrder;
    }

    public Integer getIsPaidOrder() {
        return isPaidOrder;
    }

    public void setIsPaidOrder(Integer isPaidOrder) {
        this.isPaidOrder = isPaidOrder;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }


}
